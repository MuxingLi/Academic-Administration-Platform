package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.NewsDao;
import dto.News;

public class SelectNewsMainKind1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelectNewsMainKind1() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search=Decode.decode(request.getParameter("search"));
		String ntype=Decode.decode(request.getParameter("ntype"));
		request.setAttribute("search",search);
		request.setAttribute("ntype1",ntype);
		NewsDao dao = new NewsDao();
		int rowCount;
		int currentCount;
		int sumPageCount;
		String strPage=request.getParameter("page");
		if(strPage==null){
		  	currentCount=1;
		}else{
		  	currentCount=Integer.parseInt(strPage);
		}
		rowCount=dao.sumData1(search);
		sumPageCount=dao.sumPageCount1(search);
		ArrayList<News> slist = dao.fenye1(currentCount,search);//分页
		if(slist.size()==0){
			slist=null;
		}
		request.setAttribute("stry1", slist);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("sumPageCount", sumPageCount);
		request.setAttribute("currentCount", currentCount);
		request.getRequestDispatcher("selectNewsMainKind1.jsp").forward(request, response);
	}

}
