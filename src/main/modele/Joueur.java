package main.modele;

public class Joueur {

    private Gobelet gobelet;
    private int score;
    private String nom;

    //Constructeurs
    Joueur(String nom) {
        gobelet = new Gobelet();
        score = 0;
        this.nom = nom;
    }

    //Getter&Setter
    public void remplirGlobelet(){
        gobelet = new Gobelet();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public Gobelet getGobelet() {
        return gobelet;
    }

    public String getNom() {
        return nom;
    }
}

