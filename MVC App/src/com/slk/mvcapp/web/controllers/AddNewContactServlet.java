package com.slk.mvcapp.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.mvcapp.dao.ContactsDao;
import com.slk.mvcapp.dao.DaoFactory;
import com.slk.mvcapp.entity.Contact;

public class AddNewContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/contact-form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// get request parameters and other info like cookies, headers
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		
		Contact c = new Contact(name, email, phone, city);

		try {
			
			
			// talk to the model and get the data
			ContactsDao dao = DaoFactory.getContactsDao("jdbc");
			dao.addContact(c);
			
			// store the data in a common location (scope)
			
			// goto the view (always do a clientside redirection after POST submission)
			response.sendRedirect("./get-all-contacts");
			

		} catch (Exception e) {
			request.setAttribute("contact", c);
			request.setAttribute("errMsg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/contact-form.jsp").forward(request, response);
		}
	}

}
