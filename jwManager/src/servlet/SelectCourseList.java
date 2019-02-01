package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TeacherCourseDao;
import dao.TeacherDao;
import dto.StudentCourse;
import dto.Teacher;
import dto.TeacherCourse;

public class SelectCourseList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectCourseList() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		Teacher tech=(Teacher)session.getAttribute("userinfo");
		TeacherDao tdao= new TeacherDao();
		Teacher t=new Teacher();
		t=tdao.selectTeacherById(tech.getId());
		String tname=t.getName();
		TeacherCourseDao tcdao = new TeacherCourseDao();
		
		ArrayList<TeacherCourse> term = tcdao.term();
		ArrayList<TeacherCourse> year = tcdao.term1();
		request.setAttribute("term", term);
		request.setAttribute("year", year);
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=tcdao.sumData(tname);
		sumPageCount=tcdao.sumPageCount(tname);
		ArrayList<TeacherCourse> slist = tcdao.fenye(currentCount,tname);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("ctry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);	
		
		request.getRequestDispatcher("selectCourseList.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
