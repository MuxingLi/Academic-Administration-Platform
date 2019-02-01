package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentCourseDao;
import dto.Student;
import dto.StudentCourse;

public class SelectAllMarks extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectAllMarks() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		Student stu=(Student) session.getAttribute("userinfo");
		String id=stu.getId();
		StudentCourseDao scdao = new StudentCourseDao();
		//年份及学期
		ArrayList<StudentCourse> term = scdao.term();
		ArrayList<StudentCourse> year = scdao.term1();
		request.setAttribute("term", term);
		request.setAttribute("year", year);
		//分页
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=scdao.sumData3(id);
		sumPageCount=scdao.sumPageCount3(id);
		ArrayList<StudentCourse> slist = scdao.fenye3(currentCount,id);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("ctry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);	
		
		request.getRequestDispatcher("selectAllMarks.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
