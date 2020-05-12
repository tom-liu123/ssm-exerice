<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
<meta charset="UTF-8">
<title>阳光健身俱乐部管理系统</title>

<!-- 标题图标、CSS、js、jQ 
<link href="../image/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<script src="../js/fun.js" type="text/javascript"></script>-->
<script type="text/javascript" src="/StudentInfo/utils/js/jquery-3.3.1.min.js"></script>
<!-- Loading Bootstrap -->
<link href="/StudentInfo/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI Pro -->
<link href="/StudentInfo/utils/css/flat-ui.css" rel="stylesheet">
<!-- Loading Flat UI JS -->
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.min.js"></script>


<script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script><link href="/StudentInfo/utils/css/animate.css" rel="stylesheet"></head>

<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
<jsp:include page="adminLeft.jsp" />
<div class="container">
		<div class="row">
			<div class="col-md-12">
			<h5>留言管理</h5>
			
			<form name="studentquery" action="/StudentInfo/AdminHandler/query/1" method="get">
				<div class="row">
					<div class="col-md-4">
							<strong>查询条件<br></strong>
							 <select name="serc" class="form-control select select-primary select-block mbl">
								<option value="all">全部会员</option>
								<option value="sid">按会员号查询</option>

							</select>
							
					</div>
					<div class="col-md-4">
						
							
								<strong>条件</strong>
							
							<div class="form-group has-feedback">
						
						<input type="text" name="condition"  placeholder="输入值" class="form-control"/>
					
						</div> 
						
					</div>
					<div class="col-md-3 pos">
						<br>
						<input type="submit" class="btn btn-primary" value="查询" />
					</div>
				</div>
				</form>
			
			</div>
			<div class="col-md-12">
				<div class="row">
				<div class="col-md-12" >
						<div class="margin:0 15px" style="overflow-x: scroll;">
				<table  style="overflow:scroll;" class="table table-striped table-hover animated fadeIn">
			<tr>
				<th>会员号</th>
				<th>姓名</th>
				<th>留言内容</th>
				<th>回复</th>
				
				<th>修改</th>
			
			</tr>
			<c:forEach var="student" items="${requestScope.slist}">
				<tr>
					<td>${student.sid}</td>
					<td>${student.sname }</td>
					<td>${student.comment}</td>
					<td>${student.reply}</td>
					

					<td><a class="btn btn-warning" href="/StudentInfo/AdminHandler/moditysture/${student.sid}">
							回复 </a></td>

					
				</tr>

			</c:forEach>
		</table></div></div></div>
			</div>
		</div>
		
		
		
		
		<!-- 显示分页信息 -->
	<div class="row">
		<!--分页文字信息  -->
		<div class="col-md-6">当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
			页,总 ${pageInfo.total } 条记录</div>
		<!-- 分页条信息 -->
		<div class="col-md-6">
			<nav aria-label="Page navigation">
			<ul class="pagination bg-primary">
				<li><a href="/StudentInfo/AdminHandler/managestucom/1?serc=${requestScope.serc}&condition=${requestScope.condition}">首页</a></li>
				<c:if test="${pageInfo.hasPreviousPage }">
					<li><a href="/StudentInfo/AdminHandler/managestucom/${pageInfo.pageNum-1}?serc=${requestScope.serc}&condition=${requestScope.condition}'"
						aria-label="Previous"> <span aria-hidden="true">«</span>
					</a></li>
				</c:if>
 
				<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
					<c:if test="${page_Num == pageInfo.pageNum }">
						<li class="active"><a href="#">${page_Num }</a></li>
					</c:if>
					<c:if test="${page_Num != pageInfo.pageNum }">
						<li><a href="/StudentInfo/AdminHandler/managestucom/${page_Num }?serc=${requestScope.serc}&condition=${requestScope.condition}">${page_Num }</a></li>
					</c:if>
 
				</c:forEach>
				<c:if test="${pageInfo.hasNextPage }">
					<li><a href="/StudentInfo/AdminHandler/managestucom/${pageInfo.pageNum+1 }?serc=${requestScope.serc}&condition=${requestScope.condition}"
						aria-label="Next"> <span aria-hidden="true">»</span>
					</a></li>
				</c:if>
				<li><a href="/StudentInfo/AdminHandler/managestucom/${pageInfo.pages}?serc=${requestScope.serc}&condition=${requestScope.condition}">末页</a></li>
			</ul>
			</nav>
		</div>
	</div>
		
		
		
		
		

		
		<!--
		<ul class="pagination bg-info">
	        <li><a href="#">&laquo;</a></li>
	       <li><a href="#">1</a></li>
	            
	            <li><a href= "javascript:studentquery.action='${ctx}/StudentInfo/AdminHandler/query/4/6';studentquery.submit()">2</a></li>
	            <li><a href="#">4</a></li>
	            <li><a href="#">5</a></li>
	            <li><a href="#">&raquo;</a></li>
            </ul>	
		
		-->
</div>	

<script>
	$("select").select2({dropdownCssClass: 'dropdown-inverse'});
</script>
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script></body>
</html>