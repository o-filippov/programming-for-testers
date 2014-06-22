package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	public static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}
	
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
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
