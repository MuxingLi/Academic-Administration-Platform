<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.text.*"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'selectNewsDetail.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <div></div>
<table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30px" width="15%" align="center">标题</td>
    <td width="88%" colspan="2"><input name="ntitle" value="${requestScope.news.ntitle}" style="width:100%; border:0px" type="text" readonly/> </td>
  </tr>
  <tr>
    <td height="30px" align="center">发布人</td>
    <td colspan="2"><input name="nauthor" style="width:100%; border:0px " value="${sessionScope.userinfo.id}" readonly type="text" /></td>
  </tr>
  <% Date now = new Date(); %>
  <% DateFormat d2 = DateFormat.getDateTimeInstance(); %>
  <% String str2 = d2.format(now);%>
  <tr>
  <td height="30px" align="center">发布时间</td>
  <td colspan="2"><input type="text" style="width:100%; border:0px" name="ntime" value="<% out.print(str2);%>" readonly/></td>
  </tr>
  <tr>
    <td height="30px" align="center">类型</td>
    <td colspan="2"><input name="ntype" value="${requestScope.news.ntype}" type="text" style="width:100%; border:0px " readonly /></td>
  </tr>
  <tr>
    <td height="200px" align="center">内容</td>
    <td colspan="2"><TEXTAREA name="ncontent" style="width:100%;height:100%" style="width:100%; border:0px " readonly>${requestScope.news.ncontent}</TEXTAREA></td>
  </tr>
  <tr>
    <td height="30px" align="center">附件下载</td>
    <td colspan="2"><a style="text-decoration:none;color:#213541;" href="DownloadNews?nfake=${requestScope.news.nfake}">${requestScope.news.nfile}</a></td>
  </tr>
  <tr>
    <td colspan="3" align="center"><a href="SelectAllNewsServlet"><input id="btn_loca" type="button" value="返回"/></a></td>
  </tr>
</table>


</body>
</html>