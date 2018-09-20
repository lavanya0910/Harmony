package com.harmony;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PaperUplode;
import model.Registration;
import service.PaperUplodeDao;
import service.PaperUplodeDaoImpl;
import service.RegistrationDao;
import service.RegistrationDaoImpl;

/**
 * Servlet implementation class PaperUplode
 */
@WebServlet(name="/PaperUplodse",
urlPatterns={"/PaperUplodes"})
public class PaperUplodes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperUplodes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println(1111);
		System.out.println(request.getParameter("tit"));
		System.out.println(request.getParameter("des"));
		 HttpSession session=request.getSession();  
		 PaperUplode p=new PaperUplode();
		 PaperUplodeDao pp=new PaperUplodeDaoImpl(); 
		 Registration r=(Registration)session.getAttribute("p");
		 p.setDescription(request.getParameter("des"));
		 p.setName(r.getName());
		 p.setRegister_id(r.getRegister_id());
		 p.setTitle(request.getParameter("tit"));
		 pp.SaveorUpdate(p);
		 System.out.println(11111);
		 response.sendRedirect("uploadpaper.jsp");
	}

}
