package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Decode;
import dao.StudentDao;
import dao.TeacherDao;
import dao.UserDao;
import dto.Student;
import dto.Teacher;
import dto.User;

public class UpdateUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UpdateUserServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		name=Decode.decode(name);
		String oldpassword=request.getParameter("oldpassword");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");	
		String role=request.getParameter("role");
		
		role=Decode.decode(role);
		
		UserDao dao = new UserDao();
		User user = new User();
		StudentDao sdao  =new StudentDao();
		Student users = new Student();
		TeacherDao tdao = new TeacherDao();
		Teacher usert = new Teacher();			
		user.setRole(role);	
			
		if("管理员".equals(role)){
				user.setId(name);
				User user1 = dao.login(user);
				if(!oldpassword.equals(user1.getPassword())){
					out.println("<script language=javascript>");				
					out.println("alert('密码输入错误');");	
					out.println("window.location='insertCourse.jsp'");

					out.println("window.location='updatepwd.jsp'");
					out.println("</script>");
				}else{
					if(!confirmpassword.equals(password)){
						out.println("<script language=javascript>");				
						out.println("alert('两次密码不一致');");	
						out.println("window.location='updatepwd.jsp'");
						out.println("</script>");
					}else{			
						user.setPassword(password);		
						int i=dao.updateUser(user);
						if(i==0){
							out.println("<script language=javascript>");				
							out.println("alert('更改失败');");	
							out.println("window.location='updatepwd.jsp'");
							out.println("</script>");
						}else{
							out.println("<script language=javascript>");				
							out.println("alert('更改成功');");	
							out.println("window.parent.location='login.jsp'");
							out.println("</script>");
						}	
					}
			}
		}else if ("学生".equals(role)) {
			users.setId(name);
			users.setPassword(password);
			Student users1= sdao.login(users);
			if(!oldpassword.equals(users1.getPassword())){
				out.println("<script language=javascript>");				
				out.println("alert('密码输入错误');");	
				out.println("window.location='updatepwd.jsp'");
				out.println("</script>");
			}else{
				if(!confirmpassword.equals(password)){
					out.println("<script language=javascript>");				
					out.println("alert('两次密码不一致');");	
					out.println("window.location='updatepwd.jsp'");
					out.println("</script>");
				}else{
					int i=sdao.updateStudentpwd(users);
					if(i==0){
						out.println("<script language=javascript>");				
						out.println("alert('更改失败');");	
						out.println("window.location='updatepwd.jsp'");
						out.println("</script>");
					}else{
						out.println("<script language=javascript>");				
						out.println("alert('更改成功');");	
						out.println("window.parent.location='login.jsp'");
						out.println("</script>");					}	
				}
			}
		}else if ("教师".equals(role)) {
			usert.setId(name);
			usert.setPassword(password);
			Teacher usert1= tdao.login(usert);
			if(!oldpassword.equals(usert1.getPassword())){
				out.println("<script language=javascript>");				
				out.println("alert('密码输入错误');");	
				out.println("window.location='updatepwd.jsp'");
				out.println("</script>");
			}else{
				if(!confirmpassword.equals(password)){
					out.println("<script language=javascript>");				
					out.println("alert('两次密码不一致');");	
					out.println("window.location='updatepwd.jsp'");
					out.println("</script>");
				}else{
					int i=tdao.updateTeacherpwd(usert);
					if(i==0){
						out.println("<script language=javascript>");				
						out.println("alert('更改失败');");	
						out.println("window.location='updatepwd.jsp'");
						out.println("</script>");
					}else{
						out.println("<script language=javascript>");				
						out.println("alert('更改成功');");	
						out.println("window.parent.location='login.jsp'");
						out.println("</script>");	
					}	
				}
			}
		}
		out.flush();
		out.close();
	}
}

