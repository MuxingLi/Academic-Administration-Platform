package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;
import dto.News;

public class SelectNewsMainPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelectNewsMainPage() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type1="考试管理";
		String type2="实践教学";
		NewsDao dao = new NewsDao();
		News n1 = new News();
		News n2 = new News();
		n1.setNtype(type1);
		n2.setNtype(type2);
		ArrayList<News> n3=dao.selectNewsFour(n1);
		ArrayList<News> n4=dao.selectNewsFour(n2);
		request.setAttribute("t1", n3);
		request.setAttribute("t2", n4);		
		request.getRequestDispatcher("news-main.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
