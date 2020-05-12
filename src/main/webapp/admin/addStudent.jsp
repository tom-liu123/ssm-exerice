<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	 $(document).ready(
			function() {
				$("#sid").change(
						function() {
							$.post("/StudentInfo/AjaxHandler/existSid?sid="
									+ $("#sid").val(), function(data, status) {
								$("#countsid").html(data);
							})

						})

			})

</script>
<script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script><link href="/StudentInfo/utils/css/animate.css" rel="stylesheet"></head>

<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
	<jsp:include page="adminLeft.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5>添加会员</h5>
				
				
				
				
				<form action="/StudentInfo/AdminHandler/addStudent" method="post" name="form1">
				
				
					<div class="row">
						<div class="col-md-6">
							<h6>会员号</h6>
							<input type="text" name="sid" id="sid" class="form-control" oninput = "value=value.replace(/[^\d]/g,'')" maxlength="12"></input>
							<span id="countsid" style="color: #ff0000;"></span>
							<h6>姓名</h6>
							<input type="text" name="sname" class="form-control" onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')" maxlength="4"></input>
							<h6>联系方式</h6>
							<input type="text" name="sidcard" class="form-control" oninput = "value=value.replace(/[^\d]/g,'')" maxlength="11"></input>
							<h6>性别</h6>

							<label class="radio" for="radio1"> <input type="radio"
								name="ssex" value="男" id="radio1" data-toggle="radio"
								class="custom-radio"> <span class="icons"> <span
									class="icon-unchecked"></span> <span class="icon-checked"></span>
							</span> <font style="vertical-align: inherit;"> <font
									style="vertical-align: inherit;"> 男 </font>
							</font>
							</label> <label class="radio" for="radio2"> <input type="radio"
								name="ssex" value="女" id="radio2" data-toggle="radio"
								class="custom-radio"> <span class="icons"> <span
									class="icon-unchecked"></span> <span class="icon-checked"></span>
							</span> <font style="vertical-align: inherit;"> <font
									style="vertical-align: inherit;"> 女 </font>
							</font>
							</label>

							<h6>密&nbsp;&nbsp;码</h6>
							<input type="password" name="spassword" class="form-control" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"/>
						</div>
						<div class="col-md-6">
							<h6>年龄</h6>
							<input type="text" name="sage" class="form-control" maxlength="2"></input>
							
							
							<h6>家庭住址</h6>
							<input type="text" name="classr" class="form-control" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"/>
							
							<h6>开始日期</h6>
							<input type="text" name="profession" class="form-control" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"/>
							</select>
							
							<h6>截止日期</h6>
							<input type="text" name="college" class="form-control" oninput = "this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"/>
							
						</div>
						<div class="col-md-12">
							<br> <input type="submit"
								class="btn btn-primary btn-wide login-btn" value="添加" />
						</div>
					</div>
				</form>
				
				
				
				

			</div>
		</div>
	</div>

<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script>



	
</body>
</html>