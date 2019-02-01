<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'selectAllCoursesStu.jsp' starting page</title>
  <link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center" style="margin-top:10px;">
  <tr>
    <td align="center" width="15%"><div align="center">课程号</div></td>
    <td align="center" width="21%"><div align="center">课程名称</div></td>
    <td align="center" width="11%"><div align="center">授课教师</div></td>    
    <td align="center" width="9%"><div align="center">课程类型</div></td>    
    <td align="center" colspan="3"><div align="center">操作</div></td>
  </tr>
<c:if test="${requestScope.ctry1==null}">
<tr>
<td colspan="7" align="center">无课程信息</td>
</tr>
</c:if>
<c:if test="${requestScope.ctry1!=null}">
  <c:forEach items="${requestScope.ctry1}" varStatus="status" var="temp">
  <tr>
    <td align="center">${temp.cid}</td>
    <td align="center">${temp.cname}</td>
    <td align="center">${temp.cteacher}</td>
    <td align="center">${temp.ctype}</td>
    <td width="14%"><div align="center"><a style="color:#213541;" href="SelectCourseDetail?cid=${temp.cid}"><img src="Images/document.png" width="14" height="14" />查看</a></div></td>
  </tr>
 </c:forEach>
</c:if>
  <tr>
  <td colspan="7">
  	<img src="Images/blank1.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank.jpg">
     <a style="color:#213541;" href="./SelectAllCoursesStu?page=<%=1%>"><img src="Images/page_first_1.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./SelectAllCoursesStu?page=${requestScope.currentCount-1}"><img src="Images/page_back_1.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./SelectAllCoursesStu?page=${requestScope.currentCount+1}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./SelectAllCoursesStu?page=${requestScope.sumPageCount}"><img src="Images/page_last.gif"></a>
  </td>
  </tr>
  <tr>
    <td colspan="7" align="center"><a href="blank.jsp"><input id="btn_loca" type="button" value="返回"/></a></td>
  </tr>
</table>   
  </body>
</html>
