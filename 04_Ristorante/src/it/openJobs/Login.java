package it.openJobs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

	// private static Utente[] utentiRegistrati = new Utente[10];
	private static List<Utente> utentiRegistrati = new ArrayList<Utente>();

	public static void menu() {
		boolean continua = true;

		Scanner scanner = new Scanner(System.in);

		while (continua) {
			System.out.println("Benvenuto ad Imàgo Ristorante stellato di Roma! Cosa vuoi fare?");
			System.out.println("1. Registrazione");
			System.out.println("2. Login");
			System.out.println("3. Lista Utenti");

			int scelta = scanner.nextInt();

			if (scelta == 1) {
				registrazione();
			} else if (scelta == 2) {

				continua = false;
			} else if (scelta == 3) {
				listaUtenti();
			}
		}

	}

	/*
	 * Aggiunta Utenti Array public static void registrazione() { Scanner scanner =
	 * new Scanner(System.in);
	 * 
	 * System.out.println("Registrazione nuovo utente:");
	 * System.out.print("Username: "); String username = scanner.nextLine();
	 * System.out.print("Password: "); String password = scanner.nextLine();
	 * System.out.print("Ruolo (utente/admin): "); String ruolo =
	 * scanner.nextLine();
	 * 
	 * Utente nuovoUtente = new Utente(username, password, ruolo); for (int i = 0; i
	 * < utentiRegistrati.length; i++) { if (utentiRegistrati[i] == null) {
	 * utentiRegistrati[i] = nuovoUtente;
	 * System.out.println("Registrazione completata con successo!"); break; } } }
	 */
	public static void registrazione() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Registrazione nuovo utente:");
		System.out.print("Username: ");
		String username = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		System.out.print("Ruolo (utente/admin): ");
		String ruolo = scanner.nextLine();

		Utente nuovoUtente = new Utente(username, password, ruolo);
		utentiRegistrati.add(nuovoUtente);
		System.out.println("Registrazione completata con successo!");
	}

	public static Utente login() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Login:");
		System.out.print("Username: ");
		String username = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();

		for (Utente utente : utentiRegistrati) {
			if (utente != null && utente.getUsername().equals(username) && utente.getPassword().equals(password)) {
				System.out.println("Login effettuato con successo!");

				return utente;
			}
		}

		System.out.println("Username o password non validi!");
		return null;
	}

	public static void listaUtenti() {
		System.out.println("Lista Utenti:");
		for (Utente utente : utentiRegistrati) {
			if (utente != null) {
				// Qui a livello di esercizio mostro anche la password.
				System.out.println("Username: " + utente.getUsername() + " | Password: " + utente.getPassword()
						+ " ( Ruolo: " + utente.getRuolo() + " )");
			}
		}
		if (utentiRegistrati.isEmpty()) {
			System.out.println("Non risulata registrato nessun utente");
		}
	}
}