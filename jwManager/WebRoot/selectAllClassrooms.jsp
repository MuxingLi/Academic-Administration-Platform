<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'selectAllClassrooms.jsp' starting page</title>
    
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
  <form action="SelectClassroom" method="post">
    <table width="98%" border="0" align="center" style="margin-top:10px;margin-bottom:30px">
    <tr>
    <td  style="width:20%" align="center">教学楼：
    </td>
    <td style="width:25%"><select name="rmbuilding" style="width:75%">
    <option value="">------------请选择------------</option>
    <c:forEach items="${requestScope.build}" varStatus="status" var="temp">
    <option value="${temp.rbuilding}">${temp.rbuilding}</option>
    </c:forEach>
    </select>
    </td>
    <td style="width:20%" align="center">教室大小：
    </td>
    <td style="width:25%"><select name="rmseat" style="width:75%">
    <option value="">------------请选择------------</option>
    <option value="大">大</option>
    <option value="中">中</option>
    <option value="小">小</option>
    </select>
    </td>
    <td style="width:10%" align="center"><input type="submit" value="查询" name="query" id="btn_loca"/></td>
    </tr>
</table>
    <table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
  	<tr>
    <td width="14%"><div align="center" >教学楼</div></td>
    <td width="14%"><div align="center">教室号</div></td>
    <td width="14%"><div align="center">大小</div></td>
    <td width="14%"><div align="center">备注</div></td>
    <td colspan="3"><div align="center">操作</div></td>
    </tr>
     <c:if test="${requestScope.ctry1==null}">
     <td colspan="7">无教室信息</td>
     </c:if>
 	 <c:if test="${requestScope.ctry1!=null}">
  	 <c:forEach items="${requestScope.ctry1}" varStatus="status" var="temp">
  	<tr>
    <td align="center">${temp.rbuilding}</td>
    <td align="center">${temp.rno}</td>
    <td align="center">${temp.rseat}</td>
    <td align="center">${temp.rremark}</td>
    <c:if test="${sessionScope.userinfo.role=='教师'}">
    <td width="14%"><div align="center"><a style="color:#213541;" href="SelectClassroomDetail?rno=${temp.rno}&rbuilding=${temp.rbuilding}"><img src="Images/document.png" width="14" height="14" />查看</a></div></td> 
    <td width="14%"><div align="center"><a style="color:#213541;" href="ApplyClassroom?rno=${temp.rno}&rbuilding=${temp.rbuilding}"><img src="Images/list-star1.png" width="14" height="14" />申请</a></div></td> 
     </c:if>
     <c:if test="${sessionScope.userinfo.role=='管理员'}">
 	<td width="14%"><div align="center"><a style="color:#213541;" href="SelectClassroomDetail?rno=${temp.rno}&rbuilding=${temp.rbuilding}"><img src="Images/document.png" width="14" height="14" />查看</a></div></td> 
    <td width="14%"><div align="center"><a style="color:#213541;" href="UpdateClassroom?rno=${temp.rno}&rbuilding=${temp.rbuilding}"><img src="Images/114.gif" width="14" height="14" />修改</a></div></td>
 	 <td width="14%"><div align="center"><a style="color:#213541;" href="DeleteClassroom?rno=${temp.rno}&rbuilding=${temp.rbuilding}" onclick="return DeleteConfirm()"><img src="Images/083.gif" width="14" height="14" />删除</a></div></td>
 	</c:if>
 	</tr>
    </c:forEach>
  </c:if>
  <tr>
  <td colspan="7">
  	<img src="Images/blank1.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank.jpg">
     <a style="color:#213541;" href="./SelectAllClassroomsServlet?page=<%=1%>"><img src="Images/page_first_1.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./SelectAllClassroomsServlet?page=${requestScope.currentCount-1}"><img src="Images/page_back_1.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./SelectAllClassroomsServlet?page=${requestScope.currentCount+1}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./SelectAllClassroomsServlet?page=${requestScope.sumPageCount}"><img src="Images/page_last.gif"></a>
  </td>
  </tr>
  <tr>
  <td colspan="8" align="center"><a href="blank.jsp"><input type="button" value="返回" id="btn_loca"/></a>
  </tr>
</table>
</form>
  </body>
</html>
