package cn.white.service;

import cn.white.util.NoteResult;

 public interface UserService {

	 NoteResult checkLogin(String name, String password);

	 NoteResult addUser(String name, String password);

	 NoteResult modifyPassword(String id, String token, String lastPassword, String newPassword);

	 NoteResult validateToken(String id, String token);

}
