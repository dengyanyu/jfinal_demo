<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="toadd">添加</a><br>
	
	<div>
		<form id="f" action="/user/page">
			<input name="pn" id="pn" value="${page.pageNumber }">
			<input name="ps"  id="ps" value="${page.pageSize }"><br>
			<input name="username" value="${username}"><br>
			<input name="password" value="${password}"><br>
			<input type="submit">
		</form>
	</div>
	<script>
		function go(p){
			document.getElementById("pn").value=p;
			document.getElementById("f").submit();
		}
	</script>
	当前 ${page.pageNumber}/${page.totalPage }<br>
	<a>首页</a>
	<a href="javascript:go(${page.pageNumber-1});">上一页</a>
	<a>${page.pageNumber}</a>
	<a href="javascript:go(${page.pageNumber+1});">下一页</a>
	<a>尾页</a>
	
 	<table border="1">
 		<tr>
 				<td>用户名</td>
 				<td>密码</td>
 		</tr>
 		<c:forEach var="u" items="${page.list}">
 			<tr>
 				<td>${u.username }</td>
 				<td>${u.password }</td>
 				<td>${u.listCardList()}</td>
 			</tr>
 		</c:forEach>
 	</table>
 	<img src="http://127.0.0.1:8080/user/qr?nr=http://www.baidu.com/">
</body>
</html>