<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'selectApplyTech.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <form action="SelectApplyTech" method="post">
    <table width="98%" border="0" align="center" style="margin-top:10px;margin-bottom:30px">
    <tr>
    <td align="center">申请时间：
    </td>
    <td><input type="text" name="atime" value="" onclick="" /></td>
    <td align="center">使用时间： </td>
    <td><input type="text" name="ausetime" value="" onclick="WdatePicker({el:$dp.$(this)})" /></td>    
    <td align="center">申请状态： </td>
    <td><input type="text" name="astatus" value=""/></td>
    <td align="center"><input type="submit" value="查询" name="query" id="btn_loca"/></td>
    </tr>
</table>  
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="center">申请时间</td>
    <td align="center">申请教室</td>
    <td align="center">使用日期</td>
    <td align="center">使用时间</td>
    <td align="center">申请状态</td>
    <td align="center">操作</td>
  </tr>
<c:if test="${requestScope.atry1==null}">
<tr>
<td colspan="7" align="center">无教室申请信息</td>
</tr>
</c:if>
<c:if test="${requestScope.atry1!=null}">
  <c:forEach items="${requestScope.atry1}" varStatus="status" var="temp">
  <tr>
    <td align="center">${temp.time}</td>
    <td align="center">${temp.building}&nbsp;${temp.no}</td>
    <td align="center">${temp.usetime}</td>
    <td align="center">${temp.jieshu}</td>
    <td align="center">${temp.status}</td>
    <td><div align="center">
    <a style="color:#213541;" href="SelectApplyTechDetail?id=${temp.id}&building=${temp.building}&no=${temp.no}&jieshu=${temp.jieshu}&usetime=${temp.usetime}">
    <img src="Images/document.png" width="14" height="14" />查看
    </a></div></td>
  </tr>
</c:forEach>
</c:if>
<tr>
  <td colspan="7">
  	<img src="Images/blank1.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank.jpg">
     <a style="color:#213541;" href="./SelectAllApplyTech?page=<%=1%>"><img src="Images/page_first_1.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./SelectAllApplyTech?page=${requestScope.currentCount-1}"><img src="Images/page_back_1.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./SelectAllApplyTech?page=${requestScope.currentCount+1}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./SelectAllApplyTech?page=${requestScope.sumPageCount}"><img src="Images/page_last.gif"></a>
  </td>
  </tr>
  <tr>
    <td colspan="7" align="center"><a href="blank.jsp"><input id="btn_loca" type="button" value="返回"/></a></td>
  </tr>
</table>
</form>
  </body>
</html>
