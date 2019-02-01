<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'blank.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

/* body{background-image:url(Images/book2-1.jpg);
background-repeat:no-repeat;
background-size:100% 580px;}
#div1{float:left;position:fixed;bottom:0px;} */

#box{
width:100%;
height:100%;
background-image:url(Images/book1-4.jpg);
background-size:100% 480px;
opacity:0.9;
filter:"alpha(opacity=90)";
background-repeat:no-repeat;
}
</style>

  </head>
  
  <body>
  <div id=box>
  </div>
  
  

  </body>
</html>
