package com.gerardo.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import java.util.Date;

/**
 * Servlet implementation class RandomWord
 */
@WebServlet("/generate")
public class RandomWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomWord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Random random = new Random();
		DateFormat df = new SimpleDateFormat("yyy/MM/dd - HH:mm:ss");
		Date dateobj = new Date();
		
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String randomWord = "";
		
		//generates a 10 character random string using the abc string declared above and a random index for it
		for (byte i=0; i<10; i++) {
			int randomIndex = random.nextInt(35);
			randomWord += abc.charAt(randomIndex);
		}
		
		if (session.getAttribute("prevDate") == null || session.getAttribute ("date") == null) {
			session.setAttribute("prevDate", df.format(dateobj));
			session.setAttribute("date", df.format(dateobj));
			request.setAttribute("randomWord", randomWord);
			session.setAttribute("count", (Integer) session.getAttribute("count")+1);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Show.jsp");
			view.forward(request, response);
		} else {
			session.setAttribute("date", df.format(dateobj));
			session.setAttribute("prevDate", session.getAttribute("date"));
			request.setAttribute("randomWord", randomWord);
			session.setAttribute("count", (Integer) session.getAttribute("count")+1);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Show.jsp");
			view.forward(request, response);
			
		}
		
	}

}
