package ui;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import model.Controller;

public class Main {

	private Scanner reader;
	private Controller controller;

	public Main() {
		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {
		Main exe = new Main();
		exe.menu();
	}

	public void menu() {
		int option = 0;
		do {
			System.out.println("Select an option:");
			System.out.println("1. Register a new project.");
			System.out.println("2. Search for projects before a certain date.");
			System.out.println("3. Search for projects after a certain date.");
			System.out.println("4. Exit.");
			option = reader.nextInt();

			switch (option) {
				case 1:
					registerProject();
					break;
				case 2:
					searchProjectsBeforeDate();
					break;
				case 3:
					searchProjectsAfterDate();
					break;
				case 4:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
			}
		} while (option != 4);
	}

	public void registerProject() {
		System.out.println("Enter the project's name:");
		String nameP = reader.next();

		System.out.println("Enter the project's description:");
		String descriptionP = reader.next();

		System.out.println("Enter the project's budget:");
		double budgetP = reader.nextDouble();

		System.out.println("Enter the project's initial date (dd-mm-yyyy):");
		String initialDateString = reader.next();
		Calendar initialDateP = parseCalendar(initialDateString);

		System.out.println("Enter the project's final date (dd-mm-yyyy):");
		String finalDateString = reader.next();
		Calendar finalDateP = parseCalendar(finalDateString);

		boolean result;
		if (result = controller.registerProject(nameP, descriptionP, budgetP, initialDateP, finalDateP)) {
			System.out.println("se ha registrado con exito");

		} else {

			System.out.println("ha ocurrido un problema con el registro");

		}

	}

	public void searchProjectsBeforeDate() {
		System.out.println("Enter the initial date to search (dd-mm-yyyy):");
		String dateString = reader.next();
		Calendar date = parseCalendar(dateString);

		String result = controller.searchProjectsBeforeDate(date);
		System.out.println(result);

	}

	public void searchProjectsAfterDate() {
		System.out.println("Enter the date to search after (dd-mm-yyyy):");
		String dateString = reader.next();
		Calendar date = parseCalendar(dateString);

		String result = controller.searchProjectsAfterDate(date);
		System.out.println(result);
	}

	private Calendar parseCalendar(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(dateString));
		} catch (ParseException e) {
			System.out.println("Invalid date format. Please try again.");
		}
		return calendar;
	}
}
