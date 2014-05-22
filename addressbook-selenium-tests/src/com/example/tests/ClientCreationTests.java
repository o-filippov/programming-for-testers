package com.example.tests;

// import org.junit.*;
import org.testng.annotations.Test;

public class ClientCreationTests extends TestBase {
  
  @Test
  public void testNonEmptyClientCreation() throws Exception {
    openMainPage();
    initClientCreation();
    ClientData client = new ClientData();
    client.first_name = "Vasilii";
    client.last_name  = "Pupkin";
    client.address = "20 Tester street";
    client.home_phone = "+380441234567";
    client.mobile_phone = "+380501234567";
    client.work_phone = "+380671234567";
    client.email = "tester@test.com";
    client.email_2 = "privatetestersaddress@test.com";
    client.birth_day = "1";
    client.birth_month = "January";
    client.birth_year = "1978";
    client.group = "Rob";
    client.address_2 = "21 Secondary Napilnika str.";
    client.home_phone_2 = "1111111";	
	fillClientForm(client);
    submitClientCreation();
    returnToMainPage();
  }
  
  @Test
  public void testEmptyExceptForDateOfBirthAndGroupClientCreation() throws Exception {
	openMainPage();
	initClientCreation();
	ClientData client = new ClientData();
	client.first_name = "";
	client.last_name  = "";
	client.address = "";
	client.home_phone = "";
	client.mobile_phone = "";
	client.work_phone = "";
	client.email = "";
	client.email_2 = "";
	client.birth_day = "1";
	client.birth_month = "January";
	client.birth_year = "1978";
	client.group = "Rob";
	client.address_2 = "";
	client.home_phone_2 = "";	
	fillClientForm(client);
	submitClientCreation();
	returnToMainPage();
  }
  
  @Test
  public void testEmptyClientCreation() throws Exception {
	openMainPage();
	initClientCreation();
	ClientData client = new ClientData();
	client.first_name = "";
    client.last_name  = "";
    client.address = "";
    client.home_phone = "";
    client.mobile_phone = "";
    client.work_phone = "";
    client.email = "";
    client.email_2 = "";
    client.birth_day = "1";
    client.birth_month = "";
    client.birth_year = "";
    client.group = "";
    client.address_2 = "";
    client.home_phone_2 = "";	
	fillClientForm(client);
    submitClientCreation();
    returnToMainPage();
  }
}
