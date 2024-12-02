package GameMechanics;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class CanBuildList {

    public static int currentBioCost = 0;
    public static int currentMinCost = 0;

    public static void checkBuild(int[] ID){
        BorderPane buildList = new BorderPane();
        VBox buildButtons = new VBox();
        ScrollPane buildScroll = new ScrollPane(buildButtons);
        Button close = new Button("Close");
        Scene BuildScene = new Scene(buildList, 150, 200);
        buildList.setCenter(buildScroll);
        buildList.setBottom(close);


        close.setPrefWidth(150);
        close.setPrefHeight(50);
        close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                MainGameLogic.buildReturnValue(false);
                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
            }
            
        });
            //Neutral
                //Testling
                    if(ID[0] == 0 && ID[1] == 3){
                        Button bioDeposit = new Button("Bio. Deposit (0B/0M)");
                        Button MinDeposit = new Button("Min. Deposit (0B/0M)");
                        Button Testling = new Button("Testling (0B/0M)");
                        buildButtons.getChildren().addAll(bioDeposit, MinDeposit, Testling);

                        bioDeposit.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {0, 1});
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });

                        MinDeposit.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {0, 2});
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                        });

                        Testling.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {0, 3});
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                        });
                    }

            //Faction 1: <NAME>
                //Main Hive
                    if(ID[0] == 1 && ID[1] == 0){

                    }

            //Faction 2: <NAME>
                //Main Hive
                    if(ID[0] == 2 && ID[1] == 0){
                        
                    }

            //Faction 3: <NAME>
                //Main Hive
                    if(ID[0] == 3 && ID[1] == 0){
                        
                    }

            //Faction 4: <NAME>
                //Main Hive
                    if(ID[0] == 4 && ID[1] == 0){
                        
                    }

        
        Stage BuildBox = new Stage();
        BuildBox.setScene(BuildScene);
        BuildBox.setAlwaysOnTop(true);
        BuildBox.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent arg0) {
                MainGameLogic.buildReturnValue(false);
            }
            
        });
        BuildBox.show();
    }

    public static int getCurrentBioCost() {
        return(currentBioCost);
    }

    public static int getCurrentMinCost() {
        return(currentMinCost);
    }

    public static void resetCurrentCost() {
        currentBioCost = 0;
        currentMinCost = 0;
    }
}
