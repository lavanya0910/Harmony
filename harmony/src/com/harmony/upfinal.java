package com.harmony;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.PaperUplode;
import model.Registration;
import service.PaperUplodeDao;
import service.PaperUplodeDaoImpl;

/**
 * Servlet implementation class upfinal
 */
@WebServlet("/upfinal")
public class upfinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public upfinal() {
        super();
    }

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 150 * 5024;
    private int maxMemSize = 200 * 5024;
    private File file ;
    private String temp;
    public void init( ){
       // Get the file location where it would be stored.
       filePath = getServletContext().getInitParameter("file-upload2"); 
       temp=getServletContext().getInitParameter("temp");
     		  
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, java.io.IOException {
    System.out.println(11111);
       // Check that we have a file upload request
       isMultipart = ServletFileUpload.isMultipartContent(request);
       response.setContentType("text/html");
       java.io.PrintWriter out = response.getWriter( );
    
       if( !isMultipart ) {
          out.println("<html>");
          out.println("<head>");
          out.println("<title>Servlet upload</title>");  
          out.println("</head>");
          out.println("<body>");
          out.println("<p>No file uploaded</p>"); 
          out.println("</body>");
          out.println("</html>");
          return;
       }
   
       DiskFileItemFactory factory = new DiskFileItemFactory();
    
       // maximum size that will be stored in memory
       factory.setSizeThreshold(maxMemSize);
    
       // Location to save data that is larger than maxMemSize.
       factory.setRepository(new File(temp));

       // Create a new file upload handler
       ServletFileUpload upload = new ServletFileUpload(factory);
    
       // maximum file size to be uploaded.
       upload.setSizeMax( maxFileSize );

       try { 
          // Parse the request to get file items.
          List fileItems = upload.parseRequest(request);
 	
          // Process the uploaded file items
          Iterator i = fileItems.iterator();

          out.println("<html>");
          out.println("<head>");
          out.println("<title>Servlet upload</title>");  
          out.println("</head>");
          out.println("<body>");
          
          PaperUplodeDao pd=new PaperUplodeDaoImpl();
          HttpSession session=request.getSession();  
          PaperUplode p=(PaperUplode)session.getAttribute("pu");
          
          while ( i.hasNext () ) {
             FileItem fi = (FileItem)i.next();
             if ( !fi.isFormField () ) {
                // Get the uploaded file parameters
                String fieldName = fi.getFieldName();
                String fileName =fi.getName();
                String contentType = ".pdf";
                boolean isInMemory = fi.isInMemory();
                long sizeInBytes = fi.getSize();
             
                // Write the file
                if( fileName.lastIndexOf("\\") >= 0 ) {
                   file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
                   p.setFilename(fileName);
                   p.setLocation(filePath+file.getName());
                } else {
                   file = new File( filePath +p.getRegister_id()+" "+fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                   p.setFilename(fileName);
                   p.setLocation(filePath+file.getName());
                }
                fi.write( file ) ;
                out.println("Uploaded Filename: " + fileName + "<br>");
                p.setStatus("Approve");
                p.setFilename(fileName);
                pd.SaveorUpdate(p);
                session.setAttribute("message2", "We Have Successfuly Recived Your Paper");
                response.sendRedirect("uploadApproval.jsp");
             }
             
             
             
          }
          } catch(Exception ex) {
             System.out.println(ex);
          }
       }
       
       public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, java.io.IOException {

          throw new ServletException("GET method used with " +
             getClass( ).getName( )+": POST method required.");
       }
    }
