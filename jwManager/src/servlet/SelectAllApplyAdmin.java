package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.RoomApplyDao;
import dto.RoomApply;

public class SelectAllApplyAdmin extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public SelectAllApplyAdmin() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoomApplyDao dao = new RoomApplyDao();
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
		ArrayList<RoomApply> slist = dao.fenye(currentCount);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("atry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);		
		request.getRequestDispatcher("selectAllApplys.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
