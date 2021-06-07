package main.modele;



import main.Main;

import java.util.ArrayList;
import java.util.List;

public class Gobelet {

    //Attributs
    private List<De> des = new ArrayList<>();
    private int vert;
    private int jaune;
    private int rouge;

    //Constructeur
    public Gobelet() {

        Niveau niveau = Main.getPlateau().getNiveau();

        vert = niveau.getVert();
        jaune = niveau.getJaune();
        rouge = niveau.getRouge();

        for (int i = 0; i < vert; i++) {
            des.add(new De(DeColor.VERT));
        }

        for (int i = 0; i < jaune; i++) {
            des.add(new De(DeColor.JAUNE));
        }

        for (int i = 0; i < rouge; i++) {
            des.add(new De(DeColor.ROUGE));
        }
    }

    public De tirerDe() {

        int nombreAleatoire = (int)(Math.random() * ((des.size()-1) + 1));
        De de = des.get(nombreAleatoire);

        Face face = de.randomFace();

        if (!face.equals(Face.EMPRUNTES)){
            des.remove(nombreAleatoire);
        }
        else {
            DeColor deColor = de.getDeColor();
            switch(deColor){
                case VERT ->  vert--;
                case JAUNE -> jaune--;
                case ROUGE -> rouge--;
            }

        }

        return de;
    }

    public int getVert() {
        return vert;
    }

    public int getJaune() {
        return jaune;
    }

    public int getRouge() {
        return rouge;
    }


}

