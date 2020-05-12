<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-expand-lg" role="navigation">
  <a class="navbar-brand" href="#"style="color:#ccc;font-size:28px;">Stern</a>
  <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-01"></button>
  <div class="collapse navbar-collapse" id="navbar-collapse-01">
  <ul class="nav navbar-nav mr-auto" >

			<li><a href="/StudentInfo/AdminHandler/managestu/1"><strong>会员管理</strong></a>
		
			<li><a href="/StudentInfo/AdminHandler/managetea/1"><strong>教练管理</strong></a>  
			
			
			
			
			<li><a href="/StudentInfo/CourseHandler/managecou/1"><strong>课程管理</strong></a>
			
			
		<!-- 
			<li><a href="/StudentInfo/AdminHandler/addstu"><strong>添加学生</strong></a>
			
			<li><a href="/StudentInfo/AdminHandler/addtea"><strong>添加教师</strong></a>
			
			<li><a href="/StudentInfo/AdminHandler/addcou"><strong>添加课程</strong></a>
		 -->		
			
			<li><a href="/StudentInfo/AdminHandler/managestucom/1"><strong>留言管理</strong></a>
			<li><a href="/StudentInfo/AdminHandler/managenotice/1"><strong>公告管理</strong></a>
		<!--<li><a href="/StudentInfo/AdminHandler/addnotice"><strong>添加公告</strong></a> -->
		    <li><a href="/StudentInfo/AdminHandler/managevideo/1"><strong>视频管理</strong></a>
		<!--<li><a href="/StudentInfo/AdminHandler/addvideo"><strong>添加视频</strong></a> -->
		<li><a href="/StudentInfo/AdminHandler/manageinvest/1"><strong>充值管理</strong></a>
		
		 	
		</ul>
 
	<p class="navbar-text navbar-right" style="color:red;">你好！${sessionScope.aname} &emsp;&emsp;<a href="/StudentInfo/LoginHandler/adminlogout" class="navbar-link" href="#">注销</a></p>
	<!--
    <ul class="nav navbar-nav mr-auto">
      <li class="active"><a href="#fakelink">Products</a></li>
      <li><a href="#fakelink">Features</a></li>
    </ul>-->
  </div> <!--/.navbar-collapse -->
</nav><!-- /navbar -->



