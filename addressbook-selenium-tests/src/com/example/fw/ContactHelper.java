package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

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
		cachedContacts = new ArrayList<ContactData>();
		
		manager.navigateTo().mainPage();
		int number_of_rows = Integer.parseInt(driver.findElement(By.xpath("//body/div/div[4]/label/strong/span")).getText()); // may be calculated with " = driver.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td[1]")).size();"
		for (int i = 2; i <= number_of_rows + 1; i++) {
			String lastName = driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[2]")).getText();
			String firstName = driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[3]")).getText();
			String email = driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[4]")).getText();
			String homePhone = driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[5]")).getText();
			cachedContacts.add(
				new ContactData()
						.withLastName(lastName)
						.withFirstName(firstName)
						.withEmail(email)
						.withHomePhone(homePhone));
		}
		return cachedContacts;
	}
	
}
