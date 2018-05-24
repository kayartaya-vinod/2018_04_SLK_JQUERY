package com.slk.mvcapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slk.mvcapp.dao.ContactsDao;
import com.slk.mvcapp.dao.DaoException;
import com.slk.mvcapp.entity.Contact;
import com.slk.mvcapp.util.DbUtil;

public class ContactsDaoJdbcImpl implements ContactsDao {

	@Override
	public void addContact(Contact contact) throws DaoException {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			String sql = "insert into contacts values (null, ?, ?, ?, ?)";
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getPhone());
			stmt.setString(4, contact.getCity());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, null);
		}
	}

	@Override
	public List<Contact> getAllContacts() throws DaoException {
		List<Contact> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from contacts;";
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Contact c = resultSetToContact(rs);
				list.add(c);
			}

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, null);
		}
		return list;
	}

	Contact resultSetToContact(ResultSet rs) throws SQLException {
		Contact c = new Contact();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setPhone(rs.getString("phone"));
		c.setCity(rs.getString("city"));
		return c;
	}

	@Override
	public Contact getContactById(Integer id) throws DaoException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from contacts where id = ?";
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return resultSetToContact(rs);
			}

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			DbUtil.releaseResources(conn, stmt, null);
		}
		return null;
	}

}
