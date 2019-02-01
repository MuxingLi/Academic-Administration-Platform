<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
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
<form action="InsertTeacher" method="post"  onsubmit="return warning(this)" >
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center" style="margin-bottom:10px">
  <tr>
    <td width="102"><div align="center">工号<a style="color:red;">*</a></div></td>
    <td width="215" colspan="2"><input name="techid" style="width:100%;height:100%" type="text" /></td>
    <td width="103"><div align="center">姓名<a style="color:red;">*</a></div></td>
    <td width="199" colspan="2"><input name="techname" type="text" style="width:100%;height:100%" /></td>
    <td width="96"><div align="center">性别</div></td>
    <td width="202" colspan="2"><input name="techsex" style="width:100%;height:100%"/></td>
  </tr>
  <tr>
	<td><div align="center">出生日期<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="techbirth" style="width:100%;height:100%" type="text" onclick="WdatePicker({el:$dp.$(this)})"/></td>
    <td><div align="center">政治面貌</div></td>
    <td colspan="5"><input name="techlook" style="width:100%;height:100%" type="text"/></td>
    </tr>
  <tr>
    <td><div align="center">民族</div></td>
    <td colspan="2"><input name="technation" style="width:100%;height:100%" type="text"/></td>
    <td><div align="center">职称</div></td>
    <td colspan="2"><input name="techzhicheng"  style="width:100%;height:100%" type="text" /></td>
    <td ><div align="center">所属院系</div></td>
    <td colspan="2"><input name="techdepartment" style="width:100%;height:100%" type="text"/></td>
  </tr>
  <tr>
    <td><div align="center">入职时间<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="techenterdate" style="width:100%;height:100%" type="text" onclick="WdatePicker({el:$dp.$(this)})"/></td>
    <td width="103"><div align="center">电话<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="techtel" style="width:100%;height:100%" type="text"/></td> 
    <td><div align="center">身份证号</div></td>
    <td colspan="5">
    <input name="techidentity" style="width:100%;height:100%" type="text"/></td> 
  </tr>

  <tr>
  <td ><div align="center">家庭住址</div></td>
    <td colspan="8"><input name="techaddress"  style="width:100%;height:100%" type="text" /></td>
    </tr>
  <tr>
    <td height="75"><div align="center">受教育经历</div></td>
    <td colspan="8"><textarea name="techeducation" style="width:100%;height:100%"></textarea></td>
    </tr>
  <tr>
    <td height="75"><div align="center">获得奖项</div></td>
    <td colspan="8"><textarea name="techaward" style="width:100%;height:100%"></textarea></td>
    </tr>
  <tr>
    <td height="75"><div align="center">科研成果</div></td>
    <td colspan="8"><textarea name="techkeyan" style="width:100%;height:100%"></textarea></td>
    </tr>
  <tr>
    <td height="75"><div align="center">备注</div></td>
    <td colspan="8"><textarea name="techremark" style="width:100%;height:100%"></textarea></td>
    </tr>
  <tr>
    <td colspan="4" align="center" ><a href="blank.jsp"><input type="button" value="返回"/></a></td>
    <td colspan="5" align="center" ><input type="submit" value="提交" name="submit" /></td>
    </tr>
</table>
<input type="hidden" name="password" value="111111" /><input type="hidden" name="role" value="教师" />
</form>
</body>
</html>