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
		return "ContactData [first_name=" + first_name + ", last_name="
				+ last_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
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
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.first_name.toLowerCase().compareTo(other.first_name.toLowerCase());
	}
	
}