<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'insertProgram.jsp' starting page</title>
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
function onchecks(){
	  var tb = document.getElementById("tb");
      var tr1 = tb.insertRow(tb.rows.length);
      index= tb.rows.length;
      var td1 = tr1.insertCell();
   	  td1.innerHTML="<div align='center'>课程号</div>";   
      var td2 = tr1.insertCell();
	  td2.innerHTML="<input name='cid' type='text' value='' style='width:70%;height:100%'/>";
	  index++; 
	  var td3 = tr1.insertCell();
   	  td3.innerHTML="<div align='center'>上课教室</div>";   
      var td4 = tr1.insertCell();
	  td4.innerHTML="<input name='cp' type='text' value='' style='width:70%;height:100%'/>";
}

</script>

  </head>
  
  <body>
  <form action="InsertProgram" method="post" onsubmit="return warning(this)">
  <table style="margin-top:10px;" align="center" width="98%" border="1" cellspacing="0" cellpadding="0">
    <tr>
      <td align="center" width="10%">院系</td>
      <td width="40%"><select name="dept" style="width: 180px; ">
      <option value="">-----------请选择-----------</option>
      <option value="船舶工程学院">船舶工程学院</option>
      <option value="航天与建筑工程学院">航天与建筑工程学院</option>
      <option value="动力与能源工程学院">动力与能源工程学院</option>
      <option value="自动化学院">自动化学院</option>
      <option value="水声工程学院">水声工程学院</option>
      <option value="计算机科学与技术学院">计算机科学与技术学院</option>
      <option value="机电工程学院">机电工程学院</option>
      <option value="信息与通信工程学院">信息与通信工程学院</option>
      <option value="经济管理学院">经济管理学院</option>
      <option value="材料科学与化学工程学院">材料科学与化学工程学院</option>
      <option value="理学院">理学院</option>
      <option value="外语系">外语系</option>
      <option value="人文社会科学学院">人文社会科学学院</option>
      </select></td>
      <td width="15%" align="center">学期(第X学期)</td>
      <td><input name="term" type="text" style="width:100%;height:100%" value="" /></td>
    </tr>
</table>
<table align="center" width="98%" border="1" cellspacing="0" cellpadding="0" id="tb">
    <tr>
      <td align="center" width="10%">课程号</td>
      <td width="40%"><input name="cid" type="text" value="" style="width:70%;height:100%" />
	  </td>
	  <td align="center" width="15%">上课教室</td>
      <td><input name="cp" type="text" value="" style="width:70%;height:100%" />
     <input type="button" value="添加行" onclick="onchecks();" style="width: 80px;float:'right'" id="btn_loca1">
	  </td>
    </tr>
</table>
<table align="center" width="98%" border="1" cellspacing="0" cellpadding="0">
    <tr>
      <td align="center">
      <a href="blank.jsp"><input type="button" value="返回" id="btn_loca"/></a>
      </td>
      <td align="center" >
      <input type="submit" value="提交" name="submit" id="btn_loca" />
      </td>      
    </tr>
</table>
</form>
  </body>
</html>
