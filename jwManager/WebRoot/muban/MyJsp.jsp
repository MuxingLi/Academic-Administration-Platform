<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">





<HTML>
<HEAD><TITLE>请您登录</TITLE>
<script language="JavaScript">
function Judge()
	{
	var WebUserNO=document.all["WebUserNO"].value;
	if(WebUserNO=="")
	   {alert("登录用户不能为空！");
	   document.all["WebUserNO"] .focus();
	   return false;
	   }
}
</script>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<STYLE type=text/css>TD {
	FONT-SIZE: 12px
}
p1 {
	FONT-SIZE: 12px
}
INPUT {
	FONT-SIZE: 12px
}
p2 {
	FONT-SIZE: 12px; LINE-HEIGHT: 14pt
}
p3 {
	FONT-SIZE: 14px
}
p4 {
	FONT-SIZE: 14px; LINE-HEIGHT: 14pt
}
p5 {
	FONT-SIZE: 16px
}
p6 {
	FONT-SIZE: 14px; LINE-HEIGHT: 180%
}
p7 {
	FONT-SIZE: 12px; COLOR: #136792; LINE-HEIGHT: 160%
}
BIG {
	FONT-SIZE: 18px
}
A:link {
	COLOR: #0000ff
}
A:visited {
	COLOR: #0000ff
}
A:hover {
	COLOR: #ff0000
}
hand {
	CURSOR: hand; BACKGROUND-COLOR: rgb(208,207,192)
}
</STYLE>
<!--style end-->
<META content="MSHTML 6.00.2600.0" name=GENERATOR></HEAD>
<BODY bgColor=#ffffff topMargin=7 marginheight="0" marginwidth="25">
<form name="LoginForm" method="post" action="ACTIONLOGON.APPPROCESS">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD bgColor=#e6e6e6 height=20></TD>
      <TD align=right bgColor=#e6e6e6>&nbsp;</TD>
    </TR></TBODY></TABLE><BR>
<TABLE cellSpacing=0 cellPadding=1 width=492 align=center border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE borderColor=#c1eaff cellSpacing=0 cellPadding=20 width=474 
      align=center border=1>
        <TBODY>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=6 width=474 align=center 
              border=0><TBODY>
              <TR>
                        <TD class=p7 bgColor=#33CCFF 
                  colSpan=2><strong>用户未登录或者登录已过期\n如需继续操作请重新登录\n</strong></TD>
                </TR></TBODY></TABLE>
                <TABLE width=283 height="100" 
              border=0 align=center cellPadding=0 cellSpacing=0>
                                   <tr>
					  <td width="50" rowspan="4">&nbsp;</td>
                    <td align="left">
					  </td>
                      </tr>
                                   <tr>
                                     <td height="22" align="left">用户名:
                                     <input name="WebUserNO" type="text" id="WebUserNO" size="12"></td>
                                   </tr>
                                   <tr>
                                     <td height="22" align="left">密&nbsp;&nbsp;码:
                                     <input name="Password" type="password" id="Password" size="12"></td>
                                   </tr>
                                   <tr>
                                     <td height="22" align="left" valign="middle">附加码:
                                     <input name="Agnomen" type="text" id="Agnomen" size="12"><img src="ACTIONVALIDATERANDOMPICTURE.APPPROCESS" width="60" height="20"></td>
                                   </tr>
                  <tr align="center"> 
                    <td colspan="2"><input type="image" border="0" name="submit" src="User_JSP/images/Logon.gif" width="37" height="18" onClick="javascript:return Judge();">
                    &nbsp;&nbsp;&nbsp;
					<input type="image" border="0" name="reset" src="User_JSP/images/Register.gif" width="37" height="18" onClick=""></td>
				</tr>	
                  <tr> 
                    <td colspan="2"><div align="center"><input name="applicant" type="hidden" value="ACTIONQUERYELECTIVERESULTBYSTUDENT"></div></td>
				</tr>	
                </TABLE>
            <br>
          </TD>
        </TR>
        </TABLE></TD></TR></TBODY></TABLE>
</form>		
<BR>
<BR>
</BODY></HTML>
