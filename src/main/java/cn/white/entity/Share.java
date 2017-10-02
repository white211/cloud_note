package cn.white.entity;

public class Share {
   private Integer cn_share_id;//日记分享id
   private String cn_share_title;//共享标题
   private String cn_share_body;//共享内容
   private Integer cn_note_id;//笔记id
public Integer getCn_share_id() {
	return cn_share_id;
}
public void setCn_share_id(Integer cn_share_id) {
	this.cn_share_id = cn_share_id;
}
public String getCn_share_title() {
	return cn_share_title;
}
public void setCn_share_title(String cn_share_title) {
	this.cn_share_title = cn_share_title;
}
public String getCn_share_body() {
	return cn_share_body;
}
public void setCn_share_body(String cn_share_body) {
	this.cn_share_body = cn_share_body;
}
public Integer getCn_note_id() {
	return cn_note_id;
}
public void setCn_note_id(Integer cn_note_id) {
	this.cn_note_id = cn_note_id;
}
   
}
