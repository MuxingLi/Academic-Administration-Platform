<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'right_top.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="Css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		function gettime(){
        document.getElementById("time").innerHTML = new Date().toLocaleString()
                + ' 星期' + '日一二三四五六'.charAt(new Date().getDay());
		window.setTimeout("gettime()",1000);
                }
        window.onload = gettime;
</script>
  </head>
  
<body id="righ_top_body">

<div id="right_top">
  <div id="loginout">
    <div id="loginoutimg"><img src="Images/loginout.gif" /></div>
	<span class="logintext"><a href="login.jsp" target="_parent">注　销</a></span>	 
  </div>			
</div>
<div id="right_font">
<div id=time></div>
</div>
<!--<input type="hidden" value="(#fc4f08橘色;#79909d浅灰蓝;#ccc 浅灰;#375987 稍深浅灰蓝;#37596D 原始蓝灰)" >-->
</body>
</html>
