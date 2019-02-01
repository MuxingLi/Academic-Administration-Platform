package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Decode;
import dao.CourseArrangeDao;
import dao.StudentDao;
import dto.CourseArrange;
import dto.Student;

public class InsertCourseArrange1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public InsertCourseArrange1() {
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
		String caterm=Decode.decode(request.getParameter("caterm"));
		String cayear=Decode.decode(request.getParameter("cayear"));
		String cterm=caterm+"学期";
		request.setAttribute("term",cterm);
		request.setAttribute("year",cayear);
		Student s = new Student();
		StudentDao sdao = new StudentDao();
		s=sdao.selectStudentById(id);
		request.setAttribute("s",s);
		CourseArrangeDao cadao = new CourseArrangeDao();
		CourseArrange ca = new CourseArrange();
		ca = cadao.selectCAById(id,caterm,cayear);
		request.setAttribute("cas", ca);
		request.getRequestDispatcher("selectCourseArrange.jsp").forward(request, response);
	}

}
