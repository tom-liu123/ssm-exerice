package net.fuzui.StudentInfo.handler;

import net.fuzui.StudentInfo.pojo.Comment;
import net.fuzui.StudentInfo.pojo.Invest;
import net.fuzui.StudentInfo.pojo.Notice;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.Teacher;
import net.fuzui.StudentInfo.pojo.Video;
import net.fuzui.StudentInfo.service.AdminService;
import net.fuzui.StudentInfo.service.CommentService;
import net.fuzui.StudentInfo.service.CoursePlanService;
import net.fuzui.StudentInfo.service.CourseService;
import net.fuzui.StudentInfo.service.InvestService;
import net.fuzui.StudentInfo.service.NoticeService;
import net.fuzui.StudentInfo.service.SelectCourseService;
import net.fuzui.StudentInfo.service.StudentService;
import net.fuzui.StudentInfo.service.TeacherService;
import net.fuzui.StudentInfo.service.VideoService;
import net.fuzui.StudentInfo.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.handler
 * @ClassName: AdminHandler
 * @Description: admin的handler层（servlet）
 * @Author: 王泽
 * @CreateDate: 2019-04-10 22:50
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 22:50
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

@Controller
@RequestMapping("/AdminHandler")
//@SessionAttributes("studentList")
//@SessionAttributes("teacherList")
public class AdminHandler {


    @Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	CoursePlanService coursePlanService;
	@Autowired
    CourseService courseService;
	@Autowired
	SelectCourseService selectCourseService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	NoticeService noticeService;
	@Autowired
	VideoService videoService;
	
	@Autowired
	InvestService investService;


	/**
	 * JavaScript学的不好，目前只能通过这种方式把三级联动下拉列表的val改变为以下值传给数据库。
	 * 
	 */
	String[] arr_belongcoll = {"锦州市"};
	String[][] arr_belongpro = {
                    {"古塔区","凌河区","太和区"}
                   
				};
	String[][][] arr_belongcla = {
                {
                    {"天安街道","石油街道","北街街道","敬业街道","保安街道","南街街道","饶阳街道","站前街道","士英街道"},
                    {"大薛街道","凌南街道","陵西街道","太和街道","汤河子街道","天桥街道","王家街道","兴隆街道","杏仁街道"},
                    {"锦铁街道","菊园街道","康宁街道","凌安街道","榴花街道","龙江街道","马家街道","石桥子街道","铁新街道","正大街道","紫荆街道"}                   
                }
              
		};
	
	

 // 添加

	
	@RequestMapping("/addStudent")
	public String addStudent(Student student, Model model) {

 		if (studentService.insertStudent(student) != 0) {
 			model.addAttribute("student", student);

 			//---------------------------------待优化-----同样不能实时刷新--------------------------------------------
 			return "success";
 			//return new ModelAndView(new RedirectView("/StudentInfo/TeacherHandler/finalPage"));
 			// return "techer/teacherFace";
 		} else {
 			return "fail";
 			//return new ModelAndView(new RedirectView("fail"));
 		}

 	}
	
	
	
 	//查询全部学生方法
 	public void queryStu(HttpServletRequest request) {
 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.selectStudentBySql(1,10);
 		
 		
 		request.setAttribute("slist", studentList);
 	}

 	public void pageIn(Model model,List list) {
 		PageInfo page = new PageInfo(list, 5);
	 	model.addAttribute("pageInfo", page);
 	}
 	
 	// 查询
 	@RequestMapping(value = "/query/{pn}", method = RequestMethod.GET)
 	public String redirect(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {

 		int no = Integer.parseInt(pn);
// 		System.out.println("-----"+no+"----");
 		List<Student> studentList = new ArrayList<Student>();
 		PageHelper.startPage(no, 5);
 		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
 		//查询全部
 		if (serc.equals("all")) {
 			
 			
 			
 	 		
 			System.out.println("------------------------------------------------------------------------------------------------");
// 			studentList = studentService.selectStudentBySql(1,10);
// 			//model.addAttribute("studentList", studentList);
// 			request.setAttribute("slist", studentList);
// 			System.out.println("00000"+request.getAttribute("slist"));
// 			System.out.println(studentList);
 			studentList = studentService.selectStudentBySql(1,10);
 			pageIn(model, studentList);
 	 		request.setAttribute("slist", studentList);
 			return "admin/queryStudent";

 		//根据学号查询
 		} else if (serc.equals("sid")) {

 			studentList = studentService.getByStudentSid(1,10,condition);
 			pageIn(model, studentList);
 			request.setAttribute("slist", studentList);
 			System.out.println("sid");

 			return "admin/queryStudent";

 		//根据学院查询
 		} else if (serc.equals("col")) {
 			
 			
 			studentList = studentService.getByStudentCol(1,10,condition);
 			pageIn(model, studentList);
 			request.setAttribute("slist", studentList);
 			System.out.println(studentList);
 			System.out.println("col");
 			return "admin/queryStudent";

 		//根据专业查询
 		} else if (serc.equals("pro")) {
 			studentList = studentService.getByStudentPro(1,10,condition);
 			pageIn(model, studentList);
 			request.setAttribute("slist", studentList);
 			System.out.println(studentList);
 			System.out.println("pro");
 			return "admin/queryStudent";

 		//根据班级查询
 		} else if (serc.equals("cla")) {
 			studentList = studentService.getByStudentCla(1,10,condition);
 			pageIn(model, studentList);
 			//model.addAttribute("studentList", studentList);
 			request.setAttribute("slist", studentList);
// 			System.out.println(studentList);
// 			System.out.println("cla");
 			return "admin/queryStudent";

 		} else {

// 			studentList = studentService.selectStudentBySql(1,10);
// 			model.addAttribute("studentList", studentList);
// 			request.setAttribute("slist", studentList);
// 			System.out.println("00000"+request.getAttribute("slist"));
// 			System.out.println(studentList);
 			studentList = studentService.selectStudentBySql(1,10);
 			pageIn(model, studentList);
 	 		request.setAttribute("slist", studentList);
 			return "admin/queryStudent";

 		}

 	}

 	// 删除学生
 	@RequestMapping(value = "/delete/{sid}", method = RequestMethod.GET)
 	public String deleteStudent(@PathVariable(value = "sid") String sid, Model model) {


 		if (studentService.deleteStudent(sid) != 0) {
 			System.out.println("success");
 			
 			return "success";
 		} else {
 			System.out.println("fail");
 			return "fail";
 		}

 	}

 	// 跳转页面
 	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
 	public String finalPage(HttpServletRequest request) {
 		queryStu(request);
 		return "admin/queryStudent";
 	}

 	
 	
 	
 	// 修改定位
 	@RequestMapping(value = "/moditystu/{sid}", method = RequestMethod.GET)
 	public String editPre(@PathVariable("sid") String sid, HttpServletRequest request) {

 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.getByStudentSid(1,10,sid);
 		
 		request.setAttribute("studentList", studentList);
 		System.out.println("-----进入修改");
 		return "admin/modiStudent";
 	}
 	

	
 // 修改
 	@RequestMapping(value = "/moditystud/{sid}", method = RequestMethod.GET)
 	public String update(@PathVariable("sid") String sid, Student student, HttpServletRequest request) {

 		if (studentService.modifyStudent(student) != 0) {
 			return "success";
 		} else {
 			return "fail";
 		}
 	}
 	
 	
 	/**
 	 * 留言相关
 	 */

 	

 	// 修改定位
 	@RequestMapping(value = "/moditysture/{sid}", method = RequestMethod.GET)
 	public String editPreReply(@PathVariable("sid") String sid, HttpServletRequest request) {

 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.getByStudentSid(1,10,sid);
 		
 		request.setAttribute("studentList", studentList);
 		System.out.println("-----进入修改");
 		return "admin/addReply";
 	}
 	
 	
 	

 	

	// 修改
	@RequestMapping("/moditystudreply/{sid}")
      public ModelAndView replyModiPw(@PathVariable(value = "sid") String tid,
			@RequestParam("reply") String reply, Model model) {
		if (studentService.modifyReply(reply, tid)!= 0) {
			return new ModelAndView(new RedirectView("../queryReply/{sid}"));
		} else {
			return new ModelAndView(new RedirectView("../fail.jsp"));
		}

	}

 	// 跳转页面
 	@RequestMapping("/managestu/{pn}")
 	public String manageStudent(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		
 		PageHelper.startPage(no, 5);
 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.selectStudentBySql(1,100);
 		pageIn(model, studentList);
 		request.setAttribute("slist", studentList);
 		return "admin/queryStudent";
 	}
 	// 跳转页面
 	@RequestMapping("/managestucom/{pn}")
 	public String manageStudentcom(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		
 		PageHelper.startPage(no, 5);
 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.selectStudentBySql(1,100);
 		pageIn(model, studentList);
 		request.setAttribute("slist", studentList);
 		
 		
 		return "admin/queryReply";
 	}
 		
	
 	// 跳转页面
 	@RequestMapping("/managetea/{pn}")
 	public String manageTeacher(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		List<Teacher> teacherList = new ArrayList<Teacher>();
	 	teacherList = teacherService.selectTeacherBySql(1,10);
	 	pageIn(model, teacherList);
	 	request.setAttribute("teacherList", teacherList);
 		return "admin/queryTeacher";
 	}


 	// 跳转页面
 	@RequestMapping("/managecomment/{pn}")
 	public String manageComment(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		
 		List<Comment> commentList = new ArrayList<Comment>();
	 	commentList = commentService.selectCommentBySql(1,10);
	 	pageIn(model, commentList);
	 	request.setAttribute("commentList", commentList);
 		return "admin/queryComment";
 	}
 	

 	
 	
 	
 	
 	//跳转页面
 	@RequestMapping("/managenotice/{pn}")
 	public String manageNotice(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		
 		List<Notice> noticeList = new ArrayList<Notice>();
 		noticeList = noticeService.selectNoticeBySql(1, 10);
	 	pageIn(model, noticeList);
	 	request.setAttribute("noticeList", noticeList);
	 	
	 	
 		return "admin/queryNotice";
 	}
 	
 	// 查询
 	@RequestMapping(value = "/queryNotice/{pn}", method = RequestMethod.GET)
 	public String redinotice(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {

 		int no = Integer.parseInt(pn);
// 		System.out.println("-----"+no+"----");
 		List<Notice> noticeList = new ArrayList<Notice>();
 		PageHelper.startPage(no, 5);
 		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
 		//查询全部
 		if (serc.equals("all")) {
 			
 			
 			
 	 		
 			System.out.println("------------------------------------------------------------------------------------------------");

 			noticeList = noticeService.selectNoticeBySql(1, 10);
 			pageIn(model, noticeList);
 	 		request.setAttribute("nlist", noticeList);
 			return "admin/queryNotice";

 		//根据学号查询
 		} else if (serc.equals("noticeid")) {

 			noticeList = noticeService.getByNoticeid(1, 10, condition);
 			pageIn(model, noticeList);
 			request.setAttribute("clist", noticeList);
 			System.out.println("noticeid");

 			return "admin/queryNotice";

 		
 		} else {

 			noticeList = noticeService.selectNoticeBySql(1,10);
 			pageIn(model, noticeList);
 	 		request.setAttribute("clist", noticeList);
 			return "admin/queryNotice";

 		}

 	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	//跳转页面
 	@RequestMapping("/managevideo/{pn}")
 	public String manageVideo(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		
 		List<Video> videoList = new ArrayList<Video>();
 		videoList = videoService.selectVideoBySql(1, 10);
	 	pageIn(model, videoList);
	 	request.setAttribute("videoList", videoList);
 		return "admin/queryVideo";
 	}
 	
 	
 	//跳转页面
 	@RequestMapping("/manageinvest/{pn}")
 	public String manageInvest(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		
 		List<Invest> investList = new ArrayList<Invest>();
 		investList = investService.selectInvestBySql(1, 10);
	 	pageIn(model, investList);
	 	request.setAttribute("investList", investList);
 		return "admin/queryInvest";
 	}
 	
 	// 查询
 	@RequestMapping(value = "/queryinvest/{pn}", method = RequestMethod.GET)
 	public String redirectInvest(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		List<Invest> investList = new ArrayList<Invest>();
 		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
 		
 		if (serc.equals("all")) {

 			investList = investService.selectInvestBySql(1,10);
 			pageIn(model, investList);
 	 		request.setAttribute("investList", investList);
 			return "admin/queryInvest";

 		} else if (serc.equals("investid")) {

 			investList = investService.getByInvestid(1,10,condition);
 			pageIn(model, investList);
 			request.setAttribute("investList", investList);
 			System.out.println("investList");

 			return "admin/queryInvest";

 		}
 		else {

 			investList = investService.selectInvestBySql(1,10);
 			pageIn(model, investList);
 	 		request.setAttribute("investList", investList);
 			return "admin/queryInvest";

 		}

 	}
 	
 	
 	
 	
 	
 	//删除充值
 	@RequestMapping(value = "/deleteInvest/{investid}", method = RequestMethod.GET)
 	public String deleteInvest(@PathVariable(value = "investid") String investid, Model model) {


 		if (investService.deleteInvest(investid) != 0) {
 			System.out.println("success");
 //------------------------代优化，现状：删除后需要手动刷新界面或者重新查询，不能实时刷新。---------------------------------------------------
 			return "success";
 		} else {
 			System.out.println("fail");
 			return "fail";
 			
 		}

 	}
 	
 	//添加充值
@RequestMapping("/addInvest")
public String addInvest(Invest invest, Model model) {

		if (investService.insertInvest(invest) != 0) {
			model.addAttribute("invest", invest);

			//---------------------------------待优化-----同样不能实时刷新--------------------------------------------
			return "success";
			//return new ModelAndView(new RedirectView("/StudentInfo/TeacherHandler/finalPage"));
			// return "techer/teacherFace";
		} else {
			return "fail";
			//return new ModelAndView(new RedirectView("fail"));
		}

	}

 	
 	
 	
 	// 跳转页面
 	@RequestMapping("/addstu")
 	public String adStudent() {
 		return "admin/addStudent";
 	}

 	// 跳转页面
 	@RequestMapping("/addtea")
 	public String adTeacher() {
 		return "admin/addTeacher";
 	}

 	// 跳转页面
 	@RequestMapping("/addcou")
 	public String adCourse() {
 		return "admin/addCourse";
 	}
 	// 跳转页面
 	@RequestMapping("/addnotice")
 	public String adNotice() {
 		return "admin/addNotice";
 	}
 	// 跳转页面
 	@RequestMapping("/addvideo")
 	public String adVideo() {
 		return "admin/addVideo";
 	}
 	
 	
 	
 	// 跳转页面
 	@RequestMapping("/addinvest")
 	public String adInvest() {
 		return "admin/addInvest";
 	}
 	
 	
 // 添加
 	@RequestMapping("/addTeacher")
 	public String addTeacher(Teacher teacher, Model model, HttpSession httpSession) {

 		if (teacherService.insertTeacher(teacher) != 0) {
 			model.addAttribute("teacher", teacher);

 			//---------------------------------待优化-----同样不能实时刷新--------------------------------------------
 			return "success";
 			//return new ModelAndView(new RedirectView("/StudentInfo/TeacherHandler/finalPage"));
 			// return "techer/teacherFace";
 		} else {
 			return "fail";
 			//return new ModelAndView(new RedirectView("fail"));
 		}

 	}
 	
 	

 	
 	



 	
 	
    
 	
 	
 	/**
 	 * 公告相关
 	 */
 	
 	//查询全部公告方法
	 	public void queryNotice(HttpServletRequest request) {
	 		List<Notice> noticeList = new ArrayList<Notice>();
	 		noticeList = noticeService.selectNoticeBySql(1,10);
	 		request.setAttribute("noticeList", noticeList);
	 	}
	 	
	 	

 	
 	// 查询
 	@RequestMapping(value = "/querynotice/{pn}", method = RequestMethod.GET)
 	public String redirectNotice(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		List<Notice> noticeList = new ArrayList<Notice>();
 		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
 		
 		if (serc.equals("all")) {

 			noticeList = noticeService.selectNoticeBySql(1,10);
 			pageIn(model, noticeList);
 	 		request.setAttribute("noticeList", noticeList);
 			return "admin/queryNotice";

 		} else if (serc.equals("noticeid")) {

 			noticeList = noticeService.getByNoticeid(1,10,condition);
 			pageIn(model, noticeList);
 			request.setAttribute("noticeList", noticeList);
 			System.out.println("noticeid");

 			return "admin/queryNotice";

 		} else {

 			noticeList = noticeService.selectNoticeBySql(1,10);
 			pageIn(model, noticeList);
 	 		request.setAttribute("noticeList", noticeList);
 			return "admin/queryNotice";

 		}

 	}
 	
 	
	// 跳转页面
	@RequestMapping("/moditynotice/{noticeid}")
	public ModelAndView noticeModi(@PathVariable(value = "noticeid") String noticeid, Model model) {

		return new ModelAndView(new RedirectView("/StudentInfo/admin/addNotice.jsp"));
	}

	
	
	
//	// 修改
//	@RequestMapping("/moditypasswordstu/{sid}")
//	public ModelAndView teacherModiPw(@PathVariable(value = "sid") String tid,
//			@RequestParam("spassword") String spassword, Model model) {
//		if (studentService.modifyStudentPwd(spassword, tid) != 0) {
//			return new ModelAndView(new RedirectView("../queryvitastu/{sid}"));
//		} else {
//			return new ModelAndView(new RedirectView("../fail.jsp"));
//		}
//
//	}

	
	
	
	 	//添加公告
	@RequestMapping("/addNotice")
	public String addNotice(Notice notice, Model model) {

 		if (noticeService.insertNotice(notice) != 0) {
 			model.addAttribute("notice", notice);

 			//---------------------------------待优化-----同样不能实时刷新--------------------------------------------
 			return "success";
 			//return new ModelAndView(new RedirectView("/StudentInfo/TeacherHandler/finalPage"));
 			// return "techer/teacherFace";
 		} else {
 			return "fail";
 			//return new ModelAndView(new RedirectView("fail"));
 		}

 	}
	 	
	 	
	 	//删除公告
	 	@RequestMapping(value = "/deleteNotice/{noticeid}", method = RequestMethod.GET)
	 	public String deleteNotice(@PathVariable(value = "noticeid") String noticeid, Model model) {


	 		if (noticeService.deleteNotice(noticeid) != 0) {
	 			System.out.println("success");
	 //------------------------代优化，现状：删除后需要手动刷新界面或者重新查询，不能实时刷新。---------------------------------------------------
	 			return "success";
	 		} else {
	 			System.out.println("fail");
	 			return "fail";
	 			
	 		}

	 	}
	 	
	 	/**
	 	 * 视频相关
	 	 */
 	
 	
	 	
	 	//查询全部公告方法
	 	public void queryVideo(HttpServletRequest request) {
	 		List<Video> videoList = new ArrayList<Video>();
	 		videoList = videoService.selectVideoBySql(1,10);
	 		request.setAttribute("videoList", videoList);
	 	}
	 	
	 	

 	
 	// 查询
 	@RequestMapping(value = "/queryvideo/{pn}", method = RequestMethod.GET)
 	public String redirectVideo(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		List<Video> videoList = new ArrayList<Video>();
 		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
 		
 		if (serc.equals("all")) {

 			videoList = videoService.selectVideoBySql(1,10);
 			pageIn(model, videoList);
 	 		request.setAttribute("videoList", videoList);
 			return "admin/queryVideo";

 		} else if (serc.equals("videoid")) {

 			videoList = videoService.getByVideoid(1,10,condition);
 			pageIn(model, videoList);
 			request.setAttribute("videoList", videoList);
 			System.out.println("videoid");

 			return "admin/queryVideo";

 		} else {

 			videoList = videoService.selectVideoBySql(1,10);
 			pageIn(model, videoList);
 	 		request.setAttribute("videoList", videoList);
 			return "admin/queryVideo";

 		}

 	}
 	
 	
	// 跳转页面
	@RequestMapping("/modityvideo/{videoid}")
	public ModelAndView videoModi(@PathVariable(value = "videoid") String videoid, Model model) {

		return new ModelAndView(new RedirectView("/StudentInfo/admin/addVideo.jsp"));
	}

	
	
	
//	// 修改
//	@RequestMapping("/moditypasswordstu/{sid}")
//	public ModelAndView teacherModiPw(@PathVariable(value = "sid") String tid,
//			@RequestParam("spassword") String spassword, Model model) {
//		if (studentService.modifyStudentPwd(spassword, tid) != 0) {
//			return new ModelAndView(new RedirectView("../queryvitastu/{sid}"));
//		} else {
//			return new ModelAndView(new RedirectView("../fail.jsp"));
//		}
//
//	}

	
	
	

	 	
	 	
	 	//删除公告
	 	@RequestMapping(value = "/deleteVideo/{videoid}", method = RequestMethod.GET)
	 	public String deleteVideo(@PathVariable(value = "videoid") String videoid, Model model) {


	 		if (videoService.deleteVideo(videoid) != 0) {
	 			System.out.println("success");
	 //------------------------代优化，现状：删除后需要手动刷新界面或者重新查询，不能实时刷新。---------------------------------------------------
	 			return "success";
	 		} else {
	 			System.out.println("fail");
	 			return "fail";
	 			
	 		}

	 	}
 	
	 	//添加视频
	@RequestMapping("/addVideo")
	public String addVideo(Video video, Model model) {

 		if (videoService.insertVideo(video) != 0) {
 			model.addAttribute("video", video);

 			//---------------------------------待优化-----同样不能实时刷新--------------------------------------------
 			return "success";
 			//return new ModelAndView(new RedirectView("/StudentInfo/TeacherHandler/finalPage"));
 			// return "techer/teacherFace";
 		} else {
 			return "fail";
 			//return new ModelAndView(new RedirectView("fail"));
 		}

 	}
	 	
	 	
 	/**
 	 * 教师相关
 	 */
 	
 	//查询全部教师方法
 	 	public void queryTea(HttpServletRequest request) {
 	 		List<Teacher> teacherList = new ArrayList<Teacher>();
 	 		teacherList = teacherService.selectTeacherBySql(1,10);
 	 		request.setAttribute("teacherList", teacherList);
 	 	}
 	
 	// 查询
 	@RequestMapping(value = "/queryTea/{pn}", method = RequestMethod.GET)
 	public String redirectTea(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		List<Teacher> teacherList = new ArrayList<Teacher>();
 		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
 		
 		if (serc.equals("all")) {

 			teacherList = teacherService.selectTeacherBySql(1,10);
 			pageIn(model, teacherList);
 	 		request.setAttribute("teacherList", teacherList);
 			return "admin/queryTeacher";

 		} else if (serc.equals("tid")) {

 			teacherList = teacherService.getByTeacherTid(1,10,condition);
 			pageIn(model, teacherList);
 			request.setAttribute("teacherList", teacherList);
 			System.out.println("tid");

 			return "admin/queryTeacher";

 		} else {

 			teacherList = teacherService.selectTeacherBySql(1,10);
 			pageIn(model, teacherList);
 	 		request.setAttribute("teacherList", teacherList);
 			return "admin/queryTeacher";

 		}

 	}
 	
 	

 	//删除教师
 	@RequestMapping(value = "/deleteTea/{tid}", method = RequestMethod.GET)
 	public String deleteTeacher(@PathVariable(value = "tid") String tid, Model model) {


 		if (teacherService.deleteTeacher(tid) != 0) {
 			System.out.println("success");
 //------------------------代优化，现状：删除后需要手动刷新界面或者重新查询，不能实时刷新。---------------------------------------------------
 			return "success";
 		} else {
 			System.out.println("fail");
 			return "fail";
 			
 		}

 	}

 	@RequestMapping(value = "/finalPageTea", method = RequestMethod.GET)
 	public String finalPageTea(HttpServletRequest request) {
 		queryTea(request);
 		return "admin/queryTeacher";
 	}

 	//修改定位，可优化
 	@RequestMapping(value = "/modityTea/{tid}", method = RequestMethod.GET)
 	public String editPreTea(@PathVariable("tid") String tid, HttpServletRequest request) {

 		List<Teacher> teacherList = new ArrayList<Teacher>();
 		teacherList = teacherService.getByTeacherTid(1,10,tid);
 		//model.addAttribute("teacherList", teacherList);
 		request.setAttribute("teacherList", teacherList);

 		return "admin/modiTeacher";
 	}

 	// 修改
 	@RequestMapping(value = "/modityTeac/{tid}", method = RequestMethod.GET)
 	public String update(@PathVariable("tid") String tid, Teacher teacher, HttpServletRequest request) {

 		if (teacherService.modifyTeacher(teacher) != 0) {
 			return "success";
 		} else {
 			return "fail";
 		}
 	}
    
 	
 	
 	
 	
 	
 	
    
}
