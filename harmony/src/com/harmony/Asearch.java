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
import model.accummodate;
import service.RegistrationDao;
import service.RegistrationDaoImpl;
import service.accummodateDao;
import service.accummodateDaoImpl;

/**
 * Servlet implementation class Asearch
 */
@WebServlet("/Asearch")
public class Asearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Asearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(111111);
		PrintWriter out = response.getWriter();
		String us=request.getParameter("search");
		System.out.println(us);
		accummodateDao accummodateDao=new accummodateDaoImpl();	
		accummodate accummodate=accummodateDao.get(us);
		 HttpSession session=request.getSession();
		if(accummodate==null)
		{
		  session.setAttribute("messs", "register number not found");
		  response.sendRedirect("accomodation.jsp");
		}
		else
		{
			session.setAttribute("message2",accummodate);
			response.sendRedirect("asearch.jsp");
		}
	}

}
