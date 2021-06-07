package main.modele;

public enum Niveau {

    FACILE(8,3,2), MOYEN(6,4,3), DIFFICILE(4,5,4);

    //Attributs
    private int vert;
    private int jaune;
    private int rouge;

    //Constructeur
    Niveau(int vert, int jaune, int rouge) {
        this.vert=vert;
        this.jaune=jaune;
        this.rouge=rouge;
    }

    //Getter&Setters
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
