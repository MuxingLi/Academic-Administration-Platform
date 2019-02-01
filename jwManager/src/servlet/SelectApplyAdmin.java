package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.RoomApplyDao;
import dto.RoomApply;


public class SelectApplyAdmin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectApplyAdmin() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String time=request.getParameter("atime");
		String id=Decode.decode(request.getParameter("aname"));
		String usetime=Decode.decode(request.getParameter("ausetime"));
		RoomApplyDao dao = new RoomApplyDao();
		RoomApply a1 = new RoomApply();
		a1.setTime(time);
		a1.setId(id);
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
		rowCount=dao.sumData1(time,usetime,id);
		sumPageCount=dao.sumPageCount1(time,usetime,id);
		ArrayList<RoomApply> slist = dao.fenye1(currentCount,time,usetime,id);
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("atry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);		
		request.getRequestDispatcher("selectApply.jsp").forward(request, response);
	}
}
