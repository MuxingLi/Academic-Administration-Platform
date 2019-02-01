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
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <form action="UpdateClassroom" method="post"  onsubmit="return warning(this)" >
  <table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <td width="25%"><div align="center">教学楼</div></td>
	  <td><input readonly name="rbuilding" style="width:100%;font-size:16px;" type="text" value="${requestScope.classrooms.rbuilding}" readonly /></td>
	  <td width="20%"><div align="center">教室号</div></td>
      <td width="30%"><input readonly name="rno" style="width:100%;font-size:16px;" type="text" value="${requestScope.classrooms.rno}" readonly /></td>
    </tr>
    
    <tr>
      <td><div align="center">教室类型</div></td>
      <td><select name="rtype" style="width: 100px;font-size:16px; ">
      <c:choose>
      <c:when test="${requestScope.classrooms.rtype=='实验室'}">
      <option value="">----请选择----</option>
      <option value="实验室" selected="selected">实验室</option>
	  <option value="教室">教室</option>
      </c:when>
      <c:when test="${requestScope.classrooms.rtype=='教室'}">
      <option value="">----请选择----</option>
      <option value="实验室">实验室</option>
	  <option value="教室" selected="selected">教室</option>
      </c:when>
      <c:otherwise>
      <option value="">----请选择----</option>
 	    <option value="实验室">实验室</option>
	    <option value="教室">教室</option>
      </c:otherwise>
      </c:choose>
	  </select>  </td>
      <td><div align="center">教室大小</div></td>
      <td><select name="rseat"  style="width: 100px;font-size:16px; ">
      <option value="">-----请选择-----</option>
        <c:choose>
    <c:when test="${requestScope.classrooms.rseat=='大'}">
    <option value="大" selected="selected">大</option>
    <option value="中">中</option>
    <option value="小">小</option>
    </c:when>
    <c:when test="${requestScope.classrooms.rseat=='中'}">
    <option value="大">大</option>
    <option value="中" selected="selected">中</option>
    <option value="小">小</option>
    </c:when>
    <c:when test="${requestScope.classrooms.rseat=='小'}">
    <option value="大">大</option>
    <option value="中">中</option>
    <option value="小" selected="selected">小</option>
    </c:when>
    <c:otherwise>
    <option value="大">大</option>
    <option value="中">中</option>
    <option value="小">小</option>
    </c:otherwise>
	    </c:choose>
	  </select> </td>
    </tr>
    <tr>
      <td><div align="center">是否有多媒体</div></td>
     <td colspan="3"><select name="rmedia" style="width: 100px;font-size:16px;">
     <c:choose>
    <c:when test="${requestScope.classrooms.rmedia=='是'}">
		<option value="是" selected="selected">是</option>
	    <option value="否">否</option>
    </c:when>
    <c:when test="${requestScope.classrooms.rmedia=='否'}">
		<option value="是">是</option>
	    <option value="否" selected="selected">否</option>
    </c:when>
    <c:otherwise>
		<option value="是">是</option>
	    <option value="否">否</option>
    </c:otherwise>
	 </c:choose>
	  </select> </td>
	 </tr>	 
    <tr>
      <td height="70px"><div align="center">备注</div></td>
      <td colspan="3">
      <textarea name="rremark" style="width:100%;height:100%;font-size:16px" >${requestScope.classrooms.rremark}</textarea>
    </tr>
    <tr>
      <td colspan="2" align="center" ><a href="SelectAllClassroomsServlet"><input id="btn_loca" type="button" value="返回"/></a></td>
      <td colspan="2" align="center" ><input type="submit" value="更新" name="update" id="btn_loca" /></td>
    </tr>
</table>
</form>
</body>
</html>
