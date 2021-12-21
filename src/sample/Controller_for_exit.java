package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_for_exit {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Button closeButton;

    public void SwitchToMM(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("mainMenu.FXML"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene((root));
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
