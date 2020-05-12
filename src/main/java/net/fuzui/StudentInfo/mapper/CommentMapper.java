package net.fuzui.StudentInfo.mapper;

import net.fuzui.StudentInfo.pojo.Comment;
import net.fuzui.StudentInfo.pojo.Course;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
public interface CommentMapper {

    /**
     *  添加课程
     * @param course   课程信息
     * @return  插入结果 !=0则插入成功
     */
    public int insertComment(Comment comment);

    /**
     *  根据课程编号删除课程信息信息
     * @param cid   课程编号
     * @return  删除结果，!=0则删除成功
     */
    public int deleteComment(String commentid);
    


    /**
     *  修改课程信息
     * @param course   课程信息
     * @return  修改结果 !=0则修改成功
     */
    public int modifyComment(@Param("commentreply") String commentreply, @Param("commentid") String commentid);

    /**
     *  根据课程编号查询出课程实体
     * @param cid
     * @return
     */
    public Comment getByCommentid(String commentid);


    /**
     * 查询全部课程，接住sql语句进行分页
     * @param data
     * @return      查询结果
     */
    public List<Comment> selectCommentBySql(Map<String, Object> data);

    /**
     * 根据课程编号查询课程信息
     * @param data
     * @return  查询结果
     */
    public List<Comment> getByCommentid(Map<String, Object> data);
    
    public List<Comment> getByCommentSname(Map<String, Object> data);
    public List<Comment> getByCommentSid(Map<String, Object> data);

//    /**
//     * 根据课程名称查询课程信息
//     * @param data
//     * @return  查询结果
//     */
//    public List<Course> getByCourseCname(Map<String, Object> data);
//
//    /**
//     *  根据学院查询课程信息
//     * @param data
//     * @return 结果
//     */
//    public List<Course> getByCourseCol(Map<String, Object> data);
//
//    /**
//     *  根据课程类型查询课程信息
//     * @param data
//     * @return  结果
//     */
//    public List<Course> getByCourseType(Map<String, Object> data);



    /**
     *  ajax验证课程编号是否存在
     * @param cid   课程编号
     * @return  结果
     */
    public String ajaxQueryByCommentid(String commentid);




}
