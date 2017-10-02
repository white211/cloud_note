package cn.white.util;

import cn.white.dao.UserDao;
import cn.white.service.UserService;
import cn.white.service.UserServiceImpl;
import org.apache.commons.codec.binary.Base64;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.UUID;

public class NoteUtil {

	/**
	 * UUID:防止用户id重复
	 * 
	 * @return 随机UUID
	 */
	public static String createId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}

	/**
	 * 密码加密 明文md5
	 * 
	 * @param src
	 *            密码明文
	 * @return 加密后的密文
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5(String src) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] output = md.digest(src.getBytes());
		String s = Base64.encodeBase64String(output);
		return s;
	}

    /**
     * 验证用户令牌
     * @param id 用户id
     * @param token 用户令牌
     * @return 结果
     */
	public static NoteResult validateToken(String id,String token){
        UserService userService = new UserServiceImpl();
        return userService.validateToken(id,token);
    }
}
