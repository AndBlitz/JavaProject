package it.openJobs;
import java.util.ArrayList;
import java.util.Scanner;

public class Programma {
    private static ArrayList<Piatto> piattiOrdinati = new ArrayList<Piatto>();

    public static void main(String[] args) {
        
    	// Array di piatti offerti dal ristorante, con più di tempo sarebbe meglio trasformarlo in 
    	//in List come ho fatto per gli utenti.
        Piatto[] piatti = new Piatto[4];
        piatti[0] = new Piatto("Pizza Capricciosa", "Pomodoro, Mozzarella, Uovo, Funghi, Prosciutto", 19.99);
        piatti[1] = new Piatto("Pasta al Sugo", "Pomodoro, Basilico, Parmigiano", 32.99);
        piatti[2] = new Piatto("Yakiniku di Kobe", "Tajima di Kobe 200gr, Cipolla, Limone, Scalogno", 200.99);
        piatti[3] = new Piatto("Vino Magnum Lodovico", "Tenuta di Biserno, IGT 2013", 1100.99);
        
        double totale = 0.00;
        Login.menu();
        // Autenticazione dell'utente
        //Login.registrazione();
        //Login login = new Login();
        Utente utente = Login.login();
       

        if (utente != null) {
            // Controllo se l'utente è un admin
            boolean isAdmin = utente.getRuolo().equals("admin");

            boolean continua = true;
            Scanner bool = new Scanner(System.in);
            Scanner scanner = new Scanner(System.in);
            
            while (continua) {
                System.out.println("Benvenuto ad Imàgo Ristorante stellato di Roma! Cosa vuoi fare?");
                System.out.println("1. Ordinare");
                System.out.println("2. Uscire");
                System.out.println("3. back");

                int scelta = scanner.nextInt();
                
                if (scelta == 1) {
                    while (true) {
                        System.out.println("Cosa desideri fare?");
                        System.out.println("1. Visualizzare i piatti disponibili");
                        System.out.println("2. Ordinare un piatto");

                        if (isAdmin) {
                            System.out.println("3. Modifica piatti");
                        }

                        System.out.println("4. Tornare al menu precedente");

                        scelta = scanner.nextInt();

                        if (scelta == 1) {
                            System.out.println("Ecco i piatti disponibili:");

                            for (Piatto piatto : piatti) {
                                System.out.println("- " + piatto.getNome() + " (" + piatto.getIngredienti() + ") - €" + piatto.getPrezzo());
                            }
                        } else if (scelta == 2) {
                            System.out.println("Quale piatto vuoi ordinare?");

                            for (int i = 0; i < piatti.length; i++) {
                                System.out.println((i + 1) + ". " + piatti[i].getNome() + " (" + piatti[i].getIngredienti() + ") - €" + piatti[i].getPrezzo());
                            }

                            scelta = scanner.nextInt();

                            if (scelta >= 1 && scelta <= piatti.length) {
                                piattiOrdinati.add(piatti[scelta - 1]);

                                System.out.println("Hai aggiunto " + piatti[scelta - 1].getNome() + " all'ordine.");
                            }
                        } else if (scelta == 3 && isAdmin) {
                            System.out.println("Quale operazione vuoi eseguire?");
                            System.out.println("1. Aggiungi il piatto.");
                            System.out.println("2. Elimina");

                            int opzione = scanner.nextInt();

                            if (opzione == 1) {
                                System.out.println("Inserisci il nome del nuovo piatto:");
                                scanner.nextLine(); // Consuma il newline rimasto
                                String nome = scanner.nextLine();

                                System.out.println("Inserisci gli ingredienti del nuovo piatto:");
                                String ingredienti = scanner.nextLine();

                                System.out.println("Inserisci il prezzo del nuovo piatto:");
                                double prezzo = bool.nextDouble();

                                // Crea il nuovo piatto e lo aggiunge all'array
                                Piatto nuovoPiatto = new Piatto(nome, ingredienti, prezzo);
                                Piatto[] nuoviPiatti = new Piatto[piatti.length + 1];
                                for (int i = 0; i < piatti.length; i++) {
                                    nuoviPiatti[i] = piatti[i];
                                }
                                nuoviPiatti[nuoviPiatti.length - 1] = nuovoPiatto;
                                piatti = nuoviPiatti;

                                System.out.println("Il nuovo piatto " + nome + " è stato aggiunto.");
                            } else if (opzione == 2) {
                                System.out.println("Quale piatto vuoi eliminare?");

                                for (int i = 0; i < piatti.length; i++) {
                                    System.out.println((i + 1) + ". " + piatti[i].getNome());
                                }

                                opzione = scanner.nextInt();

                                if (opzione >= 1 && opzione <= piatti.length) {
                                    // Rimuove il piatto dall'array
                                    Piatto[] nuoviPiatti = new Piatto[piatti.length - 1];
                                    for (int i = 0, j = 0; i < piatti.length; i++) {
                                        if (i != opzione - 1) {
                                            nuoviPiatti[j++] = piatti[i];
                                        }
                                    }
                                    piatti = nuoviPiatti;

                                    System.out.println("Il piatto è stato eliminato.");
                                }
                            }
                        } else if (scelta == 4) {
                            break;
                        }
                    }
                } else if (scelta == 2) {
                    
                    
                	System.out.println("Hai ordinato i seguenti piatti:");
                	for (Piatto piatto : piattiOrdinati) {
                        System.out.println("- " + piatto.getNome() + " - €" + piatto.getPrezzo());
                        totale += piatto.getPrezzo();
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
                    
                } else if (scelta ==3) {
                	utente = null;
                	Login.menu();
                	
                }
            }

        }
        }
    }                            