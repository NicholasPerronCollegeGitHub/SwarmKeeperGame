package Menus;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class HowToPlayMenu {
    public static Scene TutorialConst(){
        TitledPane Basics = new TitledPane("Basic Controls", new Label("PUT_GUIDE_HERE"));
        TitledPane Objectives = new TitledPane("Objectives", new Label("PUT_GUIDE_HERE"));
        TitledPane Strategy = new TitledPane("Basic Strategy Tips", new Label("PUT_GUIDE_HERE"));

        VBox factionBox = new VBox();
        TitledPane FactionGuides = new TitledPane("Hive Guides", factionBox);

        TitledPane faction1 = new TitledPane("placehold 1", new Label("PUT_GUIDE_HERE"));
        TitledPane faction2 = new TitledPane("placehold 2", new Label("PUT_GUIDE_HERE"));
        TitledPane faction3 = new TitledPane("placehold 3", new Label("PUT_GUIDE_HERE"));
        TitledPane faction4 = new TitledPane("placehold 4", new Label("PUT_GUIDE_HERE"));
        
        factionBox.getChildren().addAll(faction1,faction2,faction3,faction4);

        Basics.setExpanded(false);
        Objectives.setExpanded(false);
        Strategy.setExpanded(false);
        FactionGuides.setExpanded(false);
        faction1.setExpanded(false);
        faction2.setExpanded(false);
        faction3.setExpanded(false);
        faction4.setExpanded(false);

        Button back = new Button("Back");
        back.setMaxWidth(4000);
        back.setPrefHeight(50);
        back.setCancelButton(true);
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                //((Stage)(((Button)arg0.getSource()).getScene().getWindow())).setScene(StartMenu.mainMenuConst());
                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
            }
            
        });

        VBox InfoBoxes = new VBox();

        ScrollPane list = new ScrollPane(InfoBoxes);
        list.setFitToWidth(true);

        BorderPane contents = new BorderPane();
        contents.setCenter(list);
        contents.setBottom(back);

        InfoBoxes.getChildren().addAll(Basics,Objectives,FactionGuides,Strategy);

        Scene HowToPlay = new Scene(contents, 300, 400);
        return(HowToPlay);
    }
}
