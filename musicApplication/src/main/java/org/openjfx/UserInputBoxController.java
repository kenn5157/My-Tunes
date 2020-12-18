package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class UserInputBoxController extends App {

    //@FXML private Button cancel;
    //@FXML private Button accept;
    @FXML private TextField listName;

    @FXML
    private void handleCancelButtonOnAction(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    private void acceptPlaylistName(ActionEvent event) {
        String string = listName.getText();
        App.addToPlaylist(string);
        App.loadPlaylist();
        //App.populatePlaylist();
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

}
