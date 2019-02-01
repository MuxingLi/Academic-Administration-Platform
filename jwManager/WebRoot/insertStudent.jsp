<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生学籍信息</title>
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
			s.stubirth.focus();
			return false;
		}
		if(s.stutel.value==""){
			alert("电话非空");
			s.stutel.focus();
			return false;
		}
		if(s.stuenterdate.value==""){
			alert("入学日期非空");
			s.stuenterdate.focus();
			return false;
		}
		if(s.stuleavedate.value==""){
			alert("毕业日期非空");
			s.stuleavedate.focus();
			return false;
		}
		if(s.stuclassid.value==""){
			alert("班级非空");
			s.stuclassid.focus();
			return false;
		}
		
		return true;
}
</script>


<link href="Css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Css/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<form action="InsertStudent" method="post"  onsubmit="return warning(this)" >
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td colspan="2" width="47"><div align="center">学号<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="stuid" style="width:100%;height:100%" type="text" /></td>
    <td width="197"><div align="center">姓名<a style="color:red;">*</a></div></td>
    <td colspan="2" width="198"><input name="stuname" type="text" style="width:100%;height:100%" /></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">出生日期<a style="color:red;">*</a></div></td>
    <td colspan="2">
    <input type="text" name="stubirth" style="width:100%;height:100%;font-size:16px" onclick="WdatePicker({el:$dp.$(this)})" />
    </td>
    <td><div align="center">性别</div></td>
    <td colspan="2" width="198"><input name="stusex" style="width:100%;height:100%"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">身份证号</div></td>
    <td colspan="2"><input name="stuidentity" style="width:100%;height:100%" type="text"/></td>
    <td colspan="2" width="82"><div align="center">民族</div></td>
    <td><input name="stunation" style="width:100%;height:100%" type="text"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">政治面貌</div></td>
    <td colspan="2"><input name="stulook" style="width:100%;height:100%" type="text"/></td>
    <td><div align="center">生源地</div></td>
    <td colspan="2"><input name="stubirthplace" style="width:100%;height:100%" type="text"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">联系电话<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="stutel" style="width:100%;height:100%" type="text"/></td>
    <td><div align="center">邮箱</div></td>
    <td colspan="3"><input name="stuemail" style="width:100%;height:100%" type="text"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">联系人</div></td>
    <td colspan="2"><input name="stucontacter" style="width:100%;height:100%" type="text"/></td>
    <td><div align="center">联系人电话</div></td>
    <td colspan="3"><input name="stuhometel" style="width:100%;height:100%" type="text" /></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">家庭住址</div></td>
    <td colspan="6"><input name="stuaddress" style="width:100%;height:100%" type="text"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">入学时间<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="stuenterdate" style="width:100%;height:100%" type="text" onclick="WdatePicker({el:$dp.$(this)})"/></td>
    <td><div align="center">毕业时间<a style="color:red;">*</a></div></td>
    <td colspan="3"><input name="stuleavedate" style="width:100%;height:100%" type="text" onclick="WdatePicker({el:$dp.$(this)})"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">所属院系</div></td>
    <td colspan="2"><input name="studepartment" style="width:100%;height:100%" type="text"/></td>
    <td><div align="center">专业信息</div></td>
    <td colspan="3"><input name="stumajor" style="width:100%;height:100%" type="text"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">班级<a style="color:red;">*</a></div></td>
    <td colspan="2"><input name="stuclassid" style="width:100%;height:100%" type="text"/></td>
    <td><div align="center">学生状态</div></td>
    <td colspan="3"><input name="stustatus"style="width:100%;height:100%" type="text"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">寝室信息</div></td>
    <td colspan="6"><input name="sturoomid" style="width:100%;height:100%" type="text"/></td>
  </tr>
  <tr>
    <td colspan="2" height="70"><div align="center">备注</div></td>
    <td colspan="6"><textarea name="sturemark" style="width:100%;height:100%"></textarea></td>
  </tr>
  <tr>
    <td colspan="4" align="center" ><a href="blank.jsp"><input type="button" value="返回" id="btn_loca"/></a></td>
    <td colspan="4" align="center" ><input type="submit" value="提交" name="submit" id="btn_loca"/></td>
  </tr>
</table>
<input type="hidden" name="password" value="0000" />
<input type="hidden" name="role" value="学生" />
</form>
</body>
</html>