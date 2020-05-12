package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.mapper.CommentMapper;
import net.fuzui.StudentInfo.mapper.CourseMapper;
import net.fuzui.StudentInfo.mapper.NoticeMapper;
import net.fuzui.StudentInfo.mapper.VideoMapper;
import net.fuzui.StudentInfo.pojo.Comment;
import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.pojo.Notice;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.Video;
import net.fuzui.StudentInfo.service.CommentService;
import net.fuzui.StudentInfo.service.CourseService;
import net.fuzui.StudentInfo.service.NoticeService;
import net.fuzui.StudentInfo.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service.impl
 * @ClassName: CourseServiceImpl
 * @Description: 课程service具体实现类
 * @Author: 王泽
 * @CreateDate: 2019-04-10 13:32
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 13:32
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired VideoMapper videoMapper;

	@Override
	public int insertVideo(Video video) {
		// TODO Auto-generated method stub
		return videoMapper.insertVideo(video);
	}

	@Override
	public int deleteVideo(String videoid) {
		// TODO Auto-generated method stub
		return videoMapper.deleteVideo(videoid);
	}

    @Override
    public Video getByVidSid(String videoid) {
        return videoMapper.getByVidSid(videoid);
    }
//	@Override
//	public List<Notice> getByNoticeid(int pageNo, int pageSize, String noticeid) {
//		Map<String,Object> data = new HashMap<String,Object>();
//        data.put("pageNo",(pageNo-1) * pageSize);
//        data.put("pageSize",pageSize);
//        data.put("noticeid",noticeid);
//		
//		return noticeMapper.getByNoticeid(data);
//	}

	

	@Override
	public List<Video> getByVideoid(int pageNo, int pageSize, String videoid) {
		    Map<String,Object> data = new HashMap<String,Object>();
	        data.put("pageNo",(pageNo-1) * pageSize);
	        data.put("pageSize",pageSize);
	        data.put("videoid",videoid);
		return videoMapper.getByVideoid(data);
	}
	@Override
	public List<Video> selectVideoBySql(int pageNo, int pageSize) {
		Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        return videoMapper.selectVideoBySql(data);
	}

	@Override
	public String ajaxQueryByVideoid(String videoid) {
		// TODO Auto-generated method stub
		return null;
	}





}
