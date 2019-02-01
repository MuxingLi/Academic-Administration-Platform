<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员登录</title>
<script type="text/javascript">
	function login111() {
		
		window.location.href="LoginServlet";
	}
</script>

<link href="Css/login.css" rel="stylesheet" type="text/css" />
  </head>
  
<body bgcolor="#f5f5f5">
<div id="login">
	     <div id="top">
		      <div id="top_left">
		      </div>
			  <div id="top_center"></div>
		 </div>
	<div id="center">
		 <div id="center_left"></div>
		 <div id="center_middle">
	<form name="login" method="post" action="LoginServlet">	 
	<table border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="25">&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="35" align="right" id="user" >用户名：</td>
          <td><input name="username" type="text" class="Input" /></td>
      </tr>
        <tr>
          <td height="35" align="right" id="password">密&nbsp;&nbsp;码：</td>
          <td><input name="password" type="password" class="Input"/></td>
        </tr>
        <tr>
          <td height="50" colspan="2" align="center">
          	<input type="radio" name="role" value="学生" checked="checked"/>学生
          	<input value="教师" type="radio" name="role"/>教师
         	<input value="管理员" type="radio" name="role"/>管理员</td>
      </tr>
        <tr >
            <td align="right" id="btn" height="30"> <input type="submit" name="submit" value="登  录" id="sub" /></td>
            <td align="left"><input type="reset" name="reset" value="清  空" id="sub"/></td>
               </tr>
    </table>	
    </form>  
		 </div>
		 <div id="center_right"></div>		 
	</div>
	<div id="down">
		 <div id="down_left">
        </div>
		<div id="down_center"></div>		 
	</div>
</div>
</body>
</html>