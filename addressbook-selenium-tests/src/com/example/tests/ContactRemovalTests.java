package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
			app.getNavigationHelper().openMainPage();
			
			// save state
			List<ContactData> oldList = app.getContactHelper().getContacts();
			
			// actions
			int index = 0;
			
			app.getContactHelper().deleteContact(index);
			app.getContactHelper().returnToMainPage();
			
			// save new state
			List<ContactData> newList = app.getContactHelper().getContacts();
		 
		    // compare states
			oldList.remove(index);
		    assertEquals(newList, oldList);
	}
}
