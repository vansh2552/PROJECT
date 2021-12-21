package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

public class Controller_PAUSE {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchtoMM(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("mainMenu.FXML"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene((root));
        stage.setScene(scene);
        stage.show();
    }

    public void switchGame(ActionEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("Main.FXML"));
        Parent root= loader.load();
        Controller controller=loader.getController();
        stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);



        scene.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                if(controller.flag)
                    controller.removetap();

                controller.showscore();
                controller.move();
                controller.updateText();
            }
        });
        stage.setScene(scene);
        stage.show();
    }
}
