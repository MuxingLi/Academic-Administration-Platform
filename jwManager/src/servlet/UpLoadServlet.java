package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
//import org.apache.tomcat.util.http.fileupload.FileItem;

import org.apache.commons.fileupload.FileItem;

import dao.StudentDao;

@SuppressWarnings("deprecation")
public class UpLoadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UpLoadServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	  	response.setContentType("text/html;charset=UTF-8");
	  	String id=null;
	  	String name=null;
	  	PrintWriter out = response.getWriter();
	  	String filename;
	  	String filepath;
	  	filepath=null;
	  	StudentDao sd=new StudentDao();
		filepath=this.getServletContext().getRealPath("WEB-INF/upload");
		File file=new File(filepath);
		if(!file.exists()&&!file.isDirectory())
		{
			file.mkdir();
		}
	  	try{
	  		DiskFileUpload fu=new DiskFileUpload();
	  		fu.setSizeMax(10485760);//允许文件最大字节数
	  		fu.setSizeThreshold(4096);//内存空间
	  		fu.setRepositoryPath("F:\\java\\workspace\\jwManager\\WebRoot\\WEB-INF\\upload");//超过内存
	  		@SuppressWarnings("rawtypes")
			List fileItems=fu.parseRequest(request);
	  		@SuppressWarnings("rawtypes")
			Iterator iter=fileItems.iterator();
	  		while(iter.hasNext())
	  		{
	  			FileItem item=(FileItem)iter.next();
	  			if(item.isFormField())
	  			{
	  				if(item.getFieldName().equalsIgnoreCase("id"))
	  				{
	  					id=item.getString();
	  				}
	  				if(item.getFieldName().equalsIgnoreCase("name"))
	  				{
	  					name=item.getString();
	  				}
	  			}
	  			else
	  			{
	  				String name1=item.getName();
	  				long size=item.getSize();
	  				if((name1==null||name1.equals(""))&&size==0)
	  				{
	  					continue;
	  				}
	  				filename=item.getName();
	  				filename = filename.substring(filename.lastIndexOf("\\")+1);
	  				filename=id+"-"+filename;
	  				String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
	  				if(fileExtName.equalsIgnoreCase("xlsx"))
	  				{ 
	  						item.write(new File(filepath+"//"+filename));
				  			out.println("<script language=javascript>");
							out.println("alert('上传文件成功');");
							out.println("</script>");
							if(sd.insertDB(id, filename, filepath)>0)
							{
								out.println("<script language=javascript>");
								out.println("alert('插入数据库成功');");
								out.println("</script>");
								response.sendRedirect("SelectAllStudentsServlet");
							}
							else{
								out.println("<script language=javascript>");
								out.println("alert('插入数据库失败');");
								out.println("window.location.href='insertStu.jsp'");
								out.println("</script>");
							}
							out.flush();
							out.close();
	  				}
	  				else{
	  					out.println("<script language=javascript>");
						out.println("alert('文件类型错误');");
						out.println("window.location.href='insertStu.jsp'");
						out.println("</script>");
						out.flush();
						out.close();
	  				}
	  			}	  			
	  		}
	  		
	  	}
	  	catch(Exception ex)
	  	{
	  		out.println("<script language=javascript>");
			out.println("alert('上传文件失败');");
			out.println("window.location.href='insertStu.jsp'");
			out.println("</script>");
			out.flush();
			out.close();
			ex.printStackTrace();
	  	
	  	}
	  	
	}

}
