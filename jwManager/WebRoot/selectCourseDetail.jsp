<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'selectCourseDetail.jsp' starting page</title>
<script type="text/javascript">
function warning(s){
		if(s.cid.value==""){
			alert("课程号非空");
			s.cid.focus();
			return false;
		}
		if(s.cname.value==""){
			alert("课程名非空");
			s.cname.focus();
			return false;
		}
		if(s.ctype.value==""){
			alert("课程类型非空");
			s.cname.focus();
			return false;
		}
		return true;
}
</script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
input{text-align:center;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
<form action="UpdateCourse" method="post"  onsubmit="return warning(this)" >
  <table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <td width="20%" align="center">课程号</td>
      <td width="30%"><div align="center"><input name="cid" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cid}" readonly /></div></td>
      <td width="20%" align="center">课程名称</td>
      <td width="30%"><div align="center"><input name="cname" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cname}" readonly  /></div></td>
    </tr>
    <tr>
      <td align="center">学时</td>
      <td><div align="center"><input name="ctime" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.ctime}" readonly /></div></td>
      <td align="center">周学时</td>
      <td><div align="center"><input name="cweektime" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cweektime}" readonly /></div></td>
    </tr>
    <tr>
      <td align="center">开课学期</td>
      <td><div align="center"><input name="cterm" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cterm}" readonly /></div></td>
      <td align="center">开课院系</td>
      <td><div align="center"><input name="cdepartment" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cdepartment}" readonly /></div></td>
    </tr>
    <tr>
      <td align="center">课程类型</td>
      <td><div align="center"><input name="ctype" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.ctype}" readonly /></div></td>
      <td align="center">课程学分</td>
      <td><div align="center"><input name="cscore" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cscore}" readonly /></div></td>
    </tr>
    <tr>
      <td align="center">授课教师</td>
      <td><div align="center"><input name="cteacher" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cteacher}" readonly /></div></td>
      <td align="center">考试方式</td>
      <td><div align="center"><input name="cexam" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cexam}" readonly /></div></td>
    </tr>
    <tr>
      <td align="center">上课时间</td>
      <td><div align="center"><input name="cshangke" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cshangke}" readonly /></div></td>
      <td align="center">上课教室（选修）</td>
      <td><input name="cplace" style="width:100%;height:100%" type="text" value="${requestScope.courses.cplace}" readonly  /></td>   
    </tr>
     <tr>
      <td align="center">上课星期</td>
      <td><div align="center"><input name="cweekday" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cweekday[0]}" readonly="readonly" /></div></td>
      <td align="center">上课节数</td>
      <td><div align="center"><input name="cjieshu" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cjieshu[0]}" readonly="readonly" /></div></td>
    </tr>
     <c:if test="${requestScope.courses.cweekday[1]!=''}">
     <tr>
      <td align="center">上课星期</td>
      <td><div align="center"><input name="cweekday" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cweekday[1]}" readonly="readonly" /></div></td>
      <td align="center">上课节数</td>
      <td><div align="center"><input name="cjieshu" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cjieshu[1]}" readonly="readonly" /></div></td>
    </tr>     
     </c:if>
     <c:if test="${requestScope.courses.cweekday[2]!=''}">
     <tr>
      <td align="center">上课星期</td>
      <td><div align="center"><input name="cweekday" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cweekday[2]}" readonly="readonly" /></div></td>
      <td align="center">上课节数</td>
      <td><div align="center"><input name="cjieshu" style="width:100%;font-size:16px;" type="text" value="${requestScope.courses.cjieshu[2]}" readonly="readonly" /></div></td>
    </tr>     
     </c:if>
    <tr>
      <td align="center">内容概要</td>
      <td colspan="3" height="70px"><div align="center">
      <textarea name="cdescribe" style="width:100%;height:100%;font-size:16px" readonly>${requestScope.courses.cdescribe}</textarea>
    </div>
    </tr>
    <c:if test="${sessionScope.userinfo.role=='学生'}">
    <tr>
    <td colspan="4" align="center" ><a href="SelectAllCoursesStu"><input id="btn_loca" type="button" value="返回"/></a></td>
    </tr>     
    </c:if>
    <c:if test="${sessionScope.userinfo.role=='管理员'}">
    <tr>
    <td colspan="4" align="center" ><a href="SelectAllCoursesServlet"><input id="btn_loca" type="button" value="返回"/></a></td>
    </tr>
    </c:if>
    <c:if test="${sessionScope.userinfo.role=='教师'}">
    <tr>
    <td colspan="4" align="center" ><a href="SelectAllCoursesServlet"><input id="btn_loca" type="button" value="返回"/></a></td>
    </tr>
    </c:if>
  </table>
</form>
  </body>
</html>
