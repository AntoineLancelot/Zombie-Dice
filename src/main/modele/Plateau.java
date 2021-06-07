package main.modele;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Plateau {

    //Attributs
    private List<Joueur> joueurs;
    private Niveau niveau;
    private int nbJoueur;

    //Constructeur
    public Plateau(Niveau n, int nbJoueur) {
        this.niveau = n;
        this.nbJoueur = nbJoueur;
    }

    //Méthode(s)
    public void commencer() {
        joueurs = new ArrayList<>();
        for (int i = 0; i < nbJoueur; i++) {
            joueurs.add(new Joueur("Joueur " + (i + 1)));
        }
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public List<Joueur> getJoueursTrie() {
        List<Joueur> j = new ArrayList<>();
        j.addAll(joueurs);
        j.sort(Comparator.comparingInt(Joueur::getScore).reversed());

        return j;
    }
}









