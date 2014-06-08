package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {
  
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	// actions
	app.getContactHelper().initContactCreation();
	ContactData contact = new ContactData();
    contact.first_name = "";
    contact.last_name  = "";
    contact.address = "20 Tester street";
    contact.home_phone = "+380441234567";
    contact.mobile_phone = "+380501234567";
    contact.work_phone = "+380671234567";
    contact.email = "tester@test.com";
    contact.email_2 = "privatetestersaddress@test.com";
    contact.birth_day = "1";
    contact.birth_month = "January";
    contact.birth_year = "1978";
    contact.group = "Rob";
    contact.address_2 = "21 Secondary Napilnika str.";
    contact.home_phone_2 = "1111111";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToMainPage();
    
    // save new state
	List<ContactData> newList = app.getContactHelper().getContacts();
 
    // compare states
    oldList.add(contact);
    //Collections.sort(oldList);
    assertEquals(newList, oldList);
 }
  
  //@Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactCreation();
	ContactData contact = new ContactData();
	contact.first_name = "";
    contact.last_name  = "";
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
