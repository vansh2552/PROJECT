package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Contoller2  {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Stage stage2;
    private Scene scene2;
    private Parent root2;


    public void Switch(ActionEvent event) throws IOException {
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
    public void SwitchtoExit(ActionEvent event) throws IOException {
        Parent root2= FXMLLoader.load(getClass().getResource("Exit.FXML"));
        stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene2=new Scene((root2));
        stage2.setScene(scene2);
        stage2.show();
    }


}
