package net.fuzui.StudentInfo.pojo;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.pojo
 * @ClassName: Course
 * @Description: 课程实体类
 * @Author: 王泽
 * @CreateDate: 2019-04-06 16:34
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-06 16:34
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
public class Comment implements java.io.Serializable{
    /**
     *  序列化
     */
    private static final long serialVersionUID = 1L;
    //课程编号
    private String commentid;
    //课程名称
    private String sid;
    //课程介绍
    private String sname;
    //类型
    private String commentcont;
    
    private String commentreply;

    /**
     * 默认构造方法
     */
    public Comment() {

    }

	public String getCommentid() {
		return commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCommentcont() {
		return commentcont;
	}

	public void setCommentcont(String commentcont) {
		this.commentcont = commentcont;
	}

	public String getCommentreply() {
		return commentreply;
	}

	public void setCommentreply(String commentreply) {
		this.commentreply = commentreply;
	}
	
	
	

    /**
     *  置取方法
     */
   


}

