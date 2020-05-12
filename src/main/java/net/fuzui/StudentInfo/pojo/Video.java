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
public class Video implements java.io.Serializable{
    /**
     *  序列化
     */
    private static final long serialVersionUID = 1L;
  
    private String Videoid;
    private String Videohref;
    private String videotype;
    private String videodesc;

    /**
     * 默认构造方法
     */
    public Video() {

    }

	public String getVideoid() {
		return Videoid;
	}

	public void setVideoid(String videoid) {
		Videoid = videoid;
	}

	public String getVideohref() {
		return Videohref;
	}

	public void setVideohref(String videohref) {
		Videohref = videohref;
	}

	public String getVideotype() {
		return videotype;
	}

	public void setVideotype(String videotype) {
		this.videotype = videotype;
	}

	public String getVideodesc() {
		return videodesc;
	}

	public void setVideodesc(String videodesc) {
		this.videodesc = videodesc;
	}
	

	

    /**
     *  置取方法
     */
 

}

