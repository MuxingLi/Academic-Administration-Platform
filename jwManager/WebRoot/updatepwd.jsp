<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <title>My JSP 'updatepwd.jsp' starting page</title>
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
<!--    target="_parent" -->
  <body>
 <form action="UpdateUserServlet" method="post">
    <table width="98%" border="1" align="center">
  <tr>
    <td align="center">用户名</td>
    <td><input type="text" name="name" class="txt" value="${sessionScope.userinfo.id}" readonly="readonly"></td>
  </tr>
  <tr>
    <td align="center">原密码</td>
    <td><input type="password" name="oldpassword" class="txt"><input name="role" type="hidden" value="${sessionScope.userinfo.role}"></td>
  </tr>
  <tr>
    <td align="center">密码</td>
    <td><input type="password" name="password" class="txt"></td>
  </tr>
  <tr>
    <td align="center">确认密码</td>
    <td><input type="password" name="confirmpassword" class="txt"></td>
  </tr>    
  <tr>
    <td align="center" ><a href="blank.jsp"><input type="button" value="返回" id="btn_loca"/></a></td>
    <td align="center"><input type="submit" name="change" value="更改" id="btn_loca" /></td>
  </tr>
</table>
</form>
  </body>
</html>
