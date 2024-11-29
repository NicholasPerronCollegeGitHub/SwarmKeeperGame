package GameMechanics;



public class Entity {
     private int team = 0;
     private int health = 0;
     private int speed = 0;
     private int sightRange = 0;
     private int damage = 0;
     private String imgPath = null;
     private int[] typeID = {0,0}; //1st indicates which faction, 2nd which unit for stats index

     public Entity(int[] ID){
          team = MainGameLogic.getCurrentTurn();
          health = StatsIndex.getHealth(ID);
          speed = StatsIndex.getSpeed(ID);
          sightRange = StatsIndex.getSightRange(ID);
          damage = StatsIndex.getDamage(ID);
          imgPath = StatsIndex.getImg(ID);
          typeID[0] = ID[0];
          typeID[1] = ID[1];
     }
}
