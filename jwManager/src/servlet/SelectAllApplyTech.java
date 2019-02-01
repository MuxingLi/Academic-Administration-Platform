package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RoomApplyDao;
import dto.RoomApply;
import dto.Teacher;

public class SelectAllApplyTech extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectAllApplyTech() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoomApplyDao dao = new RoomApplyDao();
		HttpSession session=request.getSession();
		Teacher tech=(Teacher)session.getAttribute("userinfo");

		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=dao.sumData2(tech.getId());
		sumPageCount=dao.sumPageCount2(tech.getId());
		ArrayList<RoomApply> slist = dao.fenye2(currentCount,tech.getId());//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("atry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);	
		request.getRequestDispatcher("selectApplyTech.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
