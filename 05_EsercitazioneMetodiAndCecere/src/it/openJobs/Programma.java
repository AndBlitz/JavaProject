package it.openJobs;

import java.util.Scanner;

public class Programma {

	public static void main(String[] args) {

		Scanner inputInt = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		Scanner inputDouble = new Scanner(System.in);
		int a = 3;
		int b = 4;
		int c = somma(a, b);

		System.out.println("La somma è: " + c);

		double[] numeri2 = { 2, 4, 6, 8, 10 };
		double risultato = media(numeri2);
		System.out.println("La media del array è: " + risultato);

		String parola = "ciao";
		String parolaInvertita = inverti(parola);
		System.out.println("La stringa invertita è: " + parolaInvertita);

		System.out.println();
		System.out.println("Esercizi con lo scanner: ");

		// Scanner Metodo Inverti:
		System.out.print("Inserisci la parola: ");
		String parola2 = inputString.nextLine();
		String parola2Invertita = inverti(parola2);
		System.out.println("Tramite scanner parola invertita: " + parola2Invertita);

		// scanner metodo media:
		System.out.print("Inserisci la dimensione che vuoi dare all'array: ");
		int dimensione = inputInt.nextInt();

		double[] numeri = new double[dimensione];

		for (int i = 0; i < dimensione; i++) {
			System.out.print("Inserisci il " + (i + 1) + "° numero: ");
			numeri[i] = inputDouble.nextDouble();
		}

		double risultato2 = media(numeri);
		System.out.println("La media dei numeri è: " + risultato2);

		// scanner metodo somma:
		System.out.print("Inserisci primo numero: ");
		int primoNumero = inputInt.nextInt();
		System.out.print("Inserisci secondo numero: ");
		int secondoNumero = inputInt.nextInt();
		int sommaNumeri = primoNumero + secondoNumero;
		System.out.println("La somma dei numeri: " + primoNumero + " + " + secondoNumero + " = " + sommaNumeri);

		inputDouble.close();
		inputInt.close();
		inputString.close();

	}

	// Metodo somma: Ho creato un metodo public, static per essere richiamato senza
	// dover fare un istanza della classe e che restituisce un int.
	// Il metodo prende due argomenti: entrambi interi, indicati da x e y.
	// La sua implementazione somma i due argomenti e restituire il risultato con
	// l'istruzione return.
	public static int somma(int x, int y) {
		return x + y;
	}

	// Metodo media = Dato come argomento un array, uilizzo un ciclo for per fare la
	// somma di tutti i numeri interni all'array
	// poi ottengo la media dividendo la somma per la dimensione dell'array. E
	// tramite un return ritorno il risultato
	public static double media(double[] numeri) {
		double somma = 0;
		for (int i = 0; i < numeri.length; i++) {
			somma += numeri[i];
		}
		double media = (double) somma / numeri.length;
		return media;
	}

	// Creo un metodo public, static che restituisce una stringa che prende come
	// argomento una stringa indicata dal nome str. Il metodo restituisce una
	// stringa.
	// Ho implementato il metodo utilizzando classe StringBuilder per creare una
	// copia della stringa, ho invertito la copia utilizzando il metodo reverse() e
	// restituisco la stringa invertita.
	public static String inverti(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}

}
