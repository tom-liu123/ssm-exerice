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
public class Invest implements java.io.Serializable{
    /**
     *  序列化
     */
    private static final long serialVersionUID = 1L;
    //课程编号
    private String investid;
    //课程名称
    private String month;
    //课程介绍
    private String info;
    //类型
    private String price;
    
    private String oldprice;
    private String represent;
    

    /**
     * 默认构造方法
     */
    public Invest() {

    }


	public String getInvestid() {
		return investid;
	}


	public void setInvestid(String investid) {
		this.investid = investid;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getOldprice() {
		return oldprice;
	}


	public void setOldprice(String oldprice) {
		this.oldprice = oldprice;
	}


	public String getRepresent() {
		return represent;
	}


	public void setRepresent(String represent) {
		this.represent = represent;
	}

	
	
	
	

    /**
     *  置取方法
     */
   


}

