package com.gerardo.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gerardo.web.models.Game;

/**
 * Servlet implementation class Guess
 */
@WebServlet("/guess")
public class Guess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guess() {
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
		Game game = (Game) session.getAttribute("game");
		int numberGuess = Integer.parseInt( request.getParameter("numberGuess") );
		
		if ( numberGuess == game.getRandomNumber()) {
			session.setAttribute("result", 0);
		} else if (numberGuess < game.getRandomNumber()) {
			session.setAttribute("result", -1);
		} else {
			session.setAttribute("result", 1);
		}
		
		response.sendRedirect("/NumberGame/");
	}

}
