package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import common.Decode;
import dao.NewsDao;
import dto.News;


public class InsertNewsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public InsertNewsServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();	
//		form: enctype="multipart/form-data" ;
		request.setCharacterEncoding("utf-8");  //设置编码            
        //获得磁盘文件条目工厂  
		DiskFileItemFactory factory = new DiskFileItemFactory();  
        //高水平的API文件上传处理  
        ServletFileUpload upload = new ServletFileUpload(factory); 
        upload.setHeaderEncoding("UTF-8");
        
		String ntitle=null;
		String nauthor=null;
		String ntype=null;
		String ncontent=null;
		String ntime=null;		
		String nfake=null;
		String nfile1=null;
		
		factory.setSizeThreshold(5*1024*1024) ;     
        try {  
            //可以上传多个文件  
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);  
            for(FileItem item : list)  
            {  
                //获取表单的属性名字  
                String name = item.getFieldName();  
                //获取原始文件名
                String nfile=item.getName();
                //如果获取的 表单信息是普通的 文本 信息  
                if(item.isFormField())  
                {                     
                    //获取用户具体输入的字符串 
                    String content = item.getString() ;   
                    content=Decode.decode(content);
                    //request.setAttribute(name, content);  
                    if(name.equals("ntitle")){
                    	ntitle=content;
                    }else if(name.equals("nauthor")){
                    	nauthor=content;
                    }else if(name.equals("ntype")){
                    	ntype=content;   
                    }else if(name.equals("ncontent")){
                    	ncontent=content;
                    }else if(name.equals("ntime")){
                    	ntime=content;
                    }
                }  
                //对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些  
                else  if(item.getSize()>0)
                {  
                	//获取文件需要上传到的绝对路径  
        	        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");   
                  //  if(suffixList.contains(suffix)){}			//限制上传的格式
        	        //获取后缀名
        	        String suffix=nfile.substring(nfile.lastIndexOf("."));
        	        //相对路径(真实路径)
        	        String relativePath=UUID.randomUUID().toString()+suffix;
        	         nfake=relativePath;				//存入数据库的属性名
        	         nfile1=nfile;
        	        File file=new File(realPath,relativePath);
        	        //写入硬盘
        	        item.write(file);
                }                	
            }
        NewsDao dao =  new NewsDao();
        News n = new News();
        n.setNtitle(ntitle);
        n.setNauthor(nauthor);
        n.setNtype(ntype);
        n.setNcontent(ncontent);
        n.setNtime(ntime);
        n.setNfile(nfile1);
        n.setNfake(nfake);
		int i=dao.insertNews(n);
		if(i>0){
			out.println("<script language=javascript>");
			out.println("alert('发布公告成功');");
			out.println("window.location.href='SelectAllNewsServlet'");
			out.println("</script>");
		}else{
			out.println("<script language=javascript>");
			out.println("alert('发布公告失败');");
			out.println("window.location.href='insertNews.jsp'");
			out.println("</script>");
		}
		out.flush();
		out.close();
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
           if(e instanceof FileUploadBase.FileSizeLimitExceededException){
        	   response.setContentType("text/html;charset=UTF-8");
        	   response.getWriter().write("请上传5M以内文件"); 	        	   
           }else{	        	
        	   System.out.println(e);
           }
        }
	}

}
