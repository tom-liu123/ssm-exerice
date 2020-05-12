package net.fuzui.StudentInfo.pojo;

public class Notice implements java.io.Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private String noticeid;
    private String noticecontent;
    private String noticetime;
    public Notice(){
    	
    }
	public String getNoticeid() {
		return noticeid;
	}
	public void setNoticeid(String noticeid) {
		this.noticeid = noticeid;
	}
	public String getNoticecontent() {
		return noticecontent;
	}
	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}
	public String getNoticetime() {
		return noticetime;
	}
	public void setNoticetime(String noticetime) {
		this.noticetime = noticetime;
	}
	
	

}
