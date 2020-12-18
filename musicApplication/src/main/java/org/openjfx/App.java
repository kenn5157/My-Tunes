package org.openjfx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage primaryStage;

    private static String filepathAsString;
    private static String filePath = "/Users/kennethhjort/IdeaProjects/musicApplication/playlist.txt";
    public static ObservableList<String> playlist = FXCollections.observableArrayList();

    public static Stage getPrimaryStage(){
        return primaryStage;
    }
    private void setPrimaryStage(Stage primaryStage){
        App.primaryStage = primaryStage;
    }


    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        setPrimaryStage(primaryStage);

        scene = new Scene(loadFXML("primary"), 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Music Application");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args){
        launch();
        loadPlaylist();
        //addToPlaylist("Some Music");
    }


    //Loads playlist from file
    public static void loadPlaylist() {
        System.out.println("\r\n" + "Loading Playlists..." + "\r\n" + "-----------");
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            playlist.clear();
            while(line!=null) {
                System.out.println(line);
                playlist.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToPlaylist(String text){
        System.out.println("\r\n" + "Adding text to playlist..." + "\r\n" + "-----------");
        try (FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw)) {
            bw.append(text).append("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    //Main Actions

        //Play & Pause
    public static void playPause(){
        
    }

        //File chooser for choosing the playlist file
    public static void choosePlaylist() {
        System.out.println("\r\n" + "Choose Which Playlist File..." + "\r\n" + "--------------");
        FileChooser fc = new FileChooser();
        fc.setInitialFileName("Playlist.txt");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fc.showOpenDialog(primaryStage);
        //System.out.println(selectedFile);
        if (selectedFile!=null){
            filepathAsString = selectedFile.getAbsolutePath();
            filePath = filepathAsString;
            System.out.println(filepathAsString);
            loadPlaylist();
        }
    }

        //Creates new playlist
    public static void createPlaylist() throws IOException {
        Scene newScene = new Scene(loadFXML("userInputBox"),310, 50);
        Stage newWindow = new Stage();
        newWindow.setTitle("Name For New Playlist");
        newWindow.setScene(newScene);
        newWindow.show();
    }






    //Menu Actions



    public static void newAppWindow() throws IOException {
        Scene newScene = new Scene(loadFXML("primary"), 1200, 700);

        Stage newWindow = new Stage();
        newWindow.setTitle("Music Application");
        newWindow.setScene(newScene);

        newWindow.show();
    }

    public static void quit() {
        System.out.println("Closing Program...");
        System.exit(0);
    }

}