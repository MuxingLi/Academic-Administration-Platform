<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'left.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="Css/main.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" language="javascript" src="Css/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function()
{
	$("#firstpane p.menu_head").click(function()
    {
		$(this).css({backgroundImage:"url(down.png)"}).next("div.menu_body").slideToggle(300).siblings("div.menu_body").slideUp("fast");
       	$(this).siblings().css({backgroundImage:"url(left.png)"});
	});
});
</script>
	
	
<style type="text/css">
body { margin: 0px auto; font: 75%/120% Verdana, Arial, Helvetica, sans-serif; }
.menu_head { padding: 5px 10px; cursor: pointer; position: relative; margin:0px; font-weight:bold;font-size:15px;font-family:"魏体"; height:20px; line-height:20px; background: #fff url(left.png) center right no-repeat; }
.menu_body { display:none; }
.menu_body a { display:block; color:#000000; background-color:#f8f4ff; padding-left:10px;  font-size:14px;font-family:"魏体"; text-decoration:none;height:30px;line-height:30px; }
.menu_body a:hover { background-color:#f5f5f5;color: #006699; text-decoration:none; }
.menu_body a:active { background-color:#eaefff;color: #37596D; text-decoration:none; }
</style>
  </head>
  <body>
    <div id="left">
		<div id="left_menu"></div>
	  <div id="left_tree">
			<div id="tree_text">
        <c:if test="${sessionScope.userinfo.role=='学生'}">
        	<div id="firstpane" > 
			<p class="menu_head">学生信息管理</p>
       		<div class="menu_body">
			<a href="SelectStudentDetail?id=${sessionScope.userinfo.id}" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看学生信息</a>
			<a href="UpdateStudent?id=${sessionScope.userinfo.id}" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>修改学生信息</a>
 			</div>
			<p class="menu_head">学生课程管理</p>
        	<div class="menu_body">
			<a href="SelectAllCoursesStu" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看课程信息</a>
			<a href="SelectAllStudentCourses" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>学生选课</a>
			<a href="SelectStudentCourse" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看选课</a>
			</div>
			<p class="menu_head">课&nbsp;&nbsp;表&nbsp;&nbsp;查&nbsp;&nbsp;看</p>
			<div class="menu_body">
			<a href="InsertCourseArrange" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看课表</a>
			</div>
			<p class="menu_head">成&nbsp;&nbsp;绩&nbsp;&nbsp;查&nbsp;&nbsp;询</p>
			<div class="menu_body">
			<a href="SelectAllMarks" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看成绩</a>
			</div>			
			<p class="menu_head">个人信息管理</p>
			<div class="menu_body">
			<a href="updatepwd.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>修改密码</a>
			</div>
			</div>
		</c:if>
		<c:if test="${sessionScope.userinfo.role=='教师'}">
			<div id="firstpane" > 
			<p class="menu_head">教师信息管理</p>
       		<div class="menu_body">
			<a href="SelectTeacherDetail?id=${sessionScope.userinfo.id}" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看教师信息</a>
			<a href="UpdateTeacher?id=${sessionScope.userinfo.id}" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>修改教师信息</a>
			</div>
			<p class="menu_head">教室信息管理</p>
        	<div class="menu_body">
			<a href="SelectAllClassroomsServlet" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看教室信息</a>
			<a href="SelectAllApplyTech" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看教室申请</a>			
			</div>
			<p class="menu_head">课程信息管理</p>
        	<div class="menu_body">
			<a href="SelectAllCoursesServlet" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看课程信息</a>
			<a href="SelectCourseList" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看学生名单</a>
			<a href="InsertCourseArrangeTech" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看课表</a>
			</div>
			<p class="menu_head">学生成绩管理</p>
        	<div class="menu_body">
			<a href="SelectAllCoursesMark" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>添加学生成绩</a>
			<a href="SelectAllCoursesMark2"  target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看学生成绩</a>
			</div>
			<p class="menu_head">个人信息管理</p>
			<div class="menu_body">
			<a href="updatepwd.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>修改密码</a>
			</div>
			</div>
			</c:if>
		<c:if test="${sessionScope.userinfo.role=='管理员'}">
		<div id="firstpane" >     
        <p class="menu_head">学生信息管理</p>
        <div class="menu_body">
        <a href="insertStudent.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>手动输入学生信息</a>
        <a href="insertStu.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>添加学生信息文件</a>
        <a href="SelectAllStudentsServlet" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看学生信息</a>
		</div>
        <p class="menu_head">教师信息管理</p>
        <div class="menu_body">
		<a href="insertTeacher.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>手动输入教师信息</a>
		<a href="insertTech.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>添加教师信息文件</a>
		<a href="SelectAllTeachersServlet" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看教师信息</a>
		</div>
		<p class="menu_head">教室信息管理</p>
        <div class="menu_body">
		<a href="insertClassroom.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>添加教室信息</a>
		<a href="SelectAllClassroomsServlet" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看教室信息</a>
		<a href="SelectAllApplyAdmin" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看教室申请</a>			
		</div>
		<p class="menu_head">课程信息管理</p>
        <div class="menu_body">
		<a href="insertCourse.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>添加课程信息</a>
		<a href="insertCrs.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>添加课程信息文件</a>
		<a href="SelectAllCoursesServlet" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看课程信息</a>
		</div>
		<p class="menu_head">公告信息管理</p>
        <div class="menu_body">
		<a href="insertNews.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>发布公告</a>
		<a href="SelectAllNewsServlet" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看所有公告</a>
		</div>
		<p class="menu_head">教学计划管理</p>
        <div class="menu_body">
		<a href="insertProgram.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>新增教学计划</a>
		<a href="insertPro.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>添加教学计划文件</a>
		<a href="SelectAllPrograms" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>查看教学计划</a>
		</div>
		<p class="menu_head">个人信息管理</p>
		<div class="menu_body">
		<a href="updatepwd.jsp" target="aaa"><span class="list_img"><img src="Images/list_img.gif" /></span>修改密码</a>
		</div>
		</div>
		</c:if>
	      </div>
        </div>
		<div id="tree_down"></div>
</div>
</body>
</html>
