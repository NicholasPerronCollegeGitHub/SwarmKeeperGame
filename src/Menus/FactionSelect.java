package Menus;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;

import java.io.FileInputStream;

import GameMechanics.MainGameLogic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FactionSelect {

    static Boolean P1Selected = false;
    static Boolean P2Selected = false;
    
    public static Scene FactionSelectConst(){
        BorderPane mainPane = new BorderPane();

        HBox selectContainer = new HBox();

        ScrollPane selectScroll = new ScrollPane(selectContainer);

        Button fac1Select = new Button("Select");
        Button fac2Select = new Button("Select");
        Button fac3Select = new Button("Select");
        Button fac4Select = new Button("Select");
        Button fac1Info = new Button("More Information");
        Button fac2Info = new Button("More Information");
        Button fac3Info = new Button("More Information");
        Button fac4Info = new Button("More Information");
        Button StartGame = new Button("Select Player 1 Faction");

        BorderPane fac1 = new BorderPane();
        BorderPane fac2 = new BorderPane();
        BorderPane fac3 = new BorderPane();
        BorderPane fac4 = new BorderPane();

        VBox fac1Btns = new VBox(fac1Info,fac1Select);
        VBox fac2Btns = new VBox(fac2Info,fac2Select);
        VBox fac3Btns = new VBox(fac3Info,fac3Select);
        VBox fac4Btns = new VBox(fac4Info,fac4Select);

        try {
            ImageView Fac1img = new ImageView(new Image(new FileInputStream("src\\Images\\Fac1prev.png")));
            Fac1img.setX(400);
            Fac1img.setY(300);
            fac1.setCenter(Fac1img);
        } catch (Exception e) {
            System.out.println("Warning: Faction 1 Image Missing");
        }
        try {
            ImageView Fac2img = new ImageView(new Image(new FileInputStream("src\\Images\\Fac2prev.png")));
            Fac2img.setX(400);
            Fac2img.setY(300);
            fac2.setCenter(Fac2img);
        } catch (Exception e) {
            System.out.println("Warning: Faction 2 Image Missing");
        }
        try {
            ImageView Fac3img = new ImageView(new Image(new FileInputStream("src\\Images\\Fac3prev.png")));
            Fac3img.setX(400);
            Fac3img.setY(300);
            fac3.setCenter(Fac3img);
        } catch (Exception e) {
            System.out.println("Warning: Faction 3 Image Missing");
        }
        try {
            ImageView Fac4img = new ImageView(new Image(new FileInputStream("src\\Images\\Fac4prev.png")));
            Fac4img.setX(400);
            Fac4img.setY(300);
            fac4.setCenter(Fac4img);
        } catch (Exception e) {
            System.out.println("Warning: Faction 4 Image Missing");
        }

        fac1.setPrefWidth(400);
        fac2.setPrefWidth(400);
        fac3.setPrefWidth(400);
        fac4.setPrefWidth(400);

        fac1Select.setPrefHeight(49);
        fac1Select.setPrefWidth(400);
        fac1Select.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                if(!P1Selected){
                    MainGameLogic.setP1Fac(1);
                    StartGame.setText("Select Player 2 Faction");
                    P1Selected = true;
                }else if(!P2Selected){
                    MainGameLogic.setP2Fac(1);
                    StartGame.setText("START");
                    StartGame.setDisable(false);
                    
                    fac1Select.setDisable(true);
                    fac2Select.setDisable(true);
                    fac3Select.setDisable(true);
                    fac4Select.setDisable(true);

                    P2Selected = true;
                }
            }
            
        });
        fac1Info.setPrefHeight(25);
        fac1Info.setPrefWidth(400);
        fac1Info.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                 
                BorderPane InfoBorderContainer = new BorderPane();

                VBox InfoContainer = new VBox();

                Scene Information = new Scene(InfoBorderContainer, 300, 400);

                Button close = new Button("Close");
                close.setPrefHeight(50);
                close.setPrefWidth(300);

                close.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                    }
                    
                });

                TitledPane overView = new TitledPane("Overview", new Label("<OVERVIEW_GOES_HERE>"));
                TitledPane strategy = new TitledPane("Strategy", new Label("STRATEGY_GOES_HERE"));
                TitledPane techTree = new TitledPane("Nest Progression", new Label("TECHTREE_GOES_HERE"));
                TitledPane unitList = new TitledPane("Full Unit/Structure List", new Label("UNIT_LIST_GOES_HERE"));

                strategy.setExpanded(false);
                techTree.setExpanded(false);
                unitList.setExpanded(false);

                InfoBorderContainer.setCenter(InfoContainer);
                InfoBorderContainer.setBottom(close);
                InfoContainer.getChildren().addAll(overView, strategy, techTree, unitList);

                Stage InfoBox = new Stage();
                InfoBox.setScene(Information);

                InfoBox.setTitle("More Information");
                try {
                    InfoBox.getIcons().add(new Image(new FileInputStream("src\\Images\\InfoBoxIcon.png")));
                } catch (Exception e) {
                    System.out.println("Warning: InfoBox Icon Missing");
                }
                InfoBox.setAlwaysOnTop(true);
                InfoBox.show();
            }
            
        });


        fac2Select.setPrefHeight(49);
        fac2Select.setPrefWidth(400);
        fac2Select.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                if(!P1Selected){
                    MainGameLogic.setP1Fac(2);
                    StartGame.setText("Select Player 2 Faction");
                    P1Selected = true;
                }else if(!P2Selected){
                    MainGameLogic.setP2Fac(2);
                    StartGame.setText("START");
                    StartGame.setDisable(false);
                    
                    fac1Select.setDisable(true);
                    fac2Select.setDisable(true);
                    fac3Select.setDisable(true);
                    fac4Select.setDisable(true);

                    P2Selected = true;
                }
            }
            
        });
        fac2Info.setPrefHeight(25);
        fac2Info.setPrefWidth(400);
        fac2Info.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                 
                BorderPane InfoBorderContainer = new BorderPane();

                VBox InfoContainer = new VBox();

                Scene Information = new Scene(InfoBorderContainer, 300, 400);

                Button close = new Button("Close");
                close.setPrefHeight(50);
                close.setPrefWidth(300);

                close.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                    }
                    
                });

                TitledPane overView = new TitledPane("Overview", new Label("<OVERVIEW_GOES_HERE>"));
                TitledPane strategy = new TitledPane("Strategy", new Label("STRATEGY_GOES_HERE"));
                TitledPane techTree = new TitledPane("Nest Progression", new Label("TECHTREE_GOES_HERE"));
                TitledPane unitList = new TitledPane("Full Unit/Structure List", new Label("UNIT_LIST_GOES_HERE"));

                strategy.setExpanded(false);
                techTree.setExpanded(false);
                unitList.setExpanded(false);

                InfoBorderContainer.setCenter(InfoContainer);
                InfoBorderContainer.setBottom(close);
                InfoContainer.getChildren().addAll(overView, strategy, techTree, unitList);

                Stage InfoBox = new Stage();
                InfoBox.setScene(Information);

                InfoBox.setTitle("More Information");
                try {
                    InfoBox.getIcons().add(new Image(new FileInputStream("src\\Images\\InfoBoxIcon.png")));
                } catch (Exception e) {
                    System.out.println("Warning: InfoBox Icon Missing");
                }
                InfoBox.setAlwaysOnTop(true);
                InfoBox.show();
            }
            
        });


        fac3Select.setPrefHeight(49);
        fac3Select.setPrefWidth(400);
        fac3Select.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                if(!P1Selected){
                    MainGameLogic.setP1Fac(3);
                    StartGame.setText("Select Player 2 Faction");
                    P1Selected = true;
                }else if(!P2Selected){
                    MainGameLogic.setP2Fac(3);
                    StartGame.setText("START");
                    StartGame.setDisable(false);
                    
                    fac1Select.setDisable(true);
                    fac2Select.setDisable(true);
                    fac3Select.setDisable(true);
                    fac4Select.setDisable(true);

                    P2Selected = true;
                }
            }
            
        });
        fac3Info.setPrefHeight(25);
        fac3Info.setPrefWidth(400);
        fac3Info.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                 
                BorderPane InfoBorderContainer = new BorderPane();

                VBox InfoContainer = new VBox();

                Scene Information = new Scene(InfoBorderContainer, 300, 400);

                Button close = new Button("Close");
                close.setPrefHeight(50);
                close.setPrefWidth(300);

                close.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                    }
                    
                });

                TitledPane overView = new TitledPane("Overview", new Label("<OVERVIEW_GOES_HERE>"));
                TitledPane strategy = new TitledPane("Strategy", new Label("STRATEGY_GOES_HERE"));
                TitledPane techTree = new TitledPane("Nest Progression", new Label("TECHTREE_GOES_HERE"));
                TitledPane unitList = new TitledPane("Full Unit/Structure List", new Label("UNIT_LIST_GOES_HERE"));

                strategy.setExpanded(false);
                techTree.setExpanded(false);
                unitList.setExpanded(false);

                InfoBorderContainer.setCenter(InfoContainer);
                InfoBorderContainer.setBottom(close);
                InfoContainer.getChildren().addAll(overView, strategy, techTree, unitList);

                Stage InfoBox = new Stage();
                InfoBox.setScene(Information);

                InfoBox.setTitle("More Information");
                try {
                    InfoBox.getIcons().add(new Image(new FileInputStream("src\\Images\\InfoBoxIcon.png")));
                } catch (Exception e) {
                    System.out.println("Warning: InfoBox Icon Missing");
                }
                InfoBox.setAlwaysOnTop(true);
                InfoBox.show();
            }
            
        });



        fac4Select.setPrefHeight(49);
        fac4Select.setPrefWidth(400);
        fac4Select.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                if(!P1Selected){
                    MainGameLogic.setP1Fac(4);
                    StartGame.setText("Select Player 2 Faction");
                    P1Selected = true;
                }else if(!P2Selected){
                    MainGameLogic.setP2Fac(4);
                    StartGame.setText("START");
                    StartGame.setDisable(false);
                    
                    fac1Select.setDisable(true);
                    fac2Select.setDisable(true);
                    fac3Select.setDisable(true);
                    fac4Select.setDisable(true);

                    P2Selected = true;
                }
            }
            
        });
        fac4Info.setPrefHeight(25);
        fac4Info.setPrefWidth(400);
        fac4Info.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                 
                BorderPane InfoBorderContainer = new BorderPane();

                VBox InfoContainer = new VBox();

                Scene Information = new Scene(InfoBorderContainer, 300, 400);

                Button close = new Button("Close");
                close.setPrefHeight(50);
                close.setPrefWidth(300);

                close.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                    }
                    
                });

                TitledPane overView = new TitledPane("Overview", new Label("<OVERVIEW_GOES_HERE>"));
                TitledPane strategy = new TitledPane("Strategy", new Label("STRATEGY_GOES_HERE"));
                TitledPane techTree = new TitledPane("Nest Progression", new Label("TECHTREE_GOES_HERE"));
                TitledPane unitList = new TitledPane("Full Unit/Structure List", new Label("UNIT_LIST_GOES_HERE"));

                strategy.setExpanded(false);
                techTree.setExpanded(false);
                unitList.setExpanded(false);

                InfoBorderContainer.setCenter(InfoContainer);
                InfoBorderContainer.setBottom(close);
                InfoContainer.getChildren().addAll(overView, strategy, techTree, unitList);

                Stage InfoBox = new Stage();
                InfoBox.setScene(Information);

                InfoBox.setTitle("More Information");
                try {
                    InfoBox.getIcons().add(new Image(new FileInputStream("src\\Images\\InfoBoxIcon.png")));
                } catch (Exception e) {
                    System.out.println("Warning: InfoBox Icon Missing");
                }
                InfoBox.setAlwaysOnTop(true);
                InfoBox.show();
            }
            
        });


        StartGame.setPrefHeight(75);
        StartGame.setPrefWidth(600);
        StartGame.setDisable(true);

        fac1.setBottom(fac1Btns);
        fac2.setBottom(fac2Btns);
        fac3.setBottom(fac3Btns);
        fac4.setBottom(fac4Btns);

        selectContainer.getChildren().addAll(fac1,fac2,fac3,fac4);


        mainPane.setCenter(selectScroll);
        mainPane.setBottom(StartGame);

        Scene FactionSelect = new Scene(mainPane, 600,465);
        return(FactionSelect);
    }
}
