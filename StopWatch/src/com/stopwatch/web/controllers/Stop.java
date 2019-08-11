package com.stopwatch.web.controllers;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Stop
 */
@WebServlet("/Stop")
public class Stop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stop() {
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
		doGet(request, response);
		
		HttpSession session = request.getSession();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime now = LocalTime.now();

		String stopTime = dtf.format(now);
		System.out.println(stopTime + " This is printing from STOP...");
		
		
		session.setAttribute("stop", stopTime);
	
		LocalTime start = LocalTime.parse((CharSequence) session.getAttribute("start"));
        LocalTime stop = LocalTime.parse((CharSequence) session.getAttribute("stop"));
        System.out.println(stop);
        if (stop.isAfter(start)) { 
            session.setAttribute("runTime",(Duration.between(start, stop).getSeconds()));
        } else {
            response.getWriter().print("End time " + session.getAttribute("stop") + " was before start time " + session.getAttribute("start"));
        }
        
    		
    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/stop.jsp");
    	view.forward(request, response);
        
        




		
	}

}
