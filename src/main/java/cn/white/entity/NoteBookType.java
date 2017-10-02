package cn.white.entity;

public class NoteBookType {
    private Integer cn_notebook_type_id;//笔记本类型id
    private String cn_notebook_type_name;//笔记本类型名称
    private String cn_notebook_type_desc;//笔记本类型说明
//    private String cn_notebook_type_code;
    
	public Integer getCn_notebook_type_id() {
		return cn_notebook_type_id;
	}
	public void setCn_notebook_type_id(Integer cn_notebook_type_id) {
		this.cn_notebook_type_id = cn_notebook_type_id;
	}
	public String getCn_notebook_type_name() {
		return cn_notebook_type_name;
	}
	public void setCn_notebook_type_name(String cn_notebook_type_name) {
		this.cn_notebook_type_name = cn_notebook_type_name;
	}
	public String getCn_notebook_type_desc() {
		return cn_notebook_type_desc;
	}
	public void setCn_notebook_type_desc(String cn_notebook_type_desc) {
		this.cn_notebook_type_desc = cn_notebook_type_desc;
	}
    
}
