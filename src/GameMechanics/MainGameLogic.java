package GameMechanics;

public class MainGameLogic {

    static int P1Fac = 0;
    static int P2Fac = 0;

    static int turn = 0; // 0 is neutral/inbetween turns, 1 is P1, 2 is P2
    static int nextTurn = 1;

    static int P1Bio = 0;
    static int P1BioInc = 0;
    static int P1Min = 0;
    static int P1MinInc = 0;

    static int P2Bio = 0;
    static int P2BioInc = 0;
    static int P2Min = 0;
    static int P2MinInc = 0;

    static int X1 = -1;
    static int Y1 = -1;

    static int X2 = -1;
    static int Y2 = -1;

    static int selectMode = 0;


    Entity[][] boardState = new Entity[20][20];

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

    }
}
