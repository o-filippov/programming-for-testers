package com.example.tests;


public class ContactData implements Comparable<ContactData> {
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

	@Override
	public String toString() {
		return "ContactData [last_name=" + last_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.last_name.toLowerCase().compareTo(other.last_name.toLowerCase());
	}
	
	/* public ContactData(String first_name, String last_name, String address,
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
	} */
}