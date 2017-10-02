package cn.white.dao;

import cn.white.entity.User;

public interface UserDao {

	public User findUserById(Integer cn_user_id);

	public User findUserByName(String name);//通过用户名查找用户

	public User findUserByPassword(String password);//通过密码查找用户

	public void saveUser(User user);//将注册用户保存

	public void update(User user);//修改密码

	public void updateToken(User user);//通过id更新令牌

}





