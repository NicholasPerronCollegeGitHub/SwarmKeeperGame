package GameMechanics;

public class StatsIndex {
    static int[][] healthList = new int[5][10];
    static int[][] speedList = new int[5][10];
    static int[][] sightRangeList = new int[5][10];
    static int[][] damageList = new int[5][10];
    static int[][] attkRangeList = new int[5][10];
    static String[][] imgStubList = new String[5][10];
    static String[][] PortraitList = new String[5][10];
    static String[][] descList = new String[5][10];

    static{
    //Unit statistic info
        //Neutral
            //Empty Tile
                healthList[0][0] = 0;
                speedList[0][0] = 0;
                sightRangeList[0][0] = 0;
                damageList[0][0] = 0;
                attkRangeList[0][0] = 0;
                imgStubList[0][0] = "src\\Images\\Gameplay\\MapTiles\\GamePiece\\EmptyTile.png";
                PortraitList[0][0] = "src\\Images\\Gameplay\\MapTiles\\Portrait\\EmptyTilePortrait.png";
                descList[0][0] = "An empty area, devoid of notable features."; 
        //Faction 1: <NAME>
        //Faction 2: <NAME>
        //Faction 3: <NAME>
        //Faction 4: <NAME>
    }


    public static int getHealth(int[] ID){
        return(healthList[ID[0]][ID[1]]);
    }

    public static int getSpeed(int[] ID) {
        return(speedList[ID[0]][ID[1]]);
    }

    public static int getAttkRange(int[] ID) {
        return(attkRangeList[ID[0]][ID[1]]);
    }

    public static int getSightRange(int[] ID) {
        return(sightRangeList[ID[0]][ID[1]]);
    }

    public static int getDamage(int[] ID) {
        return(damageList[ID[0]][ID[1]]);
    }

    public static String getImg(int[] ID) {
        return(imgStubList[ID[0]][ID[1]]);
    }

    public static String getPortrait(int[] ID) {
        return(PortraitList[ID[0]][ID[1]]);
    }
}
