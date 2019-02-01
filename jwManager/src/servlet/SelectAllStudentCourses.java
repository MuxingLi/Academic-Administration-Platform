package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseArrangeDao;
import dao.CourseDao;
import dao.StudentCourseDao;
import dto.Course;
import dto.CourseArrange;
import dto.Student;

public class SelectAllStudentCourses extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelectAllStudentCourses() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		StudentCourseDao dao= new StudentCourseDao();
//获取系统时间 月 判断。7月前-》秋季       7月后 -》春季
		Calendar d=Calendar.getInstance();
		int month = d.get(Calendar.MONTH)+1;
//确认输出当前月份 但若是选课6-7月选秋季课 1-2月选春季课
		if(month!=6&&month!=7&&month!=1&&month!=2){
			out.println("<script language=javascript>");				
			out.println("alert('当前不开放选课');");	
			out.println("window.location.href='blank.jsp'");			
			out.println("</script>");
		}else{
			String cterm="";
			if(month>5){
				cterm="秋季";
			}else{
				cterm="春季";
			}
//获取年份
		int year = d.get(Calendar.YEAR);
		String cyear="";
		if(month==6||month==7){
			cyear=year+"-"+(year+1);
		}else if(month==1||month==2){
			cyear=(year-1)+"-"+year;
		}
			int rowCount;
			int currentCount;
			int sumPageCount;
			String strPage=request.getParameter("page");
			if(strPage==null){
			  	currentCount=1;
			}else{
			  	currentCount=Integer.parseInt(strPage);
			}
			//course 选修+cterm 的分页
			CourseDao cdao= new CourseDao();
			rowCount=cdao.sumData4(cterm);
			sumPageCount=cdao.sumPageCount4(cterm);
			ArrayList<Course> slist = cdao.fenye4(currentCount,cterm);//分页
			if(slist.size()==0){
				slist=null;
			}
			request.setAttribute("ctry1", slist);
			request.setAttribute("rowCount", rowCount);
			request.setAttribute("sumPageCount", sumPageCount);
			request.setAttribute("currentCount", currentCount);		
			
//			CourseArrange ca=new CourseArrange();
//			HttpSession session=request.getSession();
//			Student stu=(Student)session.getAttribute("userinfo");
//			ca.setId(stu.getId());
//			ca.setCaterm(cterm);
//			ca.setCayear(cyear);
//			CourseArrangeDao dao2=new CourseArrangeDao();
//			if(dao2.panduan(stu.getId(),cyear,cterm)==null){
//				dao2.insertCourseArrange(ca);
//			}
			request.getRequestDispatcher("insertStudentCourse.jsp").forward(request, response);
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
