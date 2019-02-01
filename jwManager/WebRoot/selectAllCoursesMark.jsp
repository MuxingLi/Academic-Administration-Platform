<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>My JSP 'selectAllCoursesMark.jsp' starting page</title>
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
   <form action="SelectCourseMark" method="post">
    <table width="98%" border="0" align="center" style="margin-top:10px;margin-bottom:30px">
    <tr>
    <td width="14%" align="center">年&nbsp;&nbsp;份：
    </td>
    <td width="16%"><select name="cryear" style="width:100%">
    <option value="">-------请--选--择-------</option>
    <c:forEach items="${requestScope.year}" varStatus="status" var="temp">
    <option value="${temp.cyear}">${temp.cyear}</option>
    </c:forEach>
    </select>
    </td>
    <td width="14%" align="center">学&nbsp;&nbsp;期：
    </td>
    <td width="16%"><select name="crterm" style="width:100%">
    <option value="">-------请--选--择-------</option>
    <c:forEach items="${requestScope.term}" varStatus="status" var="temp">
    <option value="${temp.cterm}">${temp.cterm}</option>
    </c:forEach>
    </select>
    </td>    
    <td width="14%" align="center">考试方式： </td>
    <td width="16%"><select name="crexam" style="width:75%">
    <option value="">-----请选择-----</option>
    <option value="考试">考试</option>
    <option value="考察">考察</option>
    </select></td>
    <td width="13%" align="center"><input type="submit" value="查询" name="query" id="btn_loca"/></td>
    </tr>
</table>
  <table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
  	<td align="center" width="20%">上课时间</td>
    <td width="16%" align="center">课程号</td>
    <td width="16%" align="center">课程名称</td>
    <td width="16%" align="center">授课教师</td>
    <td width="16%" align="center">考试方式</td>
    <td width="16%" align="center">添加成绩</td>
  </tr>
<c:if test="${requestScope.ctry1==null}">
<tr><td colspan="6">无课程信息</td></tr>
</c:if>
<c:if test="${requestScope.ctry1!=null}">
  <c:forEach items="${requestScope.ctry1}" varStatus="status" var="temp">
  <tr>
  	<td align="center">${temp.cyear} ${temp.cterm}</td>
    <td align="center">${temp.cid}</td>
    <td align="center">${temp.cname}</td>
    <td align="center">${temp.name}</td>
    <td align="center">${temp.cexam}</td>
    <td align="center"><a style="color:#213541;" href="UpdateMark?cid=${temp.cid}"><img src="Images/114.gif" width="14" height="14" />录入成绩</a></td>
  </tr>
   </c:forEach>
</c:if>
  <tr>
  <td colspan="6">
  	<img src="Images/blank1.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank.jpg">
     <a style="color:#213541;" href="./SelectAllCoursesMark?page=<%=1%>"><img src="Images/page_first_1.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./SelectAllCoursesMark?page=${requestScope.currentCount-1}"><img src="Images/page_back_1.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./SelectAllCoursesMark?page=${requestScope.currentCount+1}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./SelectAllCoursesMark?page=${requestScope.sumPageCount}"><img src="Images/page_last.gif"></a>
  </td>
  </tr>
  <tr>
    <td colspan="6" align="center"><a style="color:#213541;" href="blank.jsp"><input id="btn_loca" type="button" value="返回"/></a></td>
    </tr>
</table>
</form>
  </body>
</html>
