package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.mapper.CommentMapper;
import net.fuzui.StudentInfo.mapper.CourseMapper;
import net.fuzui.StudentInfo.mapper.InvestMapper;
import net.fuzui.StudentInfo.mapper.NoticeMapper;
import net.fuzui.StudentInfo.mapper.VideoMapper;
import net.fuzui.StudentInfo.pojo.Comment;
import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.pojo.Invest;
import net.fuzui.StudentInfo.pojo.Notice;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.Video;
import net.fuzui.StudentInfo.service.CommentService;
import net.fuzui.StudentInfo.service.CourseService;
import net.fuzui.StudentInfo.service.InvestService;
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
public class InvestServiceImpl implements InvestService {
	
	@Autowired InvestMapper investMapper;

	@Override
	public int insertInvest(Invest invest) {
		// TODO Auto-generated method stub
		return investMapper.insertInvest(invest);
	}

	@Override
	public int deleteInvest(String investid) {
		// TODO Auto-generated method stub
		return investMapper.deleteInvest(investid);
	}

	
	@Override
	public Video getByInvid(String investid) {
		// TODO Auto-generated method stub
		return investMapper.getByInvid(investid);
	}

	




	@Override
	public List<Invest> getByInvestid(int pageNo, int pageSize, String investid) {
	    Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("investid",investid);
	  return investMapper.getByInvestid(data);
	}
	



	@Override
	public List<Invest> selectInvestBySql(int pageNo, int pageSize) {
		Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        return investMapper.selectInvestBySql(data);
	}

	@Override
	public String ajaxQueryByInvestid(String investid) {
		// TODO Auto-generated method stub
		return null;
	}







}
