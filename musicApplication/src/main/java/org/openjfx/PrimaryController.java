package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController extends App implements Initializable{
    public ListView<String> playlists;


    //Main Actions
    @FXML
    private void newPlaylist() throws IOException {
        App.createPlaylist();
        //playlists.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    private void deletePlaylist(){

    }

    @FXML
    private void editPlaylist() {
        playlists.setItems(App.playlist);
    }

    //Menu Items

    //File Menu
    @FXML
    private void newStart() throws IOException {
        App.newAppWindow();
    }

    @FXML
    private void newQuit() {
        App.quit();
    }

    @FXML
    public void loadPlaylist(ActionEvent actionEvent) {
        App.choosePlaylist();
        //App.loadPlaylist();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playlists.setItems(App.playlist);
        App.loadPlaylist();
    }

    public void playPauseMusic(ActionEvent event) {

    }
}
