
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;
import dao.StudentDao;
import dto.News;
import dto.Student;

public class SelectNewsDetail extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelectNewsDetail() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nid=request.getParameter("nid");
		NewsDao ndao = new NewsDao();
		News n = new News();
		News news = new News();
		news.setNid(nid);
		n=ndao.selectNewsById(news);
		request.setAttribute("news", n);
		request.getRequestDispatcher("selectNewsDetail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
