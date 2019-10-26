package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();

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
		System.out.println("\t1. Look up a film by its ID.");
		System.out.println("\t2. Look up a film by a search keyword.");
		System.out.println("\t3. Exit the application.");
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
			System.out.println("Thank you, and have a great one.");
			System.exit(0);
			break;
		default:
			System.err.println("Sorry, input did not match 1, 3, or 3. Please try again.");
			startUserInterface(input);
			break;
		}

	}

	private void searchFilmByID(Scanner input) {
		System.out.print("Please enter a Film ID: ");
		int filmID = 0;

		try {
			filmID = input.nextInt();
		} catch (InputMismatchException e) {
			input.nextLine();
			System.err.println("Sorry, your input was not a number. Please try again.");
			System.out.println();
			startUserInterface(input);
		} finally {
			input.nextLine();
		}

		Film film = db.findFilmById(filmID);
		List<Actor> actors = db.findActorsByFilmId(filmID);
		StringBuilder sb = new StringBuilder();

		System.out.println();

		if (film == null) {
			System.out.println("Sorry, the Film ID was not found.");
		} else {
			System.out.println(film.toStringFilmByID());
			for (Actor actor : actors) {
				sb.append(actor.getFirstName()).append(" ").append(actor.getLastName()).append(", ");
			}
			System.out.println("Actors: " + sb.delete(sb.length() - 2, sb.length() - 1));
		}

		System.out.println();
		startUserInterface(input);
	}

	private void searchByKeyword(Scanner input) {
		System.out.print("Please enter a keyword: ");
		String keyword = input.nextLine();

		List<Film> films = db.findFilmByKeyword(keyword);

		List<Actor> actors = null;
		StringBuilder sb = new StringBuilder();

		if (films.size() == 0) {
			System.out.println("Sorry, the keyword you input was not found.");
		} else {
			for (Film film : films) {
				System.out.println(film.toStringFilmByID());
				actors = db.findActorsByFilmId(film.getFilmId());
				for (Actor actor : actors) {
					sb.append(actor.getFirstName()).append(" ").append(actor.getLastName()).append(", ");
				}
				System.out.println("Actors: " + sb.delete(sb.length() - 2, sb.length() - 1));
				sb.delete(0, sb.length() - 1);
				System.out.println();
			}
		}

		System.out.println();
		startUserInterface(input);
	}
}
