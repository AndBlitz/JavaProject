package it.openJobs;

import java.util.HashMap;
import java.util.Scanner;

public class Login {

	    private static HashMap<String, String> utenti = new HashMap<>();

	    public static void registra() {
	        Scanner input = new Scanner(System.in);
	        System.out.println("Registrazione nuovo utente:");
	        System.out.print("Inserisci username: ");
	        String username = input.nextLine();
	        System.out.print("Inserisci password: ");
	        String password = input.nextLine();
	        utenti.put(username, password);
	        System.out.println("Registrazione avvenuta con successo!");
	        System.out.println();
	    }

	    public static boolean login() {
	        Scanner input = new Scanner(System.in);
	        System.out.println("Login:");
	        System.out.print("Inserisci username: ");
	        String username = input.nextLine();
	        System.out.print("Inserisci password: ");
	        String password = input.nextLine();
	        if (utenti.containsKey(username) && utenti.get(username).equals(password)) {
	            System.out.println("Accesso effettuato con successo!");
	            System.out.println();
	            return true;
	        } else {
	            System.out.println("Credenziali non valide. Riprova.");
	            System.out.println();
	            return false;
	        }
	    }

	    public static void access() {
	        Scanner input = new Scanner(System.in);
	        boolean autenticato = false;
	        while (!autenticato) {
	            System.out.println("Benvenuto! Cosa vuoi fare?");
	            System.out.println("1. Registrati");
	            System.out.println("2. Login");
	            int scelta = input.nextInt();
	          
	            switch (scelta) {
	                case 1:
	                    registra();
	                    break;
	                case 2:
	                    autenticato = login();
	                    break;
	                default:
	                    System.out.println("Scelta non valida. Riprova.");
	            }
	        }
	    }
	}

	