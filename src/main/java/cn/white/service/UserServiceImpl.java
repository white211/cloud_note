package cn.white.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.white.dao.UserDao;
import cn.white.entity.User;
import cn.white.util.NoteResult;
import cn.white.util.NoteUtil;

import java.util.Date;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /*
     * 验证登陆信息 用户名 与密码 返回验证结果
     */
    public NoteResult checkLogin(String name, String password) {
        NoteResult noteResult = new NoteResult();
        if (name == null || "".equals(name)) {
            noteResult.setStatus(1);
            noteResult.setMsg("用户名不能为空！");
            return noteResult;
        }
        if (password == null || "".equals(password)) {
            noteResult.setStatus(1);
            noteResult.setMsg("密码不能为空");
            return noteResult;
        }
        User user = userDao.findUserByName(name);
        if (user == null) {
            noteResult.setStatus(1);
            noteResult.setMsg("用户名不存在");
            return noteResult;
        }
        try {
            // String md5_password = NoteUtil.md5(password);
            if (!user.getCn_user_password().equals(password)) {
                noteResult.setStatus(2);
                noteResult.setMsg("密码错误");
                return noteResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
            noteResult.setStatus(1);
            noteResult.setMsg("登录失败！信息：" + e.getMessage());
            return noteResult;
        }
        noteResult.setStatus(0);
        noteResult.setMsg("登录成功");
        user.setCn_user_token(NoteUtil.createId());
        userDao.updateToken(user);
        user.setCn_user_password("******");
        noteResult.setData(user);//登陆成功将用户传输到前台
        return noteResult;
    }

    /*
     * 进行验证 添加用户信息阶段
     */
    public NoteResult addUser(String name, String password) {
        NoteResult noteResult = new NoteResult();
        if (name == null || "".equals(name)) {
            noteResult.setStatus(1);
            noteResult.setMsg("用户名不能为空！");
            return noteResult;
        }
        if (password == null || "".equals(password)) {
            noteResult.setStatus(1);
            noteResult.setMsg("密码不能为空");
            return noteResult;
        }
        // 判断用户名是否已经存
        User user = userDao.findUserByName(name);
        if (user != null) {
            noteResult.setStatus(1);
            noteResult.setMsg("用户名已经存在！");
            return noteResult;
        }
        // 注册功能的
        user = new User();
        user.setCn_user_name(name);
        try {
            // 对密码进行md5加密
            // String md5_password = NoteUtil.md5(password);
            user.setCn_user_password(password);
            // 获取随机的UUID
            // String userId = NoteUtil.createId();
            // user.setCn_user_id(userId);
            userDao.saveUser(user);
            noteResult.setStatus(0);
            noteResult.setMsg("注册成功");
            return noteResult;
        } catch (Exception e) {
            e.printStackTrace();
            noteResult.setStatus(1);
            noteResult.setMsg("注册失败！信息：" + e.getMessage());
            return noteResult;
        }
    }

    /*
     * 修改密码
     */
    public NoteResult modifyPassword(String id, String token, String lastPassword, String newPassword) {
        NoteResult noteResult = new NoteResult();
        try {
            User user = userDao.findUserById(Integer.parseInt(id));
            if (user == null) {
                noteResult.setStatus(1);
                noteResult.setMsg("找不到该用户！");
            } else if (token == null || !token.equals(user.getCn_user_token())) {
                noteResult.setStatus(1);
                noteResult.setMsg("令牌不正确！");
            } else if (((new Date()).getTime()) - (user.getCn_user_last_login().getTime()) > 1000 * 2 * 60) {
                noteResult.setStatus(500);
                noteResult.setMsg("登陆超时，请重新登录！");
            } else if (lastPassword == null || !lastPassword.equals(user.getCn_user_password())) {
                noteResult.setStatus(1);
                noteResult.setMsg("原密码不正确！");
            } else if (newPassword == null || newPassword.length() < 6 || newPassword.length() > 20) {
                noteResult.setStatus(1);
                noteResult.setMsg("新密码格式不正确！");
            } else {
                user.setCn_user_password(newPassword);
                userDao.update(user);
                noteResult.setStatus(0);
                noteResult.setMsg("密码修改成功！");
            }
        } catch (Exception e) {
            noteResult.setStatus(1);
            noteResult.setMsg("出错了，" + e.getMessage());
        }
        return noteResult;
    }

    public NoteResult validateToken(String id, String token) {
        NoteResult noteResult = new NoteResult();
        try {
            User user = userDao.findUserById(Integer.parseInt(id));
            if (user == null) {
                noteResult.setStatus(1);
                noteResult.setMsg("找不到该用户！");
            } else if (token == null || !token.equals(user.getCn_user_token())) {
                noteResult.setStatus(1);
                noteResult.setMsg("令牌不正确！");
            } else if (((new Date()).getTime()) - (user.getCn_user_last_login().getTime()) > 1000 * 20) {
                noteResult.setStatus(500);
                noteResult.setMsg("登陆超时，请重新登录！");
            } else {
                noteResult.setStatus(0);
                noteResult.setMsg("验证通过！");
            }
        } catch (Exception e) {
            noteResult.setStatus(1);
            noteResult.setMsg("验证失败！信息：" + e.getMessage());
        }
        return noteResult;
    }

}
