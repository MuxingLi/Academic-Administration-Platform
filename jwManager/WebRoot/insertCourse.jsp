<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'insertCourse.jsp' starting page</title>
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
		if(s.cteacher.value==""){
			alert("授课教师非空");
			s.cteacher.focus();
			return false;
		}
		if(s.ctype.value==""){
			alert("课程类型非空");
			s.cname.focus();
			return false;
		}
		return true;
}
function onchecks(){
	  var tb = document.getElementById("tb");
      var tr1 = tb.insertRow(tb.rows.length);
      index= tb.rows.length;
      var td1 = tr1.insertCell();
   	  td1.innerHTML="<div align='center'>上课星期</div>";   
      var td2 = tr1.insertCell();
	  td2.innerHTML="<select name='cweekday'><option selected='selected' value='周一'>周一</option><option value='周二'>周二</option><option value='周三'>周三</option><option value='周四'>周四</option><option value='周五'>周五</option></select><br/>";
	  index++;
      var td3 = tr1.insertCell();
      td3.innerHTML="<div align='center'>上课节数</div>";
      var td4 = tr1.insertCell();
      td4.innerHTML="<select name='cjieshu'><option value='1-2节' selected='selected'>1-2节</option><option value='3-4节'>3-4节</option><option value='5-6节'>5-6节</option><option value='7-8节'>7-8节</option><option value='9-10节'>9-10节</option></select><br/>";
      index++;
}
</script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
select{width:100px;text-align:left;align:left;}
</style>
<link href="Css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
<form action="InsertCourse" method="post"  onsubmit="return warning(this)" >
  <table width="98%" border="1" cellspacing="0" cellpadding="0" id="tb" align="center">
    <tr>
      <td width="20%" align="center">课程号</td>
      <td width="30%"><input name="cid" style="width:100%;height:100%" type="text" /></td>
      <td width="20%" align="center">课程名称</td>
      <td width="30%"><input name="cname" style="width:100%;height:100%" type="text" /></td>
    </tr>
    <tr>
      <td align="center">学时</td>
      <td><input name="ctime" style="width:100%;height:100%" type="text" /></td>
      <td align="center">周学时</td>
      <td><input name="cweektime" style="width:100%;height:100%" type="text" /></td>
    </tr>
    <tr>
      <td align="center">开课学期</td>
      <td><div>
      <select name="cterm" style="width: 100px;" >
      <option value="">---请选择---</option>
      <option value="春季">春季</option>
      <option value="秋季">秋季</option>
      </select>
      </div>
      </td>
      <td align="center">开课院系</td>
      <td>
      <select name="cdepartment" style="width: 180px; ">
      <option value="">-----------请选择-----------</option>
      <option value="船舶工程学院">船舶工程学院</option>
      <option value="航天与建筑工程学院">航天与建筑工程学院</option>
      <option value="动力与能源工程学院">动力与能源工程学院</option>
      <option value="自动化学院">自动化学院</option>
      <option value="水声工程学院">水声工程学院</option>
      <option value="计算机科学与技术学院">计算机科学与技术学院</option>
      <option value="机电工程学院">机电工程学院</option>
      <option value="信息与通信工程学院">信息与通信工程学院</option>
      <option value="经济管理学院">经济管理学院</option>
      <option value="材料科学与化学工程学院">材料科学与化学工程学院</option>
      <option value="理学院">理学院</option>
      <option value="外语系">外语系</option>
      <option value="人文社会科学学院">人文社会科学学院</option>
      <option value="文化素质教育基地">文化素质教育基地</option>
      </select>
      </td>
    </tr>
    <tr>
      <td align="center">课程类型</td>
      <td>
      <select name="ctype" style="width: 100px; ">
      <option value="">---请选择---</option>
      <option value="必修">必修</option>
      <option value="选修">选修</option>      
      </select>
      </td>
      <td align="center">课程学分</td>
      <td><input name="cscore" style="width:100%;height:100%" type="text" value="" /></td>
    </tr>
    <tr>
      <td align="center">授课教师</td>
      <c:if test="${sessionScope.userinfo.role=='管理员'}">
      <td><input name="cteacher" style="width:100%;height:100%" type="text"/></td>
      </c:if>
      <td align="center">考试方式</td>
      <td>
      <select name="cexam" style="width: 100px; ">
      <option value="">---请选择---</option>
      <option value="考试">考试</option>
      <option value="考察">考察</option>
      </select>
      </td>
    </tr>
    <tr>
    <td align="center">上课周期</td>
    <td><select name="cshangke" style="width: 130px; ">
      <option value="">------请选择------</option>
      <option value="第一周至第九周">第一周至第九周</option>
      <option value="第十周至第十八周">第十周至第十八周</option>
      </select></td>
      <td align="center">上课教室（选修）</td>
      <td><input name="cplace" style="width:100%;height:100%" type="text" value="" /></td>
    </tr>
    <tr>
      <td align="center">内容概要</td>
      <td colspan="3" height="70px"><textarea style="width:100%;height:100%" name="cdescribe"></textarea></td>
    </tr>
        <tr>
   <td align="center" class="title" width="1%" nowrap >上课星期</td>
    <td width="1%">
     <select name="cweekday" style="width: 100px; ">
     <option selected="selected" value="周一">周一</option>
     <option value="周二">周二</option>
     <option value="周三">周三</option>
     <option value="周四">周四</option>
     <option value="周五">周五</option>
     </select>
    </td>  
    <td align="center" class="title" width="1%" nowrap>上课节数</td>
    <td width="1%">
     <select name="cjieshu" style="width: 100px; ">
     <option value="1-2节" selected="selected">1-2节</option>
     <option value="3-4节">3-4节</option>
     <option value="5-6节">5-6节</option>
     <option value="7-8节">7-8节</option>
     <option value="9-10节">9-10节</option>
     </select>
     <input type="button" value="添加行" onclick="onchecks();" style="width: 80px;float:'right'" id="btn_loca1">
    </td>  
   </tr>
   </table>
   <table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
    <tr>
    <td colspan="2" align="center" ><a href="blank.jsp"><input type="button" value="返回" id="btn_loca"/></a></td>
    <td colspan="2" align="center" ><input type="submit" value="提交" name="submit" id="btn_loca" /></td>
    </tr>
   </table>  
</form>
  </body>
</html>
