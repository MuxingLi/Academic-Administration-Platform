package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;

import dao.StudentCourseDao;
import dto.StudentCourse;

public class SelectStudentList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectStudentList() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid=Decode.decode(request.getParameter("cid"));
		StudentCourseDao scdao = new StudentCourseDao();
		ArrayList<StudentCourse> sc= scdao.selectAllStudentsByCid(cid);
		StudentCourse sc1 = new StudentCourse();
		sc1.setCid(cid);
		request.setAttribute("mark", sc);
		request.setAttribute("mark1", sc1);		
		request.getRequestDispatcher("selectStudentList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
