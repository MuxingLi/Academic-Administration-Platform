package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Decode;
import dao.RoomApplyDao;
import dto.RoomApply;
import dto.Teacher;

public class SelectApplyTech extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelectApplyTech() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		Teacher tech=(Teacher)session.getAttribute("userinfo");
		String time=request.getParameter("atime");
		String status=Decode.decode(request.getParameter("astatus"));
		String usetime=Decode.decode(request.getParameter("ausetime"));
		RoomApplyDao dao = new RoomApplyDao();
		RoomApply a1 = new RoomApply();
		a1.setTime(time);
		a1.setStatus(status);
		a1.setUsetime(usetime);
		request.setAttribute("a1",a1);
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=dao.sumData3(time,usetime,tech.getId(),status);
		sumPageCount=dao.sumPageCount3(time,usetime,tech.getId(),status);
		ArrayList<RoomApply> slist = dao.fenye3(currentCount,time,usetime,tech.getId(),status);
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("atry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);		
		request.getRequestDispatcher("selectApplyTech1.jsp").forward(request, response);
	}

}
