package com.harmony;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Registration;
import service.RegistrationDao;
import service.RegistrationDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String us=request.getParameter("use");
		String pass=request.getParameter("pass");
		System.out.println(us+" "+pass);
		 HttpSession session=request.getSession();  
		if(us.equals("harmony2019@christuniversity.in") && pass.equals("christ"))
		{
		     session.setAttribute("uname","Addmin");
		     response.sendRedirect("dashboard.jsp");
			
		}
		else if(!us.equals("harmony2019@christuniversity.in"))
		{
			
			 Registration r;
			 RegistrationDao rd=new RegistrationDaoImpl();
			 r=rd.getemail(us);
			 String otp=(String)session.getAttribute("otp");
			 System.out.println("otp = "+otp);
			 if(otp.equals(pass))
			 {
		     session.setAttribute("uname","user");
		     session.setAttribute("p",r);
		     response.sendRedirect("dashboard2.jsp");
			 }
			 else
			 {session.setAttribute("mess","Invalid Otp or Email");
			     response.sendRedirect("login.jsp");
			 }
		}
		else
		{
		     session.setAttribute("mess","Invalid password or Email");
		     response.sendRedirect("login.jsp");
		}
		
		
		
	}

}
