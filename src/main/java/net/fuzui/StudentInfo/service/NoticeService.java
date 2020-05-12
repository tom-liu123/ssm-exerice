package net.fuzui.StudentInfo.service;

import net.fuzui.StudentInfo.pojo.Comment;
import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.pojo.Notice;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.Teacher;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service
 * @ClassName: CourseService
 * @Description: 课程service接口层
 * @Author: 王泽
 * @CreateDate: 2019-04-10 13:27
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 13:27
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

public interface NoticeService {

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

    
    /**
     *  根据课程编号查询出课程实体
     * @param cid
     * @return
     */
    public List<Notice> getByNoticeid(int pageNo, int pageSize,String noticeid);


    /**
     * 查询全部课程，接住sql语句进行分页
     * @param pageNo
     * @param pageSize
     * @return      查询结果
     */
    public List<Notice> selectNoticeBySql(int pageNo, int pageSize);


    
    
    

    
    




    /**
     *  ajax验证课程编号是否存在
     * @param cid   课程编号
     * @return  结果
     */
    public String ajaxQueryByNoticeid(String noticeid);

	



}
