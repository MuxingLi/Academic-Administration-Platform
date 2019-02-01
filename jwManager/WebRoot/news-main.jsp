<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'news-main.jsp' starting page</title>
<script type="text/javascript">
myimages=new Array("Images/pic1.jpg","Images/pic2.jpg","Images/pic3.jpg");
function autochange(){
	left();
	tid=setTimeout("autochange()",1000);
}
function stopchange(){
	clearTimeout(tid);
}
</script>
<style type="text/css">
#btn_loca{line-height:15px; height:30px; width:50px;}
#in-bg{background-color:#303030;text-align:center;font-size:20px;font-weight:bold;color:#fff}
</style>
  </head>
  
  <body bgcolor="#e8ecee">
<table align="center" width="80%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30px" width="90%" style="font-size:30px;font-weight:500;font-family:'隶书'; text-align:center">在 线 教 务 管 理 平 台</td>
    <td width="10%" style="font-size:20px; font-weight:bold;text-align:center"><a style="color:#213541;text-decoration:none;" href="login.jsp">登录</a></td>
  </tr>
  <tr>
    <td colspan="2" onmouseover="stopchange()"  onmouseout="autochange()" height="190px" align="center"><img src="Images/pic2.jpg" width="1080" height="190" /></td>
  </tr>
</table>

<form action="SelectNewsMainSearch" method="post">
<table align="center" style="margin-top:30px;margin-bottom:30px" width="80%" border="1" cellspacing="0" cellpadding="0" bordercolor="#666666">
  <tr>
    <td height="30px" width="90%">
    <input type="text" value="" name="search" style="font-size:15px;width:100%; border:0px;background-color:#e8ecee "/>
    </td>
    <td width="10%" style="font-size:20px; font-weight:bold;text-align:center"><input type="submit" value="查询" name="query" id="btn_loca"/></td>
  </tr>
  <tr></tr>
</table>


<table align="center" width="80%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width="43%" height="100%">
<table width="100%" align="center" border="1" cellspacing="0" cellpadding="0">
<tr>
  <td width="100%" height="50" bgcolor="#303030" align="center">
    <input style="border:0px;width:100%;" id="in-bg" value="考试管理" name="ntype" type="text"/>
   </td>
</tr>
<c:if test="${requestScope.t1==null}">
	<tr>
	<td style="font-size:18px" align="center">目前无公告</td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
</c:if>
<c:if test="${requestScope.t1!=null}">
 	<c:forEach items="${requestScope.t1}" varStatus="status" var="temp">
  	<tr>
  	<td style="font-size:18px" height="25px"><a style="color:#213541;text-decoration:none;" href="SelectNewsMainDetail?nid=${temp.nid}">${temp.ntitle}</a></td>
  	</tr>
  </c:forEach>
  	<tr>
  	<td style="font-size:18px" align="center"><a style="color:#213541; text-decoration:none;" href="SelectNewsMainKind?ntype=考试管理">查看更多</a></td>
  	</tr>
</c:if>
</table>
</td>

<td width="14%"></td>

<td width="43%">
<table width="100%" align="center" border="1" cellspacing="0" cellpadding="0">
<tr>
    <td width="100%" height="50" bgcolor="#303030" align="center">
    <input style="border:0px;width:100%;text-align:center;" id="in-bg" value="实践教学" name="ntype" type="text"/>
    </td>
</tr>
<c:if test="${requestScope.t2==null}">
	<tr>
	<td style="font-size:18px" align="center">目前无公告</td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
</c:if>
<c:if test="${requestScope.t2!=null}">
 	<c:forEach items="${requestScope.t2}" varStatus="status" var="temp">
  	<tr>
  	<td style="font-size:18px"><a style="color:#213541;text-decoration:none;" href="SelectNewsMainDetail?nid=${temp.nid}">${temp.ntitle}</a></td>
  	</tr>
  </c:forEach>
  	<tr>
  	<td style="font-size:18px" align="center"><a style="color:#213541; text-decoration:none;" href="SelectNewsMainKind?ntype=实践教学">查看更多</a></td>
  	</tr>
</c:if>
</table>
</td>
</tr>

</table>
</form>
  </body>
</html>
