package com.slk.mvcapp.dao;

import java.util.List;

import com.slk.mvcapp.entity.Contact;

public interface ContactsDao {

	// CRUD operations

	public void addContact(Contact contact) throws DaoException;
	public Contact getContactById(Integer id) throws DaoException;
	
	// QURIES

	public List<Contact> getAllContacts() throws DaoException;

	
}
