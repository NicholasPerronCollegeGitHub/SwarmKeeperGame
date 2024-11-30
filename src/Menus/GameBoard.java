package Menus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import GameMechanics.MainGameLogic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameBoard {
    
    static int[] selectLoc = {0,0};
    public static Scene GameBoardConst(){
        GridPane mapGrid = new GridPane();
        GridPane ordersGrid = new GridPane();
        Button turnButton = new Button();
        Button selectedInfo = new Button("More Information");
        ScrollPane mapScroll = new ScrollPane(mapGrid);
        BorderPane mainContent = new BorderPane();
        BorderPane bottomBar = new BorderPane();
        BorderPane bottomBarMiddle = new BorderPane();
        Label textOutput = new Label("Turn Start");
        ImageView previewImage = new ImageView();
        try {
            Image prevImg = new Image(new FileInputStream("src\\Images\\Gameplay\\MapTiles\\Portrait\\UnknownTilePortrait.png"));
            previewImage.setImage(prevImg);
        } catch (FileNotFoundException e) {
            System.out.println("Warning: Image Portrait File Missing");
        }
        

    for(int c = 0; c < 20; c++){
        for(int r = 0; r < 20; r++){
            Button mapCell = new Button();
            mapCell.setPrefHeight(50);
            mapCell.setPrefWidth(50);
            try {
                mapCell.setGraphic(new ImageView(new Image(new FileInputStream("src\\Images\\Gameplay\\MapTiles\\GamePiece\\UnknownTile.png"))));
            } catch (FileNotFoundException e) {
                System.out.println("Warning: One or More Tile Images are Missing");
            }
            mapCell.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    int x = (GridPane.getColumnIndex((Button)arg0.getSource()));
                    int y = (GridPane.getRowIndex((Button)arg0.getSource()));
                    int[] coords = {x,y};
                    MainGameLogic.SelectLoc(coords);
                    selectLoc = coords;
                    try {
                        Image prevImg = new Image(new FileInputStream(MainGameLogic.getBoardStateatLoc(selectLoc).getPortraitPath()));
                        previewImage.setImage(prevImg);
                    } catch (FileNotFoundException e) {
                        System.out.println("Warning: Image Portrait File Missing");
                    }
                    for(int a = 0 ; a < 20; a ++){
                        for(int b = 0; b < 20; b ++){
                            try {
                                
                                ((Button)mapGrid.getChildren().get(a + (b * 20))).setGraphic(new ImageView(new Image(new FileInputStream(MainGameLogic.getBoardStateatLoc(new int[] {a , b}).getTilePath()))));
                            } catch (FileNotFoundException e) {
                                System.out.println("Warning: Tile Image Missing");
                            };
                        }
                    }
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
        bottomBar.setCenter(bottomBarMiddle);
        selectedInfo.setPrefHeight(100);
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

        bottomBarMiddle.setBottom(textOutput);
        bottomBarMiddle.setLeft(previewImage);

        Scene gameBoard = new Scene(mainContent, 500, 500);
        return(gameBoard);
    }
}
