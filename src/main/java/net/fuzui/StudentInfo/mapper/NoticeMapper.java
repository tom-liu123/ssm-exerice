package net.fuzui.StudentInfo.mapper;

import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.pojo.Notice;

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
public interface NoticeMapper {

    /**
     *  添加课程
     * @param course   课程信息
     * @return  插入结果 !=0则插入成功
     */
    public int insertNotice(Notice notice);

    /**
     *  根据课程编号删除课程信息信息
     * @param cid   课程编号
     * @return  删除结果，!=0则删除成功
     */
    public int deleteNotice(String noticeid);

    
    


    public List<Notice> selectNoticeBySql(Map<String, Object> data);

   
    public List<Notice> getByNoticeid(Map<String, Object> data);



    /**
     *  ajax验证课程编号是否存在
     * @param cid   课程编号
     * @return  结果
     */
    public String ajaxQueryByNoticeid(String noticeid);
}
