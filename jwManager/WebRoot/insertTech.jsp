<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'insertTech.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<STYLE type="text/css">
	#btn_loca2{line-height:15px; height:27px; width:60px;}
	</STYLE>
  </head>
  
  <body>
	<form method="post" action="UpLoadTeacherServlet" enctype="multipart/form-data">
	选择一个文件:
	<input type="file" name="uploadFile" /><span style="width:80px"></span><input type="submit" value="上传" id="btn_loca2" />
	</form>
  </body>
</html>
