<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'insertPro.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <STYLE type="text/css">
	#btn_loca2{line-height:15px; height:27px; width:60px;}
	</STYLE>
  </head>
  
  <body>
    <form method="post" action="UpLoadProgram" enctype="multipart/form-data">
	选择一个文件:
	<input type="file" name="uploadFile" /><span style="width:80px"></span><input type="submit" value="上传" id="btn_loca2" />
	</form>
  </body>
</html>
