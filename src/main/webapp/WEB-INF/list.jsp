<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="util.*,entity.*,controller.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/airsys/assets/css/main.css">
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
					<td><a href="/airsys/user/${act.id }">查看</a> 
						<a href="#" onclick="updateUser(${act.id })">编辑</a> 
						<a href="#" onclick="deleteUser(${act.id })">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
<!--  	<script type="text/javascript">
	function deleteUser(id){
		isDelete=confirm("您确认删除这条记录么")
			if(isDelete){
				window.location.href="deleteuser/"+id
			}
	}
	</script>  --> 
	<script type="text/javascript" src="/airsys/assets/js/user.js"></script> 
</body>
</html>