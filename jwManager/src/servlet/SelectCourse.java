package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.CourseDao;
import dao.TeacherDao;
import dto.Classroom;
import dto.Course;
import dto.Teacher;

public class SelectCourse extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectCourse() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid=Decode.decode(request.getParameter("crid"));
		String cname=Decode.decode(request.getParameter("crname"));
		String ctype=Decode.decode(request.getParameter("crtype"));
		CourseDao dao = new CourseDao();
		Course c1 = new Course();
		c1.setCid(cid);
		c1.setCname(cname);
		c1.setCtype(ctype);
		request.setAttribute("c1",c1);
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		System.out.println("这是page输出");
		System.out.println(strPage);
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		System.out.println("这是currentCount输出");
		System.out.println(currentCount);
		rowCount=dao.sumData1(ctype, cid, cname);
		sumPageCount=dao.sumPageCount1(ctype, cid, cname);
		ArrayList<Course> slist = dao.fenye1(currentCount,ctype, cid, cname);//分页
		if(slist.size()==0){
			slist=null;
		}
		System.out.println("这是在sc的servlet中");
		System.out.println(cid);
		System.out.println(slist);
		System.out.println("000");
		request.setAttribute("ctry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);	
		request.getRequestDispatcher("selectCourse.jsp").forward(request, response);
	}

}
