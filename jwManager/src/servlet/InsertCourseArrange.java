package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseArrangeDao;
import dao.StudentDao;
import dto.CourseArrange;
import dto.Student;

public class InsertCourseArrange extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public InsertCourseArrange() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		Student stu=(Student)session.getAttribute("userinfo");
		String id=stu.getId();
		Student s = new Student();
		StudentDao sdao = new StudentDao();
		s=sdao.selectStudentById(id);
		request.setAttribute("s",s);
		
//获取系统时间 
		Calendar d=Calendar.getInstance();
		int month = d.get(Calendar.MONTH)+1;
		int year = d.get(Calendar.YEAR);
//7-12月查看秋季课表  1-6月查看春季课表
		String cterm="";
		String cyear="";
		if(month>6){
			cterm="秋季";
			cyear=year+"-"+(year+1);
		}else{
			cterm="春季";
			cyear=(year-1)+"-"+year;
		}
		CourseArrangeDao cadao = new CourseArrangeDao();
		CourseArrange ca = new CourseArrange();
		ca = cadao.selectCAById(id,cterm,cyear);
		request.setAttribute("cas", ca);
		request.getRequestDispatcher("selectCourseArrange.jsp").forward(request, response);
	}
}
