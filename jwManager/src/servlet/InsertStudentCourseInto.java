package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.record.formula.functions.Match;

import dao.CourseArrangeDao;
import dao.CourseDao;
import dao.StudentCourseDao;
import dao.StudentDao;
import dao.TeacherCourseDao;
import dao.TeacherDao;
import dto.Course;
import dto.CourseArrange;
import dto.Student;
import dto.StudentCourse;
import dto.Teacher;
import dto.TeacherCourse;

public class InsertStudentCourseInto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public InsertStudentCourseInto() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//course
		String cid=request.getParameter("cid");
		CourseDao dao =new CourseDao();
		Course c1=dao.selectCourseById(cid);	
//student
		HttpSession session=request.getSession();
		Student stu=(Student)session.getAttribute("userinfo");
		Student s= new Student();
		StudentDao sdao = new StudentDao();
		s=sdao.selectStudentById(stu.getId());
//teacher
		Teacher t = new Teacher();
		TeacherDao tdao = new TeacherDao();
		t=tdao.selectTeacherByName(c1.getCteacher());
//studentcourse
		StudentCourse sc=new StudentCourse();
		StudentCourseDao dao1=new StudentCourseDao();
		sc.setId(stu.getId());
		sc.setCourse(c1);
		sc.setStudent(s);
//获取系统时间 年 月 分别判断存入cyear中 2016。7月前-》2015-2016【即当前年份-1~当前年份】 7月后 2016-2017【即当前年份~当前年份+1】
		Calendar d=Calendar.getInstance();
		int year = d.get(Calendar.YEAR);
		int month = d.get(Calendar.MONTH)+1;
		String cyear = "";
		String cterm = "";
		if(month>5){
			cterm = "秋季";
			cyear = year+"-"+(year+1);
		}else{
			cterm = "春季";
			cyear = (year-1)+"-"+year;
		}
		sc.setCyear(cyear);
//coursearrange
		CourseArrange ca=new CourseArrange();
		CourseArrange ca1=new CourseArrange();
		CourseArrangeDao dao2=new CourseArrangeDao();
		ca.setId(stu.getId());
		ca.setCourse(c1);
		ca.setCaterm(cterm);
		ca.setCayear(cyear);
//teachercourse
		TeacherCourse tc=new TeacherCourse();
		TeacherCourseDao dao3=new TeacherCourseDao();
		tc.setId(t.getId());
		tc.setName(t.getName());
		tc.setCourse(c1);
		tc.setCyear(cyear);
//插入课程前 检测时间是否冲突		
//		String sk=c1.getCshangke();
		String test="";
		test=dao2.selectCA(ca);
		if(test==null){
		int i=dao1.insertStudentCourse(sc);//将课程信息插入选课表中
		if(i==1){
			out.println("<script language=javascript>");				
			out.println("alert('选择课程成功');");	
			out.println("</script>");
			dao2.insertCourseArrange2(ca);
	//查看tc表中是否有【tid,term,year,cid】已有 不加，没有则加
			if(dao3.selectByIC(t.getId(),c1.getCid(),c1.getCterm(),cyear)==null){
			dao3.insertTeacherCourse(tc);
			}
//教师课表添加	
			ca1.setId(t.getId());
			ca1.setCayear(cyear);
			ca1.setCaterm(cterm);
			ca1.setCourse(c1);
			if(dao2.panduan(t.getId(),cyear,cterm)==null){
				dao2.insertCourseArrange(ca1);
				dao2.insertCourseArrange4(ca1);
			}else{
				dao2.insertCourseArrange4(ca1);
			}
		}else{
			out.println("<script language=javascript>");				
			out.println("alert('课程已选择');");	
			out.println("</script>");
		}
		out.println("<script language=javascript>");				
		out.println("window.location.href='SelectAllStudentCourses'");	
		out.println("</script>");
		}else{
			out.println("<script language=javascript>");				
			out.println("alert('课程时间冲突');");	
			out.println("</script>");
		}
		out.flush();
		out.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
