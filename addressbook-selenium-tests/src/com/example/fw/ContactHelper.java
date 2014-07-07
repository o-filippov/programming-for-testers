package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public List<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}
	
	public ContactHelper createContact(ContactData contact, boolean CREATION) {
		initContactCreation();
   		fillContactForm(contact, CREATION);
   		submitContactCreation();
   		returnToMainPage();
   		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact, boolean MODIFICATION) {
		initContactEditingByIndex(index);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		returnToMainPage();		
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactEditingByIndex(index);
		confirmContactDeletion();
		returnToMainPage();
		cachedContacts = null;
		return this;
	}

//-----------------------------------------------------------------------------
	
	public ContactHelper initContactCreation() {
		manager.navigateTo().mainPage();
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
	    type(By.name("firstname"), contact.getFirstName());
	    type(By.name("lastname"), contact.getLastName());
	    type(By.name("address"), contact.getAddress());
	    type(By.name("home"), contact.getHomePhone());
	    type(By.name("mobile"), contact.getMobilePhone());
	    type(By.name("work"), contact.getWorkPhone());
	    type(By.name("email"), contact.getEmail());
	    type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBirthDay());
		selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());
	    if (formType == CREATION) {
			selectByText(By.name("new_group"), "[none]");
	    } /* else {
	    		if (driver.findElements(By.name("new_group")).size() != 0) {
	    			throw new Error("Group selector exists in contact modification form");
	    		} 
	    	} */
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getHomePhone2());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToMainPage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initContactEditingByIndex(int index) {
		manager.navigateTo().mainPage();
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));
		cachedContacts = null;
		return this;
	}
	
	public void confirmContactDeletion() {
		click(By.xpath("(//input[@name='update'])[2]"));
	}

	private	List<ContactData> cachedContacts;	

	private List<ContactData> rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement row : rows) {
			String lastName = row.findElement(By.xpath(".//td[2]")).getText();
			String firstName = row.findElement(By.xpath(".//td[3]")).getText();
			cachedContacts.add(new ContactData().withLastName(lastName).withFirstName(firstName));
		}
		return cachedContacts;
	}
}
