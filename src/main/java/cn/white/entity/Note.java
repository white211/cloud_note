package cn.white.entity;

import java.sql.Timestamp;

public class Note {
    private Integer cn_note_id;
    private Integer cn_notebook_id;
    private Integer cn_user_id;
    private String cn_note_title;
    private String cn_note_body;
    private Timestamp cn_note_createtime;

    public Integer getCn_note_id() {
        return cn_note_id;
    }

    public void setCn_note_id(Integer cn_note_id) {
        this.cn_note_id = cn_note_id;
    }

    public Integer getCn_notebook_id() {
        return cn_notebook_id;
    }

    public void setCn_notebook_id(Integer cn_notebook_id) {
        this.cn_notebook_id = cn_notebook_id;
    }

    public Integer getCn_user_id() {
        return cn_user_id;
    }

    public void setCn_user_id(Integer cn_user_id) {
        this.cn_user_id = cn_user_id;
    }

    public String getCn_note_title() {
        return cn_note_title;
    }

    public void setCn_note_title(String cn_note_title) {
        this.cn_note_title = cn_note_title;
    }

    public String getCn_note_body() {
        return cn_note_body;
    }

    public void setCn_note_body(String cn_note_body) {
        this.cn_note_body = cn_note_body;
    }

    public Timestamp getCn_note_createtime() {
        return cn_note_createtime;
    }

    public void setCn_note_createtime(Timestamp cn_note_createtime) {
        this.cn_note_createtime = cn_note_createtime;
    }

}
