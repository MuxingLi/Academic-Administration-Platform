<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.text.SimpleDateFormat,java.util.Date" %>
<%@ page import="java.text.*"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'insertNews.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function warning(s){
		if(s.ntype.value==""){
			alert("必须选择公告类型");
			s.ntype.focus();
			return false;
		}
		if(s.ntitle.value==""){
			alert("公告标题为空");
			s.ntitle.focus();
			return false;
		}
		if(s.ncontent.value==""){
			alert("公告内容为空");
			s.ncontent.focus();
			return false;
		}
}
</script>
  </head>
  
  <body>
<form action="InsertNewsServlet" method="post" onsubmit="return warning(this)" enctype="multipart/form-data">
<table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30px" width="15%" align="center">标题</td>
    <td width="88%" colspan="2"><input name="ntitle" value="" style="width:100%; border:0px" type="text" /> </td>
  </tr>
  <tr>
    <td height="30px" align="center">发布人</td>
    <td colspan="2"><input name="nauthor" style="width:100%; border:0px " value="${sessionScope.userinfo.id}" readonly="readonly" type="text" /></td>
  </tr>
  <tr>
    <td height="30px" align="center">类型</td>
    <td colspan="2"><select name="ntype" style="width:30%;">
    <option value="">---------请选择---------</option>
    <option value="考试管理">考试管理</option>
    <option value="实践教学">实践教学</option>
    <option value="基础教务">基础教务</option>
    </select>
    
  </tr>
  <tr>
    <td height="300px" align="center">内容</td>
    <td colspan="2"><TEXTAREA name="ncontent" style="width:100%;height:100%;border:0px "></TEXTAREA></td>
  </tr>
  <tr>
    <td height="30px" align="center">上传文件</td>
    <td colspan="2"><input type="file" name="nfile" value="上传" /></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><a href="blank.jsp"><input id="btn_loca" type="button" value="返回"/></a></td>
    <td width="50%" align="center"><input type="submit" value="提交" name="submit" id="btn_loca"/></td>
  </tr>
</table>


<% Date now = new Date(); %>
<% DateFormat d2 = DateFormat.getDateTimeInstance(); %>
<% String str2 = d2.format(now);%>
<input type="hidden" name="ntime" value="<% out.print(str2);%>"/>
  </form>
</body>
</html>
