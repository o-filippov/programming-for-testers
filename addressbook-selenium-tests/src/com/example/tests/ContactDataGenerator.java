package com.example.tests;

import static com.example.tests.GroupDataGenerator.generateRandomString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <test data amount> <file> <format>");
			return;
		}
	
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File '" + file + "' exists, please remove it manually");
			return;	
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format " + format +". Please, use csv or xml");
			return;
		}
	}
	
	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);	
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}
	
	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + 
							contact.getLastName() + "," + 
							contact.getAddress() + "," + 
							contact.getHomePhone() + "," + 
							contact.getMobilePhone() + "," + 
							contact.getWorkPhone() + "," + 
							contact.getEmail() + "," + 
							contact.getEmail2() + "," + 
							contact.getBirthDay() + "," + 
							contact.getBirthMonth() + "," + 
							contact.getBirthYear() + "," + 
							contact.getAddress() + "," + 
							contact.getAddress2() + "," + 
							contact.getHomePhone2() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
				.withFirstName(part[0])
				.withLastName(part[1])
				.withAddress(part[2])
				.withHomePhone(part[4])
				.withMobilePhone(part[5])
				.withWorkPhone(part[6])
				.withEmail(part[7])
				.withEmail2(part[8])
				.withBirthDay(part[9])
				.withBirthMonth(part[10])
				.withBirthYear(part[11])
				.withGroup(part[12])
				.withAddress2(part[13])
				.withHomePhone2((part[14]));
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}
	
	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
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
			list.add(contact);
		}
		return list;
	}
	
	public static String generateRandomYear() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return String.valueOf(rnd.nextInt(110) + 1900);
		}
	}
	
	public static String generateRandomDay() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "-";
		} else {
			return String.valueOf(rnd.nextInt(29) + 1);
		}
	}
	
	public static String generateRandomNumber() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return String.valueOf(Math.abs(rnd.nextInt()));
		}
	}
	
	public static String generateRandomMonth() {
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
