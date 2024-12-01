package GameMechanics;

public class StatsIndex {
    static int[][] healthList = new int[5][10];
    static int[][] speedList = new int[5][10];
    static int[][] sightRangeList = new int[5][10];
    static int[][] damageList = new int[5][10];
    static int[][] attkRangeList = new int[5][10];
    static String[][] imgStubList = new String[5][10]; //plans were for things to look different depending on if they were yours or the opponent's, but there is not enough time to double the art assets
    static String[][] PortraitList = new String[5][10];
    static String[][] descList = new String[5][10];
    static boolean[][] canBuild = new boolean[5][10];

    static{
    //Unit statistic info
        //Neutral
            //Empty Tile
                healthList[0][0] = 0;
                speedList[0][0] = 0;
                sightRangeList[0][0] = -1;
                damageList[0][0] = 0;
                attkRangeList[0][0] = 0;
                imgStubList[0][0] = "src\\Images\\Gameplay\\MapTiles\\GamePiece\\EmptyTile.png";
                PortraitList[0][0] = "src\\Images\\Gameplay\\MapTiles\\Portrait\\EmptyTilePortrait.png";
                canBuild[0][0] = false;
                descList[0][0] = "An empty area, devoid of notable features."; 
            //Bio. Deposit
                healthList[0][1] = 999999999; //hopefully prevents destruction and therefore hopefully mitigate unexpected bugs
                speedList[0][1] = 0;
                sightRangeList[1][0] = -1;
                damageList[0][1] = 0;
                attkRangeList[1][0] = 0;
                imgStubList[0][1] = "";
                PortraitList[0][1] = "";
                canBuild[0][1] = false;
                descList[0][1] = "An area rich with flora and fauna, essential for the growth and mantainance of a hive."; 
            //Min. Deposit
                healthList[0][2] = 999999999; //same as above
                speedList[0][2] = 0;
                sightRangeList[2][0] = -1;
                damageList[0][2] = 0;
                attkRangeList[2][0] = 0;
                imgStubList[0][2] = "";
                PortraitList[0][2] = "";
                canBuild[0][2] = false;
                descList[0][2] = "An outcrop of particularly rich minerals, often used to reinforce the shells of larger creatures."; 
            //Testling <Exists for testing purposes only>
                healthList[0][3] = 100;
                speedList[0][3] = 4;
                sightRangeList[0][3] = 2;
                damageList[0][3] = 50;
                attkRangeList[0][3] = 4;
                imgStubList[0][3] = "src\\Images\\Gameplay\\Units\\GamePiece\\Testling.png";
                PortraitList[0][3] = "src\\Images\\Gameplay\\Units\\Portrait\\TestlingPortrait.png";
                canBuild[0][3] = true;
                descList[0][3] = "An odd creature, Rumor has it that this creature shouldn't even exist."; 
        //Faction 1: <NAME>
            //Main Base:
                healthList[1][0] = 1000;
                speedList[1][0] = 0;
                sightRangeList[1][0] = 3;
                damageList[1][0] = 0;
                attkRangeList[1][0] = 0;
                imgStubList[1][0] = "";
                PortraitList[1][0] = "";
                canBuild[1][0] = true;
                descList[1][0] = "The main hive of the <NAMEHERE>. Destruction of this leads to a victory for the opposing hive."; 
        //Faction 2: <NAME>
            //Main Base:
                healthList[2][0] = 1000;
                speedList[2][0] = 0;
                sightRangeList[2][0] = 3;
                damageList[2][0] = 0;
                attkRangeList[2][0] = 0;
                imgStubList[2][0] = "";
                PortraitList[2][0] = "";
                canBuild[2][0] = true;
                descList[2][0] = "The main hive of the <NAMEHERE>. Destruction of this leads to a victory for the opposing hive.";
        //Faction 3: <NAME>
            //Main Base:
                healthList[3][0] = 1000;
                speedList[3][0] = 0;
                sightRangeList[3][0] = 3;
                damageList[3][0] = 0;
                attkRangeList[3][0] = 0;
                imgStubList[3][0] = "";
                PortraitList[3][0] = "";
                canBuild[3][0] = true;
                descList[3][0] = "The main hive of the <NAMEHERE>. Destruction of this leads to a victory for the opposing hive.";
        //Faction 4: <NAME>
            //Main Base:
                healthList[4][0] = 1000;
                speedList[4][0] = 0;
                sightRangeList[4][0] = 3;
                damageList[4][0] = 0;
                attkRangeList[4][0] = 0;
                imgStubList[4][0] = "";
                PortraitList[4][0] = "";
                canBuild[4][0] = true;
                descList[4][0] = "The main hive of the <NAMEHERE>. Destruction of this leads to a victory for the opposing hive.";
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

    public static String getDesc(int[] ID) {
        return(descList[ID[0]][ID[1]]);
    }

    public static boolean getCanBuild(int[] ID) {
        return(canBuild[ID[0]][ID[1]]);
    }
}
