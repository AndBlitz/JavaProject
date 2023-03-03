package it.openJobs;

public class Piatto {
    private String nome;
    private String ingredienti;
    private double prezzo;

    public Piatto(String nome, String ingredienti, double prezzo) {
        this.nome = nome;
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public double getPrezzo() {
        return prezzo;
    }
}
