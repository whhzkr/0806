<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="/ThreeDay06/src/com/whh/servlet/Myservlet.java" method="post">
		用户名<input type="text" name="username"><br>
		密码<input type="password" name="password"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>