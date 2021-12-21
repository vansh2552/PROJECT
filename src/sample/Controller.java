package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ImageView myImage;

    @FXML
    private ImageView orc1;

    @FXML
    private ImageView RedOrc1;

    @FXML
    private ImageView bigHero;

    @FXML
    private ImageView MovingOrc;

    @FXML
    private ImageView Pause;

    @FXML
    private ImageView Tap;

    @FXML
    private Text score;
    public int Score = 0;
    public boolean flag=true;


    TranslateTransition translate=new TranslateTransition();



    public void Switch(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Pause_menu.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene((root));
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        TranslateTransition t = new TranslateTransition();

        t.setNode(myImage);
        t.setDuration(Duration.millis(450));
        t.setCycleCount(TranslateTransition.INDEFINITE);
        t.setByY(-75);
        t.setAutoReverse(true);
        t.play();

        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(orc1);
        translate1.setDuration(Duration.millis(450));
        translate1.setCycleCount(TranslateTransition.INDEFINITE);
        translate1.setByY(-75);
        translate1.setAutoReverse(true);
        translate1.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(RedOrc1);
        translate2.setDuration(Duration.millis(450));
        translate2.setCycleCount(TranslateTransition.INDEFINITE);
        translate2.setByY(-75);
        translate2.setAutoReverse(true);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(bigHero);
        translate3.setDuration(Duration.millis(450));
        translate3.setCycleCount(TranslateTransition.INDEFINITE);
        translate3.setByY(-100);
        translate3.setAutoReverse(true);
        translate3.play();

    }
    public void move(){
        myImage.setX(myImage.getX()+100);
    }
    public void updateText(){
       Score+=1;
       score.setText(String.valueOf(Score));

    }
    public void removetap(){
        FadeTransition fadeTransition= new FadeTransition(Duration.millis(500), Tap) ;
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        fadeTransition.setFromValue(0.0);
        this.flag=false;
    }

    public void showscore(){
        FadeTransition fadeTransition= new FadeTransition(Duration.millis(500), score) ;
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
        fadeTransition.setFromValue(0.0);

    }


}
