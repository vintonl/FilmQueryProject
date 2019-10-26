package com.skilldistillery.filmquery.app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome");
		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("Please choose from the following?");
		System.out.println("1. Look up a film by its id.");
		System.out.println("2. Look up a film by a search keyword.");
		System.out.println("3. Exit the application.");
		System.out.print("Enter here: ");
		
		int choice = 0;
		try {
			choice = input.nextInt();
		} catch (InputMismatchException e) {
		} finally {
			input.nextLine();
		}

		switch (choice) {
		case 1:
			searchFilmByID(input);
			break;
		case 2:
			searchByKeyword(input);
			break;
		case 3:
			System.out.println("Goodbye");
			System.exit(0);
			break;
		default:
			System.err.println("Sorry, please try again.");
			startUserInterface(input);
			break;
		}

	}

	private void searchFilmByID(Scanner input) {
		System.out.println("Enter film id: ");
		int filmID = 0;
		
		try {
			filmID = input.nextInt();
		} catch (InputMismatchException e) {
			input.nextLine();
			startUserInterface(input);
		} finally {
			input.nextLine();
		}

		Film film = db.findFilmById(filmID);

		if (film == null) {
			System.out.println("Sorry, film ID was not found.");
		} else {
			System.out.println(film);
		}
		startUserInterface(input);
	}

	private void searchByKeyword(Scanner input) {
		System.out.println("Enter film id: ");
		String keyword = "";
		
		try {
			keyword = input.nextLine();
		} catch (InputMismatchException e) {
			input.nextLine();
			startUserInterface(input);
		} finally {
			input.nextLine();
	
		}
		
		
		
		startUserInterface(input);
	}

}
