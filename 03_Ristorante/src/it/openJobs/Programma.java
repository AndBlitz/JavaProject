package it.openJobs;

import java.util.ArrayList;
import java.util.Scanner;

public class Programma {

	public static void main(String[] args) {
		 	
			Login.access();
	        ArrayList<String> ordini = new ArrayList<String>();
	        boolean continua = true;
	        double totale = 0.00;
	        Scanner input = new Scanner(System.in);
	        
	        while (continua) {
	            System.out.println("Benvenuto ad Imàgo Ristorante stellato di Roma! Cosa vuoi fare?");
	            System.out.println("1. Ordinare");
	            System.out.println("2. Uscire");
	            
	            int scelta = input.nextInt();
	            
	            if (scelta == 1) {
	                boolean continua2 = true;
	                while (continua2) {
	                    System.out.println("Cosa desideri fare?");
	                    System.out.println("1. Visualizza i piatti disponibili");
	                    System.out.println("2. Ordina");
	                    System.out.println("3. Torna indietro");
	                    int scelta2 = input.nextInt();
	                    if (scelta2 == 1) {
	                        System.out.println("Le nostre specialità sono:");
	                        System.out.println("1. Pizza Capricciosa - Ingredienti: Pomodoro, Mozzarella, uovo, Funghi, Prosciutto");
	                        System.out.println("2. Pasta al Sugo- Ingredienti: Pomodoro, Basilico, Parmigiano");
	                        System.out.println("3. Yakiniku di Kobe - Ingredienti: Tajima di Kobe 200gr, Cipolla, Limone, Scalogno");
	                        System.out.println("4. Vino Magnum Lodovico - Ingredienti: Tenuta di Biserno, IGT 2013");
	                        System.out.println();
	                    } else if (scelta2 == 2) {
	                        System.out.println("Cosa desideri ordinare?");
	                        System.out.println("1. Pizza - 19.99 euro");
	                        System.out.println("2. Pasta - 32.99 euro");
	                        System.out.println("3. Yakiniku di Kobe - 200.99 euro");
	                        System.out.println("4. Vino Magnum Lodovico - 1100.99 euro");
	                        int scelta3 = input.nextInt();
	                        String ordine = "";
	                        double prezzo = 0.0;
	                        if (scelta3 == 1) {
	                            ordine = "Pizza Capricciosa";
	                            prezzo = 19.99;
	                        } else if (scelta3 == 2) {
	                            ordine = "Pasta al sugo";
	                            prezzo = 32.99;
	                        } else if (scelta3 == 3) {
	                        	ordine = "Yakiniku di Kobe";
	                        	prezzo = 200.99;
	                        } else if (scelta3 == 4) {
	                        	ordine = "Vino Magnum Lodovico";
	                        	prezzo = 1100.99;
	                        }
	                        System.out.println("Hai ordinato " + ordine + " al prezzo di " + prezzo + " euro.");
	                        ordini.add(ordine);
	                        totale += prezzo;
	                    } else if (scelta2 == 3) {
	                        continua2 = false;
	                    }
	                }
	            } else if (scelta == 2) {
	                System.out.println("Hai ordinato i seguenti piatti:");
	                for (String ordine : ordini) {
	                    System.out.println("- " + ordine);
	                }
	                System.out.println();
	                System.out.println("Totale speso: " + totale + " euro. ");
	                if (totale > 0) {
	                System.out.println("Grazie per averci scelto!");
	                }else {
	                	System.out.println("Grazie per averci fatto perdere tempo. ");
	                	System.out.println("In fondo alla via ci sta un McDonald's. ");
	                }
	                continua = false;
	            }
	        }
	    }
	}
