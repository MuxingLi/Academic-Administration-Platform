<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.text.*"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'updateNews.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <div></div>
<form action="UpdateNews" method="post" enctype="multipart/form-data">
<table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30px" width="15%" align="center">标题</td>
    <td width="88%" colspan="2"><input name="ntitle" value="${requestScope.news.ntitle}" style="width:100%; border:0px" type="text" /> </td>
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
    <td colspan="2"><select name="ntype" style="width:30%;">
    <c:choose>
    <c:when test="${requestScope.news.ntype=='考试管理'}">
    <option value="">----请选择----</option>
    <option value="考试管理" selected="selected">考试管理</option>
    <option value="实践教学">实践教学</option>
    <option value="基础教务">基础教务</option>
    </c:when>
    <c:when test="${requestScope.news.ntype=='实践教学'}">
    <option value="">----请选择----</option>
    <option value="考试管理">考试管理</option>
    <option value="实践教学" selected="selected">实践教学</option>
    <option value="基础教务">基础教务</option>
    </c:when>
    <c:when test="${requestScope.news.ntype=='基础教务'}">
    <option value="">----请选择----</option>
    <option value="考试管理">考试管理</option>
    <option value="实践教学">实践教学</option>
    <option value="基础教务" selected="selected">基础教务</option>
    </c:when>
    <c:otherwise>
    <option value="">----请选择----</option>
    <option value="考试管理">考试管理</option>
    <option value="实践教学">实践教学</option>
    <option value="基础教务">基础教务</option>
    </c:otherwise>
    </c:choose>
    </select>
  </tr>
  <tr>
    <td height="200px" align="center">内容</td>
    <td colspan="2"><TEXTAREA name="ncontent" style="width:100%;height:100%" style="width:100%; border:0px " >${requestScope.news.ncontent}</TEXTAREA></td>
  </tr>
  <tr>
    <td height="30px" align="center">上传文件</td>
    <td colspan="2"><input type="file" name="nfile" value="上传" /></td>
  </tr>
  <tr>
  	<td height="30px" align="center">已上传文件</td>
    <td colspan="2">${requestScope.news.nfile}</td>
  </tr>  
  <tr>
    <td colspan="2" align="center"><a href="SelectAllNewsServlet"><input id="btn_loca" type="button" value="返回"/></a></td>
    <td width="50%" align="center"><input type="submit" value="更新" name="submit" id="btn_loca"/></td>
  </tr>
</table>
<input type="hidden" name="nid" value="${requestScope.news.nid}" />
</form>
</body>
</html>