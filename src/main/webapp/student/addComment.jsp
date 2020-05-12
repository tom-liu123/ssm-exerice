<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head><script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
		<meta charset="UTF-8">
		<title>阳光健身俱乐部管理系统</title>
		<script type="text/javascript" src="/StudentInfo/utils/js/jquery-3.3.1.min.js"></script>
		<!-- Loading Bootstrap -->
		<link href="/StudentInfo/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
		<!-- Loading Flat UI Pro -->
		<link href="/StudentInfo/utils/css/flat-ui.css" rel="stylesheet">
		<!-- Loading Flat UI JS -->
		<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.min.js"></script>	
		<script type="text/javascript">


		</script>		
	<script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script><link href="/StudentInfo/utils/css/animate.css" rel="stylesheet"></head>
	
	<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
	<jsp:include page="studentLeft.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h5>添加留言</h5>
				
				
			<form
			action="/StudentInfo/StudentHandler/modityreplystud/${sessionScope.sid }"
			

			method="get">
					
						
					   <h6>留言内容</h6>
						
						<textarea name="comment" cols="20" rows="6" class="form-control"></textarea>
						
						
						
						
               		
				
						
						
						<input type="submit" value="添加" class="btn btn-primary btn-wide login-btn" style="margin-top:2rem"/>	
				</form>
			</div>
		</div>	
	</div>
	<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script></body>
</html>