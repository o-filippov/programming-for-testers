package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	public static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData()
			 .withName(generateRandomString())
			 .withHeader(generateRandomString())
			 .withFooter(generateRandomString());
			list.add(new Object[]{group});
		}
		// ....		
		return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			String string = new String();
			string = "";
			return string;
		} else {
			String string = new String();
			string = "test" + rnd.nextInt();
			return string; 
		}
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData()
			.withFirstName(generateRandomString())
			.withLastName(generateRandomString())
			.withAddress(generateRandomString())
			.withHomePhone(generateRandomNumber())
			.withMobilePhone(generateRandomNumber())
			.withWorkPhone(generateRandomNumber())
			.withEmail(generateRandomString())
			.withEmail2(generateRandomString())
			.withBirthDay(generateRandomDay())
			.withBirthMonth(generateRandomMonth())
			.withBirthYear(generateRandomYear())
			.withGroup("[none]")
			.withAddress2(generateRandomString())
			.withHomePhone2(generateRandomNumber());
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	public String generateRandomYear() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return String.valueOf(rnd.nextInt(110) + 1900);
		}
	}
	
	public String generateRandomDay() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "-";
		} else {
			return String.valueOf(rnd.nextInt(29) + 1);
		}
	}
	
	public String generateRandomNumber() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return String.valueOf(Math.abs(rnd.nextInt()));
		}
	}
	
	public String generateRandomMonth() {
		String[] twelvemonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "-";
		} else {
			int index = new Random().nextInt(12);
			return twelvemonth[index];
		}

	}
	
}
