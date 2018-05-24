package com.slk.mvcapp.dao;

import com.slk.mvcapp.dao.impl.ContactsDaoJdbcImpl;

public final class DaoFactory {
	private DaoFactory() {
	}

	public static ContactsDao getContactsDao(String type) throws DaoException {
		switch (type) {
		case "jdbc":
			return new ContactsDaoJdbcImpl();
		default:
			throw new DaoException("No ContactsDao implementation for type: " + type);
		}
	}
}
