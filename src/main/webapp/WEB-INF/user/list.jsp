<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="util.*,entity.*,controller.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>账号界面</title>
</head>
<body>
	<h3 align="center">账号信息</h3>
	<hr color="red">
	<center>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>余额</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${acts}" var="act">
				<tr>
					<td>${act.id }</td>
					<td>${act.name }</td>
					<td>${act.balance }</td>
					<td>
						<a href="/user/${act.id }" >查看</a>
						<a href="#">编辑</a>
						<a href="#">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>