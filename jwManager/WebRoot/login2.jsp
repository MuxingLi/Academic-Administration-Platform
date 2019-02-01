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
<script type="text/javascript" src="js/checkCode.js" charset="GBK"></script>
<link href="Css/Style.css" rel="stylesheet" type="text/css" />

</head>

<body>

<div id="LoginTop">
	<div class="BarLeft"></div>
	<div class="BarRight"></div>
    
    <div class="Cal"></div>
</div>
<form id="AdminLogin" name="login" method="post" action="LoginServlet">
<div id="LoginBox">
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="25">&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="35" align="right" class="FontWeight">用户名：</td>
          <td><input name="username" type="text" class="Input" id="AdminName" /></td>
      </tr>
        <tr>
          <td height="35" align="right" class="FontWeight">密码：</td>
          <td><input name="password" type="password" class="Input" id="AdminPass" /></td>
        </tr>
        <tr>
          <td height="10" colspan="2" align="center"><input type="radio" name="role" value="学生" checked="checked"/>学生<input value="教师" type="radio" name="role"/>教师<input value="管理员" type="radio" name="role"/>管理员</td>
      </tr>
        <tr>
            <td height="40" colspan="2" align="center"><input type="submit" name="submit" class="Button" id="Submits" value="登录" />
       
        </tr>
    </table>
</div>
</form>
</body>
</html>