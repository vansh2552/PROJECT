package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.Serializable;


public class Main extends Application /*implements Serializable*/ {
    public static Stage stage;
    public static Scene scene;
    public static Parent root;
    public static user OurUser;

    //hello bro
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        try{

             root= FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            scene=new Scene((root));
            stage.setScene(scene);
            stage.show();


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
