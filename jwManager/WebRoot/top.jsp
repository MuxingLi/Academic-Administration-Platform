<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'table.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
<body>
<div id="top">
	<div id="user">欢迎您:&nbsp;&nbsp;${sessionScope.userinfo.role}&nbsp;&nbsp;${sessionScope.userinfo.id}  </div>	 
</div>
</body>
</html>
