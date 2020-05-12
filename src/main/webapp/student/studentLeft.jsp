<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<nav class="navbar navbar-inverse navbar-expand-lg" role="navigation">
  <a class="navbar-brand" href="#" style="color:#ccc;font-size:28px;">Stern</a>
  <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-01"></button>
  <div class="collapse navbar-collapse" id="navbar-collapse-01">
  <ul class="nav navbar-nav mr-auto">
			<li><a href="/StudentInfo/StudentHandler/selqueryy/1"><strong>预约课程</strong></a>
			<li><a href="/StudentInfo/StudentHandler/selcouresult/${sessionScope.sid }/1"><strong>预约结果</strong></a>
			
			<li><a href="/StudentInfo/StudentHandler/exitchoose/${sessionScope.sid }/1"><strong>取消预约</strong></a>
			<li><a href="/StudentInfo/StudentHandler/endcourse/${sessionScope.sid }/1"><strong>已参加课程</strong></a>
			<li><a href="/StudentInfo/StudentHandler/queryvitastu/${sessionScope.sid }"><strong>个人信息</strong></a>
			
			<li><a href="/StudentInfo/StudentHandler/addcomment/"><strong>留言板</strong></a>
			
			
			<li><a href="/StudentInfo/StudentHandler/managenotice/1"><strong>查看公告</strong></a>
			<li><a href="/StudentInfo/StudentHandler/managevoide/1"><strong>查看视频</strong></a>
    </ul>
	<p class="navbar-text navbar-right">
	<span style="color:red;">你好！${sessionScope.sname}&emsp;&emsp;</span>
	<a href="/StudentInfo/LoginHandler/studentlogout" class="navbar-link" href="#">注销</a>
	</p>
	<!--
    <ul class="nav navbar-nav mr-auto">
      <li class="active"><a href="#fakelink">Products</a></li>
      <li><a href="#fakelink">Features</a></li>
    </ul>-->
  </div> <!--/.navbar-collapse -->
</nav><!-- /navbar -->




 


<!-- 
<div class="page">
	<section class="demo">
		<ul class="menu">

			<li><a href="/online/StudentController/selqueryy"><strong>选课</strong></a>
			<br>
			<li><a href="/online/StudentController/selcouresult/${sessionScope.sid }"><strong>查看选课结果</strong></a>
			<br>

			<li><a href="/online/StudentController/exitchoose/${sessionScope.sid }"><strong>退选</strong></a>
			<br>
			<li><a href="/online/StudentController/queryvitastu/${sessionScope.sid }"><strong>管理个人信息</strong></a>

			<br>

	</ul>
	</section>

</div> -->