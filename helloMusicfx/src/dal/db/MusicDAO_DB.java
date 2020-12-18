package dal.db;


import be.Music;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicDAO_DB {

    private MyDatabaseConnector databaseConnector;

    public MusicDAO_DB(){
        databaseConnector = new MyDatabaseConnector();
    }

    public List<Music> getAllMusic() {
        ArrayList<Music> allMusic = new ArrayList<>();

        try (Connection connection = databaseConnector.getConnection()){
            String sql = "SELECT * FROM MusicPlaylist";

            Statement statement = connection.createStatement();
            if(statement.execute(sql)){
                ResultSet resultSet = statement.getResultSet();
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    Music music = new Music(id, title);
                    allMusic.add(music);

                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return allMusic;
    }


    public static void main(String[] args) {

        MusicDAO_DB musicDAO_db = new MusicDAO_DB();

        List<Music> allMusic = musicDAO_db.getAllMusic();

        System.out.println(allMusic);
    }




}
