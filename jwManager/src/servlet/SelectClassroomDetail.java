package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.ClassroomDao;
import dto.Classroom;

public class SelectClassroomDetail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectClassroomDetail() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rbuilding=Decode.decode(request.getParameter("rbuilding"));
		String rno=request.getParameter("rno");
		ClassroomDao dao=new ClassroomDao();
		Classroom cl=new Classroom();
		cl.setRno(rno);
		cl.setRbuilding(rbuilding);
		cl=dao.selectClassroomById(cl);
		request.setAttribute("classrooms", cl);
		request.getRequestDispatcher("selectClassroomDetail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
