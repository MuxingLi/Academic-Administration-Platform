package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.NewsDao;
import dto.News;

public class SelectNewsMainDetail extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SelectNewsMainDetail() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nid = Decode.decode(request.getParameter("nid"));
		NewsDao dao = new NewsDao();
		News n = new News();
		News n1 = new News();
		n.setNid(nid);
		n1=dao.selectNewsById(n);
		request.setAttribute("news", n1);
		request.getRequestDispatcher("selectNewsMainDetail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
