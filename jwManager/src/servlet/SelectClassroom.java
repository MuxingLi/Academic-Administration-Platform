package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.ClassroomDao;
import dto.Classroom;

public class SelectClassroom extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SelectClassroom() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rbuilding=Decode.decode(request.getParameter("rmbuilding"));
		String rseat=Decode.decode(request.getParameter("rmseat"));
		ClassroomDao dao = new ClassroomDao();
		ArrayList<Classroom> classrooms1=dao.building();
		request.setAttribute("build",classrooms1);
		Classroom cl1 = new Classroom();
		cl1.setRseat(rseat);
		cl1.setRbuilding(rbuilding);
		request.setAttribute("cl1",cl1);
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=dao.sumData1(rseat, rbuilding);
		sumPageCount=dao.sumPageCount1(rseat, rbuilding);
		ArrayList<Classroom> slist = dao.fenye1(currentCount,rseat,rbuilding);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("ctry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);	
		
		
		request.getRequestDispatcher("selectClassroom.jsp").forward(request, response);
	}

}
