package gui;

import javafx.event.ActionEvent;

import java.io.IOException;

public class Controller {

    public void playMusic(ActionEvent actionEvent) throws IOException {
        //Main.playMusic();
        Main.setRoot("view/VideoPlayback");
    }
}
