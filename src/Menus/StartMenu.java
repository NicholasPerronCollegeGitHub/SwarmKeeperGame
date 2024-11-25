package Menus;

import java.io.FileInputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class StartMenu {
    static public boolean next = false;
    public static Scene mainMenuConst(){
        BorderPane mainMenu = new BorderPane();
        HBox buttonBar = new HBox();

        Button StartGame = new Button("Play");
        Button Tutorial = new Button("How To Play");
        Button Exit = new Button("Exit");
        


        try {
            ImageView Title = new ImageView(new Image(new FileInputStream("src\\Images\\TitleScreen.png")));
            Title.setX(300);
            Title.setY(300);
            mainMenu.setCenter(Title);
        } catch (Exception e) {
            System.out.println("Warning: Title Image Missing");
        }
        

        StartGame.setPrefHeight(50);
        Tutorial.setPrefHeight(50);
        Exit.setPrefHeight(50);

        StartGame.setPrefWidth(100);
        Tutorial.setPrefWidth(100);
        Exit.setPrefWidth(100);
        
        mainMenu.setBottom(buttonBar);

        buttonBar.getChildren().addAll(StartGame, Tutorial, Exit);
        buttonBar.setAlignment(Pos.CENTER);

        Scene Menu = new Scene(mainMenu, 300,400);

        StartGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).setScene(FactionSelect.FactionSelectConst());
            }
            
        });

        Tutorial.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).setScene(HowToPlayMenu.TutorialConst());
            }
            
        });

        Exit.setCancelButton(true);
        Exit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
            }
            
        });

        return(Menu);
    }
}
