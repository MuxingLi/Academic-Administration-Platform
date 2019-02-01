<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'selectAllNews.jsp' starting page</title>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<script type="text/javascript">
function DeleteConfirm(){
		return confirm("确定要删除吗？");
}
</script>
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
</style>
  </head>
  
  <body>
<form action="SelectAllNewsServlet1" method="post">
  <table width="98%" border="0" align="center" style="margin-top:10px;margin-bottom:10px">
    <tr>
    <td width="70%"><input type="text" style="width:100%;border:0px" name="one" value=""/>
    </td>      
    <td width="30%" align="center"><input type="submit" value="查询" name="query" id="btn_loca"/></td>
    </tr>
  </table>
  <table width="98%" border="0" align="center">
  	<tr>
    <td width="70%"><div align="center">标题</div></td>
    <td width="30%" colspan="3"><div align="center">操作</div></td>
    </tr>
    <c:if test="${requestScope.stry1==null}">
	<tr><td colspan="6" align="center">无公告</td></tr>
    </c:if>
 	 <c:if test="${requestScope.stry1!=null}">
  	 <c:forEach items="${requestScope.stry1}" varStatus="status" var="temp">
  	<tr>
    <td align="center">${temp.ntitle}</td>
 	<td width="10%"><div align="center"><a style="color:#213541;" href="SelectNewsDetail?nid=${temp.nid}"><img src="Images/document.png" width="14" height="14" />查看</a></div></td> 
    <td width="10%"><div align="center"><a style="color:#213541;" href="UpdateNews?nid=${temp.nid}"><img src="Images/114.gif" width="14" height="14" />修改</a></div></td>
 	<td width="10%"><div align="center"><a style="color:#213541;" href="DeleteNews?nid=${temp.nid}" onclick="return DeleteConfirm()"><img src="Images/083.gif" width="14" height="14" />删除</a></div></td>
 	</tr>
    </c:forEach>
  </c:if>
  <tr>
  <td colspan="8">
  	<img src="Images/blank1.jpg">
  	共${requestScope.rowCount}条记录，共${requestScope.sumPageCount}页，当前是第${requestScope.currentCount}页 
    <img src="Images/blank.jpg">
     <a style="color:#213541;" href="./SelectAllNewsServlet?page=<%=1%>"><img src="Images/page_first_1.jpg"></a>&nbsp;
    <c:if test="${requestScope.currentCount>1}">
     <a style="color:#213541;" href="./SelectAllNewsServlet?page=${requestScope.currentCount-1}"><img src="Images/page_back_1.jpg"></a>&nbsp;
	</c:if>
	<c:if test="${requestScope.currentCount<sumPageCount}">
     <a style="color:#213541;" href="./SelectAllNewsServlet?page=${requestScope.currentCount+1}"><img src="Images/page_next.gif"></a>&nbsp;
    </c:if>
     <a style="color:#213541;" href="./SelectAllNewsServlet?page=${requestScope.sumPageCount}"><img src="Images/page_last.gif"></a>
  </td>
  </tr>
  <tr>
  <td colspan="8" align="center"><a href="blank.jsp"><input id="btn_loca" type="button" value="返回"/></a></td>
  </tr>
</table>
</form>  
  </body>
</html>
