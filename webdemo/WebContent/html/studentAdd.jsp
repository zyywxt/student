<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>学生信息新增</title>
</head>
<body>
	<div class="alert alert-info" role="alert" align="center">
		<a href="#" class="alert-link"><h1>学生信息新增</h1></a>
	</div>


	<form action="${pageContext.request.contextPath}/StudentAddServlet"
		method="post">
		<input type="hidden" name="id" value="${id }"> 
		学生姓名:<input type="text" name="stuName" value="${stuName} "> 
		学生学号:<input type="text" name="stuNo" value="${stuNo}">
		 性别：<select name="sex" value="${sex}">
			<c:choose>
				<c:when test="${sex eq '男'}">
					<option selected="selected">男</option>
					<option>女</option>
				</c:when>
				<c:when test="${sex eq '女'} ">
					<option selected="selected">女</option>
					<option>男</option>
				</c:when>
				<c:otherwise>
					<option selected="selected">男</option>
					<option>女</option>
				</c:otherwise>
			</c:choose>

		</select> 
		年龄：<input type="text" name="age" value="${age}"> 
		班级:<input	type="text" name="clzss" value="${clzss}"> 
		<input 	type="submit" class="btn btn-lg btn-primary" value="提交表单">

	</form>
	

</body>
</html>