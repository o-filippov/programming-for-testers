package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
			app.navigateTo().mainPage();
			
			// save state
			List<ContactData> oldList = app.getContactHelper().getContacts();
			
			// actions
			Random rnd = new Random();
		    int index = rnd.nextInt(oldList.size()-1); // number of the contact to be removed
			
			app.getContactHelper().deleteContact(index);
					
			// save new state
			List<ContactData> newList = app.getContactHelper().getContacts();
		 
		    // compare states
			oldList.remove(index);
		    assertEquals(newList, oldList);
	}
}
