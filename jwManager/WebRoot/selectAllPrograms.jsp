<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'selectAllPrograms.jsp' starting page</title>
<script type="text/javascript">
function DeleteConfirm(){
		return confirm("确定要删除吗？");
}
</script>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>

<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="center" width="24%"><div align="center">院系</div></td>
    <td align="center" width="16%"><div align="center">学期</div></td>
    <td width="45%" colspan="4" align="center"><div align="center">课程</div></td>
    <td width="16%" align="center" colspan="3"><div align="center">操作</div></td>
  </tr>
<c:if test="${requestScope.ctry1==null}">
<tr>
<td colspan="10" align="center">无教学计划信息</td>
</tr>
</c:if>
<c:if test="${requestScope.ctry1!=null}">
  <c:forEach items="${requestScope.ctry1}" varStatus="status" var="temp">
  <tr>
    <td rowspan="2" align="center">${temp.dept}<input type="hidden" value="${temp.id}" name="id" /></td>
    <td rowspan="2" align="center">${temp.term}</td>
    <td align="center" width="11%" height="20" >${temp.cid1}</td>
    <td width="11%" align="center">${temp.cid2}</td>
    <td width="11%" align="center">${temp.cid3}</td>
    <td width="11%" align="center">${temp.cid4}</td>
    <td width="8%" rowspan="2"><div align="center"><a style="color:#213541;" href="UpdateProgram?id=${temp.id}"><img src="Images/114.gif" width="14" height="14" />修改</a></div></td>
    <td width="8%" rowspan="2"><div align="center"><a style="color:#213541;" href="DeleteProgram?id=${temp.id}"  onclick="return DeleteConfirm()"><img src="Images/083.gif" width="14" height="14" />删除</a></div></td>
  </tr>
  <tr>
  <td align="center" width="11%" height="20" >${temp.cp1}</td>
  <td width="11%" align="center">${temp.cp2}</td>
  <td width="11%" align="center">${temp.cp3}</td>
  <td width="11%" align="center">${temp.cp4}</td>
  </tr>
 </c:forEach>
</c:if>
  <tr>
  <td colspan="10">
  	<img src="Images/blank1.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank.jpg">
     <a style="color:#213541;" href="./SelectAllPrograms?page=<%=1%>"><img src="Images/page_first_1.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./SelectAllPrograms?page=${requestScope.currentCount-1}"><img src="Images/page_back_1.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./SelectAllPrograms?page=${requestScope.currentCount+1}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./SelectAllPrograms?page=${requestScope.sumPageCount}"><img src="Images/page_last.gif"></a>
  </td>
  </tr>
  <tr>
    <td colspan="10" align="center"><a href="blank.jsp"><input id="btn_loca" type="button" value="返回"/></a></td>
  </tr>
</table>   

  </body>
</html>
