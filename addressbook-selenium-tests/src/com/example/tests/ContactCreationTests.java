package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
			contact.first_name = generateRandomString();
			contact.last_name = generateRandomString();
			contact.address = generateRandomString();
			contact.home_phone = app.getContactHelper().generateRandomNumber();
			contact.mobile_phone = app.getContactHelper().generateRandomNumber();
			contact.work_phone = app.getContactHelper().generateRandomNumber();
			contact.email = generateRandomString();
			contact.email_2 = generateRandomString();
			contact.birth_day = app.getContactHelper().generateRandomDay();
			contact.birth_month = "-"; // should be done in the future
			contact.birth_year = app.getContactHelper().generateRandomYear();
			contact.group = "[none]"; // probably should be done in the future
			contact.address_2 = generateRandomString();
			contact.home_phone_2 = app.getContactHelper().generateRandomNumber();
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	// actions
	app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToMainPage();
    
    // save new state
	List<ContactData> newList = app.getContactHelper().getContacts();
 
    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
 }
  
  //@Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactCreation();
	ContactData contact = new ContactData();
	contact.first_name = "1";
    contact.last_name  = "2";
    contact.address = "";
    contact.home_phone = "";
    contact.mobile_phone = "";
    contact.work_phone = "";
    contact.email = "";
    contact.email_2 = "";
    contact.birth_day = "-";
    contact.birth_month = "-";
    contact.birth_year = "";
    contact.group = "[none]";
    contact.address_2 = "";
    contact.home_phone_2 = "";	
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToMainPage();
  }
}
