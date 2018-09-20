package com.harmony;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PaperUplode;
import service.PaperUplodeDao;
import service.PaperUplodeDaoImpl;
/**
 * Servlet implementation class DownloadFileServlet
 */
@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends javax.servlet.http.HttpServlet implements
javax.servlet.Servlet  {
	
    public DownloadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
        static final long serialVersionUID = 1L;
        private static final int BUFSIZE = 5096;
        String filePath;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getParameter("reg"));
		PaperUplodeDao pd=new PaperUplodeDaoImpl();
		PaperUplode p=pd.get(Integer.parseInt(request.getParameter("reg")));
        System.out.println(p.getLocation());
        
 		filePath =p.getLocation();
      
 		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String filename =p.getFilename(); 
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ filename + "\"");
		FileInputStream fileInputStream = new FileInputStream(p.getLocation());
		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
		
		
		
      response.sendRedirect("approval.jsp");
	}


}
