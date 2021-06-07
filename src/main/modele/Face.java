package main.modele;

public enum Face {

    CERVEAU("cerveau.png"), EMPRUNTES( "empreinte.png"), FUSIL( "fusil.png");

    //Attributs
    private final String img;

    //Constructeur
    Face (String img) {
        this.img=img;
    }

    //Méthode(s)
    public String getImg(String couleur) {
        return "/main/resources/img/" + couleur.toLowerCase() + "_" + img;
    }
}
