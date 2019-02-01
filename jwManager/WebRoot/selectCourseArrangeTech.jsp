<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'selectCourseArrangeTech.jsp' starting page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
table{font-size:14px;border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
#t_div{padding-bottom:10px;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="Css/print.js"></script>
  </head>
  
  <body>
  <form action="InsertCourseArrangeTech1" method="post">
    <table width="98%" border="0" cellspacing="0" cellpadding="0" align="center" >
      <tr height="20px">
        <td width="24%" style="border-width:0px;padding:0px">&nbsp;&nbsp;姓名：${requestScope.t.name} &nbsp;&nbsp;学号：${requestScope.t.id}</td>
        <td width="4%" style="border-width:0px; padding:0px">年份：</td>
        <td width="12%" style="border-width:0px; padding:0px"><select name="cayear">
    <option value="" selected="selected">------请选择------</option>
    <option value="2010-2011">2010-2011</option>
    <option value="2011-2012">2011-2012</option>
    <option value="2012-2013">2012-2013</option>
    <option value="2013-2014">2013-2014</option>
    <option value="2014-2015">2014-2015</option>
    <option value="2015-2016">2015-2016</option>
    <option value="2016-2017">2016-2017</option>
    <option value="2017-2018">2017-2018</option>    
    </select></td>
        <td width="4%" style="border-width:0px;padding:0px">学期：</td>
        <td width="43%" style="border-width:0px;padding:0px"><select name="caterm">
    <option value="">------请选择-----</option>
    <option value="春季">春季</option>
    <option value="秋季">秋季</option>
    </select></td>
        <td width="10%" align="center" style="border-width:0px; border-right-width:1px;padding:0px"><input type="submit" value="查询" id="btn_loca"  /></td>
      </tr>
    </table>
    <!--startprint1-->
    <table width="98%" border="1" cellspacing="0" cellpadding="0" align="center"  > 
  <tr>
  <td align="center" colspan="6" style="font-size:20px;padding:1px">${requestScope.year} ${requestScope.term}课程表</td>
  </tr>
  <tr>
  <td colspan="6" height="20px" style="font-size:10px;padding:0px">&nbsp;&nbsp;学号： ${requestScope.t.id}&nbsp;&nbsp;&nbsp;&nbsp;院系： ${requestScope.t.techdepartment}&nbsp;&nbsp;&nbsp;&nbsp;姓名：${requestScope.t.name}
  </td>
  
  </tr>  
  <tr>
    <td height="20px" width="5%"></td>
    <td width="19%" style="padding:1px"><div align="center">周一</div></td>
    <td width="19%" style="padding:1px"><div align="center">周二</div></td>
    <td width="19%" style="padding:1px"><div align="center">周三</div></td>
    <td width="19%" style="padding:1px"><div align="center">周四</div></td>
    <td width="19%" style="padding:1px"><div align="center">周五</div></td>
  </tr>
  <tr>
    <td width="5%" height="100px" style="padding:1px"><div align="center">1-2节</div></td>
    <td style="padding:1px">${requestScope.cas.mon1}</td>
    <td style="padding:1px">${requestScope.cas.tue1}</td>
    <td style="padding:1px">${requestScope.cas.wed1}</td>
    <td style="padding:1px">${requestScope.cas.thu1}</td>
    <td style="padding:1px">${requestScope.cas.fri1}</td>
  </tr>
  <tr>
    <td style="padding:1px" height="100px"><div align="center">3-4节</div></td>
    <td style="padding:1px">${requestScope.cas.mon2}</td>
    <td style="padding:1px">${requestScope.cas.tue2}</td>
    <td style="padding:1px">${requestScope.cas.wed2}</td>
    <td style="padding:1px">${requestScope.cas.thu2}</td>
    <td style="padding:1px">${requestScope.cas.fri2}</td>
  </tr>
  <tr>
    <td style="padding:1px" height="100px"><div align="center">5-6节</div></td>
    <td style="padding:1px">${requestScope.cas.mon3}</td>
    <td style="padding:1px">${requestScope.cas.tue3}</td>
    <td style="padding:1px">${requestScope.cas.wed3}</td>
    <td style="padding:1px">${requestScope.cas.thu3}</td>
    <td style="padding:1px">${requestScope.cas.fri3}</td>
  </tr>
  <tr>
    <td style="padding:1px" height="100px"><div align="center">7-8节</div></td>
    <td style="padding:1px">${requestScope.cas.mon4}</td>
    <td style="padding:1px">${requestScope.cas.tue4}</td>
    <td style="padding:1px">${requestScope.cas.wed4}</td>
    <td style="padding:1px">${requestScope.cas.thu4}</td>
    <td style="padding:1px">${requestScope.cas.fri4}</td>
  </tr>
  <tr>
    <td style="padding:1px" height="100px"><div align="center">9-10节</div></td>
    <td style="padding:1px">${requestScope.cas.mon5}</td>
    <td style="padding:1px">${requestScope.cas.tue5}</td>
    <td style="padding:1px">${requestScope.cas.wed5}</td>
    <td style="padding:1px">${requestScope.cas.thu5}</td>
    <td>${requestScope.cas.fri5}</td>
  </tr>
  <tr>
    <td height="21" colspan="3" align="center"><a href="blank.jsp"><input  type="button" onclick="window.history.back()" value="返回"/></a></td>
    <td height="21" colspan="3" align="center"><input  type="button" onclick="printit()" value="打印"/></td>
  </tr>
</table><!--endprint1-->
</form>
  </body>
</html>
