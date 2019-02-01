<%@page import="org.apache.jasper.tagplugins.jstl.core.Import" import="dto.Course"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page language="java"%> 
<%@ page contentType="text/html; charset=utf-8"%> 
<%@ page import="java.text.*"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <title>My JSP 'select-insertSC.jsp' starting page</title>
	<script type="text/javascript">
	function tijiao(){
		return confirm("确认选择课程");
	}
	</script>
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:0px 10px;}
input{text-align:center;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
</head>
  
<body>
<form action="InsertSC" method="post">
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
<tr>
        <td align="center">课程号：    </td>
    <td><input style="text-style:left;" type="text" name="crid" value="${requestScope.c1.cid}"/></td>
    <td align="center">课程名称：    </td>
    <td><input style="text-style:left;" type="text" name="crname" value="${requestScope.c1.cname}"/></td>
    <td align="center"><input type="submit" value="查询" name="query" id="btn_loca"/></td>  
</tr>    
</table>
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center" style="margin-top:10px;margin-bottom:30px">
  <tr>
  	<td width="10.5%"><div align="center"><strong>课程编号</strong></div></td>
    <td width="10.5%"><div align="center"><strong>课程名称</strong></div></td>
    <td width="8%"> <div align="center"><strong>课程类型</strong></div></td>
    <td width="8.5%"> <div align="center"><strong>开课学期</strong></div></td>
    <td width="7%"><div align="center"><strong>授课教师</strong></div></td>
    <td width="12.5%"><div align="center"><strong>上课周期</strong></div></td>
    <td width="20%"><div align="center"><strong>上课时间</strong></div></td>
    <td width="5%" align="center"><strong>操&nbsp;&nbsp;作</strong></td>
  </tr>
<c:if test="${requestScope.ctry1==null}">
<tr><td colspan="8" align="center">无符合条件的课程信息</td></tr>
</c:if>
<c:if test="${requestScope.ctry1!=null}">
  <c:forEach items="${requestScope.ctry1}" varStatus="status" var="temp">
  <tr>
  	<td><input id="font14" name="cid" style="width:100%" type="text" value="${temp.cid}" readonly/></td>
    <td><input id="font14" name="cname" style="width:100%" type="text" value="${temp.cname}" readonly/></td>
    <td><input id="font14" name="ctype" style="width:100%" type="text" value="${temp.ctype}" readonly /></td>
    <td><input id="font14" name="cterm" style="width:100%" type="text" value="${temp.cterm}" readonly /></td>
    <td><input id="font14" name="cteacher" style="width:100%" type="text" value="${temp.cteacher}" readonly /></td>
    <td><input id="font14" name="cshangke" style="width:100%" type="text" value="${temp.cshangke}" readonly /></td>
    <td><input id="font14" name="ctime" style="width:100%" type="text" value="${temp.cweekday[0]}${temp.cjieshu[0]} ${temp.cweekday[1]}${temp.cjieshu[1]} ${temp.cweekday[2]}${temp.cjieshu[2]}" readonly/></td>
    <td><div align="center"><a style="color:#213541;" href="InsertStudentCourseInto?cid=${temp.cid}" onclick="return tijiao()" >
    <img src="Images/001.gif" width="14" height="14" />选择</a></div></td>
  </tr>
  </c:forEach>
</c:if>
  <tr>
  <td colspan="8">
  	<img src="Images/blank1.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank.jpg">
     <a style="color:#213541;" href="./InsertSC?page=<%=1%>&crtype=${requestScope.c1.ctype}&crid=${requestScope.c1.cid}&crname=${requestScope.c1.cname}"><img src="Images/page_first_1.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./InsertSC?page=${requestScope.currentCount-1}&crtype=${requestScope.c1.ctype}&crid=${requestScope.c1.cid}&crname=${requestScope.c1.cname}"><img src="Images/page_back_1.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./InsertSC?page=${requestScope.currentCount+1}&crtype=${requestScope.c1.ctype}&crid=${requestScope.c1.cid}&crname=${requestScope.c1.cname}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./InsertSC?page=${requestScope.sumPageCount}&crtype=${requestScope.c1.ctype}&crid=${requestScope.c1.cid}&crname=${requestScope.c1.cname}"><img src="Images/page_last.gif"></a>
  </td>
  </tr>
  <tr>
    <td colspan="8" align="center" ><a href="blank.jsp"><input type="button" value="返回" id="btn_loca"/></a></td>
  </tr>
</table>
</form>
<input type="hidden" name="id" value="${sessionScope.userinfo.id}" />

</body>
</html>