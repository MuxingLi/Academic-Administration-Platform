<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
    <title>My JSP 't.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function warning(s){
		if(s.techid.value==""){
			alert("工号非空");
			s.techid.focus();
			return false;
		}
		if(s.techname.value==""){
			alert("姓名非空");
			s.techname.focus();
			return false;
		}
		if(s.techbirth.value==""){
			alert("生日非空");
			s.techbirth.focus();
			return false;
		}
		if(s.techtel.value==""){
			alert("电话非空");
			s.techtel.focus();
			return false;
		}
		if(s.techenterdate.value==""){
			alert("入职日期非空");
			s.techenterdate.focus();
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
<form action="UpdateTeacher" method="post"  onsubmit="return warning(this)" >
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td width="13%"><div align="center">工号<a style="color:red;">*</a></div></td>
    <td width="15%" colspan="2"><input name="techid" style="width:100%;height:100%" type="text" value="${requestScope.teachers.id}" readonly/></td>
    <td width="13%"><div align="center">姓名<a style="color:red;">*</a></div></td>
    <td width="15%" colspan="2"><input name="techname" type="text" style="width:100%;height:100%" value="${requestScope.teachers.name}" readonly/></td>
    <td width="13%"><div align="center">性别</div></td>
    <td width="15%" colspan="2"><input name="techsex" style="width:100%;height:100%" value="${requestScope.teachers.techsex}" readonly/></td>
   
  </tr>
  <tr>
	<td><div align="center">出生日期<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="techbirth" style="width:100%;height:100%" type="text" value="${requestScope.teachers.techbirth}" onfocus="WdatePicker({el:$dp.$(this)})"/></td>
    <td><div align="center">身份证号</div></td>
    <td colspan="5">
    <input name="techidentity" style="width:100%;height:100%" type="text" value="${requestScope.teachers.techidentity}" /></td> 
    </tr>
  <tr>
      <td><div align="center">民族</div></td>
    <td colspan="2"><input name="technation" style="width:100%;height:100%" type="text" value="${requestScope.teachers.technation}" /></td>
   <td><div align="center">职称</div></td>
    <td colspan="2"><input name="techzhicheng"  style="width:100%;height:100%" type="text" value="${requestScope.teachers.techzhicheng}" /></td>
    <td ><div align="center">所属院系</div></td>
    <td colspan="2"><input name="techdepartment" style="width:100%;height:100%" type="text" value="${requestScope.teachers.techdepartment}" /></td>
  </tr>
  <tr>
    <td><div align="center">入职时间<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="techenterdate" style="width:100%;height:100%" type="text"value="${requestScope.teachers.techenterdate}" onFocus="WdatePicker({el:$dp.$(this)})"/></td>
    <td width="13%"><div align="center">电话<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="techtel" style="width:100%;height:100%" type="text" value="${requestScope.teachers.techtel}" /></td> 
    <td><div align="center">政治面貌</div></td>
    <td colspan="2"><input name="techlook" style="width:100%;height:100%" type="text"  value="${requestScope.teachers.techlook}" /></td>
  </tr>
  <tr>
  	<td><div align="center">家庭住址</div></td>
    <td colspan="8">      <input name="techaddress"  style="width:100%;height:100%" type="text" value="${requestScope.teachers.techaddress}" /></td>
  </tr>
  <tr>
    <td height="75"><div align="center">受教育经历</div></td>
    <td colspan="8"><textarea name="techeducation" style="width:100%;height:100%" >${requestScope.teachers.techeducation}</textarea></td>
    </tr>
  <tr>
    <td height="75"><div align="center">获得奖项</div></td>
    <td colspan="8"><textarea name="techaward" style="width:100%;height:100%" >${requestScope.teachers.techaward}</textarea></td>
    </tr>
  <tr>
    <td height="75"><div align="center">科研成果</div></td>
    <td colspan="8"><textarea name="techkeyan" style="width:100%;height:100%" >${requestScope.teachers.techkeyan}</textarea></td>
    </tr>
  <tr>
    <td height="75"><div align="center">备注</div></td>
    <td colspan="8"><textarea name="techremark" style="width:100%;height:100%" >${requestScope.teachers.techremark}</textarea></td>
  </tr>  
  <tr>
  <c:if test="${sessionScope.userinfo.role=='管理员'}">
    <td colspan="4" align="center" ><a href="SelectAllTeachersServlet"><input type="button" value="返回" id="btn_loca"/></a></td>
    <td colspan="4" align="center" ><input type="submit" value="更新" name="update" id="btn_loca"/></td>
  </c:if>
  <c:if test="${sessionScope.userinfo.role=='教师'}">
    <td colspan="4" align="center" ><a href="blank.jsp"><input type="button" value="返回" id="btn_loca"/></a></td>
    <td colspan="4" align="center" ><input type="submit" value="更新" name="update" id="btn_loca"/></td>
  </c:if>  
   </tr> 
</table>
<input name="role" value="${sessionScope.userinfo.role}" type="hidden" />
</form>
</body>
</html>
