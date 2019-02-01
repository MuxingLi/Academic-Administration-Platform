package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Decode;
import dao.CourseArrangeDao;
import dao.TeacherDao;
import dto.CourseArrange;
import dto.Teacher;

public class InsertCourseArrangeTech1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public InsertCourseArrangeTech1() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		Teacher tech=(Teacher) session.getAttribute("userinfo");
		String id= tech.getId();
		String caterm=Decode.decode(request.getParameter("caterm"));
		String cayear=Decode.decode(request.getParameter("cayear"));
		String cterm=caterm+"学期";
		request.setAttribute("term",cterm);
		request.setAttribute("year",cayear);
		Teacher t = new Teacher();
		TeacherDao tdao = new TeacherDao();
		t=tdao.selectTeacherById(id);
		request.setAttribute("t",t);
		CourseArrangeDao cadao = new CourseArrangeDao();
		CourseArrange ca = new CourseArrange();
		ca = cadao.selectCAById(id,caterm,cayear);
		request.setAttribute("cas", ca);
		request.getRequestDispatcher("selectCourseArrangeTech.jsp").forward(request, response);
	}

}
