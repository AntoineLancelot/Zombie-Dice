package main.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import main.Main;
import main.modele.Niveau;
import main.modele.Plateau;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Acceuil implements Initializable {

    @FXML
    Button btnScene1,btnQuit;

    @FXML
    RadioButton facile,moyen,difficile;

    @FXML
    TextField Nbjoueur;

    @FXML
    public void ChangeScene(ActionEvent Event) throws IOException {


        int Nb = Integer.parseInt(Nbjoueur.getText());



        if (facile.isSelected()) {
            Plateau plateau = new Plateau(Niveau.FACILE,Nb);
            Main.setPlateau(plateau);
        }

        if (moyen.isSelected()) {
            Main.setPlateau(new Plateau(Niveau.MOYEN,Nb));
        }

        if (difficile.isSelected()) {
            Main.setPlateau(new Plateau(Niveau.DIFFICILE,Nb));
        }

        if(Nb<=6) {
            Main.getPlateau().commencer();
        }

        Parent root = FXMLLoader.load((getClass().getResource("/vue/Jeu.fxml")));
        Stage window = (Stage) btnScene1.getScene().getWindow();
        window.setScene(new Scene(root,800,780));

    }

    @FXML
    public void QuitBtn(ActionEvent actionEvent) {
        Stage stage = (Stage) btnQuit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        facile.setToggleGroup(group);
        moyen.setToggleGroup(group);
        difficile.setToggleGroup(group);

    }

}
