package JavaFX;
import Objects.Movie;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pachetDao.MovieDao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Interfata extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        javafx.scene.text.Text category = new Text("Movies");
        category.setLayoutX(240);
        category.setLayoutY(20);
        Pane root = new Pane();

        javafx.scene.text.Text text1 = new Text("id");
        text1.setLayoutX(350);
        text1.setLayoutY(120);
        javafx.scene.text.Text text2 = new Text("title");
        text2.setLayoutX(350);
        text2.setLayoutY(160);
        javafx.scene.text.Text text3 = new Text("date");
        text3.setLayoutX(350);
        text3.setLayoutY(200);
        javafx.scene.text.Text text4 = new Text("duration");
        text4.setLayoutX(350);
        text4.setLayoutY(240);
        javafx.scene.text.Text text5 = new Text("score");
        text5.setLayoutX(350);
        text5.setLayoutY(280);
        javafx.scene.control.TextArea textArea1=new TextArea();
        textArea1.setMaxHeight(20);
        textArea1.setMaxWidth(80);
        textArea1.setLayoutX(400);
        textArea1.setLayoutY(100);
        javafx.scene.control.TextArea textArea2=new TextArea();
        textArea2.setMaxHeight(20);
        textArea2.setMaxWidth(80);
        textArea2.setLayoutX(400);
        textArea2.setLayoutY(140);
        javafx.scene.control.TextArea textArea3=new TextArea();
        textArea3.setMaxHeight(5);
        textArea3.setMaxWidth(80);
        textArea3.setLayoutX(400);
        textArea3.setLayoutY(180);
        javafx.scene.control.TextArea textArea4=new TextArea();
        textArea4.setMaxHeight(20);
        textArea4.setMaxWidth(80);
        textArea4.setLayoutX(400);
        textArea4.setLayoutY(220);
        javafx.scene.control.TextArea textArea5=new TextArea();
        textArea5.setMaxHeight(5);
        textArea5.setMaxWidth(80);
        textArea5.setLayoutX(400);
        textArea5.setLayoutY(260);
        javafx.scene.text.Text text = new Text();
        javafx.scene.control.Button btn1 = new Button();
        btn1.setText("Select");
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MovieDao movieDao=new MovieDao();
                Movie movie=new Movie();
                String id=textArea1.getText().trim();
                String title=textArea2.getText().trim();
                if(!id.equals(new String(""))) {
                    try {
                        movie=movieDao.getById(Integer.parseInt(id));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        text.setText("Acest camp nu exista!");
                        text.setLayoutX(160);
                        text.setLayoutY(450);
                        root.getChildren().add(text);
                    }

                    LocalDate localDate = movie.getRelease_date();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                    String formattedString = localDate.format(formatter);
                    text.setText("ID: "+ movie.getId()+" Title: "+movie.getTitle()+" Date: "+ formattedString+" Duration: "+ movie.getDuration()+" Score: "+movie.getScore());
                    text.setLayoutX(80);
                    text.setLayoutY(450);
                    root.getChildren().add(text);
                }
                else
                    if(!title.equals(new String(""))) {
                        try {
                            movie=movieDao.getByName(title);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        LocalDate localDate = movie.getRelease_date();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                        String formattedString = localDate.format(formatter);
                        text.setText("ID: "+ movie.getId()+" Title: "+movie.getTitle()+" Date: "+ formattedString+" Duration: "+ movie.getDuration()+" Score: "+movie.getScore());
                        text.setLayoutX(80);
                        text.setLayoutY(450);
                        root.getChildren().add(text);
                    }
                    else {
                        text.setText("Id-ul sau Title trebuie sa fie completate");
                        text.setLayoutX(160);
                        text.setLayoutY(450);
                        root.getChildren().add(text);
                    }

            }
        });

        Button btn2 = new Button();
        btn2.setText("Insert");
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MovieDao movieDao=new MovieDao();
                Movie movie=new Movie();
                String id=textArea1.getText().trim();
                String title=textArea2.getText().trim();
                String date=textArea3.getText().trim();
                String duration=textArea4.getText().trim();
                String score=textArea5.getText().trim();
                if(id.equals(new String("")) || title.equals(new String(""))
                   || date.equals(new String("")) || duration.equals(new String(""))
                   || score.equals(new String(""))){

                    text.setText("Toate campurile trebuie completate!");
                    text.setLayoutX(160);
                    text.setLayoutY(450);
                    root.getChildren().add(text);
                }
                else {
                    movie.setId(Integer.parseInt(id));
                    movie.setTitle(title);
                    movie.setRelease_date(LocalDate.parse(date));
                    movie.setDuration(Integer.parseInt(duration));
                    movie.setScore(Integer.parseInt(score));
                    try {
                        movieDao.insert(movie);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    text.setText("Camp adaugat cu succes!");
                    text.setLayoutX(160);
                    text.setLayoutY(450);
                    root.getChildren().add(text);
                }
            }
        });

        Button btn3 = new Button();
        btn3.setText("Delete");
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MovieDao movieDao = new MovieDao();
                Movie movie = new Movie();
                String id = textArea1.getText().trim();
                if (!id.equals(new String(""))) {
                    try {
                        movieDao.delete(Integer.parseInt(id));
                        text.setText("Camp eliminat cu succes!");
                        text.setLayoutX(160);
                        text.setLayoutY(450);
                        root.getChildren().add(text);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                else{
                    text.setText("Campul Id trebuie sa fie completat!");
                    text.setLayoutX(160);
                    text.setLayoutY(450);
                    root.getChildren().add(text);
                }
            }
        });
        btn1.setMinWidth(80);
        btn1.setLayoutX(100);
        btn1.setLayoutY(115);
        btn2.setMinWidth(80);
        btn2.setLayoutX(100);
        btn2.setLayoutY(150);
        btn3.setMinWidth(80);
        btn3.setLayoutX(100);
        btn3.setLayoutY(185);

        root.getChildren().add(category);
        root.getChildren().add(textArea1);
        root.getChildren().add(textArea2);
        root.getChildren().add(textArea3);
        root.getChildren().add(textArea4);
        root.getChildren().add(textArea5);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        Scene scene = new Scene(root, 500, 500);


        primaryStage.setTitle("Movies");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}