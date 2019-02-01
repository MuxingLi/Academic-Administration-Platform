package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.NewsDao;
import dao.StudentDao;
import dto.News;
import dto.Student;

public class SelectAllNewsServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelectAllNewsServlet1() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String one=Decode.decode(request.getParameter("one"));
		NewsDao dao = new NewsDao();
		request.setAttribute("one", one);
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=dao.sumData1(one);
		sumPageCount=dao.sumPageCount1(one);
		ArrayList<News> slist = dao.fenye1(currentCount, one);
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("stry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);			
		request.getRequestDispatcher("selectAllNews1.jsp").forward(request, response);
	}

}
