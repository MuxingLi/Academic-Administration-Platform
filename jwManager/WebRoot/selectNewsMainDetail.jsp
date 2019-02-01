<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'selectNewsMainDetail.jsp' starting page</title>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<style type="text/css">
#btn_loca{line-height:15px; height:30px; width:50px;}
    .highlight{
    color:red;
    }

</style>
  </head>
  
  <body bgcolor="#e8ecee">
<table align="center" width="98%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td height="50px" width="90%" style="font-size:40px;font-weight:500;font-family:'隶书'; text-align:center">在 线 教 务 管 理 平 台</td>
<td width="10%" style="font-size:20px; font-weight:bold;text-align:center"><a style="color:#213541;text-decoration:none;" href="login.jsp">登录</a></td>
</tr></table>
<table bgcolor="#a6b5be" width="98%" align="center" style="margin-top:10px;margin-bottom:30px"  border="0" cellspacing="0" cellpadding="0">
<tr>
<td height="30px" align="center" style="font-size:20px;font-weight:bold">
	<a style="color:#213541;text-decoration:none;" href="SelectNewsMainKind?ntype=<%="考试管理"%>" >考试管理</a>
</td>
<td align="center" style="font-size:20px;font-weight:bold">
<a style="color:#213541;text-decoration:none;" href="SelectNewsMainKind?ntype=<%="实践教学"%>">实践教学</a>
</td>
<td align="center" style="font-size:20px;font-weight:bold">
<a style="color:#213541;text-decoration:none;" href="SelectNewsMainKind?ntype=<%="基础教务"%>">基础教务</a>
</td>
</tr>
</table>
<table width="90%" align="center">
<tr><td align="center" style="font-size:25px">${requestScope.news.ntitle}</td>
</tr>
<tr>
  <td align="right" style="font-size:15px">发布人：${requestScope.news.nauthor}
	<span style="font-size:20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	发布时间：${requestScope.news.ntime}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
  <td align="left" style="font-size:15px; padding-bottom:10px"><span style="font-size:20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>	公告类型：${requestScope.news.ntype}</td></tr>
<tr><td style="font-size:18px;height:300px"><textarea readonly="readonly" style="width:100%;height:100%;background-color:#e8ecee;border:0px">${requestScope.news.ncontent}</textarea></td></tr>

<tr><td style="font-size:18px;">附件：<a onmouseover="this.className='highlight'" onmouseout="this.className=''" style="text-decoration:none;" href="DownloadNews?nfake=${requestScope.news.nfake}">${requestScope.news.nfile}</a></td></tr>
<tr>
  <td align="center"><a href="SelectNewsMainKind?ntype=${requestScope.news.ntype}" style="text-decoration:none;"><input id="btn_loca" type="button" value="返回"/></a></td>
</tr>




</table>



  </body>
</html>
