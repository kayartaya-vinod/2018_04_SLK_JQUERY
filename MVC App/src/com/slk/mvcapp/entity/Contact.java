package com.slk.mvcapp.entity;

public class Contact {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String city = "Bangalore";

	// good practice
	public Contact() {
	}

	public Contact(String name, String email, String phone, String city) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
