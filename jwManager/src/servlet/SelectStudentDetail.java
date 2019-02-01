package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;

import dao.StudentDao;
import dto.Student;

public class SelectStudentDetail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectStudentDetail() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuid=request.getParameter("id");
		StudentDao sdao=new StudentDao();
		Student s=new Student();
		s=sdao.selectStudentById(stuid);
		request.setAttribute("students", s);
		request.getRequestDispatcher("selectStudentDetail.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
