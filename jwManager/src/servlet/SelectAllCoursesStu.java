package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dto.Course;

public class SelectAllCoursesStu extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelectAllCoursesStu() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CourseDao dao=new CourseDao();
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=dao.sumData2();
		sumPageCount=dao.sumPageCount2();
		ArrayList<Course> slist = dao.fenye2(currentCount);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("ctry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);	
		request.getRequestDispatcher("selectAllCoursesStu.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
