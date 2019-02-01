<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'main.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<link href="Css/main.css" rel="stylesheet" type="text/css" />

  </head>
  
  <frameset rows="60,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frameset rows="*" cols="188,*" framespacing="0" frameborder="no" border="0">
    <frame src="left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" />
    <frameset rows="73,*" cols="*">
      <frame src="right_top.jsp" name="mainFrame" id="mainFrame" />
      <frame name="aaa" src="blank.jsp"  />
    </frameset>
  </frameset>
</frameset>
<noframes>
<body>
</body>
</noframes>

