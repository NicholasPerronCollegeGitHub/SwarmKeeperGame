package GameMechanics;



public class Entity {
     private int team = 0;
     private int health = 0;
     private int speed = 0;
     private int movesMade = 0;
     private int sightRange = 0;
     private int damage = 0;
     private int attkRange = 0;
     private String imgPath = "src\\Images\\Gameplay\\MapTiles\\GamePiece\\UnknownTile.png";
     private String portraitPath = "src\\Images\\Gameplay\\MapTiles\\Portrait\\UnknownTilePortrait.png";
     private String Description;
     private boolean visible = true;
     private boolean empty = true;
     private boolean hasAttkd = false;
     private boolean canBuild = false;
     private boolean capturable = false; //for resource nodes
     private int[] typeID = {0,0}; //1st indicates which faction, 2nd which unit for stats index

     public Entity(int[] ID){
          team = MainGameLogic.getCurrentTurn();
          health = StatsIndex.getHealth(ID);
          speed = StatsIndex.getSpeed(ID);
          sightRange = StatsIndex.getSightRange(ID);
          damage = StatsIndex.getDamage(ID);
          Description = StatsIndex.getDesc(ID);
          imgPath = StatsIndex.getImg(ID);
          portraitPath = StatsIndex.getPortrait(ID);
          attkRange = StatsIndex.getAttkRange(ID);
          canBuild = StatsIndex.getCanBuild(ID);
          if(ID[0] == 0 && ID[1] == 0){
               empty = true;
          }
          if(ID[0] == 1 || ID[1] ==2){
               capturable = true;
          }else{
               capturable = false;
          }
          empty = false;
          typeID[0] = ID[0];
          typeID[1] = ID[1];
     }
     public Entity(int[] ID, int teamOverride){
          team = teamOverride;
          health = StatsIndex.getHealth(ID);
          speed = StatsIndex.getSpeed(ID);
          sightRange = StatsIndex.getSightRange(ID);
          damage = StatsIndex.getDamage(ID);
          Description = StatsIndex.getDesc(ID);
          imgPath = StatsIndex.getImg(ID);
          portraitPath = StatsIndex.getPortrait(ID);
          attkRange = StatsIndex.getAttkRange(ID);
          canBuild = StatsIndex.getCanBuild(ID);
          if(ID[0] == 1 || ID[1] == 2){
               capturable = true;
          }else{
               capturable = false;
          }
          empty = false;
          visible = false;
          typeID[0] = ID[0];
          typeID[1] = ID[1];
     }

     public Entity(){
          team = 0;
          health = 0;
          speed = 0;
          sightRange = 0;
          damage = 0;
          attkRange = 0;
          imgPath = "src\\Images\\Gameplay\\MapTiles\\GamePiece\\EmptyTile.png";
          portraitPath = "src\\Images\\Gameplay\\MapTiles\\Portrait\\EmptyTilePortrait.png";
          empty = true;
          visible = false;
          capturable = false;
          canBuild = false;
          typeID[0] = 0;
          typeID[1] = 0;
          Description = StatsIndex.getDesc(typeID);
     }
     public boolean isVisible(){
          return(visible);
     }
     public String getPortraitPath(){
          if(visible){
               return(portraitPath);
          }else{
               return("src\\Images\\Gameplay\\MapTiles\\Portrait\\UnknownTilePortrait.png");
          }
     }
     public String getTilePath(){
          if(visible){
               return(imgPath);
          }else{
               return("src\\Images\\Gameplay\\MapTiles\\GamePiece\\UnknownTile.png");
          }
     }
     public String getDesc(){
          if(visible){
               return(Description);
          }else{
               return("An unseen area, you do not know what is here.");
          }
     }
     public int getMovesRemaining(){
          return(speed - movesMade);
     }
     public boolean getIsEmpty(){
          return(empty);
     }
     public void takeDamage(int damageNum){
          health -= damageNum;
          if(health <= 0){
               typeID[0] = 0;
               if(capturable){
                    if(typeID[1] == 1){
                         team = 0;
                    health = StatsIndex.getHealth(typeID);
                    speed = StatsIndex.getSpeed(typeID);
                    sightRange = StatsIndex.getSightRange(typeID);
                    damage = StatsIndex.getDamage(typeID);
                    imgPath = StatsIndex.getImg(typeID);
                    portraitPath = StatsIndex.getPortrait(typeID);
                    attkRange = StatsIndex.getAttkRange(typeID);
                    Description = StatsIndex.getDesc(typeID);
                    canBuild = StatsIndex.getCanBuild(typeID);
                    }else{
                         team = 0;
                    health = StatsIndex.getHealth(typeID);
                    speed = StatsIndex.getSpeed(typeID);
                    sightRange = StatsIndex.getSightRange(typeID);
                    damage = StatsIndex.getDamage(typeID);
                    imgPath = StatsIndex.getImg(typeID);
                    portraitPath = StatsIndex.getPortrait(typeID);
                    attkRange = StatsIndex.getAttkRange(typeID);
                    canBuild = StatsIndex.getCanBuild(typeID);
                    }
               }else{
                    typeID[1] = 0;
                    team = 0;
                    health = StatsIndex.getHealth(typeID);
                    speed = StatsIndex.getSpeed(typeID);
                    sightRange = StatsIndex.getSightRange(typeID);
                    damage = StatsIndex.getDamage(typeID);
                    imgPath = StatsIndex.getImg(typeID);
                    Description = StatsIndex.getDesc(typeID);
                    portraitPath = StatsIndex.getPortrait(typeID);
                    attkRange = StatsIndex.getAttkRange(typeID);
                    canBuild = StatsIndex.getCanBuild(typeID);
                    empty = true;
               }
          }
     }
     public int getTeam() {
          return(team);
     }
     public void move(int changeBy) {
          movesMade += changeBy;
     }
     public boolean getHasAttkd() {
          return(hasAttkd);
     }
     public void setHasAttkd(boolean newVal){
          hasAttkd = newVal;
     }
     public int getAttkRange() {
          return(attkRange);
     }
     public int getDamage() {
          return(damage);
     }
	public int getSightRange() {
          return(sightRange);
	}
    public void setVisible(boolean newVis) {
     visible = newVis;
    }
    public void newTurn(){
     hasAttkd = false;
     movesMade = 0;
    }
public int[] getID() {
     return(typeID);
}
public int getHealth() {
     return(health);
}
public boolean getCanBuild() {
     return(canBuild);
}
}
