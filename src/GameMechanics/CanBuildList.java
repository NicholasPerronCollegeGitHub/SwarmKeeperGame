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

            //Faction 1: terraxii
                //Main Hive
                    if(ID[0] == 1 && ID[1] == 0){
                        Button worker = new Button("Serf (worker) 5B/0M");
                        Button scout = new Button("Vanguard (scout) 5B/5M");
                        buildButtons.getChildren().addAll(worker, scout);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 0){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 0){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 5){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 5){
                                worker.setDisable(true);
                            }
                        }
                        worker.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {1, 6});
                                MainGameLogic.buildReturnValue(true);
                                currentBioCost = 5;
                                currentMinCost = 0;
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                        scout.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {1, 7});
                                currentBioCost = 5;
                                currentMinCost = 5;
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                    }
                //worker
                    if(ID[0] == 1 && ID[1] == 6){
                        Button BioHarvest = new Button("Biomass Harvester 5B/5M");
                        Button MinHarvest = new Button("Mineral Harvester 5B/5M");
                        Button BasicWarDen = new Button("Lanceling spawning pool 25B/0M");
                        Button RangedWarDen = new Button("Arbalest nest 30B/20M");
                        Button HeavyWarDen = new Button("Tyrant Den 50B/50M");
                        buildButtons.getChildren().addAll(BioHarvest,MinHarvest,BasicWarDen,RangedWarDen,HeavyWarDen);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 5){
                                BioHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 5){
                                MinHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 25 || MainGameLogic.P1Min < 0){
                                BasicWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 30 || MainGameLogic.P1Min < 20){
                                RangedWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 50 || MainGameLogic.P1Min < 50){
                                HeavyWarDen.setDisable(true);
                            }
                        } else if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 5){
                                BioHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 5){
                                MinHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 25 || MainGameLogic.P2Min < 0){
                                BasicWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 30 || MainGameLogic.P2Min < 20){
                                RangedWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 50 || MainGameLogic.P2Min < 50){
                                HeavyWarDen.setDisable(true);
                            }
                            
                        }
                        BioHarvest.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 5;
                                    currentMinCost = 5;
                                    MainGameLogic.UnitCreate(new int[] {1,1});
                                    MainGameLogic.constructionSpecialMode = 1;
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            MinHarvest.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 5;
                                    currentMinCost = 5;
                                    MainGameLogic.UnitCreate(new int[] {1,2});
                                    MainGameLogic.constructionSpecialMode = 2;
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            BasicWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 25;
                                    currentMinCost = 0;
                                    MainGameLogic.UnitCreate(new int[] {1,3});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            RangedWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 30;
                                    currentMinCost = 20;
                                    MainGameLogic.UnitCreate(new int[] {1,4});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            HeavyWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 50;
                                    currentMinCost = 50;
                                    MainGameLogic.UnitCreate(new int[] {1,5});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                    }
                //Basic Warrior Den
                    if(ID[0] == 1 && ID[1] == 3){
                        Button BuildWarrior = new Button("Lanceling 5B/0M");
                        buildButtons.getChildren().add(BuildWarrior);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 0){
                                BuildWarrior.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 0){
                                BuildWarrior.setDisable(true);
                            }
                        }
                        BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                currentBioCost = 5;
                                currentMinCost = 0;
                                MainGameLogic.UnitCreate(new int[] {1,8});
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                    }
                //Ranged Warrior Den
                if(ID[0] == 1 && ID[1] == 4){
                    Button BuildWarrior = new Button("Arbalest 15B/0M");
                    buildButtons.getChildren().add(BuildWarrior);
                    if(MainGameLogic.getCurrentTurn() == 1){
                        if(MainGameLogic.P1Bio < 15 || MainGameLogic.P1Min < 0){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    if(MainGameLogic.getCurrentTurn() == 2){
                        if(MainGameLogic.P2Bio < 15 || MainGameLogic.P2Min < 0){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent arg0) {
                            currentBioCost = 15;
                            currentMinCost = 0;
                            MainGameLogic.UnitCreate(new int[] {1,9});
                            MainGameLogic.buildReturnValue(true);
                            ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                        }
                        
                    });
                }
                //Heavy Warrior Den
                if(ID[0] == 1 && ID[1] == 5){
                    Button BuildWarrior = new Button("Tyrant 25B/30M");
                    buildButtons.getChildren().add(BuildWarrior);
                    if(MainGameLogic.getCurrentTurn() == 1){
                        if(MainGameLogic.P1Bio < 25 || MainGameLogic.P1Min < 30){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    if(MainGameLogic.getCurrentTurn() == 2){
                        if(MainGameLogic.P2Bio < 25 || MainGameLogic.P2Min < 30){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent arg0) {
                            currentBioCost = 25;
                            currentMinCost = 30;
                            MainGameLogic.UnitCreate(new int[] {1,10});
                            MainGameLogic.buildReturnValue(true);
                            ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                        }
                        
                    });
                }

            //Faction 2: Fortis
                //Main Hive
                    if(ID[0] == 2 && ID[1] == 0){
                        Button worker = new Button("Engineer (worker) 5B/0M");
                        Button scout = new Button("Wayfinder (scout) 5B/5M");
                        buildButtons.getChildren().addAll(worker, scout);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 0){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 0){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 5){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 5){
                                worker.setDisable(true);
                            }
                        }
                        worker.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {2, 6});
                                MainGameLogic.buildReturnValue(true);
                                currentBioCost = 5;
                                currentMinCost = 0;
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                        scout.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {2, 7});
                                currentBioCost = 5;
                                currentMinCost = 5;
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                    }
                    if(ID[0] == 2 && ID[1] == 6){
                        Button BioHarvest = new Button("Biomass Harvester 5B/5M");
                        Button MinHarvest = new Button("Mineral Harvester 5B/5M");
                        Button BasicWarDen = new Button("Scorpio Lair 25B/0M");
                        Button RangedWarDen = new Button("Ballista Warren 30B/20M");
                        Button HeavyWarDen = new Button("Trebuchet Cavern 50B/50M");
                        buildButtons.getChildren().addAll(BioHarvest,MinHarvest,BasicWarDen,RangedWarDen,HeavyWarDen);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 5){
                                BioHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 5){
                                MinHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 25 || MainGameLogic.P1Min < 0){
                                BasicWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 30 || MainGameLogic.P1Min < 20){
                                RangedWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 50 || MainGameLogic.P1Min < 50){
                                HeavyWarDen.setDisable(true);
                            }
                        } else if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 5){
                                BioHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 5){
                                MinHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 25 || MainGameLogic.P2Min < 0){
                                BasicWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 30 || MainGameLogic.P2Min < 20){
                                RangedWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 50 || MainGameLogic.P2Min < 50){
                                HeavyWarDen.setDisable(true);
                            }
                            
                        }
                        BioHarvest.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 5;
                                    currentMinCost = 5;
                                    MainGameLogic.UnitCreate(new int[] {2,1});
                                    MainGameLogic.constructionSpecialMode = 1;
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            MinHarvest.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 5;
                                    currentMinCost = 5;
                                    MainGameLogic.UnitCreate(new int[] {2,2});
                                    MainGameLogic.constructionSpecialMode = 2;
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            BasicWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 25;
                                    currentMinCost = 0;
                                    MainGameLogic.UnitCreate(new int[] {2,3});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            RangedWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 30;
                                    currentMinCost = 20;
                                    MainGameLogic.UnitCreate(new int[] {2,4});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            HeavyWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 50;
                                    currentMinCost = 50;
                                    MainGameLogic.UnitCreate(new int[] {2,5});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                    }
                    //Basic Warrior Den
                    if(ID[0] == 2 && ID[1] == 3){
                        Button BuildWarrior = new Button("Scorpio 10B/5M");
                        buildButtons.getChildren().add(BuildWarrior);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 10 || MainGameLogic.P1Min < 5){
                                BuildWarrior.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 10 || MainGameLogic.P2Min < 5){
                                BuildWarrior.setDisable(true);
                            }
                        }
                        BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                currentBioCost = 10;
                                currentMinCost = 5;
                                MainGameLogic.UnitCreate(new int[] {2,8});
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                    }
                //Ranged Warrior Den
                if(ID[0] == 2 && ID[1] == 4){
                    Button BuildWarrior = new Button("Ballista 30B/15M");
                    buildButtons.getChildren().add(BuildWarrior);
                    if(MainGameLogic.getCurrentTurn() == 1){
                        if(MainGameLogic.P1Bio < 30 || MainGameLogic.P1Min < 15){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    if(MainGameLogic.getCurrentTurn() == 2){
                        if(MainGameLogic.P2Bio < 30 || MainGameLogic.P2Min < 15){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent arg0) {
                            currentBioCost = 30;
                            currentMinCost = 15;
                            MainGameLogic.UnitCreate(new int[] {2,9});
                            MainGameLogic.buildReturnValue(true);
                            ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                        }
                        
                    });
                }
                //Heavy Warrior Den
                if(ID[0] == 2 && ID[1] == 5){
                    Button BuildWarrior = new Button("Trebuchet 40B/50M");
                    buildButtons.getChildren().add(BuildWarrior);
                    if(MainGameLogic.getCurrentTurn() == 1){
                        if(MainGameLogic.P1Bio < 40 || MainGameLogic.P1Min < 50){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    if(MainGameLogic.getCurrentTurn() == 2){
                        if(MainGameLogic.P2Bio < 40 || MainGameLogic.P2Min < 50){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent arg0) {
                            currentBioCost = 40;
                            currentMinCost = 50;
                            MainGameLogic.UnitCreate(new int[] {2,10});
                            MainGameLogic.buildReturnValue(true);
                            ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                        }
                        
                    });
                }


            //Faction 3: Vespidian
                //Main Hive
                    if(ID[0] == 3 && ID[1] == 0){
                        Button worker = new Button("Bee (worker) 5B/0M");
                        Button scout = new Button("Dragonfly (scout) 5B/5M");
                        buildButtons.getChildren().addAll(worker, scout);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 0){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 0){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 5){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 5){
                                worker.setDisable(true);
                            }
                        }
                        worker.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {3, 6});
                                MainGameLogic.buildReturnValue(true);
                                currentBioCost = 5;
                                currentMinCost = 0;
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                        scout.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {3, 7});
                                currentBioCost = 5;
                                currentMinCost = 5;
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                    }
                    if(ID[0] == 3 && ID[1] == 6){
                        Button BioHarvest = new Button("Biomass Harvester 5B/5M");
                        Button MinHarvest = new Button("Mineral Harvester 5B/5M");
                        Button BasicWarDen = new Button("Locust Nest 25B/0M");
                        Button RangedWarDen = new Button("Mosquito Aerie 30B/20M");
                        Button HeavyWarDen = new Button("Hornet Spire 50B/50M");
                        buildButtons.getChildren().addAll(BioHarvest,MinHarvest,BasicWarDen,RangedWarDen,HeavyWarDen);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 5){
                                BioHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 5 || MainGameLogic.P1Min < 5){
                                MinHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 25 || MainGameLogic.P1Min < 0){
                                BasicWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 30 || MainGameLogic.P1Min < 20){
                                RangedWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 50 || MainGameLogic.P1Min < 50){
                                HeavyWarDen.setDisable(true);
                            }
                        } else if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 5){
                                BioHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 5 || MainGameLogic.P2Min < 5){
                                MinHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 25 || MainGameLogic.P2Min < 0){
                                BasicWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 30 || MainGameLogic.P2Min < 20){
                                RangedWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 50 || MainGameLogic.P2Min < 50){
                                HeavyWarDen.setDisable(true);
                            }
                            
                        }
                        BioHarvest.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 5;
                                    currentMinCost = 5;
                                    MainGameLogic.UnitCreate(new int[] {3,1});
                                    MainGameLogic.constructionSpecialMode = 1;
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            MinHarvest.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 5;
                                    currentMinCost = 5;
                                    MainGameLogic.UnitCreate(new int[] {3,2});
                                    MainGameLogic.constructionSpecialMode = 2;
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            BasicWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 25;
                                    currentMinCost = 0;
                                    MainGameLogic.UnitCreate(new int[] {3,3});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            RangedWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 30;
                                    currentMinCost = 20;
                                    MainGameLogic.UnitCreate(new int[] {3,4});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            HeavyWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 50;
                                    currentMinCost = 50;
                                    MainGameLogic.UnitCreate(new int[] {3,5});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                    }
                    //Basic Warrior Den
                    if(ID[0] == 3 && ID[1] == 3){
                        Button BuildWarrior = new Button("Locust 10B/0M");
                        buildButtons.getChildren().add(BuildWarrior);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 10 || MainGameLogic.P1Min < 0){
                                BuildWarrior.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 10 || MainGameLogic.P2Min < 0){
                                BuildWarrior.setDisable(true);
                            }
                        }
                        BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                currentBioCost = 10;
                                currentMinCost = 0;
                                MainGameLogic.UnitCreate(new int[] {3,8});
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                    }
                //Ranged Warrior Den
                if(ID[0] == 3 && ID[1] == 4){
                    Button BuildWarrior = new Button("Mosquito 20B/5M");
                    buildButtons.getChildren().add(BuildWarrior);
                    if(MainGameLogic.getCurrentTurn() == 1){
                        if(MainGameLogic.P1Bio < 20 || MainGameLogic.P1Min < 5){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    if(MainGameLogic.getCurrentTurn() == 2){
                        if(MainGameLogic.P2Bio < 20 || MainGameLogic.P2Min < 5){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent arg0) {
                            currentBioCost = 20;
                            currentMinCost = 5;
                            MainGameLogic.UnitCreate(new int[] {3,9});
                            MainGameLogic.buildReturnValue(true);
                            ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                        }
                        
                    });
                }
                //Heavy Warrior Den
                if(ID[0] == 3 && ID[1] == 5){
                    Button BuildWarrior = new Button("Hornet 40B/25M");
                    buildButtons.getChildren().add(BuildWarrior);
                    if(MainGameLogic.getCurrentTurn() == 1){
                        if(MainGameLogic.P1Bio < 40 || MainGameLogic.P1Min < 25){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    if(MainGameLogic.getCurrentTurn() == 2){
                        if(MainGameLogic.P2Bio < 40 || MainGameLogic.P2Min < 25){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent arg0) {
                            currentBioCost = 40;
                            currentMinCost = 25;
                            MainGameLogic.UnitCreate(new int[] {3,10});
                            MainGameLogic.buildReturnValue(true);
                            ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                        }
                        
                    });
                }

                    

            //Faction 4: Crystallid
                //Main Hive
                    if(ID[0] == 4 && ID[1] == 0){
                        Button worker = new Button("Nucleator (worker) 0B/5M");
                        Button scout = new Button("Lens (scout) 0B/5M");
                        buildButtons.getChildren().addAll(worker, scout);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 0 || MainGameLogic.P1Min < 5){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 0 || MainGameLogic.P2Min < 5){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 0 || MainGameLogic.P1Min < 5){
                                worker.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 0 || MainGameLogic.P2Min < 5){
                                worker.setDisable(true);
                            }
                        }
                        worker.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {4, 6});
                                MainGameLogic.buildReturnValue(true);
                                currentBioCost = 5;
                                currentMinCost = 0;
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                        scout.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                MainGameLogic.UnitCreate(new int[] {4 , 7});
                                currentBioCost = 5;
                                currentMinCost = 5;
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                    }
                    if(ID[0] == 4 && ID[1] == 6){
                        Button BioHarvest = new Button("Acid Lobber 0B/5M");
                        Button MinHarvest = new Button("Mineral Harvester 0B/5M");
                        Button BasicWarDen = new Button("Shard Den 0B/25M");
                        Button RangedWarDen = new Button("Prism Warren 0B/40M");
                        Button HeavyWarDen = new Button("Geode Cavern 0B/70M");
                        buildButtons.getChildren().addAll(BioHarvest,MinHarvest,BasicWarDen,RangedWarDen,HeavyWarDen);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 0 || MainGameLogic.P1Min < 5){
                                BioHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 0 || MainGameLogic.P1Min < 5){
                                MinHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 0 || MainGameLogic.P1Min < 25){
                                BasicWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 0 || MainGameLogic.P1Min < 49){
                                RangedWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P1Bio < 0 || MainGameLogic.P1Min < 70){
                                HeavyWarDen.setDisable(true);
                            }
                        } else if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 0 || MainGameLogic.P2Min < 5){
                                BioHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 0 || MainGameLogic.P2Min < 5){
                                MinHarvest.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 0 || MainGameLogic.P2Min < 25){
                                BasicWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 0 || MainGameLogic.P2Min < 40){
                                RangedWarDen.setDisable(true);
                            }
                            if(MainGameLogic.P2Bio < 0 || MainGameLogic.P2Min < 70){
                                HeavyWarDen.setDisable(true);
                            }
                            
                        }
                        BioHarvest.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 0;
                                    currentMinCost = 5;
                                    MainGameLogic.UnitCreate(new int[] {4,1});
                                    MainGameLogic.constructionSpecialMode = 1;
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            MinHarvest.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 0;
                                    currentMinCost = 5;
                                    MainGameLogic.UnitCreate(new int[] {4,2});
                                    MainGameLogic.constructionSpecialMode = 2;
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            BasicWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 0;
                                    currentMinCost = 20;
                                    MainGameLogic.UnitCreate(new int[] {4,3});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            RangedWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 0;
                                    currentMinCost = 40;
                                    MainGameLogic.UnitCreate(new int[] {4,4});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                            HeavyWarDen.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent arg0) {
                                    currentBioCost = 0;
                                    currentMinCost = 70;
                                    MainGameLogic.UnitCreate(new int[] {4,5});
                                    MainGameLogic.buildReturnValue(true);
                                    ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                                }
                                
                            });
                    }
                    //Basic Warrior Den
                    if(ID[0] == 4 && ID[1] == 3){
                        Button BuildWarrior = new Button("Shard 0B/10M");
                        buildButtons.getChildren().add(BuildWarrior);
                        if(MainGameLogic.getCurrentTurn() == 1){
                            if(MainGameLogic.P1Bio < 0 || MainGameLogic.P1Min < 10){
                                BuildWarrior.setDisable(true);
                            }
                        }
                        if(MainGameLogic.getCurrentTurn() == 2){
                            if(MainGameLogic.P2Bio < 0 || MainGameLogic.P2Min < 10){
                                BuildWarrior.setDisable(true);
                            }
                        }
                        BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent arg0) {
                                currentBioCost = 0;
                                currentMinCost = 10;
                                MainGameLogic.UnitCreate(new int[] {4,8});
                                MainGameLogic.buildReturnValue(true);
                                ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                            }
                            
                        });
                    }
                //Ranged Warrior Den
                if(ID[0] == 4 && ID[1] == 4){
                    Button BuildWarrior = new Button("Prism 0B/20M");
                    buildButtons.getChildren().add(BuildWarrior);
                    if(MainGameLogic.getCurrentTurn() == 1){
                        if(MainGameLogic.P1Bio < 0 || MainGameLogic.P1Min < 20){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    if(MainGameLogic.getCurrentTurn() == 2){
                        if(MainGameLogic.P2Bio < 0 || MainGameLogic.P2Min < 20){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent arg0) {
                            currentBioCost = 0;
                            currentMinCost = 20;
                            MainGameLogic.UnitCreate(new int[] {4,9});
                            MainGameLogic.buildReturnValue(true);
                            ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                        }
                        
                    });
                }
                //Heavy Warrior Den
                if(ID[0] == 4 && ID[1] == 5){
                    Button BuildWarrior = new Button("Geode 0B/60M");
                    buildButtons.getChildren().add(BuildWarrior);
                    if(MainGameLogic.getCurrentTurn() == 1){
                        if(MainGameLogic.P1Bio < 0 || MainGameLogic.P1Min < 60){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    if(MainGameLogic.getCurrentTurn() == 2){
                        if(MainGameLogic.P2Bio < 0 || MainGameLogic.P2Min < 60){
                            BuildWarrior.setDisable(true);
                        }
                    }
                    BuildWarrior.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent arg0) {
                            currentBioCost = 0;
                            currentMinCost = 60;
                            MainGameLogic.UnitCreate(new int[] {4,10});
                            MainGameLogic.buildReturnValue(true);
                            ((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
                        }
                        
                    });
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
