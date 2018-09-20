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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(111111);
		PrintWriter out = response.getWriter();
		int us=Integer.parseInt(request.getParameter("search"));
		System.out.println(us);
		RegistrationDao registrationDao=new RegistrationDaoImpl();	
		Registration registration=registrationDao.get(us);
		 HttpSession session=request.getSession();
		if(registration==null)
		{
		  session.setAttribute("messs", "register number not found");
		  response.sendRedirect("dashboard.jsp");
		}
		else
		{
			session.setAttribute("message", registration);
			response.sendRedirect("search.jsp");
		}
	}

}
