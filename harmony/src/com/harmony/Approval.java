package com.harmony;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PaperUplode;
import service.PaperUplodeDao;
import service.PaperUplodeDaoImpl;

/**
 * Servlet implementation class Approval
 */
@WebServlet("/Approval")
public class Approval extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public Approval() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(11111111l);
		String filePath;
		PaperUplode p;
		filePath = getServletContext().getInitParameter("file-upload2");
		PaperUplodeDao pd = new PaperUplodeDaoImpl();
		p = pd.get(Integer.parseInt(request.getParameter("reg")));
		// String fileNameWithOutExt = FilenameUtils.removeExtension(source.getName());
		File source = new File(p.getLocation());
		File dest = new File(filePath);
		System.out.println(source.getName());
		Path temp = Files.move(Paths.get(p.getLocation()), Paths.get(filePath + source.getName()));

		if (temp != null) {
			System.out.println("File renamed and moved successfully");
		} else {
			System.out.println("Failed to move the file");
		}
		p.setStatus("Approve");
		p.setFilename(source.getName());

		p.setLocation(filePath + source.getName());
		pd.SaveorUpdate(p);
		response.sendRedirect("approval.jsp");

	}

}
