<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>My JSP 'updateStudent.jsp' starting page</title>

<script type="text/javascript">
function warning(s){
		if(s.stuid.value==""){
			alert("学号非空");
			s.stuid.focus();
			return false;
		}
		if(s.stuname.value==""){
			alert("姓名非空");
			s.stuname.focus();
			return false;
		}

		if(s.stubirth.value==""){
			alert("生日非空");
			s.stuname.focus();
			return false;
		}
		if(s.stutel.value==""){
			alert("电话非空");
			s.stuname.focus();
			return false;
		}
		if(s.stuenterdate.value==""){
			alert("入学日期非空");
			s.stuname.focus();
			return false;
		}
		if(s.stuleavedate.value==""){
			alert("毕业日期非空");
			s.stuname.focus();
			return false;
		}
		if(s.stuclassid.value==""){
			alert("班级非空");
			s.stuname.focus();
			return false;
		}
		
		return true;
}
</script>
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Css/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<form action="UpdateStudent" method="post"  onsubmit="return warning(this)" >
<table width="98%" border="1" align="center">
<tr>
    <td colspan="2" width="15%"><div align="center">学号<a style="color:red;">*</a></div></td>
    <td width="27%" colspan="2"><input name="stuid" style="width:100%;height:100%" type="text" value="${requestScope.students.id}" readonly /></td>
    <td width="15%"><div align="center">姓名<a style="color:red;">*</a></div></td>
    <td colspan="2" width="27%"><input name="stuname" type="text" style="width:100%;height:100%" value="${requestScope.students.name}" readonly/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">出生日期<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="stubirth" style="width:100%;height:100%" type="text" value="${requestScope.students.stubirth}" onfocus="WdatePicker({el:$dp.$(this)})"/></td>
    <td><div align="center">性别</div></td>
     <td colspan="2" width="27%"><input name="stusex" style="width:100%;height:100%"value="${requestScope.students.stusex}"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">身份证号</div></td>
    <td colspan="2"><input name="stuidentity" style="width:100%;height:100%" type="text" value="${requestScope.students.stuidentity}" /></td>
    <td width="15%"><div align="center">民族</div></td>
    <td><input name="stunation" style="width:100%;height:100%" type="text" value="${requestScope.students.stunation}" /></td>
  </tr>
<tr>
    <td colspan="2"><div align="center">政治面貌</div></td>
    <td colspan="2"><input name="stulook" style="width:100%;height:100%" type="text" value="${requestScope.students.stulook}" /></td>
    <td><div align="center">生源地</div></td>
    <td colspan="2"><input name="stubirthplace" style="width:100%;height:100%" type="text" value="${requestScope.students.stulook}" /></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">联系电话<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="stutel" style="width:100%;height:100%" type="text" value="${requestScope.students.stutel}" /></td>
    <td><div align="center">邮箱</div></td>
    <td colspan="3"><input name="stuemail" style="width:100%;height:100%" type="text" "${requestScope.students.stuemail}" /></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">联系人</div></td>
    <td colspan="2"><input name="stucontacter" style="width:100%;height:100%" type="text" value="${requestScope.students.stucontacter}" /></td>
    <td><div align="center">联系人电话</div></td>
    <td colspan="3"><input name="stuhometel" style="width:100%;height:100%" type="text" value="${requestScope.students.stuhometel}" /></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">家庭住址</div></td>
    <td colspan="6"><input name="stuaddress" style="width:100%;height:100%" type="text" value="${requestScope.students.stuaddress}" /></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">入学时间<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="stuenterdate" style="width:100%;height:100%" type="text" value="${requestScope.students.stuenterdate}" onfocus="WdatePicker({el:$dp.$(this)})"/></td>
    <td><div align="center">毕业时间<a style="color:red;">*</a></div></td>
    <td colspan="3"><input name="stuleavedate" style="width:100%;height:100%" type="text" value="${requestScope.students.stuleavedate}" onfocus="WdatePicker({el:$dp.$(this)})"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">所属院系</div></td>
    <td colspan="2"><input name="studepartment" style="width:100%;height:100%" type="text" value="${requestScope.students.studepartment}" /></td>
    <td><div align="center">专业信息</div></td>
    <td colspan="3"><input name="stumajor" style="width:100%;height:100%" type="text" value="${requestScope.students.stumajor}" /></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">班级<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="stuclassid" style="width:100%;height:100%" type="text" value="${requestScope.students.stuclassid}" /></td>
    <td><div align="center">学生状态</div></td>
    <td colspan="3"><input name="stustatus"style="width:100%;height:100%" type="text" value="${requestScope.students.stustatus}" /></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">寝室信息</div></td>
    <td colspan="6"><input name="sturoomid" style="width:100%;height:100%" type="text" value="${requestScope.students.sturoomid}" /></td>
  </tr>
  <tr>
    <td colspan="2" height="70"><div align="center">备注</div></td>
    <td colspan="6"><textarea name="sturemark" style="width:100%;height:100%"  >${requestScope.students.sturemark}</textarea></td>
  </tr>
  <tr>
  <c:if test="${sessionScope.userinfo.role=='管理员'}">
    <td colspan="4" align="center" ><a href="SelectAllStudentsServlet"><input type="button" value="返回" id="btn_loca"/></a></td>
    <td colspan="4" align="center" ><input type="submit" value="更新" name="update" id="btn_loca"/></td>
  </c:if>
  <c:if test="${sessionScope.userinfo.role=='学生'}">
    <td colspan="4" align="center" ><a href="blank.jsp"><input type="button" value="返回" id="btn_loca"/></a></td>
    <td colspan="4" align="center" ><input type="submit" value="更新" name="update" id="btn_loca"/></td>
  </c:if>
  </tr>
</table>
<input name="role" value="${sessionScope.userinfo.role}" type="hidden" />
</form>
</body>
</html>
