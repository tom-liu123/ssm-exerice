<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
<meta charset="UTF-8">
<title>学生信息管理系统</title>

<!-- 标题图标、CSS、js、jQ
<link href="../image/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<script src="../js/fun.js" type="text/javascript"></script> -->
<script type="text/javascript" src="/StudentInfo/utils/js/jquery-3.3.1.min.js"></script>
<!-- Loading Bootstrap -->
		<link href="/StudentInfo/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
		<!-- Loading Flat UI Pro -->
		<link href="/StudentInfo/utils/css/flat-ui.css" rel="stylesheet">
		<!-- Loading Flat UI JS -->
		<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.min.js"></script>	


<script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script>
<link href="/StudentInfo/utils/css/animate.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/StudentInfo/utils/css/checkVideo.css">
</head>

<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>

<jsp:include page="studentLeft.jsp" />
<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5>视频教程</h5>
				<form name="videoquery" action="/StudentInfo/StudentHandler/checkVideo/1" method="get">
	            </form>
	            
		    </div>
		
		    
		     
			<div class="col-md-12">
			   <div class="row">
			       <div class="col-md-12" >
			           <div class="margin:0 15px" style="overflow-x: scroll;">
			           
			<div  class="row ">           
		 <c:forEach var="video" items="${requestScope.videoList}">
			<div id="course1">
				<div id="course1_top">
					<span>${video.videoid }</span>
				</div>
				<div id="course_main">
			
				     <h3>${video.videotype }</h3>
				     <a>${video.videodesc }</a>
			
				     <a href="${video.videohref }"><button id="choose">查看</button></a>
				   <a  href="/StudentInfo/StudentHandler/moditycheck/${video.videoid}">
						<button id="choose">查看 </button>	</a>
				</div>
			</div>
		</c:forEach>	
	
			           
			  </div>   
			 
    
			           
			           </div>
			       </div>
			   </div>
			</div>
			
	
	   </div>
	
	
	
		<!-- 显示分页信息 -->
		
				<!-- 显示分页信息 -->
	<div class="row">
		<!--分页文字信息  -->
		<div class="col-md-6">当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
			页,总 ${pageInfo.total } 条记录</div>
		<!-- 分页条信息 -->
		<div class="col-md-6">
			<nav aria-label="Page navigation">
			<ul class="pagination bg-primary">
				<li><a href="/StudentInfo/StudentHandler/checkVideo/1?serc=${requestScope.serc}&condition=${requestScope.condition}">首页</a></li>
				<c:if test="${pageInfo.hasPreviousPage }">
					<li><a href="/StudentInfo/StudentHandler/checkVideo/${pageInfo.pageNum-1}?serc=${requestScope.serc}&condition=${requestScope.condition}"
						aria-label="Previous"> <span aria-hidden="true">«</span>
					</a></li>
				</c:if>
 
				<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
					<c:if test="${page_Num == pageInfo.pageNum }">
						<li class="active"><a href="#">${page_Num }</a></li>
					</c:if>
					<c:if test="${page_Num != pageInfo.pageNum }">
						<li><a href="/StudentInfo/StudentHandler/checkVideo/${page_Num }?serc=${requestScope.serc}&condition=${requestScope.condition}">${page_Num }</a></li>
					</c:if>
 
				</c:forEach>
				<c:if test="${pageInfo.hasNextPage }">
					<li><a href="/StudentInfo/StudentHandler/checkVideo/${pageInfo.pageNum+1}?serc=${requestScope.serc}&condition=${requestScope.condition}"
						aria-label="Next"> <span aria-hidden="true">»</span>
					</a></li>
				</c:if>
				<li><a href="/StudentInfo/StudentHandler/checkVideo/${pageInfo.pages}?serc=${requestScope.serc}&condition=${requestScope.condition}">末页</a></li>
			</ul>
			</nav>
		</div>
	</div>

	
	
	
</div>	

<script>
	$("select").select2({dropdownCssClass: 'dropdown-inverse'});
	
</script>
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script></body>
</html>