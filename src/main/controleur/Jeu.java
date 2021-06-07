package main.controleur;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;
import main.modele.De;
import main.modele.Face;
import main.modele.Joueur;


import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Jeu implements Initializable {

    int idJoueur = 0;
    int tmpCerveau = 0;
    int tmpFusil = 0;
    boolean fini = false;


    @FXML
    Button lanceDe, tourSuivant, btnScene2;

    @FXML
    Text IdJoueur;

    @FXML
    Label NbCerveau, NbFusil;

    @FXML
    ImageView de1, de2, de3;

    @FXML
    VBox VBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IdJoueur.setText("Joueur " + (idJoueur + 1));
        majScore();
    }

    @FXML
    public void lanceDe(ActionEvent actionEvent) {

        de1.setVisible(true);
        de2.setVisible(true);
        de3.setVisible(true);
        Joueur joueur = Main.getPlateau().getJoueurs().get(idJoueur);

        De d1 = joueur.getGobelet().tirerDe();
        De d2 = joueur.getGobelet().tirerDe();
        De d3 = joueur.getGobelet().tirerDe();

        if (d1.getFace().equals(Face.CERVEAU)) tmpCerveau++;
        if (d1.getFace().equals(Face.FUSIL)) tmpFusil++;

        if (d2.getFace().equals(Face.CERVEAU)) tmpCerveau++;
        if (d2.getFace().equals(Face.FUSIL)) tmpFusil++;

        if (d3.getFace().equals(Face.CERVEAU)) tmpCerveau++;
        if (d3.getFace().equals(Face.FUSIL)) tmpFusil++;

        de1.setImage(new Image(String.valueOf(getClass().getResource(d1.getFace().getImg(d1.getDeColor().name())))));
        de2.setImage(new Image(String.valueOf(getClass().getResource(d2.getFace().getImg(d2.getDeColor().name())))));
        de3.setImage(new Image(String.valueOf(getClass().getResource(d3.getFace().getImg(d3.getDeColor().name())))));

        if (tmpFusil >= 3) {
            tmpCerveau = 0;
            tourSuivant();
        }

        majScore();

    }

    private void majScore() {
        NbCerveau.setText(String.valueOf(tmpCerveau));
        NbFusil.setText(String.valueOf(tmpFusil));
        int count = 1;

        VBox.getChildren().clear();

        for (Joueur j : Main.getPlateau().getJoueursTrie()) {

            try {
                AnchorPane ap = FXMLLoader.load(getClass().getResource("/vue/ScoreBoard.fxml"));
                Text joueurName = (Text) ap.getChildren().get(0);
                joueurName.setText(j.getNom());
                Text st = (Text) ap.getChildren().get(1);
                st.setText(String.valueOf(j.getScore()));

                VBox.getChildren().add(ap);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (j.getScore() >= 13) {
                fini = true;
            }

        }

    }

    public void tourSuivant() {

        de1.setVisible(false);
        de2.setVisible(false);
        de3.setVisible(false);


        Joueur joueur = Main.getPlateau().getJoueurs().get(idJoueur);
        joueur.remplirGlobelet();
        joueur.setScore(tmpCerveau);

        if (Main.getPlateau().getJoueurs().size() == ++idJoueur) idJoueur = 0;
        IdJoueur.setText("Joueur " + (idJoueur + 1));


        tmpCerveau = 0;
        tmpFusil = 0;

        if (0 == idJoueur && fini) {
            tourSuivant.setDisable(true);
            lanceDe.setDisable(true);
            IdJoueur.setText("Partie terminé !");


        }

        majScore();
    }

    public void ChangeScene(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load((getClass().getResource("/vue/Acceuil.fxml")));
        Stage window = (Stage) btnScene2.getScene().getWindow();
        window.setScene(new Scene(root, 750, 610));

    }
}
