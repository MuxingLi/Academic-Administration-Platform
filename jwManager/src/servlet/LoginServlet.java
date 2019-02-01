package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Decode;
import dao.UserDao;
import dto.User;
import dao.StudentDao;
import dto.Student;
import dao.TeacherDao;
import dto.Teacher;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		name = Decode.decode(name);
		String password = request.getParameter("password");
		password = Decode.decode(password);
		String role= request.getParameter("role");
		role=Decode.decode(role);
		
		UserDao dao = new UserDao();
		User user = new User();	
		StudentDao sdao  =new StudentDao();
		Student users = new Student();		
		TeacherDao tdao = new TeacherDao();
		Teacher usert = new Teacher();	

		user.setRole(role);
		if ("管理员".equals(user.getRole())) {
			user.setId(name);
			user.setPassword(password);
			User user1 = dao.login(user);
			if (user1 == null) {
				out.println("<script language=javascript>");				
				out.println("alert('用户名错误');");	
				out.println("window.location.href='login.jsp'");
				out.println("</script>");
			} else if (!user1.getPassword().equals(user.getPassword())) {
				out.println("<script language=javascript>");				
				out.println("alert('密码错误');");	
				out.println("window.location.href='login.jsp'");
				out.println("</script>");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", user1);
				out.println("<script language=javascript>");
				out.println("window.location.href='main.jsp'");
				out.println("</script>");
			}
		} else if ("学生".equals(user.getRole())) {
			users.setId(name);
			users.setPassword(password);		
			Student users1 = sdao.login(users);
			if(users1==null){
				out.println("<script language=javascript>");				
				out.println("alert('用户名错误');");	
				out.println("window.location.href='login.jsp'");
				out.println("</script>");
			} else if (!users1.getPassword().equals(users.getPassword())) {
				out.println("<script language=javascript>");				
				out.println("alert('密码错误');");	
				out.println("window.location.href='login.jsp'");
				out.println("</script>");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", users1);
				out.println("<script language=javascript>");
				out.println("window.location.href='main.jsp'");
				out.println("</script>");
			}
		} else if("教师".equals(user.getRole())){
			usert.setId(name);
			usert.setPassword(password);
			Teacher usert1 = tdao.login(usert);
			if (usert1 == null) {
				out.println("<script language=javascript>");				
				out.println("alert('用户名错误');");	
				out.println("window.location.href='login.jsp'");
				out.println("</script>");
			} else if (!usert1.getPassword().equals(usert.getPassword())) {
				out.println("<script language=javascript>");				
				out.println("alert('密码错误');");	
				out.println("window.location.href='login.jsp'");
				out.println("</script>");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", usert1);
				out.println("<script language=javascript>");
				out.println("window.location.href='main.jsp'");
				out.println("</script>");
			}
		}
		out.flush();
		out.close();
	}
}
