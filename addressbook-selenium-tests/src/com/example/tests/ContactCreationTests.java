package com.example.tests;

// import org.junit.*;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  
  @Test
  public void testNonEmptyContactCreation() throws Exception {
    app.openMainPage();
    app.initContactCreation();
    ContactData contact = new ContactData();
    contact.first_name = "Vasilii";
    contact.last_name  = "Pupkin";
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
	app.fillContactForm(this, contact);
    app.submitContactCreation();
    app.returnToMainPage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.openMainPage();
	app.initContactCreation();
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
	app.fillContactForm(this, contact);
    app.submitContactCreation();
    app.returnToMainPage();
  }
}
