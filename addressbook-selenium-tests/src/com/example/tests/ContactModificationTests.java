package com.example.tests;

import static com.example.fw.ContactHelper.MODIFICATION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		// save state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
		// actions
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1); // number of the contact to be modified
		
		app.getContactHelper().modifyContact(index, contact, MODIFICATION);
		
		// save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	 
	    // compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));

	}
	
}
