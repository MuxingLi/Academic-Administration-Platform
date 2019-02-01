<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'updateStudentMark.jsp' starting page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function mark(){
return confirm("确定添加成绩？");
}

</script>
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
input{text-align:center;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <form action="UpdateMark" method="post"  onsubmit="return mark()">
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
      <td ><div align="center"><input border="0" name="id" style="width=100%;font-size:16px;" type="text" value="${temp.id}"/></div></td>
      <td><div align="center"><input border="0" name="name" style="width=100%;font-size:16px;" type="text" value="${temp.name}"/></div></td>
      <td><div align="center"><input border="0" name="cterm" style="width=100%;font-size:16px;" type="text" value="${temp.cterm}"/></div></td>
      <td><div align="center"><input border="0" name="cexam" style="width=100%;font-size:16px;" type="text" value="${temp.cexam}"/></div></td>
      <c:if test="${temp.cexam=='考察'}">
         <td><div align="center"><select name="scmark" style="width: 150px; ">
         <option selected="selected">---------请选择---------</option>
         <option value="优秀">优秀</option>
         <option value="良好">良好</option>
         <option value="中等">中等</option>
         <option value="及格">及格</option>
         <option value="不及格">不及格</option>         
         </select></div></td>
      </c:if>
      <c:if test="${temp.cexam=='考试'}">
      <td><div align="center"><input type="text" name="scmark" ></div></td>
      </c:if>
    </tr>
  </c:forEach>
</c:if>
    <tr>
      <td colspan="2" align="center"><a href="SelectAllCoursesMark"><input type="button" value="返回" id="btn_loca"/></a></td>
      <td colspan="3" align="center"><input type="hidden" name="cid" value="${requestScope.mark1.cid}"><input type="submit" value="提交" id="btn_loca"/></td>
    </tr>
  </table>
  
 </form>
</body>
</html>
