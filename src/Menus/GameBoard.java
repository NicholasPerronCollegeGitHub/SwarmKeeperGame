package Menus;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameBoard {
    
    public static Scene GameBoardConst(){
        GridPane mapGrid = new GridPane();
        GridPane ordersGrid = new GridPane();
        Button turnButton = new Button();
        Button selectedInfo = new Button("More Information");
        ScrollPane mapScroll = new ScrollPane(mapGrid);
        BorderPane mainContent = new BorderPane();
        BorderPane bottomBar = new BorderPane();
        BorderPane bottomBarMiddle = new BorderPane();
        

    for(int c = 0; c < 20; c++){
        for(int r = 0; r < 20; r++){
            Button mapCell = new Button(Integer.valueOf(c).toString() + "," + Integer.valueOf(r).toString());
            mapCell.setPrefHeight(50);
            mapCell.setPrefWidth(50);
            mapCell.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    int x = (GridPane.getColumnIndex((Button)arg0.getSource()));
                    int y = (GridPane.getRowIndex((Button)arg0.getSource()));
                    System.out.println(x + "," + y);
                }
                
            });
            mapGrid.add(mapCell, c, r);
        }
    }        

        mainContent.setCenter(mapScroll);
        mainContent.setTop(turnButton);
        mainContent.setBottom(bottomBar);
        
        bottomBar.setRight(ordersGrid);
        bottomBar.setLeft(selectedInfo);
        selectedInfo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                BorderPane infoContainer = new BorderPane();
                Button close = new Button("Close");
                VBox infoBox = new VBox();

            TitledPane desc = new TitledPane("Description", new Label("PLACEHOLDER"));
            TitledPane stats = new TitledPane("Stats", new Label("PLACEHOLDER"));
            TitledPane abil = new TitledPane("Abilities", new Label("PLACEHOLDER"));

            stats.setExpanded(false);
            abil.setExpanded(false);

            infoBox.getChildren().addAll(desc, stats, abil);

                close.setPrefWidth(150);
                close.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                    }
                    
                });

                infoContainer.setCenter(infoBox);
                infoContainer.setBottom(close);
                Scene informationWindow = new Scene(infoContainer, 150, 250);
                Stage InfoWindow = new Stage();
                InfoWindow.setScene(informationWindow);
                InfoWindow.show();
            }
            
        });

        Scene gameBoard = new Scene(mainContent, 500, 500);
        return(gameBoard);
    }
}
