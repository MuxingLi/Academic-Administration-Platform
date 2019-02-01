<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'selectAllTeachers.jsp' starting page</title>
    
<script type="text/javascript">
function DeleteConfirm(){
		return confirm("确定要删除吗？");
}
</script>
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
 <body>
  <form action="SelectTeacher" method="post">
    <table width="98%" border="0" align="center" style="margin-top:10px;margin-bottom:30px">
    <tr>
    <td align="center">院系：
    </td>
    <td><select name="tdepartment" style="width:100%">
    <option value="">---------请选择---------</option>
    <c:forEach items="${requestScope.dept}" varStatus="status" var="temp">
    <option value="${temp.techdepartment}">${temp.techdepartment}</option>
    </c:forEach>
    </select>
    </td>
    <td align="center">职称：
    </td>
    <td><select name="tzhicheng" style="width:100%">
    <option value="">---------请选择---------</option>
    <c:forEach items="${requestScope.zhicheng}" varStatus="status" var="temp">
    <option value="${temp.techzhicheng}">${temp.techzhicheng}</option>
    </c:forEach>
    </select>
    </td>    
    <td align="center">姓名：
    </td>
    <td><input type="text" name="tname" value=""/>
    </td>
    <td align="center">工号：
    </td>
    <td><input type="text" name="tid" value=""/>
    </td>
    <td align="center"><input type="submit" value="查询" name="query" id="btn_loca"/></td>
    </tr>
</table>
    <table width="98%" border="0" align="center">
  	<tr>
    <td><div align="center">工号</div></td>
    <td><div align="center">姓名</div></td>
    <td><div align="center">院系</div></td>
    <td><div align="center">职称</div></td>
    <td colspan="3"><div align="center">操作</div></td>
    </tr>
    <c:if test="${requestScope.ttry1==null}">
<tr><td colspan="5" align="center">无教师信息</td></tr>
    </c:if>
 	<c:if test="${requestScope.ttry1!=null}">
  	<c:forEach items="${requestScope.ttry1}" varStatus="status" var="temp">
  	<tr>
    <td align="center">${temp.id}</td>
    <td align="center">${temp.name}</td>
    <td align="center">${temp.techdepartment}</td>
    <td align="center">${temp.techzhicheng}</td>
	<c:if test="${sessionScope.userinfo.role=='管理员'}">
 	<td><div align="center"><a style="color:#213541;" href="SelectTeacherDetail?id=${temp.id}"><img src="Images/document.png" width="14" height="14" />查看</a></div></td> 
    <td><div align="center"><a style="color:#213541;" href="UpdateTeacher?id=${temp.id}"><img src="Images/114.gif" width="14" height="14" />修改</a></div></td>
 	<td><div align="center"><a style="color:#213541;" href="DeleteTeacher?id=${temp.id}" onclick="return DeleteConfirm()"><img src="Images/083.gif" width="14" height="14" />删除</a></div></td>
 	</c:if>
 	</tr>
    </c:forEach>
  </c:if>  
  <tr>
  <td colspan="7">
  	<img src="Images/blank1.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank.jpg">
     <a style="color:#213541;" href="./SelectAllTeachersServlet?page=<%=1%>&tid=${requestScope.t1.id}&tname=${requestScope.t1.name}&tzhicheng=${requestScope.t1.techzhicheng}&tdepartment=${requestScope.t1.techdepartment}"><img src="Images/page_first_1.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./SelectAllTeachersServlet?page=${requestScope.currentCount-1}&tid=${requestScope.t1.id}&tname=${requestScope.t1.name}&tzhicheng=${requestScope.t1.techzhicheng}&tdepartment=${requestScope.t1.techdepartment}"><img src="Images/page_back_1.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./SelectAllTeachersServlet?page=${requestScope.currentCount+1}&tid=${requestScope.t1.id}&tname=${requestScope.t1.name}&tzhicheng=${requestScope.t1.techzhicheng}&tdepartment=${requestScope.t1.techdepartment}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./SelectAllTeachersServlet?page=${requestScope.sumPageCount}&tid=${requestScope.t1.id}&tname=${requestScope.t1.name}&tzhicheng=${requestScope.t1.techzhicheng}&tdepartment=${requestScope.t1.techdepartment}"><img src="Images/page_last.gif"></a>
  </td>
  </tr>
  <tr>
  <td colspan="8" align="center"><a href="blank.jsp"><input id="btn_loca" type="button" value="返回"/></a></td>
  </tr>
</table>
</form>
  </body>
</html>
