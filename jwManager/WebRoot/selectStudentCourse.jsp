<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'selectStudentCourse.jsp' starting page</title>
<script type="text/javascript">
function DeleteConfirm(){
		return confirm("确定要删除吗？");
}
</script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    

<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
input{text-align:center;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
 <body>
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center" style="margin-top:10px;">
  <tr>
  	<td width="6.5%"><div align="center">课程编号</div></td>
    <td width="7.5%"><div align="center">课程名称</div></td>
    <td width="6.5%"><div align="center">课程类型</div></td>
    <td width="10.5%"><div align="center">开课学期</div></td>
    <td width="7%"><div align="center">授课教师</div></td>
    <td width="12.5%"><div align="center">上课周期</div></td>
    <td width="18.5%"><div align="center">上课时间</div></td>
    <td width="5%"><div align="center">操作</div></td>
  </tr>
<c:if test="${requestScope.ctry1==null}">
<tr><td colspan="8" align="center">无选课信息</td></tr>
</c:if>
<c:if test="${requestScope.ctry1!=null}">
  <c:forEach items="${requestScope.ctry1}" varStatus="status" var="temp">
  <tr>
  	<td><input name="cid" style="width:100%;font-size:16px;" type="text" value="${temp.cid}" readonly="readonly"/></td>
    <td><input name="cname" style="width:100%;font-size:16px;" type="text" value="${temp.cname}" readonly="readonly"/></td>
    <td><input name="ctype" style="width:100%;font-size:16px;" type="text" value="${temp.ctype}" readonly="readonly" /></td>
    <td><input name="cterm" style="width:100%;font-size:16px;" type="text" value="${temp.cyear} ${temp.cterm}" readonly="readonly" /></td>
    <td><input name="cteacher" style="width:100%;font-size:16px;" type="text" value="${temp.cteacher}" readonly="readonly" /></td>
    <td><input name="cshangke" style="width:100%;font-size:16px;" type="text" value="${temp.cshangke}" readonly="readonly" /></td>
    <td><input name="ctime" style="width:100%;font-size:16px;" type="text" value="${temp.cweekday[0]}${temp.cjieshu[0]} ${temp.cweekday[1]}${temp.cjieshu[1]} ${temp.cweekday[2]}${temp.cjieshu[2]}" readonly="readonly"/></td>
     <td align="center" ><a style="color:#213541;" href="DeleteStudentCourse?cid=${temp.cid}&cterm=${temp.cyear} ${temp.cterm}"><img src="Images/083.gif" width="14" height="14"  onclick="return DeleteConfirm()"/>删除</a></td>
  </tr>
  </c:forEach>
</c:if>
<tr>
  <td colspan="8">
  	<img src="Images/blank1.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank.jpg">
     <a style="color:#213541;" href="./SelectStudentCourse?page=<%=1%>"><img src="Images/page_first_1.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./SelectStudentCourse?page=${requestScope.currentCount-1}"><img src="Images/page_back_1.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./SelectStudentCourse?page=${requestScope.currentCount+1}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./SelectStudentCourse?page=${requestScope.sumPageCount}"><img src="Images/page_last.gif"></a>
  </td>
  </tr>


  <tr>
    <td colspan="8" align="center" ><a href="blank.jsp"><input type="button" value="返回" id="btn_loca"/></a></td>
  </tr>
</table>
<input type="hidden" name="id" value="${sessionScope.userinfo.id}" />
</form>
</body>
</html>
