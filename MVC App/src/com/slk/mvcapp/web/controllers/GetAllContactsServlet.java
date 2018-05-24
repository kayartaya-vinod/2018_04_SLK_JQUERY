package com.slk.mvcapp.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.mvcapp.dao.ContactsDao;
import com.slk.mvcapp.dao.DaoException;
import com.slk.mvcapp.dao.DaoFactory;
import com.slk.mvcapp.entity.Contact;

public class GetAllContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			// get request parameters and other info like cookies, headers
			
			// talk to the model and get the data
			ContactsDao dao = DaoFactory.getContactsDao("jdbc");
			List<Contact> list = dao.getAllContacts();
			
			// store the data in a common location (scope)
			request.setAttribute("contacts", list);
			
			// goto the view
			String view = "/WEB-INF/views/contact-list.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}
