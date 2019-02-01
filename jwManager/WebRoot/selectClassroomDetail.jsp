<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>

<script type="text/javascript">
function warning(s){
		if(s.rno.value==""){
			alert("教室号非空");
			s.rno.focus();
			return false;
		}
		if(s.rbuilding.value==""){
			alert("教学楼非空");
			s.rno.focus();
			return false;
		}
	return true;
}
</script>		
		
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
input{text-align:center;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <td width="25%"><div align="center">教学楼</div></td>
	  <td><div align="center"><input readonly="readonly" name="rno" style="width:100%;font-size:16px;" type="text" value="${requestScope.classrooms.rbuilding}" /></div></td>
	  <td width="20%"><div align="center">教室号</div></td>
      <td width="30%"><div align="center"><input readonly="readonly" name="rno" style="width:100%;font-size:16px;" type="text" value="${requestScope.classrooms.rno}" /></div></td>
    </tr>
    <tr>
      <td><div align="center">教室类型</div></td>
      <td><div align="center"><input readonly="readonly" name="rtype" style="width:100%;font-size:16px;" value="${requestScope.classrooms.rtype}"/></div>
 	  </td>
      <td><div align="center">教室大小</div></td>
      <td><div align="center"><input name="rseat" style="width:100%;font-size:16px;" type="text" value="${requestScope.classrooms.rseat}" readonly="readonly"/></div>
    </tr>
    <c:if test="${sessionScope.userinfo.role=='管理员'}">
    <tr>
      <td><div align="center">是否有多媒体</div></td>
      <td colspan="3"><div align="center"><input name="rmedia" style="width:100%;font-size:16px;" type="text" value="${requestScope.classrooms.rmedia}" readonly="readonly"/></div>
    </tr>
    </c:if>
    <tr>
      <td height="70px"><div align="center">备注</div></td>
      <td colspan="3">
      <textarea name="rremark" style="width:100%;height:100%;font-size:16px" readonly="readonly">${requestScope.classrooms.rremark}</textarea>
    </tr>
    <tr>
      <td colspan="4" align="center" ><a href="SelectAllClassroomsServlet"><input id="btn_loca" type="button" value="返回"/></a></td>
    </tr>
</table>
</body>
</html>
