package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.modele.Plateau;

public class Main extends Application {

    private static Plateau plateau;

    public static Plateau getPlateau() {
        return plateau;
    }

    public static void setPlateau(Plateau plateau) {
        Main.plateau = plateau;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load((getClass().getResource("/vue/Acceuil.fxml")));
        primaryStage.setTitle("Zombie Dice");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 750, 610));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
        
    }

}
