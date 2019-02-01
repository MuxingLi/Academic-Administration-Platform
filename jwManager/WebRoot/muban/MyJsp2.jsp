<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">



<html>
<head>
<title>Untitled Document</title>

<link href="css/css.css" rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript">
function Judge(){
	var WebUserNO,user_pw
	WebUserNO=document.all["WebUserNO"].value;
	if(WebUserNO=="")
	   {alert("登录用户不能为空！");
	   document.all["WebUserNO"] .focus();
	   return false;
	   }
}
</script>
</head>
<body bgcolor="#F8F8F8" leftmargin="0" topmargin="0" rightmargin="0" bottommargin="0">
<form name="LoginForm" method="post" action="ACTIONLOGON.APPPROCESS?mode=4">
<table width="100%" cellpadding="0" class="Table1" bordercolor="#4ab902" border="1" cellspacing="0">
        <tr>
          <td height="25" align="right">官方网站：</td>
          <td>http://www.17tian.com</td>
        </tr>
        <tr>
          <td height="25" align="right">技术支持：</td>
          <td>QQ:1725440647 MAIL:1725440647@qq.com</td>
        </tr>
        <tr>
          <td height="25" align="right">版权所有：</td>
          <td>免费模板网</td>
        </tr>
        <tr>
          <td height="25" align="right">版权说明：</td>
          <td>免费模板网免费授权使用本系统，但不可将本系统用于销售用途！</td>
        </tr>
      </table>
</form>		
</body>
</html>
<script language="JavaScript">
 
</script>
