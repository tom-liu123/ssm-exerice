package net.fuzui.StudentInfo.mapper;

import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.pojo.Invest;
import net.fuzui.StudentInfo.pojo.Notice;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.Video;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.mapper
 * @ClassName: CourseMapper
 * @Description: 课程数据访问层接口类
 * @Author: 王泽
 * @CreateDate: 2019-04-10 12:04
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 12:04
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
public interface InvestMapper {

    /**
     *  添加课程
     * @param course   课程信息
     * @return  插入结果 !=0则插入成功
     */
    public int insertInvest(Invest invest);

    /**
     *  根据课程编号删除课程信息信息
     * @param cid   课程编号
     * @return  删除结果，!=0则删除成功
     */
    public int deleteInvest(String investid);

    public Video getByInvid(String investid);
    


    public List<Invest> selectInvestBySql(Map<String, Object> data);

   
    public List<Invest> getByInvestid(Map<String, Object> data);
    



    /**
     *  ajax验证课程编号是否存在
     * @param cid   课程编号
     * @return  结果
     */
    public String ajaxQueryByInvestid(String investid);
}
