<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'updateStudentMark2.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript">
function mark(){
return confirm("确定修改成绩？");
}

</script>
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
input{text-align:center; }
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <form action="UpdateMark2" method="post"  onsubmit="return mark()">
  <table width="98%" border="1" cellspacing="0" cellpadding="0"  align="center">
    <tr>
      <td width="20%" align="center">学生学号</td>
      <td width="20%" align="center">学生姓名</td>
      <td width="20%" align="center">上课学期</td>
      <td width="20%" align="center">考试类型</td>
      <td width="20%" align="center">添加成绩</td>
    </tr>
<c:if test="${requestScope.mark!=null}">
  <c:forEach items="${requestScope.mark}" varStatus="status" var="temp">
    <tr>
      <td align="center"><input border="0" name="id" style="width=100%;font-size:16px;" type="text" value="${temp.id}"/></td>
      <td align="center"><input border="0" name="name" style="width=100%;font-size:16px;" type="text" value="${temp.name}"/></td>
      <td align="center"><input border="0" name="cterm" style="width=100%;font-size:16px;" type="text" value="${temp.cterm}"/></td>
      <td align="center"><input border="0" name="cexam" style="width=100%;font-size:16px;" type="text" value="${temp.cexam}"/></td>
      <c:if test="${temp.cexam=='考察'}">
         <td align="center"><select name="scmark" style="width: 150px; ">
         <c:choose>
         <c:when test="${temp.scmark=='优秀'}">
         <option value="优秀" selected="selected">优秀</option>
         <option value="良好">良好</option>
         <option value="中等">中等</option>
         <option value="及格">及格</option>
         <option value="不及格">不及格</option> 
         </c:when>
         <c:when test="${temp.scmark=='良好'}">
         <option value="优秀">优秀</option>
         <option value="良好" selected="selected">良好</option>
         <option value="中等">中等</option>
         <option value="及格">及格</option>
         <option value="不及格">不及格</option> 
         </c:when>
         <c:when test="${temp.scmark=='中等'}">
         <option value="优秀">优秀</option>
         <option value="良好">良好</option>
         <option value="中等" selected="selected">中等</option>
         <option value="及格">及格</option>
         <option value="不及格">不及格</option> 
         </c:when>
         <c:when test="${temp.scmark=='及格'}">
         <option value="优秀">优秀</option>
         <option value="良好">良好</option>
         <option value="中等">中等</option>
         <option value="及格" selected="selected">及格</option>
         <option value="不及格">不及格</option> 
         </c:when>
         <c:when test="${temp.scmark=='不及格'}">
         <option value="优秀">优秀</option>
         <option value="良好">良好</option>
         <option value="中等">中等</option>
         <option value="及格">及格</option>
         <option value="不及格" selected="selected">不及格</option> 
         </c:when>
         <c:otherwise>
         <option value="优秀">优秀</option>
         <option value="良好">良好</option>
         <option value="中等">中等</option>
         <option value="及格">及格</option>
         <option value="不及格">不及格</option>   
         </c:otherwise>
         </c:choose>
         </select></td>
      </c:if>
      <c:if test="${temp.cexam=='考试'}">
      <td align="center"><input type="text" name="scmark" value="${temp.scmark}" ></td>
      </c:if>
    </tr>
  </c:forEach>
</c:if>
    <tr>
      <td colspan="2" align="center"><a href="SelectAllCoursesMark"><input type="button" value="返回" id="btn_loca"/></a></td>
      <td colspan="3" align="center"><input type="hidden" name="cid" value="${requestScope.mark1.cid}"><input id="btn_loca" type="submit" value="更新" /></td>
    </tr>
  </table>
  
 </form>
</body>
</html>
