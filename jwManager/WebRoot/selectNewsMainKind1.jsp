<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'selectNewsMainKind1.jsp' starting page</title>

  </head>
  
  <body bgcolor="#e8ecee">
<table align="center" width="98%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td height="50px" width="90%" style="font-size:40px;font-weight:500;font-family:'隶书'; text-align:center">在 线 教 务 管 理 平 台</td>
<td width="10%" style="font-size:20px; font-weight:bold;text-align:center"><a style="color:#213541;text-decoration:none;" href="login.jsp">登录</a></td>
</tr></table>
<table bgcolor="#a6b5be" width="98%" align="center" style="margin-top:10px;margin-bottom:10px"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30px" align="center" style="font-size:20px;font-weight:bold"><a style="color:#213541;text-decoration:none;" href="SelectNewsMainKind?ntype=<%="考试管理"%>">考试管理</a></td>
    <td align="center" style="font-size:20px;font-weight:bold"><a style="color:#213541;text-decoration:none;" href="SelectNewsMainKind?ntype=<%="实践教学"%>">实践教学</a></td>
    <td align="center" style="font-size:20px;font-weight:bold"><a style="color:#213541;text-decoration:none;" href="SelectNewsMainKind?ntype=<%="基础教务"%>">基础教务</a></td>
  </tr>
</table>
<form action="SelectNewsMainKind1" method="post">
<table align="center" style="margin-top:20px;margin-bottom:15px" width="978" border="1" cellspacing="0" cellpadding="0" bordercolor="#666666">
  <tr>
    <td height="30px" width="80%">
    <input type="text" value="" name="search" value="${requestScope.search}" style="font-size:15px;width:100%; border:0px;background-color:#e8ecee "/>
    </td>
    <td width="20%" style="font-size:20px; font-weight:bold;text-align:center"><input type="submit" value="查询" name="query" id="btn_loca"/></td>
  </tr>
  <tr></tr>
</table>


<table width="90%" align="center" border="0" cellspacing="0" cellpadding="0">
<tr>
  <td width="98%" height="50" align="center">
    <input style="border:0px;width:100%;background-color:#e8ecee;text-align:center;font-size:30px;font-weight:bold;" id="in-bg" value="${requestScope.type1}" name="ntype" type="text"/>
   </td>
</tr>
<c:if test="${requestScope.stry1==null}">
	<tr>
	<td style="font-size:18px" align="center">目前无公告</td>
    </tr>
</c:if>
<c:if test="${requestScope.stry1!=null}">
 	<c:forEach items="${requestScope.stry1}" varStatus="status" var="temp">
  	<tr>
  	<td style="font-size:18px"><a style="color:#213541;text-decoration:none;" href="SelectNewsMainDetail?nid=${temp.nid}">${temp.ntitle}</a></td>
  	</tr>
  </c:forEach>
</c:if>
  	<tr>  	
    <td>
  	<img src="Images/blank1-g.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank-g.jpg">
     <a style="color:#213541;" href="./SelectNewsMainKind1?page=<%=1%>&search=${requestScope.search}&ntype=${requestScope.type1}"><img src="Images/page_first_1-g.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./SelectNewsMainKind1?page=${requestScope.currentCount-1}&search=${requestScope.search}&ntype=${requestScope.type1}"><img src="Images/page_back_1-g.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./SelectNewsMainKind1?page=${requestScope.currentCount+1}&search=${requestScope.search}&ntype=${requestScope.type1}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./SelectNewsMainKind1?page=${requestScope.sumPageCount}&search=${requestScope.search}&ntype=${requestScope.type1}"><img src="Images/page_last.gif"></a>
  </td>
  	</tr>
</table>
</form>
  </body>
</html>
