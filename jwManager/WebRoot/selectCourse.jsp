<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'selectCourse.jsp' starting page</title>

<script type="text/javascript">
function DeleteConfirm(){
		return confirm("确定要删除吗？");
}
</script>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
<body>
 <form action="SelectCourse" method="post">
    <table width="98%" border="0" align="center" style="margin-top:10px;margin-bottom:30px">
    <tr>
    <td align="center">课程类型：
    </td>
    <td><select name="crtype" style="width:100%">
    <c:choose>
    <c:when test="${requestScope.c1.ctype=='选修'}">
    <option value="">----请选择----</option>
    <option value="必修">必修</option>
    <option value="选修" selected="selected">选修</option>
    </c:when>
    <c:when test="${requestScope.c1.ctype=='必修'}">
    <option value="">----请选择----</option>
    <option value="必修" selected="selected">必修</option>
    <option value="选修">选修</option>
    </c:when>
    <c:otherwise>
    <option value="">----请选择----</option>
    <option value="必修">必修</option>
    <option value="选修">选修</option>
    </c:otherwise>
    </c:choose>
    </select>
    </td>
    <td align="center">课程号：
    </td>
    <td><input type="text" name="crid" value="${requestScope.c1.cid}"/>
    </td>    
    <td align="center">课程名：
    </td>
    <td><input type="text" name="crname" value="${requestScope.c1.cname}"/>
    </td>
    <td align="center"><input type="submit" value="查询" name="query" id="btn_loca"/></td>
    </tr>
</table>
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="center" width="12%"><div align="center">课程号</div></td>
    <td align="center" width="24%"><div align="center">课程名称</div></td>
    <td align="center" width="11%"><div align="center">授课教师</div></td>    
    <td align="center" width="9%"><div align="center">课程类型</div></td>    
    <td align="center" colspan="3"><div align="center">操作</div></td>
  </tr>
<c:if test="${requestScope.ctry1==null}">
<tr>
<td colspan="7" align="center">无符合条件课程信息</td>
</tr>
</c:if>
<c:if test="${requestScope.ctry1!=null}">
  <c:forEach items="${requestScope.ctry1}" varStatus="status" var="temp">
  <tr>
    <td align="center">${temp.cid}</td>
    <td align="center">${temp.cname}</td>
    <td align="center">${temp.cteacher}</td>
    <td align="center">${temp.ctype}</td>
    <c:if test="${sessionScope.userinfo.role=='学生'}">
    <td width="14%"><div align="center"><a style="color:#213541;" href="SelectCourseDetail?cid=${temp.cid}"><img src="Images/document.png" width="14" height="14" />查看</a></div></td>
	</c:if>
	<c:if test="${sessionScope.userinfo.role=='教师'}">
	<td width="14%"><div align="center"><a style="color:#213541;" href="SelectCourseDetail?cid=${temp.cid}"><img src="Images/document.png" width="14" height="14" />查看</a></div></td>
	</c:if>
	 <c:if test="${sessionScope.userinfo.role=='管理员'}">
	<td width="14%"><div align="center"><a style="color:#213541;" href="SelectCourseDetail?cid=${temp.cid}"><img src="Images/document.png" width="14" height="14" />查看</a></div></td>
    <td width="14%"><div align="center"><a style="color:#213541;" href="UpdateCourse?cid=${temp.cid}"><img src="Images/114.gif" width="14" height="14" />修改</a></div></td>
    <td width="14%"><div align="center"><a style="color:#213541;" href="DeleteCourseById?cid=${temp.cid}"  onclick="return DeleteConfirm()"><img src="Images/083.gif" width="14" height="14" />删除</a></div></td>
  	</c:if>
  </tr>
 </c:forEach>
</c:if>
  <tr>
  <td colspan="7">
  	<img src="Images/blank1.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank.jpg">
     <a style="color:#213541;" href="./SelectCourse?page=<%=1%>&crtype=${requestScope.c1.ctype}&crid=${requestScope.c1.cid}&crname=${requestScope.c1.cname}"><img src="Images/page_first_1.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./SelectCourse?page=${requestScope.currentCount-1}&crtype=${requestScope.c1.ctype}&crid=${requestScope.c1.cid}&crname=${requestScope.c1.cname}"><img src="Images/page_back_1.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./SelectCourse?page=${requestScope.currentCount+1}&crtype=${requestScope.c1.ctype}&crid=${requestScope.c1.cid}&crname=${requestScope.c1.cname}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./SelectCourse?page=${requestScope.sumPageCount}&crtype=${requestScope.c1.ctype}&crid=${requestScope.c1.cid}&crname=${requestScope.c1.cname}"><img src="Images/page_last.gif"></a>
  </td>
  </tr>
  <tr>
    <td colspan="7" align="center"><a href="blank.jsp"><input id="btn_loca" type="button" value="返回"/></a></td>
  </tr>
</table>   
</form>
</body>
</html>
