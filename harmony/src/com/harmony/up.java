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
 * Servlet implementation class up
 */
@WebServlet("/up")
public class up extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public up() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(1111);
		System.out.println(request.getParameter("tit"));
		System.out.println(request.getParameter("des"));
		int a=Integer.parseInt(request.getParameter("reg"));
		String e=request.getParameter("email");
		System.out.println(a);
		System.out.println(e);
		Registration r;
		RegistrationDao re=new RegistrationDaoImpl();
		r=re.getemail(e);
		PaperUplode p;
		PaperUplodeDao pd=new PaperUplodeDaoImpl();
		p=pd.get(a);
		HttpSession session=request.getSession();
		if(r==null)
		{
		 
			session.setAttribute("messa","This email id is not registerde");
			response.sendRedirect("uploadApproval.jsp");
		}
		else
		{
		   if(r.getRegister_id()!=a)
		   {
				  
				session.setAttribute("messa","Register no not valid");
				response.sendRedirect("uploadApproval.jsp");
		   }
		   else 
		   {
			   if(p==null)
				{
				   System.out.println(155);
				 p=new PaperUplode();
				 p.setRegister_id(a);
				 p.setTitle(request.getParameter("tit"));
				 
				 p.setName(r.getName());	
				 p.setDescription(request.getParameter("des"));	
				 pd.SaveorUpdate(p);
				 response.sendRedirect("uploadApproval2.jsp");
				 session.setAttribute("pu", p);   
				}
				else if(p.getLocation()==null)
				{
					response.sendRedirect("uploadApproval2.jsp");
					session.setAttribute("pu", p);	
				}
				else
				{
					session.setAttribute("messa","This email id is not registerde");
					response.sendRedirect("uploadApproval2.jsp");    	
				} 
		   }
		}
		
	}

}
