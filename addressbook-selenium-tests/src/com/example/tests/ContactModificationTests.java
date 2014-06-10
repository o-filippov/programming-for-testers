package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();

		// save state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		// actions
		int index = 0;
		
		app.getContactHelper().initContactEditingByIndex(index);
		ContactData contact = new ContactData();
		contact.first_name = "fn_modified";
		contact.last_name = "ln_modified";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToMainPage();
		
		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
	 
	    // compare states
		oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
