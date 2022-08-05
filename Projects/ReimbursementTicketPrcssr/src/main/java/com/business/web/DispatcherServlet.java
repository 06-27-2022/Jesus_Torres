package com.business.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.model.reimbursementticket;
import com.business.model.userprofiles;
import com.business.repository.reimbursementticketRepository;
import com.business.repository.reimbursementticketRepositoryImpl;
import com.business.repository.userprofileRepositoryImpl;
import com.business.repository.userprofilesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DispatcherServlet extends HttpServlet{

	/**
	 * This servlet manages all 
	 */
	private static final long serialVersionUID = 4472791272157180834L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//creating all the things will be used throughout the switch.
		String resource = request.getRequestURI();
		
		userprofilesRepository userhldr = new userprofileRepositoryImpl();
		String isolatedResource = resource.replace("/ReimbursementTicketPrcssr/api", "");
		PrintWriter writer = response.getWriter();
		userprofiles loggedInUser = null;
		Cookie[] cookieJar = request.getCookies();
		boolean goldenckStatus = false;
		boolean basicckStatus = false;
		if(cookieJar != null) {
			for(Cookie cookie : cookieJar) {
				if(cookie.getName().equals("vip")) {
				goldenckStatus = true;
				}
				if(cookie.getName().equals("authenticated")) {
				basicckStatus = true;
				}
			}
		}
		
		switch(isolatedResource) {
		//user management URI
		case "/usergate":	
			response.setContentType("text/html");
			String usernameIN = request.getParameter("username");
			String passwordIN = request.getParameter("password");
			userprofiles usernameSearch = userhldr.findbyUserName(usernameIN);
			//user profile creation
			userprofiles newUser = new userprofiles();
			//successful user creation
			if(usernameSearch == null) {
				newUser = new userprofiles(usernameIN,passwordIN);
				writer.write("New User Created.");
				userhldr.newprofile(newUser);
				Cookie basicCookie = new Cookie("authenticated","true");
				loggedInUser = userhldr.findbyUserName(usernameIN);
				response.addCookie(basicCookie);
				response.setStatus(201);
				//failed user creation because of already used username.
			}else {
				writer.write("Username already exists. Please try another Username");
				response.setStatus(202);
			}
			
			break;
		//ticket management view and editor URI	
		case "/ticketmngr/view":
			reimbursementticketRepository tickethldr = new reimbursementticketRepositoryImpl();
			if(goldenckStatus){
				reimbursementticket ticketSearch = null;
				int idIN = Integer.parseInt(request.getParameter("ticket_id"));
				String approvalstatusIN = request.getParameter("approvalstatus");
				ticketSearch=tickethldr.findbyticketID(idIN);
				if(ticketSearch == null) {
					response.setContentType("text/html");
					writer.write("The ticket you tried to edit does not exist");
					response.setStatus(401);
				}else if(ticketSearch.getApprovalStatus().equals("PENDING") == false) {
					response.setContentType("text/html");
					writer.write("The ticket you tried to edit is not eligible for APPROVAL or DENIAL");
					response.setStatus(401);
				}else if(approvalstatusIN.equals("APPROVED") || approvalstatusIN.equals("DENIED")) {
					response.setContentType("text/html");
					tickethldr.editTicketstatusbyId(idIN, approvalstatusIN);
					writer.write("Ticket number " + idIN + " has been " + approvalstatusIN +".");
					response.setStatus(201);
				}else {
					response.setContentType("text/html");
					writer.write("The approval status you tried to set for the ticket is invalid");
					response.setStatus(401);
				}
			}else {
				response.setContentType("text/html");
				writer.write("You are not logged in.");
				response.setStatus(401);
			}
			break;
		case "/ticketmngr/add":
			reimbursementticketRepository tickethldr2 = new reimbursementticketRepositoryImpl();
			if(basicckStatus){
				double ammountIN = Double.parseDouble(request.getParameter("ammount"));
				String descriptionIN = request.getParameter("description");
				reimbursementticket newticket = new reimbursementticket(ammountIN, descriptionIN);
				tickethldr2.newTicket(newticket);
				response.setContentType("text/html");
				writer.write("New ticket created for '" + descriptionIN + "'.");
				response.setStatus(201);
			}else {
				response.setContentType("text/html");
				writer.write("You are not logged in.");
				response.setStatus(401);
			}
			break;
		default:
			response.setStatus(404);
			break;
		
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//creating all the things will be used throughout the switch.
		String resource = request.getRequestURI();
		
		userprofilesRepository userhldr = new userprofileRepositoryImpl();
		String isolatedResource = resource.replace("/ReimbursementTicketPrcssr/api", "");
		PrintWriter writer = response.getWriter();
		userprofiles loggedInUser = null;
		
		Cookie[] cookieJar = request.getCookies();
		boolean goldenckStatus = false;
		if(cookieJar != null) {
			for(Cookie cookie : cookieJar) {
				if(cookie.getName().equals("vip")) {
				goldenckStatus = true;
				}
			}
		}
		
		switch(isolatedResource) {
		//user management URI
		case "/usergate":	
			response.setContentType("text/html");
			String usernameIN = request.getParameter("username");
			String passwordIN = request.getParameter("password");
			userprofiles usernameSearch = userhldr.findbyUserName(usernameIN);
			
			//some error in the input for user login
			if(usernameSearch == null) {
				writer.write("You username is not in our database.");
				response.setStatus(401);
			}else if(userhldr.checkPassword(usernameIN, passwordIN) == false){
				writer.write("The password or username gave is incorrect");
				response.setStatus(401);
				//successful user login
			}else {
				loggedInUser = userhldr.findbyUserName(usernameIN);
				writer.write("Logged In Succesfully");
				Cookie basicCookie = new Cookie("authenticated","true");
				response.addCookie(basicCookie);
				if(loggedInUser.getManager_status() == true) {
					Cookie goldenCookie = new Cookie("vip", "true");
					response.addCookie(goldenCookie);
				}
				response.setStatus(202);
			}
			
			break;
		//ticket management view and editor URI	
		case "/ticketmngr/view":
			reimbursementticketRepository tickethldr = new reimbursementticketRepositoryImpl();
			if(goldenckStatus) {
				List<reimbursementticket> ticketRepo = tickethldr.findAllPendignRT();
				
				ObjectMapper imTheMap = new ObjectMapper();
				String json = imTheMap.writeValueAsString(ticketRepo);
				
				response.setContentType("application/json");
				response.setStatus(200);
				writer.write(json);
			}else {
				response.setContentType("text/html");
				writer.write("You are not logged in.");
				response.setStatus(401);
			}
			break;
		case "/ticketmngr/add":
			response.setContentType("text/html");
			writer.write("You are not logged in.");
			response.setStatus(401);
			break;
		default:
			response.setStatus(404);
			break;
		
		}
	}	
}
