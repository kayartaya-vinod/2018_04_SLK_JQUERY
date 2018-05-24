package com.slk.mvcapp.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.mvcapp.dao.ContactsDao;
import com.slk.mvcapp.dao.DaoFactory;
import com.slk.mvcapp.entity.Contact;

public class EditContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String input = request.getParameter("id");
			Integer id = new Integer(input);

			ContactsDao dao = DaoFactory.getContactsDao("jdbc");
			Contact c = dao.getContactById(id);

			request.setAttribute("contact", c);
			request.getRequestDispatcher("/WEB-INF/views/contact-form.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
