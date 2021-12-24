package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    private user OurUser;

    private Boolean flag_reverse=false;
    @FXML
    private ImageView myImage;

    @FXML
    private ImageView orc1;

    @FXML
    private ImageView RedOrc1;

    @FXML
    private ImageView bigHero;
//
//    @FXML
//    private ImageView MovingOrc;
//
//    @FXML
//    private ImageView Pause;

    @FXML
    private ImageView Tap;

    @FXML
    private ImageView chest;

    @FXML
    private ImageView TNT;

    @FXML
    private ImageView I1;

    @FXML
    private ImageView I2;

    @FXML
    private ImageView I3;

    @FXML
    private ImageView I4;

    @FXML
    private ImageView I5;

    @FXML
    private ImageView I6;

    @FXML
    private ImageView I7;

    @FXML
    private ImageView I8;

    @FXML
    private Text score;

    //ImageView I2 = new ImageView();
    //Image image;



    public int Score = 0;
    public boolean flag=true;

    public boolean orcCheck=false;

    Image openChest=new Image(getClass().getResourceAsStream("Openchest.png"));
    Image blast=new Image(getClass().getResourceAsStream("Blast.png"));



    TranslateTransition translate=new TranslateTransition();


    public void Switch(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Pause_menu.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene((root));
        stage.setScene(scene);
        stage.show();
    }
    AnimationTimer collisionTimer=new AnimationTimer() {
        @Override
        public void handle(long l) {
            checkCollisionChest(myImage,chest);
            checkCollisionTNT(myImage,TNT);
          //  checkCollisionOrc(myImage,orc1);
           // checkCollisionPlatform(myImage);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        collisionTimer.start();

        //image = new Image("island.png");

       // I2.setImage(image);

        TranslateTransition t = new TranslateTransition();
        Bounds boundsInScene = I1.localToScene(I1.getBoundsInLocal());
        Bounds boundsInScene2 = I2.localToScene(I2.getBoundsInLocal());
        System.out.println(boundsInScene);
        System.out.println(boundsInScene2);

        t.setNode(myImage);
        t.setDuration(Duration.millis(450));
        t.setCycleCount(TranslateTransition.INDEFINITE);
        t.setByY(-75);
        if(!flag_reverse){
            t.setAutoReverse(true);
        }
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
    public void checkCollisionChest(ImageView myImage,ImageView chest){
        if (myImage.getBoundsInParent().intersects(chest.getBoundsInParent())) {
            chest.setImage(openChest);
        }
    }
    public void checkCollisionOrc(ImageView myImage,ImageView orc1){
        if (myImage.getBoundsInParent().intersects(orc1.getBoundsInParent())) {
//            TranslateTransition t = new TranslateTransition();
//            t.setNode(orc1);
//            t.setDuration(Duration.millis(75));
//            t.setCycleCount(1);
//            t.setByX(orc1.getX() + 200);
//            t.play();
        }
    }

    public void checkCollisionPlatform(ImageView i){

    }
    public void checkCollisionTNT(ImageView myImage,ImageView chest){
        if (myImage.getBoundsInParent().intersects(TNT.getBoundsInParent())) {
            ScaleTransition scale=new ScaleTransition();
            scale.setNode(TNT);
            scale.setDuration(Duration.millis(10));
            scale.setByX(2.0);
            scale.setByY(2.0);
            scale.play();

            TNT.setImage(blast);




        }
    }
    public void move(){
        flag_reverse=true;
        //myImage.setX(myImage.getX()+50);
        TranslateSmooth(myImage,true);
        flag_reverse=true;

        TranslateSmooth(I1,false);
        //I1.setX(I1.getX()-50);

        TranslateSmooth(I2,false);
        TranslateSmooth(I3,false);
        TranslateSmooth(I4,false);

        //I2.setX(I2.getX()-50);
        //I3.setX(I3.getX()-50);
        //I4.setX(I4.getX()-50);
        TranslateSmooth(orc1,false);
        TranslateSmooth(RedOrc1,false);
        TranslateSmooth(TNT,false);
        TranslateSmooth(chest,false);
        /*orc1.setX(orc1.getX()-50);
        RedOrc1.setX(RedOrc1.getX()-50);
        TNT.setX(TNT.getX()-50);
        chest.setX(chest.getX()-50);*/
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

    public void TranslateSmooth(ImageView i,boolean f){
        TranslateTransition t = new TranslateTransition();
        t.setNode(i);
        t.setDuration(Duration.millis(75));
        t.setCycleCount(1);
        if(!f){
            t.setByX(i.getX() - 50);
        }
        else{t.setByX(i.getX() + 50);}
        t.play();
    }
    public boolean collideWithPlatform(ImageView i){
        if (i.getBoundsInParent().intersects(I1.getBoundsInParent())) {
            return true;
        }
        if (i.getBoundsInParent().intersects(I2.getBoundsInParent())) {
            return true;
        }
        if (i.getBoundsInParent().intersects(I3.getBoundsInParent())) {
            return true;
        }
        if (i.getBoundsInParent().intersects(I4.getBoundsInParent())) {
            return true;
        }
        return false;
    }



}
