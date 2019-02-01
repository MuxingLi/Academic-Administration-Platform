<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectApplyDetail.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function RefuseConfirm() {
		return confirm("确认拒绝申请？");
}
function check(r){
		if(r.reply.value==""){
			alert("拒绝需输入批复");
			r.reply.focus();
			return false;
		}
}
</script>
<link href="Css/main.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  <form action="RefuseApplyServlet" method="post" onsubmit="return check(this)">
<table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="center" width=25%>教室号</td>
    <td align="center" width=25%>
    <input name="building" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applydetail.building}" readonly />
    <input name="no" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applydetail.no}" readonly />
    </td>
    <td align="center" width=25%>教室类型</td>
    <td align="center" width=25%><input name="type" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applydetail.type}" readonly /></td>
  </tr>
  <tr>
    <td align="center">教室大小</td>
    <td><input name="seat" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applydetail.seat}" readonly /></td>
    <td align="center">是否有多媒体</td>
    <td align="center"><input name="media" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applydetail.media}" readonly /></td>
  </tr>
  <tr>
    <td align="center">使用日期</td>
    <td align="center"><input name="usetime" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applydetail.usetime}" readonly /></td>
    <td align="center">使用时间</td>
    <td align="center"><input name="jieshu" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applydetail.jieshu}" readonly /></td>
  </tr>
  <tr>
    <td align="center">申请人</td>
    <td align="center"><input name="id" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applydetail.id}" readonly /></td>
    <td align="center">申请时间</td>
    <td align="center"><input name="time" style="width:100%;font-size:16px;text-align:center" type="text" value="${requestScope.applydetail.time}" readonly /></td>
  </tr>
  <tr>
    <td align="center">批复<br><a style="font-size:12px;">拒绝申请请输入:</a></td>
    <td colspan="3" align="center"><input name="reply" style="width:100%;font-size:16px;" type="text" value="${requestScope.applydetail.reply}"/></td>
  </tr>
  <tr>
    <td align="center" height="70px">备注</td>
    <td colspan="3" align="center"><textarea name="remark" style="width:100%;height:100%;font-size:16px" readonly>${requestScope.applydetail.remark}</textarea>
</td>
  </tr>
<c:if test="${requestScope.applydetail.status=='申请中'}">
  <tr>
    <td colspan="2" align="center">
    <a href="AcceptApplyServlet?id=${requestScope.applydetail.id}&building=${requestScope.applydetail.building}&no=${requestScope.applydetail.no}&jieshu=${requestScope.applydetail.jieshu}&usetime=${requestScope.applydetail.usetime}">
    <input id="btn_loca" type="button" value="同意" onclick="if(confirm('确认同意申请？')==false) return false;"/></a>
    </td>
    <td colspan="2" align="center">
    <input type="submit" value="拒绝" name="refuse" id="btn_loca" onclick="RefuseConfirm()" />
    </td>
  </tr>
</c:if>
  <tr>
    <td colspan="4" align="center">
    <a href="SelectAllApplyAdmin"><input id="btn_loca" type="button" value="返回"/></a>
    </td>
  </tr>
</table>
</form>
  </body>
</html>
