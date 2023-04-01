package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private Project[] projects;
	private int numProjects;

	public Controller() {

		projects = new Project[10];
		numProjects = 0;

	}

	public boolean registerProject(String name, String description, double budget, Calendar initialDate,
			Calendar finalDate) {

		if (numProjects < 10) {

			projects[numProjects] = new Project(name, description, initialDate, finalDate, budget);
			numProjects++;
			return true;

		} else {

			return false;

		}

	}

	public String searchProjectsAfterDate(Calendar date) {
		String msg = "";
		for (int i = 0; i < projects.length; i++) {
			if (projects[i] != null && projects[i].getFinalDate().equals(date)) {
				try {
					msg += projects[i].getProjectInfo();
				} catch (ParseException e) {
					System.out.println("Error parsing date.");
				}
			}
		}
		if (msg.equals("")) {
			msg = "No projects found.";
		}
		return msg;
	}

	public String searchProjectsBeforeDate(Calendar date) {
		String msg = "";
		for (int i = 0; i < projects.length; i++) {
			if (projects[i] != null && projects[i].getInitialDate().equals(date)) {
				try {
					msg += projects[i].getProjectInfo();
				} catch (ParseException e) {
					System.out.println("Error parsing date.");
				}
			}
		}
		if (msg.equals("")) {
			msg = "No projects found.";
		}
		return msg;
	}
}

