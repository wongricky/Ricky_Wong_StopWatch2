package com.stopwatch.web.controllers;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
		
		// Current Time
		if(session.getAttribute("start") == null || session.getAttribute("start").equals(0)) {
			session.setAttribute("current", 0);
		}
		else {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalTime now = LocalTime.now();
			String currentTime = dtf.format(now);
			System.out.println(currentTime + " This is printing from HOME...");
			session.setAttribute("current", currentTime);
		}
		
		System.out.println("This is the current time" + session.getAttribute("current"));
		
		
		// Start time
		LocalTime start = null;
		if(session.getAttribute("start") == null || session.getAttribute("start").equals(0)) {
			session.setAttribute("start", 0);
		}
		else {
			start = LocalTime.parse((CharSequence) session.getAttribute("start"));
		}
		System.out.println("this is the session: " + session.getAttribute("start"));
        System.out.println("this is start: " + start);
        
        // Stop time
        LocalTime current = LocalTime.parse((CharSequence) session.getAttribute("current"));
        System.out.println(current);
        if (current.isAfter(start)) { 
            session.setAttribute("runTime",(Duration.between(start, current).getSeconds()));
        } else {
            response.getWriter().print("End time " + session.getAttribute("current") + " was before start time " + session.getAttribute("start"));
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
