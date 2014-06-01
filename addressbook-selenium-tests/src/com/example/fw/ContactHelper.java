package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.first_name);
	    type(By.name("firstname"), contact.first_name);
	    type(By.name("lastname"), contact.last_name);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.home_phone);
	    type(By.name("mobile"), contact.mobile_phone);
	    type(By.name("work"), contact.work_phone);
	    type(By.name("email"), contact.email);
	    type(By.name("email2"), contact.email_2);
		selectByText(By.name("bday"), contact.birth_day);
		selectByText(By.name("bmonth"), contact.birth_month);
	    type(By.name("byear"), contact.birth_year);
		//selectByText(By.name("new_group"), contact.group);
	    type(By.name("address2"), contact.address_2);
	    type(By.name("phone2"), contact.home_phone_2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToMainPage() {
		click(By.linkText("home page"));
	}

	public void deleteContact(int index) {
		initContactEditingByIndex(index);
		click(By.xpath("(//input[@name='update'])[2]"));
		}

	public void initContactEditingByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		}

	public void submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));
	}
}
