package GameMechanics;

import java.util.Random;

public class MainGameLogic {

    static int P1Fac = 0;
    static int P2Fac = 0;

    static int turn = 0; // 0 is neutral/inbetween turns, 1 is P1, 2 is P2
    static int nextTurn = 1;

    static int P1Bio = 10;
    static int P1BioInc = 0;
    static int P1Min = 10;
    static int P1MinInc = 0;

    static int P2Bio = 10;
    static int P2BioInc = 0;
    static int P2Min = 10;
    static int P2MinInc = 0;

    static int X1 = -1;
    static int Y1 = -1;

    static int X2 = -1;
    static int Y2 = -1;

    static int selectMode = 0;
    static int[] selectedLoc = {0,0};
    static int[] savedLoc = {0,0};
    static int[] waitingUnitID = {0,0};
    static int constructionSpecialMode = 0;

 
    static Entity[][] boardState = new Entity[20][20];

    static{
        for(int i = 0 ; i < 20; i++){
            for(int j = 0; j < 20; j++){
                boardState[i][j] = new Entity();
            }
        }

    /*  int[] temp = {0,3};
     *  boardState[3][1] = new Entity(temp, 1);
     *  boardState[4][2] = new Entity(temp, 2);
     */
    }
    
    public static void StartGame(){
        int quad1Bio = 0;
        int quad2Bio = 0;
        int quad3Bio = 0;
        int quad4Bio = 0;

        int quad1Min = 0;
        int quad2Min = 0;
        int quad3Min = 0;
        int quad4Min = 0;

        Random rand = new Random();

        int x = 0;
        int y = 0;
        boardState[4][4] = new Entity(new int[] {P1Fac, 0}, 1); //create player main structures
        boardState[15][15] = new Entity(new int[] {P2Fac, 0}, 2);

        while(quad1Bio < 4 || quad2Bio < 4 || quad3Bio < 4 || quad4Bio < 4 ){  //generate Bio. deposits (4 per quadrant)
            if(quad1Bio < 4){
                x = rand.nextInt(9);
                y = rand.nextInt(9);
                if(getBoardStateatLoc(new int[] {x,y}).getIsEmpty()){
                    boardState[x][y] = new Entity(new int[] {0,1});
                    quad1Bio++;
                }
            }
            if(quad2Bio < 4){
                x = rand.nextInt(9) + 9;
                y = rand.nextInt(9);
                if(getBoardStateatLoc(new int[] {x,y}).getIsEmpty()){
                    boardState[x][y] = new Entity(new int[] {0,1});
                    quad2Bio++;
                }
            }
            if(quad3Bio < 4){
                x = rand.nextInt(9);
                y = rand.nextInt(9) + 9;
                if(getBoardStateatLoc(new int[] {x,y}).getIsEmpty()){
                    boardState[x][y] = new Entity(new int[] {0,1});
                    quad3Bio++;
                }
            }
            if(quad4Bio < 4){
                x = rand.nextInt(9) + 9;
                y = rand.nextInt(9) + 9;
                if(getBoardStateatLoc(new int[] {x,y}).getIsEmpty()){
                    boardState[x][y] = new Entity(new int[] {0,1});
                    quad4Bio++;
                }
            }
        }
        while(quad1Min < 4 || quad2Min < 4 || quad3Min < 4 || quad4Min < 4 ){ //generate Min. deposits (4 per quadrant)
            if(quad1Min < 4){
                x = rand.nextInt(9);
                y = rand.nextInt(9);
                if(getBoardStateatLoc(new int[] {x,y}).getIsEmpty()){
                    boardState[x][y] = new Entity(new int[] {0,2});
                    quad1Min++;
                }
            }
            if(quad2Min < 4){
                x = rand.nextInt(9) + 9;
                y = rand.nextInt(9);
                if(getBoardStateatLoc(new int[] {x,y}).getIsEmpty()){
                    boardState[x][y] = new Entity(new int[] {0,2});
                    quad2Min++;
                }
            }
            if(quad3Min < 4){
                x = rand.nextInt(9);
                y = rand.nextInt(9) + 9;
                if(getBoardStateatLoc(new int[] {x,y}).getIsEmpty()){
                    boardState[x][y] = new Entity(new int[] {0,2});
                    quad3Min++;
                }
            }
            if(quad4Min < 4){
                x = rand.nextInt(9) + 9;
                y = rand.nextInt(9) + 9;
                if(getBoardStateatLoc(new int[] {x,y}).getIsEmpty()){
                    boardState[x][y] = new Entity(new int[] {0,2});
                    quad4Min++;
                }
            }
        }
    }

    public static int getCurrentTurn(){
        return(turn);
    }

    public static void setP1Fac(int facinput){
        P1Fac = facinput;
    }
    public static int getP1Fac(){
        return(P1Fac);
    }
    public static void setP2Fac(int facinput){
        P2Fac = facinput;

    }
    public static int getP2Fac(){
        return(P2Fac);
    }

    public static void SelectLoc(int[] coords){
        if(selectMode == 0){
            selectedLoc = coords;
        }else if(selectMode == 1){
            savedLoc = selectedLoc;
            selectedLoc = coords;
            if((getBoardStateatLoc(savedLoc).getMovesRemaining() > 0) && (((selectedLoc[0] >= savedLoc[0] - 1)&&(selectedLoc[0] <= savedLoc[0] + 1))&&((selectedLoc[1] >= savedLoc[1] - 1)&&(selectedLoc[1] <= savedLoc[1] + 1))) && (turn == MainGameLogic.getBoardStateatLoc(savedLoc).getTeam()) && getBoardStateatLoc(selectedLoc).getIsEmpty()){
                Entity tempEntity = new Entity();
                tempEntity = getBoardStateatLoc(selectedLoc);
                setBoardStateatLoc(selectedLoc, getBoardStateatLoc(savedLoc));
                setBoardStateatLoc(savedLoc, tempEntity);
                getBoardStateatLoc(selectedLoc).move(1);
                iterateSight();
            }
            selectMode = 0;
        }else if(selectMode == 2){
            savedLoc = selectedLoc;
            selectedLoc = coords;
            int tempRange = getBoardStateatLoc(savedLoc).getAttkRange();
            if((!getBoardStateatLoc(savedLoc).getHasAttkd()) && (((selectedLoc[0] >= savedLoc[0] - tempRange)&&(selectedLoc[0] <= savedLoc[0] + tempRange))&&((selectedLoc[1] >= savedLoc[1] - tempRange)&&(selectedLoc[1] <= savedLoc[1] + tempRange))) && (turn == MainGameLogic.getBoardStateatLoc(savedLoc).getTeam())){
                if(getBoardStateatLoc(savedLoc).getTeam() != getBoardStateatLoc(selectedLoc).getTeam() && getBoardStateatLoc(selectedLoc).getTeam() != 0){
                    getBoardStateatLoc(selectedLoc).takeDamage(getBoardStateatLoc(savedLoc).getDamage());
                    getBoardStateatLoc(savedLoc).setHasAttkd(true);
                    iterateSight();
                }
            }
            
            selectMode = 0;
        }else if(selectMode == 4){
            selectedLoc = coords;
            if(constructionSpecialMode == 0){
                if(getBoardStateatLoc(selectedLoc).getIsEmpty()){
                    boardState[selectedLoc[0]][selectedLoc[1]] = new Entity(waitingUnitID);
                    if(turn == 1){
                        P1Bio -= CanBuildList.getCurrentBioCost();
                        P1Min -= CanBuildList.getCurrentMinCost();
                        CanBuildList.resetCurrentCost();
                    }else if(turn == 2){
                        P1Bio -= CanBuildList.getCurrentBioCost();
                        P1Min -= CanBuildList.getCurrentMinCost();
                        CanBuildList.resetCurrentCost();
                    }
                }
            }else if(constructionSpecialMode == 1){
                if(getBoardStateatLoc(selectedLoc).getID()[0] == 0 && getBoardStateatLoc(selectedLoc).getID()[1] == 1 ){
                    boardState[selectedLoc[0]][selectedLoc[1]] = new Entity(waitingUnitID);
                    if(turn == 1){
                        P1Bio -= CanBuildList.getCurrentBioCost();
                        P1Min -= CanBuildList.getCurrentMinCost();
                        CanBuildList.resetCurrentCost();
                    }else if(turn == 2){
                        P1Bio -= CanBuildList.getCurrentBioCost();
                        P1Min -= CanBuildList.getCurrentMinCost();
                        CanBuildList.resetCurrentCost();
                    }
                }
                constructionSpecialMode = 0;
            }else if(constructionSpecialMode == 2){
                if(getBoardStateatLoc(selectedLoc).getID()[0] == 0 && getBoardStateatLoc(selectedLoc).getID()[1] == 2 ){
                    boardState[selectedLoc[0]][selectedLoc[1]] = new Entity(waitingUnitID);
                    if(turn == 1){
                        P1Bio -= CanBuildList.getCurrentBioCost();
                        P1Min -= CanBuildList.getCurrentMinCost();
                        CanBuildList.resetCurrentCost();
                    }else if(turn == 2){
                        P1Bio -= CanBuildList.getCurrentBioCost();
                        P1Min -= CanBuildList.getCurrentMinCost();
                        CanBuildList.resetCurrentCost();
                    }
                }
                constructionSpecialMode = 0;
            }
            selectMode = 0;
        }
    }

    public static int[] getSelectedLoc(){
        return(selectedLoc);
    }
    public static Entity getBoardStateatLoc(int[] coords){
        return(boardState[coords[0]][coords[1]]);
    }
    public static void setBoardStateatLoc(int[] coords, Entity temp){
        boardState[coords[0]][coords[1]] = temp;
    }

    public static String getStatus() {
        if(selectMode == 0){
            if(turn == 1){
                return("Player 1 Turn");
            }else if(turn == 2){
                return("Player 2 Turn");
            }else if(turn == 0){
                return("Press Start Turn to Continue");
            }
        }else if(getBoardStateatLoc(selectedLoc).getTeam() == turn){
            if(selectMode == 1){
                return("Please select an adjacent tile to move to. (" + getBoardStateatLoc(selectedLoc).getMovesRemaining() + " Left)");
            }else if(selectMode == 2){
                if(!getBoardStateatLoc(selectedLoc).getHasAttkd()){
                    return("Please select an enemy within " + getBoardStateatLoc(selectedLoc).getAttkRange() + " tiles.");
                }else{
                    return("This Creature has Already Attacked");
                }
            }else if(selectMode == 3){
                return("Please select an object to create.");
            }
        }else{
            return("Cannot Command Enemy Creature");
        }
        return("This Message Should Not Appear");
    }

    public static void setSelectMode(int newMode) {
        selectMode = newMode;
    }
    public static void iterateSight(){
        for(int a = 0; a < 20; a++){
            for(int b = 0; b < 20; b++){
                int[] temp = {a,b};
                try {
                    getBoardStateatLoc(temp).setVisible(false);
                } catch (Exception e) {
                    // As stated Below
                    continue;
                }

            }
        }
        if(turn != 0){ 
            for(int a = 0; a < 20; a++){
                for(int b = 0; b < 20; b++){
                    int[] temp = {a,b};
                    if(turn == (getBoardStateatLoc(temp).getTeam())){
                        for(int c = (a - getBoardStateatLoc(temp).getSightRange()); c <= (a + getBoardStateatLoc(temp).getSightRange()); c++){
                            for(int d = (b - getBoardStateatLoc(temp).getSightRange()); d <= (b + getBoardStateatLoc(temp).getSightRange()); d++){
                                try {
                                    getBoardStateatLoc(new int[] {c,d}).setVisible(true);
                                } catch (Exception e) {
                                    //Nothing needs to be done here, prevents errors when out of bounds
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    public static void nextTurn() {
        int bioProduce = 0;
        int minProduce = 0;
        if(turn == 0){
            turn = nextTurn;
            if(nextTurn == 1){
                nextTurn = 2;
            }else if( nextTurn == 2){
                nextTurn = 1;
            }
        }else if(turn == 1){
            for(int a = 0; a < 20; a++){
                for(int b = 0; b < 20; b++){
                    int[] temp = new int[] {a , b};
                    if(getBoardStateatLoc(temp).getTeam() == turn){
                        getBoardStateatLoc(temp).newTurn();
                    }
                    if(getBoardStateatLoc(temp).getID()[1] == 1 && getBoardStateatLoc(temp).getTeam() == turn){
                        bioProduce++;
                    }
                    if(getBoardStateatLoc(temp).getID()[1] == 2 && getBoardStateatLoc(temp).getTeam() == turn){
                        minProduce++;
                    }
                }
            }
            P1Bio += (5 + (5*(bioProduce)));
            P1Min += (5 + (5*(minProduce)));
            bioProduce = 0;
            minProduce = 0;
            turn = 0;
        }else if(turn == 2){
            for(int a = 0; a < 20; a++){
                for(int b = 0; b < 20; b++){
                    int[] temp = new int[] {a , b};
                    if(getBoardStateatLoc(temp).getTeam() == turn){
                        getBoardStateatLoc(temp).newTurn();
                    }
                    if(getBoardStateatLoc(temp).getID()[1] == 1 && getBoardStateatLoc(temp).getTeam() == turn){
                        bioProduce++;
                    }
                    if(getBoardStateatLoc(temp).getID()[1] == 2 && getBoardStateatLoc(temp).getTeam() == turn){
                        minProduce++;
                    }
                }
            }
            P2Bio += (5 + (5*(bioProduce)));
            P2Min += (5 + (5*(minProduce)));
            bioProduce = 0;
            minProduce = 0;
            turn = 0;
            
        }
    }

    public static int getCurrentBio() {
        if(turn == 1){
            return(P1Bio);
        }else if(turn == 2){
            return(P2Bio);
        }else{
            return(0);
        }
    }

    public static int getCurrentMin() {
        if(turn == 1){
            return(P1Min);
        }else if(turn == 2){
            return(P2Min);
        }else{
            return(0);
        }
    }

    public static String getTurnStatus() {
        if(turn == 0){
            return("Start Turn");
        }else{
            return("End Turn");
        }
    }

    public static String getSelectedStatsBasic() {
        if(getBoardStateatLoc(selectedLoc).getTeam() == 0 || turn == 0){
            return(null);
        }else{
            int currentHp = getBoardStateatLoc(selectedLoc).getHealth();
            int maxHp = StatsIndex.getHealth(getBoardStateatLoc(selectedLoc).getID());
            int attk = StatsIndex.getDamage(getBoardStateatLoc(selectedLoc).getID());
            int range = StatsIndex.getAttkRange(getBoardStateatLoc(selectedLoc).getID());
            int move = StatsIndex.getSpeed(getBoardStateatLoc(selectedLoc).getID());
            return("Health: " + currentHp + "/" + maxHp + "\n" + "Damage: " + attk + "\n" + "Range: " + range + "\n" + "Speed: " + move);
        }
    }

    public static String getSelectedStatsAdvanced(){
        int currentHp = getBoardStateatLoc(selectedLoc).getHealth();
            int maxHp = StatsIndex.getHealth(getBoardStateatLoc(selectedLoc).getID());
            int attk = StatsIndex.getDamage(getBoardStateatLoc(selectedLoc).getID());
            int range = StatsIndex.getAttkRange(getBoardStateatLoc(selectedLoc).getID());
            int move = StatsIndex.getSpeed(getBoardStateatLoc(selectedLoc).getID());
            int sight = StatsIndex.getSightRange(getBoardStateatLoc(selectedLoc).getID());
            int movesLeft = getBoardStateatLoc(selectedLoc).getMovesRemaining();
            boolean hasAttkd = getBoardStateatLoc(selectedLoc).getHasAttkd();
            boolean canBuild = getBoardStateatLoc(selectedLoc).getCanBuild();
            String hasAttkdString;
            String canBuildString;
            if(hasAttkd){
                hasAttkdString = "Yes";
            }else{
                hasAttkdString = "No";
            }
            if(canBuild){
                canBuildString = "Yes";
            }else{
                canBuildString = "No";
            }

        return("Health: " + currentHp + "/" + maxHp + "\n" + "Damage: " + attk + "\n" + "Range: " + range  + "\n" + "Sight Range:" + sight + "\n" + "Speed: " + move + "\n" + "Moves Left: " + movesLeft + "\n" + "Has attacked Yet: " + hasAttkdString + "\n" + "Can create things: " + canBuildString);
    }

    public static void checkSelectedBuildable() {
        if(getBoardStateatLoc(selectedLoc).getCanBuild()){
            selectMode = 3;
            CanBuildList.checkBuild(getBoardStateatLoc(selectedLoc).getID());
        }else{
            selectMode = 0;
        }
    }
    public static void buildReturnValue(boolean bool){
        if(bool){
            selectMode = 4;
        }else{
            selectMode = 0;
        }
    }

    public static void UnitCreate(int[] ID) {
        waitingUnitID = ID;
    }

    public static void setConstructionSpecialMode(int mode){
        constructionSpecialMode = mode;
    }
}
