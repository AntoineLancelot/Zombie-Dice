package main.modele;


import java.util.ArrayList;
import java.util.List;

public class De {

    //Attributs
    private List<Face> faces;
    private DeColor deColor;
    private Face face;

    //Constructeur
    public De(DeColor deColor){

        this.deColor=deColor;
        faces = new ArrayList<>();
        int cerveau = deColor.getCerveau();
        int emprunte = deColor.getEmprunte();
        int fusil = deColor.getFusil();

        for (int i = 0; i < cerveau; i++) {
            faces.add(Face.CERVEAU);
        }

        for (int i = 0; i < emprunte; i++) {
            faces.add(Face.EMPRUNTES);
        }

        for (int i = 0; i < fusil; i++) {
            faces.add(Face.FUSIL);
        }
    }


    //Méthode(s)
    public Face randomFace(){
        int nombreAleatoire = (int)(Math.random() * ((faces.size()-1) + 1));

        face = faces.get(nombreAleatoire);

        return face;
    }

    public DeColor getDeColor() {
        return deColor;
    }

    public Face getFace() { return face; }

}
