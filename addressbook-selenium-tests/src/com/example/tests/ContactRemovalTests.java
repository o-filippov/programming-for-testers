package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
		app.navigateTo().mainPage();
			
		// save state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
			
		// actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1); // number of the contact to be removed
		
		app.getContactHelper().deleteContact(index);
				
		// save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		
		// compare states
		assertThat(newList, equalTo(oldList.without(index)));

	}
	
}
