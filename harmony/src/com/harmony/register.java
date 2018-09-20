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

import mail.EmailUtility;
import model.Registration;
import service.RegistrationDao;
import service.RegistrationDaoImpl;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
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

	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(123);
		int couunt = 0, f = 0;

		PrintWriter out = response.getWriter();
		RegistrationDao registrationDao = new RegistrationDaoImpl();
		Registration res = new Registration();

		res.setName(request.getParameter("name"));
		res.setSex(request.getParameter("sex"));
		res.setAddress(request.getParameter("adress"));
		res.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
		res.setCounter(request.getParameter("country"));
		res.setEmail(request.getParameter("email"));
		res.setInstitution(request.getParameter("university"));
		// Bank Information
		System.out.println(request.getParameter("bankname"));
		res.setBankName(request.getParameter("bankname"));
		
		res.setCurren(request.getParameter("currency"));
		res.setAmount(Double.parseDouble(request.getParameter("amount")));
		res.setTranssactionalrefno(request.getParameter("transsactionalrefno"));
		res.setDateoftrans(request.getParameter("dateof"));
		res.setRemark(request.getParameter("remark"));

		for (Registration r : registrationDao.Li()) {
			if (res.getRegister_id() == r.getRegister_id()) {
				res.setRegister_id(r.getRegister_id() + 1);
			} else if (res.getEmail() == r.getEmail()) {
				f++;
			}
		}
		

		if (f == 0) {
			if (registrationDao.SaveorUpdate(res)) {
				HttpSession session = request.getSession();
				session.setAttribute("r", res);
				try {
					EmailUtility.sendEmail(host,port,user,pass,res.getEmail(),
				            "Acknowledgement",ccadd,res);
		             System.out.println("The e-mail was sent successfully"); 

				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("mess","You have successfully registered");
				response.sendRedirect("register.jsp");
			} else {
				out.print("Sorry");
			}
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("mess", "This email Id Is All Ready Register");
			response.sendRedirect("register.jsp");
		}

	}

}
