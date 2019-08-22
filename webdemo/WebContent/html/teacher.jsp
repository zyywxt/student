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
<title>教师信息管理</title>
</head>
<body>

	<div class="alert alert-info" role="alert" align="center">
		<a href="#" class="alert-link"><h1>教师信息管理</h1></a>
	</div>
	<form action="${pageContext.request.contextPath}/TeacherServlet"
		method="post">

		<label class="control-label" for="inputSuccess2">查询教师姓名：</label>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">@</span> <input 	type="text" class="form-control" placeholder="查询教师姓名" name="tName" aria-describedby="basic-addon1">
		</div>
		<label class="control-label" for="inputSuccess2">薪水：</label>
		<div class="input-group">
			<span class="input-group-addon">$</span> 
			<input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" name="salary" placeholder="薪水"> 
			<span class="input-group-addon">.00</span>
		</div>

		<label class="control-label" for="inputSuccess2">班级：</label>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">></span>
			 <input	type="text" class="form-control" name="clzss" placeholder="班级" 	aria-describedby="basic-addon1">
		</div>

		<label class="control-label" for="inputSuccess2">学院：</label>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">#</span>
			 <input type="text" class="form-control" name="is" placeholder="学院" 	aria-describedby="basic-addon1"><br>
		</div>

		<div align="right">
			<button type="submit" class="btn btn-primary">查询</button>
			<br>
		</div>
	</form>
	<font color:red>${mes}</font>
	<table class="table table-hover">
		<tr align="center">
			<td>数据库ID</td>
			<td>姓名</td>
			<td>薪水</td>
			<td>班级</td>
			<td>学院</td>
		</tr>

		<c:forEach items="${teacherist}" var="t">
			<tr align="center">
				<td>${t.id}</td>
				<td>${t.tname}</td>
				<td>${t.salary}</td>
				<td>${t.clzss}</td>
				<td>${t.institusion}</td>
				<td><a href="${pageContext.request.contextPath}/TeacherServlet?act=updateInit&id=${t.id}">修改</a></td>
				<td><a href="${pageContext.request.contextPath}/TeacherServlet?act=delete&id=${t.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>

	<div align="center">

		<a href="${pageContext.request.contextPath }/html/teacher_add.jsp">
		<button type="submit" class="btn btn-primary">新增教师信息</button></a>
	</div>

</body>
</html>