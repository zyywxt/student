<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>学生信息</title>
</head>
<body>
	<div class="alert alert-info" role="alert" align="center">
		<a href="#" class="alert-link"><h1>学生信息</h1></a>
	</div>

	<form action="${pageContext.request.contextPath}/studentservlet"
		method="post">

		<div class="form-group has-success has-feedback">
			<label class="control-label" for="inputSuccess2">查询学生姓名：</label>
			 <input 	type="text" class="form-control" type="text" name="sname" placeholder="请输入查询的姓名" aria-describedby="inputSuccess2Status">
			<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span> 
			<span id="inputSuccess2Status" class="sr-only">(success)</span>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1" class="control-label">查询学生学号：</label>
			<input type="text" class="form-control" name="stuno" 	placeholder="请输入查询的学号">
			<div align="right">
				<button type="submit" class="btn btn-primary">查询</button>
			</div>
		</div>
	</form>

	<table class="table table-bordered">
		<tr align="center">
			<td>数据库ID</td>
			<td>学号</td>
			<td>姓名</td>
			<td>年 龄</td>
			<td>性 别</td>
			<td>班 级</td>
		</tr>
		<c:forEach items="${studentList}" var="s">
			<tr align="center">
				<td>${s.id}</td>
				<td>${s.stuNo}</td>
				<td>${s.stuName}</td>
				<td>${s.age}</td>
				<td>${s.sex}</td>
				<td>${s.clzss}</td>
				<td><a
					href="${pageContext.request.contextPath}/DelStuServlet?id=${s.id}">删除</a></td>
				<td><a
					href="${pageContext.request.contextPath}/StuUpdateServlet?id=${s.id}&&stuNo=${s.stuNo}&&stuName=${s.stuName}&&age=${s.age}&&sex=${s.sex}&&clzss=${s.clzss}">修改</a></td>

			</tr>
		</c:forEach>
	</table>
	<div align="center">
		<a href="${pageContext.request.contextPath}/html/studentAdd.jsp">
			<button type="submit" class="btn btn-primary">新增学生信息</button>
		</a>
	</div>
</body>
</html>