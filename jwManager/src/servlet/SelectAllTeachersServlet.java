package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDao;
import dto.Teacher;

public class SelectAllTeachersServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectAllTeachersServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		TeacherDao dao=new TeacherDao();
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=dao.sumData();
		sumPageCount=dao.sumPageCount();
		ArrayList<Teacher> slist = dao.fenye(currentCount);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("ttry1", slist);
		ArrayList<Teacher> teachers1=dao.depart();//分院系
		request.setAttribute("dept", teachers1);
		ArrayList<Teacher> teachers2=dao.zhicheng();//分职称
		request.setAttribute("zhicheng", teachers2);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);		
		request.getRequestDispatcher("selectAllTeachers.jsp").forward(request, response);

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
