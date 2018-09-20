package com.harmony;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.EmailUtility2;
import model.accummodate;
import service.accummodateDao;
import service.accummodateDaoImpl;

/**
 * Servlet implementation class Accummodate
 */
@WebServlet("/Accummodate")
public class Accummodate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accummodate() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	private String host;
	private String port;
	private String user;
	private String pass;
	private String ccadd;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
		ccadd=context.getInitParameter("ccadd");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		accummodateDao accummodateDao = new accummodateDaoImpl();
		accummodate res = new accummodate();
		System.out.println(request.getParameter("regnum"));
		if(Integer.parseInt(request.getParameter("regnum"))==0)
		{
			response.sendRedirect("accummodate.jsp");
			HttpSession session=request.getSession();  
		    session.setAttribute("mess","This EmailID is not registered with us. Use the same Email ID used during conference registartion");
		}
		else
		{
		res.setRegister_id(Integer.parseInt(request.getParameter("regnum")));
		res.setEmail(request.getParameter("email"));
//		res.setInstitution(request.getParameter("university"));
		// Bank Information
		res.setBankName(request.getParameter("bankname"));
		res.setCurren(request.getParameter("currency"));
		res.setAmount(Double.parseDouble(request.getParameter("amount")));
		res.setTranssactionalrefno(request.getParameter("transsactionalrefno"));
		res.setDateoftrans(request.getParameter("dateof"));
		if(accummodateDao.SaveorUpdate(res))
		{
			System.out.println("Done");
				try {
					EmailUtility2.sendEmail(host, port, user, pass, res.getEmail(), "Accnolegment", ccadd,res );
					 System.out.println("The e-mail was sent successfully");
					 
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.sendRedirect("accummodate.jsp");
				HttpSession session=request.getSession();  
			    session.setAttribute("mess","Thank you For Registaring For Accummodation");
			
	}

 }
 }
}