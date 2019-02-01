<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'selectApplyTechDetail.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>

  <body>
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="center" width=25%>教室号</td>
    <td align="center" width=25%>
    <input name="building" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applytechdetail.building}" readonly />
    <input name="no" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applytechdetail.no}" readonly />
    </td>
    <td align="center" width=25%>教室类型</td>
    <td align="center" width=25%><input name="type" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applytechdetail.type}" readonly /></td>
  </tr>
  <tr>
    <td align="center">教室大小</td>
    <td><input name="seat" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applytechdetail.seat}" readonly /></td>
    <td align="center">是否有多媒体</td>
    <td align="center"><input name="media" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applytechdetail.media}" readonly /></td>
  </tr>
  <tr>
    <td align="center">使用日期</td>
    <td align="center"><input name="usetime" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applytechdetail.usetime}" readonly /></td>
    <td align="center">使用时间</td>
    <td align="center"><input name="jieshu" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applytechdetail.jieshu}" readonly /></td>
  </tr>
  <tr>
    <td align="center">申请人</td>
    <td align="center"><input name="id" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applytechdetail.id}" readonly /></td>
    <td align="center">申请时间</td>
    <td align="center"><input name="time" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applytechdetail.time}" readonly /></td>
  </tr>
  <tr>
    <td align="center">批复</td>
    <td colspan="3" align="center"><input name="reply" style="width:100%;font-size:16px;" type="text" value="${requestScope.applytechdetail.reply}" readonly /></td>
  </tr>
  <tr>
    <td align="center" height="70px">备注</td>
    <td colspan="3" align="center"><textarea name="remark" style="width:100%;height:100%;font-size:16px" readonly>${requestScope.applytechdetail.remark}</textarea>
</td>
  </tr>
  <tr>
    <td colspan="4" align="center">
    <a href="SelectAllApplyTech"><input id="btn_loca" type="button" value="返回"/></a>
    </td>
  </tr>
</table>
  </body>
</html>
