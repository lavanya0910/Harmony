package com.harmony;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.SendOtp;
import model.Registration;
import service.RegistrationDao;
import service.RegistrationDaoImpl;
import utility.GenerateOTP;

/**
 * Servlet implementation class getotp
 */
@WebServlet("/getotp")
public class getotp extends HttpServlet {
	    
	private static final long serialVersionUID = 1L;

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
    public getotp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		GenerateOTP otp=new GenerateOTP();
		System.out.println(123);
		System.out.println(111111+" "+request.getParameter("email") );
		Registration reg;
		RegistrationDao regi=new RegistrationDaoImpl();
		reg=regi.getemail(request.getParameter("email"));
		
		if(reg==null)
		{
			
			
		}
		else
		{ 
			
			
			response.getOutputStream().print(reg.getRegister_id());
			HttpSession session=request.getSession();
			String o=otp.generateOTP();
			SendOtp mail=new SendOtp();
	        try {
	        	
				mail.sendEmail(host, port, user, pass, reg.getEmail(), "Otp", o);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        session.setAttribute("otp",o);
	        return ;
			
		}
		
		
	}
   
}
