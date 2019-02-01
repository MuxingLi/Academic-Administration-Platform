<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'updateProgram.jsp' starting page</title>
   <link href="Css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function warning(s){
		if(s.dept.value==""){
			alert("院系非空");
			s.cname.focus();
			return false;
		}
		if(s.term.value==""){
			alert("学期非空");
			s.cteacher.focus();
			return false;
		}
		return true;
}

</script>
  </head>
  
  <body>
  <form action="UpdateProgram" method="post" onsubmit="return warning(this)">
  <table style="margin-top:10px;" align="center" width="98%" border="1" cellspacing="0" cellpadding="0">
    <tr>
      <td align="center" width="10%">院系</td>
      <td id="td" width="40%"><input type="text" name="dept" value="${requestScope.program.dept}" readonly /></td>
      <td width="20%" align="center">学期(第X学期)</td>
      <td colspan="2"><input name="term" type="text" style="width:100%;height:100%" value="${requestScope.program.term}" /></td>
    </tr>
    <tr>
      <td align="center" width="10%">课程号</td>
      <td><input name="cid1" type="text" value="${requestScope.program.cid1}" style="width:100%;height:100%" />
	  </td>
	  <td align="center" width="10%">上课教室</td>
      <td><input name="cp1" type="text" value="${requestScope.program.cp1}" style="width:100%;height:100%" />
	  </td>
    </tr>
    <tr>
      <td align="center" width="10%">课程号</td>
      <td><input name="cid2" type="text" value="${requestScope.program.cid2}" style="width:100%;height:100%" />
	  </td>
	  <td align="center" width="10%">上课教室</td>
      <td><input name="cp2" type="text" value="${requestScope.program.cp2}" style="width:100%;height:100%" />
	  </td>
   </tr>
   <tr>
      <td align="center" width="10%">课程号</td>
      <td><input name="cid3" type="text" value="${requestScope.program.cid3}" style="width:100%;height:100%" />
	  </td>
	  <td align="center" width="10%">上课教室</td>
      <td><input name="cp3" type="text" value="${requestScope.program.cp3}" style="width:100%;height:100%" />
	  </td>
   </tr>
   <tr>
      <td align="center" width="10%">课程号</td>
      <td><input name="cid4" type="text" value="${requestScope.program.cid4}" style="width:100%;height:100%" />
	  </td>
	  <td align="center" width="10%">上课教室</td>
      <td><input name="cp4" type="text" value="${requestScope.program.cp4}" style="width:100%;height:100%" />
	  </td>
   </tr>
    <tr>
      <td colspan="2" align="center">
      <a href="SelectAllPrograms"><input type="button" value="返回" id="btn_loca"/></a>
      </td>
      <td colspan="2" align="center" >
      <input type="submit" value="提交" name="submit" id="btn_loca" />
      </td>      
    </tr>
</table>
</form>



  </body>
</html>
