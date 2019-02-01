<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat,java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java"%> 
<%@ page contentType="text/html; charset=utf-8"%> 
<%@ page import="java.text.*"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'applyClassroom.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
<link href="Css/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="Css/My97DatePicker/WdatePicker.js"></script>

</head>
  
  <body>
  <form action="ApplyClassroom" method="post"  onsubmit="return ApplyConfirm()" >
  <table width="98%" border="1" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <td width="25%"><div align="center">教学楼</div></td>
	  <td><input readonly name="building" style="width:100%;font-size:16px;" type="text" value="${requestScope.classrooms.rbuilding}" readonly /></td>
	  <td width="20%"><div align="center">教室号</div></td>
      <td width="30%"><input readonly name="no" style="width:100%;font-size:16px;" type="text" value="${requestScope.classrooms.rno}" readonly /></td>
    </tr>
    
    <tr>
      <td><div align="center">教室类型</div></td>
      <td><input name="type" value="${requestScope.classrooms.rtype}" style="width:100%;font-size:16px;" type="text" readonly></td>
      <td><div align="center">教室大小</div></td>
      <td><input name="seat" value="${requestScope.classrooms.rseat}" style="width:100%;font-size:16px;" type="text" readonly></td>
    </tr>
    <tr>
	<tr>
      <td><div align="center">是否有多媒体</div></td>
      <td><div align="center"><input name="media" style="width:100%;font-size:16px;" type="text" value="${requestScope.classrooms.rmedia}" readonly/></div></td>
      <td align="center">申请时间</td>
      <td >
      <input id="week" type="text" style="width:100%;font-size:16px;" name="week" onfocus="WdatePicker({el:$dp.$(this)})" onblur="check(this);"/>
      </td>
    </tr>
    <tr>
    <td><div align="center">可用时间</div></td>
      <td colspan="2">
      
      <select id="jieshu" name="jieshu" style="width:100px;font-size:16px" >
		<option></option>
      </select>
      </td>
    </tr>
    <tr>
      <td height="70px"><div align="center">备注</div></td>
      <td colspan="3">
      <textarea name="remark" style="width:100%;height:100%;font-size:16px" ></textarea>
    </tr>
    <tr>
      <td colspan="2" align="center" ><a href="SelectAllClassroomsServlet"><input id="btn_loca" type="button" value="返回"/></a></td>
      <td colspan="2" align="center" ><input type="submit" value="申请" name="update" id="btn_loca"/></td>
    </tr>

<% Date now = new Date(); %>
<% DateFormat d2 = DateFormat.getDateTimeInstance(); %>
<% String str2 = d2.format(now);%>
</table>
<input type="hidden" name="time" value="<% out.print(str2);%>"/>
<input type="hidden" name="status" value="申请中"/>
</form>
<script type="text/javascript">
function ApplyConfirm(){
		f=document.forms[0];
		if(f.week.value==""){
			alert("选课时间不能为空 ");
			f.week.focus();
			return false;
		}
 		if(confirm("确认申请？")){
		f.sbumit();
		}
		return false;

}

    function  check(sDate){    //sDate1和sDate2是2006-12-18格式  
   	   var sDate1=sDate.value;
   	   var sDate2=new Date().toLocaleDateString();
       var  aDate,  oDate1,  oDate2,  iDays  ;
       aDate  =  sDate1.split("/")  ;
       oDate1  =  new  Date(aDate[0],aDate[1]-1,aDate[2]) ;   
       aDate2  =  sDate2.split("/")  ;//dangqian    
       oDate2  =  new  Date(aDate2[0],aDate2[1]-1,aDate2[2])  ;  
       if((oDate1-oDate2)/1000/60/60/24<0) {
       alert("申请时间选择错误");
	   sDate.value="";
	   sDate.focus();
       } 
       iDays  =  parseInt((oDate1 - oDate2)  /  1000  /  60  /  60  /24) ;   //把相差的毫秒数转换为天数  
	   if(iDays>6){
	   alert("仅允许申请7天内");
	  sDate.value="";
	  sDate.focus();
	   }
		check2();
        
   } 
   function check1(sDate){
   	    var sDate1=sDate.value;
   		var a=new Date(sDate1).getDay();
		return a;
		
   }

   function check2() {
   document.getElementById("jieshu").options.length=0;
	var abc=document.getElementById("week");
	var a=check1(abc);
		if(a==1){
		if("${requestScope.m[0]}"=="可申请"||"${requestScope.m[0]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("1-2节","1-2节"));
 		}
	if("${requestScope.m[1]}"=="可申请"||"${requestScope.m[1]}"=="已拒绝"){
		document.getElementById("jieshu").options.add(new Option("3-4节","3-4节"));
		}
	if("${requestScope.m[2]}"=="可申请"||"${requestScope.m[2]}"=="已拒绝"){
		document.getElementById("jieshu").options.add(new Option("5-6节","5-6节"));
		}
	if("${requestScope.m[3]}"=="可申请"||"${requestScope.m[3]}"=="已拒绝"){
		document.getElementById("jieshu").options.add(new Option("7-8节","7-8节"));
		}
	if("${requestScope.m[4]}"=="可申请"||"${requestScope.m[4]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("9-10节","9-10节"));
		}
	}	
		if(a==2){
			if("${requestScope.m[5]}"=="可申请"||"${requestScope.m[5]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("1-2节","1-2节"));
	 		}
		if("${requestScope.m[6]}"=="可申请"||"${requestScope.m[6]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("3-4节","3-4节"));
			}
		if("${requestScope.m[7]}"=="可申请"||"${requestScope.m[7]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("5-6节","5-6节"));
			}
		if("${requestScope.m[8]}"=="可申请"||"${requestScope.m[8]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("7-8节","7-8节"));
			}
		if("${requestScope.m[9]}"=="可申请"||"${requestScope.m[9]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("9-10节","9-10节"));
			}
		}
		if(a==3){
			if("${requestScope.m[10]}"=="可申请"||"${requestScope.m[10]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("1-2节","1-2节"));
	 		}
		if("${requestScope.m[11]}"=="可申请"||"${requestScope.m[11]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("3-4节","3-4节"));
			}
		if("${requestScope.m[12]}"=="可申请"||"${requestScope.m[12]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("5-6节","5-6节"));
			}
		if("${requestScope.m[13]}"=="可申请"||"${requestScope.m[13]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("7-8节","7-8节"));
			}
		if("${requestScope.m[14]}"=="可申请"||"${requestScope.m[14]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("9-10节","9-10节"));
			}
		}
		if(a==4){
		if("${requestScope.m[15]}"=="可申请"||"${requestScope.m[15]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("1-2节","1-2节"));
	 		}
		if("${requestScope.m[16]}"=="可申请"||"${requestScope.m[16]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("3-4节","3-4节"));
			}
		if("${requestScope.m[17]}"=="可申请"||"${requestScope.m[17]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("5-6节","5-6节"));
			}
		if("${requestScope.m[18]}"=="可申请"||"${requestScope.m[18]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("7-8节","7-8节"));
			}
		if("${requestScope.m[19]}"=="可申请"||"${requestScope.m[19]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("9-10节","9-10节"));
			}
		}
		if(a==5){
			if("${requestScope.m[20]}"=="可申请"||"${requestScope.m[20]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("1-2节","1-2节"));
	 		}
		if("${requestScope.m[21]}"=="可申请"||"${requestScope.m[21]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("3-4节","3-4节"));
			}
		if("${requestScope.m[22]}"=="可申请"||"${requestScope.m[22]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("5-6节","5-6节"));
			}
		if("${requestScope.m[23]}"=="可申请"||"${requestScope.m[23]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("7-8节","7-8节"));
			}
		if("${requestScope.m[24]}"=="可申请"||"${requestScope.m[24]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("9-10节","9-10节"));
			}
		}
		if(a==6){
			if("${requestScope.m[25]}"=="可申请"||"${requestScope.m[25]}"=="已拒绝"){
					document.getElementById("jieshu").options.add(new Option("1-2节","1-2节"));
		 		}
			if("${requestScope.m[26]}"=="可申请"||"${requestScope.m[26]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("3-4节","3-4节"));
				}
			if("${requestScope.m[27]}"=="可申请"||"${requestScope.m[27]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("5-6节","5-6节"));
				}
			if("${requestScope.m[28]}"=="可申请"||"${requestScope.m[28]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("7-8节","7-8节"));
				}
			if("${requestScope.m[29]}"=="可申请"||"${requestScope.m[29]}"=="已拒绝"){
					document.getElementById("jieshu").options.add(new Option("9-10节","9-10节"));
				}
			}
		if(a==0){
			if("${requestScope.m[30]}"=="可申请"||"${requestScope.m[30]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("1-2节","1-2节"));
	 		}
		if("${requestScope.m[31]}"=="可申请"||"${requestScope.m[31]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("3-4节","3-4节"));
			}
		if("${requestScope.m[32]}"=="可申请"||"${requestScope.m[32]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("5-6节","5-6节"));
			}
		if("${requestScope.m[33]}"=="可申请"||"${requestScope.m[33]}"=="已拒绝"){
			document.getElementById("jieshu").options.add(new Option("7-8节","7-8节"));
			}
		if("${requestScope.m[34]}"=="可申请"||"${requestScope.m[34]}"=="已拒绝"){
				document.getElementById("jieshu").options.add(new Option("9-10节","9-10节"));
			}
		}
		}
</script>
</body>
</html>