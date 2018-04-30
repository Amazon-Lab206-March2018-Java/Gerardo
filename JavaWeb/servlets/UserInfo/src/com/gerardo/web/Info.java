package com.gerardo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Info
 */
@WebServlet("/info")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (request.getParameter("firstName")!=null || request.getParameter("lastName")!= null) {
			out.write ("<h1> Welcome, "+request.getParameter("firstName")+" "+request.getParameter("lastName")+"</h1>");
		} else
			out.write ("<h1> Welcome, Unknown</h1>");
		if (request.getParameter("favLanguage")!=null) {
			out.write ("<h2> Your favorite language is: "+request.getParameter("favLanguage")+"</h2>");
		} else {
			out.write ("<h2> Your favorite language is: Unknown</h2>");
		}
		if (request.getParameter("homeTown")!= null) {
			out.write ("<h1> Your hometown is: "+request.getParameter("homeTown")+"</h1>");
		} else {
			out.write("<h3> Your hometown is: Unknown</h3>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
