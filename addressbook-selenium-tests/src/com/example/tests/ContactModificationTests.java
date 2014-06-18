package com.example.tests;

import static com.example.fw.ContactHelper.MODIFICATION;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;


public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		// save state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		// actions
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1); // number of the contact to be modified
		
		app.getContactHelper().modifyContact(index, contact, MODIFICATION);
		
		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
	 
	    // compare states
		oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
