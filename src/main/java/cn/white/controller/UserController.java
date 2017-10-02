package cn.white.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.white.entity.User;
import cn.white.service.UserService;
import cn.white.util.NoteResult;
import cn.white.util.NoteUtil;

@RestController
@RequestMapping("/api")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/register.do")
	public NoteResult register(String username, String password) {
		return this.userService.addUser(username, password);
	}

	@RequestMapping(value = "/login.do")
	public NoteResult login(String username, String password) {
		return this.userService.checkLogin(username, password);
	}

	@RequestMapping("/updatePassword.do")
	public NoteResult update(String id,String token,String oldPassword, String newPassword) {
		return userService.modifyPassword(id,token,oldPassword, newPassword);
	}

	@RequestMapping("/validator.do")
	public NoteResult validator(String id,String token){
	    return userService.validateToken(id,token);
    }
}












