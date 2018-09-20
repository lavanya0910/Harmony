package com.harmony;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Registration;
import service.RegistrationDao;
import service.RegistrationDaoImpl;


@WebServlet("/Getnumber")
public class Getnumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getnumber() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println(111111+" "+request.getParameter("email") );
		Registration reg;
		RegistrationDao regi=new RegistrationDaoImpl();
		reg=regi.getemail(request.getParameter("email"));
		
		if(reg==null)
		{
			
			response.getOutputStream().print("Sorry Not Register");
		}
		else
		{
			response.getOutputStream().print(reg.getRegister_id());
			
		}
		System.out.println(reg.getRegister_id());
		
		
	}

}
