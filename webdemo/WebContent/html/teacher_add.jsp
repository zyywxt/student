<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>教师信息添加</title>
</head>
<body>
	<div class="alert alert-info" role="alert" align="center">
		<a href="#" class="alert-link"><h1>教师信息添加</h1></a>
	</div>

	<form action="${pageContext.request.contextPath }/TeacherServlet"
		method="post">
		<input type="hidden" name="act" value="edit">
		 <input type="hidden" name="id" value="${teacher.id}">
		  姓名:<input name="tname" value="${teacher.tname}">
		  薪水：<input name="salary" value="${teacher.salary}">
		   班级:<input 	name="clzss" value="${teacher.clzss}"> 
		   学院:<input 	name="institusion" value="${teacher.institusion}"> 
		   <input type="submit" value="提交信息">
	</form>
</body>
</html>