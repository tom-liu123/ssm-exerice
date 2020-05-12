<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
<meta charset="UTF-8">
<title>阳光健身俱乐部管理系统</title>

<!-- 标题图标、CSS、js、jQ 
<link href="/online/image/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="/online/css/main.css">

<script src="/online/js/fun.js" type="text/javascript"></script>-->
<script type="text/javascript" src="/StudentInfo/utils/js/jquery-3.3.1.min.js"></script>

<!-- Loading Bootstrap -->
<link href="/StudentInfo/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI Pro -->
<link href="/StudentInfo/utils/css/flat-ui.css" rel="stylesheet">
<!-- Loading Flat UI JS -->
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.min.js"></script>


<script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script>
<script type='text/javascript' src="/StudentInfo/utils/scripts/video.js"></script>
<link href="/StudentInfo/utils/css/animate.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/StudentInfo/utils/css/video.css" />
</head>

<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
<jsp:include page="studentLeft.jsp" />
<div class="container">
		<div class="row">
			<div class="col-md-12">
			<h5>视频详情</h5>
			<c:forEach var="video" items="${requestScope.videoList}">							
			    <form method="get">
					
					
					
					<video id="myVideo"  width="100%" height="500" autoplay="" controls="" src="${video.videohref }">
        <!--判断是否支持其播放器-->
        <!-- <source /> -->
        <!-- 您的浏览器不支持video标签 -->
    </video>
    <br />
<button id="playPause" onclick="playPause();">播放</button>
<button onclick="goBack(5);">快进5秒</button>
<button onclick="goBack(-5);">快退5秒</button>
<button onclick="volume(0.1);">音量+</button>
<button onclick="volume(-0.1);">音量-</button>
<button id="isMuted" onclick="isMuted();">静音</button>

<div class="row">			
						<div class="col-md-6">
						  <!--    <h6>视频id</h6>
							<a>${video.videoid }</a>-->
							<h6>视频类型</h6>
							<a>${video.videotype }</a>
							<!-- <h6>视频链接</h6>
							<a>${video.videohref }</a>-->
							<h6>视频描述</h6>
							<a>${video.videodesc }</a>
						</div>						
					</div>
				</form>
			</c:forEach>
					
					
					
					

</body>

			
			

		
			</div></div></div>


<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script></body>
</html>