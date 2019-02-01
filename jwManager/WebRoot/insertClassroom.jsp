<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'insertClassroom.jsp' starting page</title>
<script type="text/javascript">
function warning(s){
		if(s.rno.value==""){
			alert("教室号非空");
			s.rno.focus();
			return false;
		}
		if(s.rbuilding.value==""){
			alert("教学楼非空");
			s.rno.focus();
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
  <form action="InsertClassroom" method="post"  onsubmit="return warning(this)" >
  <table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <td width="25%"><div align="center">教学楼</div></td>
	  <td><select name="rbuilding"  style="width: 100px; ">
 	    <option value="">----请选择----</option>
 	    <option value="11号楼">11号楼</option>
	    <option value="21B">21B</option>
	    <option value="1号楼N楼">1号楼N楼</option>
	    <option value="1号楼S楼">1号楼S楼</option>
	    <option value="逸夫楼">逸夫楼</option>
	  </select>  </td>
	  <td width="20%"><div align="center">教室号</div></td>
      <td width="30%"><input name="rno" style="width:100px" type="text" /></td>
    </tr>
    <tr>
      <td><div align="center">教室类型</div></td>
      <td><select name="rtype" style="width: 100px; ">
 	    <option value=" ">----请选择----</option>
 	    <option value="实验室">实验室</option>
	    <option value="教室">教室</option>
	  </select>  </td>
      <!--<td><input name="rtype" style="width=100px" type="text" /></td>-->
      <td><div align="center">教室大小</div></td>
      <td><select name="rseat" style="width: 100px; ">
 	    <option value=" ">----请选择----</option>
 	    <option value="大">大</option>
	    <option value="中">中</option>
	    <option value="小">小</option>
	  </select> </td>
    </tr>
    <tr>
      <td><div align="center">是否有多媒体</div></td>
     <td colspan="3"><select name="rmedia" style="width: 100px; ">
        <option value=" ">----请选择----</option>
        <option value="是">是</option>
	    <option value="否">否</option>
	  </select>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  <input type="hidden" name="ravailable" value="可申请"/>
	  <input type="hidden" name="ravailable" value="可申请"/>	  
	  </td>
<!--       <td><div align="center">可用时间</div></td>
   	  <td><select name="ravailable" style="width: 100px; ">
 	    <option value=" ">----请选择----</option>
 	    <option value="1-2节">1-2节</option>
	    <option value="3-5节">3-5节</option>
	    <option value="6-7节">6-7节</option>
	    <option value="8-10节">8-10节</option>
	    <option value="11-12节">11-12节</option>
	  </select> </td> -->
    </tr>
<!--     <tr>
      <td><div align="center">批复</div></td>
      <td colspan="3"><input name="rreply" style="width:100%;height:100%" type="text" /></td>
    </tr> -->
    <tr >
      <td height="70px"><div align="center">备注</div></td>
      <td colspan="3"><textarea name="rremark"  style="width:100%;height:100%"></textarea></td>
    </tr>
    <tr>
      <td colspan="2" align="center" ><a href="blank.jsp"><input id="btn_loca" type="button" value="返回"/></a></td>
      <td colspan="2" align="center" ><input id="btn_loca" type="submit" value="提交" name="submit" /></td>
    </tr>
  </table>
  </form>
  </body>
</html>
