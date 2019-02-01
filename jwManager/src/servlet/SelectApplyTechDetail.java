package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;

import dao.RoomApplyDao;
import dto.RoomApply;

public class SelectApplyTechDetail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectApplyTechDetail() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String building = Decode.decode(request.getParameter("building"));
		String no = Decode.decode(request.getParameter("no"));
		String jieshu = Decode.decode(request.getParameter("jieshu"));
		String usetime = Decode.decode(request.getParameter("usetime"));
		RoomApplyDao dao = new RoomApplyDao();
		RoomApply ra = new RoomApply();
		RoomApply ra1 = new RoomApply();		
		ra.setId(id);
		ra.setBuilding(building);
		ra.setNo(no);
		ra.setJieshu(jieshu);
		ra.setUsetime(usetime);
		ra1=dao.selectApplyBySth(ra);
		request.setAttribute("applytechdetail", ra1);
		request.getRequestDispatcher("selectApplyTechDetail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
