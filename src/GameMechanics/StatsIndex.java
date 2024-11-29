package GameMechanics;

public class StatsIndex {
    public static int getHealth(int[] ID){
        int[][] healthList = new int[5][10];
        return(healthList[ID[0]][ID[1]]);
    }

    public static int getSpeed(int[] ID) {
        int[][] speedList = new int[5][10];
        return(speedList[ID[0]][ID[1]]);
    }

    public static int getSightRange(int[] ID) {
        int[][] sightRangeList = new int[5][10];
        return(sightRangeList[ID[0]][ID[1]]);
    }

    public static int getDamage(int[] ID) {
        int[][] damageList = new int[5][10];
        return(damageList[ID[0]][ID[1]]);
    }

    public static String getImg(int[] ID) {
        String[][] imgStubList = new String[5][10];
        return(imgStubList[ID[0]][ID[1]]);
    }
}
