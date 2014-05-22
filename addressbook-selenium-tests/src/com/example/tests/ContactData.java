package com.example.tests;

public class ContactData {
	public String first_name;
	public String last_name;
	public String address;
	public String home_phone;
	public String mobile_phone;
	public String work_phone;
	public String email;
	public String email_2;
	public String birth_day;
	public String birth_month;
	public String birth_year;
	public String group;
	public String address_2;
	public String home_phone_2;

	public ContactData() {
		}

	public ContactData(String first_name, String last_name, String address,
			String home_phone, String mobile_phone, String work_phone,
			String email, String email_2, String birth_day, String birth_month,
			String birth_year, String group, String address_2,
			String home_phone_2) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.home_phone = home_phone;
		this.mobile_phone = mobile_phone;
		this.work_phone = work_phone;
		this.email = email;
		this.email_2 = email_2;
		this.birth_day = birth_day;
		this.birth_month = birth_month;
		this.birth_year = birth_year;
		this.group = group;
		this.address_2 = address_2;
		this.home_phone_2 = home_phone_2;
	}
}