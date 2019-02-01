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

import dao.StudentCourseDao;
import dto.Course;
import dto.Student;
import dto.StudentCourse;

public class SelectStudentCourse extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelectStudentCourse() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		StudentCourseDao scdao = new StudentCourseDao();
		StudentCourse sc=new StudentCourse();
		HttpSession session=request.getSession();
		Student stu=(Student)session.getAttribute("userinfo");
		sc.setId(stu.getId());
		String id= sc.getId();
//		ArrayList<StudentCourse> scs=scdao.selectAllStudentCourses(id);
		//加入时间判断 输出当前时间 存入cyear中
/*		Calendar d=Calendar.getInstance();
		int year = d.get(Calendar.YEAR);
		int month = d.get(Calendar.MONTH)+1;
		String cyear = "";
		if(month<8){
			cyear = year-1+"-"+year;
		}else{
			cyear = year+"-"+year+1;
		}
		request.setAttribute("cyear", cyear);*/
		//获取系统时间 月 判断。7月前-》秋季       7月后 -》春季
		Calendar d=Calendar.getInstance();
		int month = d.get(Calendar.MONTH)+1;
		//确认输出当前月份 但若是选课6-7月选秋季课 1-2月选春季课
		String cterm="";
		String cyear="";
		if(month!=6&&month!=7&&month!=1&&month!=2){
			out.println("<script language=javascript>");				
			out.println("alert('当前不开放该功能');");	
			out.println("window.location.href='blank.jsp'");			
			out.println("</script>");
		}else{
			
			if(month>5){
				cterm="秋季";
			}else{
				cterm="春季";
			}
		//获取年份
			int y = d.get(Calendar.YEAR);
			
			if(month==6||month==7){
				cyear=y+"-"+(y+1);
			}else if(month==1||month==2){
				cyear=(y-1)+"-"+y;
			}		
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
		String ctype="选修";
		rowCount=scdao.sumData2(ctype,cterm,cyear,id);
		sumPageCount=scdao.sumPageCount2(ctype,cterm,cyear,id);
		ArrayList<StudentCourse> slist = scdao.fenye2(currentCount,ctype,cterm,cyear,id);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("ctry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);	
		
		request.getRequestDispatcher("selectStudentCourse.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
	}

}
