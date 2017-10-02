package cn.white.util;

public class NoteResult {
	private int status;// 0成功1失败
	private String msg;// 登录消息
	private Object data;//存放数据
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
