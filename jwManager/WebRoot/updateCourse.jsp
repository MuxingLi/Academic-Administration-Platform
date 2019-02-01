<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 't.jsp' starting page</title>
<script type="text/javascript">
function warning(s){
		if(s.cid.value==""){
			alert("课程号非空");
			s.cid.focus();
			return false;
		}
		if(s.cname.value==""){
			alert("课程名非空");
			s.cname.focus();
			return false;
		}
		if(s.ctype.value==""){
			alert("课程类型非空");
			s.cname.focus();
			return false;
		}
		return true;
}
</script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
<form action="UpdateCourse" method="post"  onsubmit="return warning(this)" >
  <table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <td width="20%" align="center">课程号</td>
      <td width="30%"><input name="cid" style="width:100%;height:100%" type="text" value="${requestScope.courses.cid}" readonly /></td>
      <td width="20%" align="center">课程名称</td>
      <td width="30%"><input name="cname" style="width:100%;height:100%" type="text" value="${requestScope.courses.cname}" readonly  /></td>
    </tr>
    <tr>
      <td align="center">学时</td>
      <td><input name="ctime" style="width:100%;height:100%" type="text" value="${requestScope.courses.ctime}"  /></td>
      <td align="center">周学时</td>
      <td><input name="cweektime" style="width:100%;height:100%" type="text" value="${requestScope.courses.cweektime}"  /></td>
    </tr>
    <tr>
      <td align="center">开课学期</td>
      <td><input name="cterm" style="width:100%;height:100%" type="text" value="${requestScope.courses.cterm}"  /></td>
      <td align="center">开课院系</td>
      <td><input name="cdepartment" style="width:100%;height:100%" type="text" value="${requestScope.courses.cdepartment}"  /></td>
    </tr>
    <tr>
      <td align="center">课程类型</td>
      <td><input name="ctype" style="width:100%;height:100%" type="text" value="${requestScope.courses.ctype}" /></td>
      <td align="center">课程学分</td>
      <td><input name="cscore" style="width:100%;height:100%" type="text" value="${requestScope.courses.cscore}" /></td>
    </tr>
    <tr>
      <td align="center">授课教师</td>
      <td><input name="cteacher" style="width:100%;height:100%" type="text" value="${requestScope.courses.cteacher}" /></td>
      <td align="center">考试方式</td>
      <td><input name="cexam" style="width:100%;height:100%" type="text" value="${requestScope.courses.cexam}" /></td>
    </tr>
    <tr>
    <td align="center">上课时间</td>
    <td><input name="cshangke" style="width:100%;height:100%" type="text" value="${requestScope.courses.cshangke}" /></td>
    <td align="center">上课教室（选修）</td>
    <td><input name="cplace" style="width:100%;height:100%" type="text" value="${requestScope.courses.cplace}" /></td>   
    </tr>
	<tr>
      <td align="center">上课星期</td>
	<td>
	 <select name="cweekday" style="width: 150px; ">
	 <option value="">----请选择----</option>	 
	 <c:choose>
    <c:when test="${requestScope.courses.cweekday[0]=='周一'}">
     <option value="周一" selected="selected">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[0]=='周二'}">
     <option value="周一">周一</option>
     <option value="周二" selected="selected">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[0]=='周三'}">
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三" selected="selected">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[0]=='周四'}">
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四" selected="selected">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[0]=='周五'}">
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五" selected="selected">周五</option>
    </c:when>
    <c:otherwise>
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:otherwise>
    </c:choose>
     </select></td>
      <td align="center">上课节数</td>
      <td>
    	<select name="cjieshu" style="width: 150px; ">
    	<option value="">-----请选择-----</option>
    	<c:choose>
    	<c:when test="${requestScope.courses.cjieshu[0]=='1-2节'}">
  		  <option value="1-2节" selected="selected">1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[0]=='3-4节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节" selected="selected">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[0]=='5-6节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节" selected="selected">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[0]=='7-8节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节" selected="selected">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[0]=='9-10节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节" selected="selected">9-10节</option>
    	</c:when>
    	<c:otherwise>
    	  <option value="1-2节">1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:otherwise>
    	</c:choose>
 	  </select>
      </td>
    </tr>
     <c:if test="${requestScope.courses.cweekday[1]!=''}">
	<tr>
      <td align="center">上课星期</td>
	<td>
	 <select name="cweekday" style="width: 150px; ">
     <option value="">----请选择----</option>	 
	 <c:choose>
    <c:when test="${requestScope.courses.cweekday[1]=='周一'}">
     <option value="周一" selected="selected">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[1]=='周二'}">
     <option value="周一">周一</option>
     <option value="周二" selected="selected">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[1]=='周三'}">
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三" selected="selected">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[1]=='周四'}">
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四" selected="selected">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[1]=='周五'}">
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五" selected="selected">周五</option>
    </c:when>
    <c:otherwise>
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:otherwise>
    </c:choose>
     </select></td>
      <td align="center">上课节数</td>
      <td>
    	<select name="cjieshu" style="width: 150px; ">
    	<option value="">-----请选择-----</option>
    	<c:choose>
    	<c:when test="${requestScope.courses.cjieshu[1]=='1-2节'}">
  		  <option value="1-2节" selected="selected">1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[1]=='3-4节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节" selected="selected">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[1]=='5-6节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节" selected="selected">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[1]=='7-8节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节" selected="selected">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[1]=='9-10节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节" selected="selected">9-10节</option>
    	</c:when>
    	<c:otherwise>
    	  <option value="1-2节">1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:otherwise>
    	</c:choose>
 	  </select>
      </td>
    </tr>     
     </c:if>
     <c:if test="${requestScope.courses.cweekday[2]!=''}">
    <tr>
      <td align="center">上课星期</td>
	<td>
	 <select name="cweekday" style="width: 150px; ">
     <option value="">----请选择----</option>	 
	 <c:choose>
    <c:when test="${requestScope.courses.cweekday[2]=='周一'}">
     <option value="周一" selected="selected">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[2]=='周二'}">
     <option value="周一">周一</option>
     <option value="周二" selected="selected">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[2]=='周三'}">
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三" selected="selected">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[2]=='周四'}">
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四" selected="selected">周四</option>
     <option value="周五">周五</option>
    </c:when>
    <c:when test="${requestScope.courses.cweekday[2]=='周五'}">
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五" selected="selected">周五</option>
    </c:when>
    <c:otherwise>
     <option value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
    </c:otherwise>
    </c:choose>
     </select></td>
      <td align="center">上课节数</td>
      <td>
    	<select name="cjieshu" style="width: 150px; ">
    	<option value="">-----请选择-----</option>
    	<c:choose>
    	<c:when test="${requestScope.courses.cjieshu[2]=='1-2节'}">
  		  <option value="1-2节" selected="selected">1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[2]=='3-4节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节" selected="selected">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[2]=='5-6节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节" selected="selected">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[2]=='7-8节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节" selected="selected">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:when>
    	<c:when test="${requestScope.courses.cjieshu[2]=='9-10节'}">
  		  <option value="1-2节" >1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节" selected="selected">9-10节</option>
    	</c:when>
    	<c:otherwise>
    	  <option value="1-2节">1-2节</option>
  		  <option value="3-4节">3-4节</option>
   		  <option value="5-6节">5-6节</option>
 		  <option value="7-8节">7-8节</option>
    	  <option value="9-10节">9-10节</option>
    	</c:otherwise>
    	</c:choose>
 	  </select>
      </td>
    </tr>
     </c:if>
    <tr>
      <td align="center">内容概要</td>
      <td colspan="3" height="70px">
      <textarea name="cdescribe" style="width:100%;height:100%;font-size:16px">${requestScope.courses.cdescribe}</textarea>
    </tr>
    <tr>
    <td colspan="2" align="center" ><a href="SelectAllCoursesServlet"><input type="button" value="返回" id="btn_loca"/></a></td>
    <td colspan="2" align="center" ><input type="submit" value="更新" name="update" id="btn_loca"/></td>
    </tr>
  </table>
</form>
  </body>
</html>