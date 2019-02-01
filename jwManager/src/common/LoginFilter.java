package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI();
		HttpSession session = req.getSession();
		Object o = session.getAttribute("userinfo");
		if (o != null || path.endsWith("/jwManager/")
				|| path.endsWith("LoginServlet")
				|| path.endsWith("SelectNewsMainDetail")
				|| path.endsWith("login.jsp") || path.endsWith("SelectNewsMainKind")
				|| path.endsWith("SelectNewsMainKind1")|| path.endsWith("DownloadNews")
				|| path.endsWith(".gif") || path.endsWith(".css")
				|| path.endsWith(".js") || path.endsWith(".jpg")) {
			// ����
			chain.doFilter(request, response);
		} else {
			request.setAttribute("msg", "please login!!!");
			request.getRequestDispatcher("SelectNewsMainPage")
					.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
