package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import common.Decode;

public class DownloadNews extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DownloadNews() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String nfake=request.getParameter("nfake");
	       nfake=Decode.decode(nfake);

	     //获取文件需要上传到的绝对路径  
	        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");
	        File file=new File(realPath,nfake);
	
	        if(!file.exists()){
	        	response.setContentType("text/html;charset=UTF-8"); 
	        	response.getWriter().write("文件不存在"); 
	        	return;
	        }
	   
	        response.addHeader("content-disposition", "attachment;filename="+nfake);
	        IOUtils.copy(new FileInputStream(file), response.getOutputStream());
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
