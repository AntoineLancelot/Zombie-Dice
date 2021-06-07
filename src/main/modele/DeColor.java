package main.modele;

public enum DeColor {

    VERT(3,2,1), JAUNE(2,2,2), ROUGE(1,2,3);

    //Attributs
    private int cerveau;
    private int emprunte;
    private int fusil;

    //Constructeur
    DeColor (int cerveau, int emprunte, int fusil) {
        this.cerveau=cerveau;
        this.emprunte=emprunte;
        this.fusil=fusil;
    }

    //Méthode(s)
    public int getCerveau() {
        return cerveau;
    }

    public int getEmprunte() {
        return emprunte;
    }

    public int getFusil() {
        return fusil;
    }

}
