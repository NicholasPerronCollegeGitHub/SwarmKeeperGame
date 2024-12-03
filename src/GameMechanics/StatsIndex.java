package GameMechanics;

public class StatsIndex {
    static int[][] healthList = new int[5][11];
    static int[][] speedList = new int[5][11];
    static int[][] sightRangeList = new int[5][11];
    static int[][] damageList = new int[5][11];
    static int[][] attkRangeList = new int[5][11];
    static String[][] imgStubList = new String[5][11]; //plans were for things to look different depending on if they were yours or the opponent's, but there is not enough time to double the art assets
    static String[][] PortraitList = new String[5][11];
    static String[][] descList = new String[5][11];
    static boolean[][] canBuild = new boolean[5][11];

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
                imgStubList[0][1] = "src\\Images\\Gameplay\\MapTiles\\GamePiece\\BiomassDepositTile.png";
                PortraitList[0][1] = "src\\Images\\Gameplay\\MapTiles\\Portrait\\BiomassDepositPortrait.png";
                canBuild[0][1] = false;
                descList[0][1] = "An area rich with flora and fauna, essential for the growth and mantainance of a hive."; 
            //Min. Deposit
                healthList[0][2] = 999999999; //same as above
                speedList[0][2] = 0;
                sightRangeList[2][0] = -1;
                damageList[0][2] = 0;
                attkRangeList[2][0] = 0;
                imgStubList[0][2] = "src\\Images\\Gameplay\\MapTiles\\GamePiece\\MineralDepositTile.png";
                PortraitList[0][2] = "src\\Images\\Gameplay\\MapTiles\\Portrait\\MineralDepositPortrait.png";
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
        //Faction 1: terraxii
            //Main Base:
                healthList[1][0] = 1000;
                speedList[1][0] = 0;
                sightRangeList[1][0] = 3;
                damageList[1][0] = 0;
                attkRangeList[1][0] = 0;
                imgStubList[1][0] = "src\\Images\\Gameplay\\Structures\\GamePiece\\TeraxiiMainHiveTile.png";
                PortraitList[1][0] = "src\\Images\\Gameplay\\Structures\\Portrait\\TeraxiiMainHivePortrait.png";
                canBuild[1][0] = true;
                descList[1][0] = "The main hive of a terraxii swarm. Destruction of this leads to a victory for the opposing hive."; 
            //Bio Collect:
                healthList[1][1] = 250;
                speedList[1][1] = 0;
                sightRangeList[1][1] = 2;
                damageList[1][1] = 0;
                attkRangeList[1][1] = 0;
                imgStubList[1][1] = "src\\Images\\Gameplay\\Structures\\GamePiece\\TeraxiiBiomassTile.png";
                PortraitList[1][1] = "src\\Images\\Gameplay\\Structures\\Portrait\\TeraxiiBiomassDeposit.png";
                canBuild[1][1] = false;
                descList[1][1] = "A terraxii-controlled area for collecting the biomass to feed their vast swarms."; 
            //Min collect:
                healthList[1][2] = 250;
                speedList[1][2] = 0;
                sightRangeList[1][2] = 2;
                damageList[1][2] = 0;
                attkRangeList[1][2] = 0;
                imgStubList[1][2] = "src\\Images\\Gameplay\\Structures\\GamePiece\\TeraxiiMineralTile.png";
                PortraitList[1][2] = "src\\Images\\Gameplay\\Structures\\Portrait\\TeraxiiMineralDeposit.png";
                canBuild[1][2] = false;
                descList[1][2] = "Though sparsely used, minerals are still neccessary for the teraxii's larger strains."; 
            //Lanceling spawning pool
                healthList[1][3] = 500;
                speedList[1][3] = 0;
                sightRangeList[1][3] = 2;
                damageList[1][3] = 0;
                attkRangeList[1][3] = 0;
                imgStubList[1][3] = "src\\Images\\Gameplay\\Structures\\GamePiece\\TeraxiiBasicWarNestTile.png";
                PortraitList[1][3] = "src\\Images\\Gameplay\\Structures\\Portrait\\TeraxiiBasicWarNestPortrait.png";
                canBuild[1][3] = true;
                descList[1][3] = "The lanceling spawning pool is a sprawling nest structure created to spew short-lived lanceling to overrun enemies.";
            //Arbalest nest
                healthList[1][4] = 500;
                speedList[1][4] = 0;
                sightRangeList[1][4] = 2;
                damageList[1][4] = 0;
                attkRangeList[1][4] = 0;
                imgStubList[1][4] = "src\\Images\\Gameplay\\Structures\\GamePiece\\TeraxiiRangedWarNestTile.png";
                PortraitList[1][4] = "src\\Images\\Gameplay\\Structures\\Portrait\\TeraxiiRangedWarNestPortrait.png";
                canBuild[1][4] = true;
                descList[1][4] = "The arbalest nest allows for the growth of the short ranged yet dangerous teraxii arbalests.";
            //Tyrant Den
                healthList[1][5] = 750;
                speedList[1][5] = 0;
                sightRangeList[1][5] = 2;
                damageList[1][5] = 0;
                attkRangeList[1][5] = 0;
                imgStubList[1][5] = "src\\Images\\Gameplay\\Structures\\GamePiece\\TeraxiiHeavyWarNestTile.png";
                PortraitList[1][5] = "src\\Images\\Gameplay\\Structures\\Portrait\\TeraxiiHeavyWarNestPortrait.png";
                canBuild[1][5] = true;
                descList[1][5] = "Home to the fearsome teraxii tyrants, large creatures specialized in crushing thick shells.";
                
            //Serf
                healthList[1][6] = 25;
                speedList[1][6] = 3;
                sightRangeList[1][6] = 1;
                damageList[1][6] = 10;
                attkRangeList[1][6] = 1;
                imgStubList[1][6] = "src\\Images\\Gameplay\\Units\\GamePiece\\TeraxiiWorker.png";
                PortraitList[1][6] = "src\\Images\\Gameplay\\Units\\Portrait\\TeraxiiWorkerPortrait.png";
                canBuild[1][6] = true;
                descList[1][6] = "The teraxii serf is a fragile creature, near useless in combat, but play an essential role in the maintainance and expansion of a hive.";
        
            //Vanguard (scout)
                healthList[1][7] = 50;
                speedList[1][7] = 5;
                sightRangeList[1][7] = 3;
                damageList[1][7] = 20;
                attkRangeList[1][7] = 1;
                imgStubList[1][7] = "src\\Images\\Gameplay\\Units\\GamePiece\\TeraxiiScout.png";
                PortraitList[1][7] = "src\\Images\\Gameplay\\Units\\Portrait\\TeraxiiScoutPortrait.png";
                canBuild[1][7] = false;
                descList[1][7] = "The teraxii vanguard move far ahead of the rest of the swarm, using their superior vision to spot far off targets";
        
            //Lanceling (light basic)
                healthList[1][8] = 75;
                speedList[1][8] = 3;
                sightRangeList[1][8] = 1;
                damageList[1][8] = 25;
                attkRangeList[1][8] = 1;
                imgStubList[1][8] = "src\\Images\\Gameplay\\Units\\GamePiece\\TeraxiiBasicWarrior.png";
                PortraitList[1][8] = "src\\Images\\Gameplay\\Units\\Portrait\\TeraxiiBasicWarriorPortrait.png";
                canBuild[1][8] = false;
                descList[1][8] = "The lanceling are tiny creatures that overwhelm targets with numbers rather than strength, they surge forwards to defend their larger siblings from direct attack.";
        
            //Arbalest (short range, high power)
                healthList[1][9] = 125;
                speedList[1][9] = 3;
                sightRangeList[1][9] = 2;
                damageList[1][9] = 100;
                attkRangeList[1][9] = 2;
                imgStubList[1][9] = "src\\Images\\Gameplay\\Units\\GamePiece\\TeraxiiRangedWarrior.png";
                PortraitList[1][9] = "src/Images/Gameplay/Units/Portrait/TeraxiiRangedWarriorPortrait.png";
                canBuild[1][9] = false;
                descList[1][9] = "The arbalest are often found near the front-lines of conflict, spraying down enemies with caustic acid.";
            //Tyrant ()
                healthList[1][10] = 500;
                speedList[1][10] = 2;
                sightRangeList[1][10] = 1;
                damageList[1][10] = 125;
                attkRangeList[1][10] = 1;
                imgStubList[1][10] = "src\\Images\\Gameplay\\Units\\GamePiece\\TeraxiiHeavyWarrior.png";
                PortraitList[1][10] = "src\\Images\\Gameplay\\Units\\Portrait\\TeraxiiHeavyWarriorPortrait.png";
                canBuild[1][10] = false;
                descList[1][10] = "The tyrant is a massive form of teraxii, crushing enemies under its' massive bulk, though it is a sluggish creature due to its bulky armor.";
            
        
        //Faction 2: Fortis <CUT FOR TIME> (Images)
            //Main Base:
                healthList[2][0] = 1000;
                speedList[2][0] = 0;
                sightRangeList[2][0] = 3;
                damageList[2][0] = 0;
                attkRangeList[2][0] = 0;
                imgStubList[2][0] = "";
                PortraitList[2][0] = "";
                canBuild[2][0] = true;
                descList[2][0] = "The main hive of a fortis swarm. Destruction of this leads to a victory for the opposing hive."; 
            //Bio Collect:
                healthList[2][1] = 250;
                speedList[2][1] = 0;
                sightRangeList[2][1] = 2;
                damageList[2][1] = 0;
                attkRangeList[2][1] = 0;
                imgStubList[2][1] = "";
                PortraitList[2][1] = "";
                canBuild[2][1] = false;
                descList[2][1] = "A Fortis-controlled area for collecting the biomass for their massive creatures.";
            //Min Collect:
                healthList[2][2] = 250;
                speedList[2][2] = 0;
                sightRangeList[2][2] = 2;
                damageList[2][2] = 0;
                attkRangeList[2][2] = 0;
                imgStubList[2][2] = "";
                PortraitList[2][2] = "";
                canBuild[2][2] = false;
                descList[2][2] = "A Fortis-controlled area for collecting essential minerals for their fortified shells.";
            //Scorpio lair ()
                healthList[2][3] = 550;
                speedList[2][3] = 0;
                sightRangeList[2][3] = 2;
                damageList[2][3] = 0;
                attkRangeList[2][3] = 0;
                imgStubList[2][3] = "";
                PortraitList[2][3] = "";
                canBuild[2][3] = true;
                descList[2][3] = "A nest of scorpio strain fortis, these short range creatures are unusally fast and aggresive for their species.";
            //Ballista warren ()
                healthList[2][4] = 550;
                speedList[2][4] = 0;
                sightRangeList[2][4] = 2;
                damageList[2][4] = 0;
                attkRangeList[2][4] = 0;
                imgStubList[2][4] = "";
                PortraitList[2][4] = "";
                canBuild[2][4] = true;
                descList[2][4] = "A nest for ballista fortis, these creatures have unparalleled accuracy over long distances.";

            //Trebuchet cavern ()
                healthList[2][5] = 800;
                speedList[2][5] = 0;
                sightRangeList[2][5] = 2;
                damageList[2][5] = 0;
                attkRangeList[2][5] = 0;
                imgStubList[2][5] = "";
                PortraitList[2][5] = "";
                canBuild[2][5] = true;
                descList[2][5] = "The trebuchet fortis birthed here are able to deal incredible damage at range, as long as another creature can designate a target";
            //Engineer (worker)
                healthList[2][6] = 75;
                speedList[2][6] = 2;
                sightRangeList[2][6] = 1;
                damageList[2][6] = 20;
                attkRangeList[2][6] = 1;
                imgStubList[2][6] = "";
                PortraitList[2][6] = "";
                canBuild[2][6] = true;
                descList[2][6] = "Well armored compared to workers of other hives, the fortis engineers are still very vulnerable to direct attacks.";
            //Wayfinder (scout)
                healthList[2][7] = 50;
                speedList[2][7] = 4;
                sightRangeList[2][7] = 4;
                damageList[2][7] = 10;
                attkRangeList[2][7] = 1;
                imgStubList[2][7] = "";
                PortraitList[2][7] = "";
                canBuild[2][7] = false;
                descList[2][7] = "Unlike other fortis creatures, the wayfinder has only a thin carapace to protect it from harm, it uses its incredible vision to direct larger creatures towards aggressors.";
            //Scorpio (light ranged)
                healthList[2][8] = 150;
                speedList[2][8] = 3;
                sightRangeList[2][8] = 2;
                damageList[2][8] = 75;
                attkRangeList[2][8] = 2;
                imgStubList[2][8] = "";
                PortraitList[2][8] = "";
                canBuild[2][8] = false;
                descList[2][8] = "The smallest of the fortis warriors, scorpio prefer to ambush their prey as opposed to a direct conflict.";
        
            //Ballista (precision siege)
            healthList[2][9] = 200;
                speedList[2][9] = 2;
                sightRangeList[2][9] = 2;
                damageList[2][9] = 100;
                attkRangeList[2][9] = 4;
                imgStubList[2][9] = "";
                PortraitList[2][9] = "";
                canBuild[2][9] = false;
                descList[2][9] = "The ballista can propel spines across incredible distances to accurately eliminate key hostile targets.";
            //Trebuchet (Heavy ranged)
                healthList[2][10] = 400;
                speedList[2][10] = 1;
                sightRangeList[2][10] = 0;
                damageList[2][10] = 250;
                attkRangeList[2][10] = 3;
                imgStubList[2][10] = "";
                PortraitList[2][10] = "";
                canBuild[2][10] = false;
                descList[2][10] = "Though essentially blind on their own, the trebuchet can anihilate almost anything with the help of another creature to direct it.";
            
        
        //Faction 3: Vespidian  <CUT FOR TIME> (Images)
            //Main Base:
                healthList[3][0] = 1000;
                speedList[3][0] = 0;
                sightRangeList[3][0] = 3;
                damageList[3][0] = 0;
                attkRangeList[3][0] = 0;
                imgStubList[3][0] = "";
                PortraitList[3][0] = "";
                canBuild[3][0] = true;
                descList[3][0] = "The main hive of a vespidian swarm. Destruction of this leads to a victory for the opposing hive."; 
            //Bio Collect:
                healthList[3][1] = 250;
                speedList[3][1] = 0;
                sightRangeList[3][1] = 2;
                damageList[3][1] = 0;
                attkRangeList[3][1] = 0;
                imgStubList[3][1] = "";
                PortraitList[3][1] = "";
                canBuild[3][1] = false;
                descList[3][1] = "A vespidian-controlled area for collecting the biomass to fuel their rapid forces.";
            //Min Collect:
                healthList[3][2] = 250;
                speedList[3][2] = 0;
                sightRangeList[3][2] = 2;
                damageList[3][2] = 0;
                attkRangeList[3][2] = 0;
                imgStubList[3][2] = "";
                PortraitList[3][2] = "";
                canBuild[3][2] = false;
                descList[3][2] = "A vespidian-controlled area for harvesting minerals from the environment.";
            //Locust Nest ()
                healthList[3][3] = 500;
                speedList[3][3] = 0;
                sightRangeList[3][3] = 2;
                damageList[3][3] = 0;
                attkRangeList[3][3] = 0;
                imgStubList[3][3] = "";
                PortraitList[3][3] = "";
                canBuild[3][3] = true;
                descList[3][3] = "This structure rapidly produces locusts, small flying creatures that work together to harass prey.";
            //Mosquito aerie ()
                healthList[3][4] = 500;
                speedList[3][4] = 0;
                sightRangeList[3][4] = 2;
                damageList[3][4] = 0;
                attkRangeList[3][4] = 0;
                imgStubList[3][4] = "";
                PortraitList[3][4] = "";
                canBuild[3][4] = true;
                descList[3][4] = "The vespidians' ranged mosquito caste are born and raised within this structure.";
            //Hornet spire ()
                healthList[3][5] = 750;
                speedList[3][5] = 0;
                sightRangeList[3][5] = 2;
                damageList[3][5] = 0;
                attkRangeList[3][5] = 0;
                imgStubList[3][5] = "";
                PortraitList[3][5] = "";
                canBuild[3][5] = true;
                descList[3][5] = "The hornets produced here are even more aggressive than the typical vespidian warrior.";
            //Bee (worker)
                healthList[3][6] = 30;
                speedList[3][6] = 3;
                sightRangeList[3][6] = 1;
                damageList[3][6] = 20;
                attkRangeList[3][6] = 1;
                imgStubList[3][6] = "";
                PortraitList[3][6] = "";
                canBuild[3][6] = true;
                descList[3][6] = "The vespidian bee forms the backbone of the hive's expansion.";
            //Dragonfly (scout, actually combat capable)
                healthList[3][7] = 50;
                speedList[3][7] = 6;
                sightRangeList[3][7] = 3;
                damageList[3][7] = 25;
                attkRangeList[3][7] = 1;
                imgStubList[3][7] = "";
                PortraitList[3][7] = "";
                canBuild[3][7] = false;
                descList[3][7] = "The dragonfly serves a scouting role for a vespidian hive, though it is still very capable of hit-and-run attacks.";
            //Locust (small basic melee)
                healthList[3][8] = 60;
                speedList[3][8] = 5;
                sightRangeList[3][8] = 2;
                damageList[3][8] = 40;
                attkRangeList[3][8] = 1;
                imgStubList[3][8] = "";
                PortraitList[3][8] = "";
                canBuild[3][8] = false;
                descList[3][8] = "Where they lack in durability, the vespidian locust more than make up for it with sheer speed and aggression.";
            //Mosquito (ranged, very fragile)
                healthList[3][9] = 20;
                speedList[3][9] = 5;
                sightRangeList[3][9] = 2;
                damageList[3][9] = 40;
                attkRangeList[3][9] = 3;
                imgStubList[3][9] = "";
                PortraitList[3][9] = "";
                canBuild[3][9] = false;
                descList[3][9] = "The vespidian mosquito attacks from a distance, its brittle and thin carapace is far too weak to take much damage.";
            //Hornet (large, fast, strong)
                healthList[3][10] = 50;
                speedList[3][10] = 6;
                sightRangeList[3][10] = 3;
                damageList[3][10] = 25;
                attkRangeList[3][10] = 1;
                imgStubList[3][10] = "";
                PortraitList[3][10] = "";
                canBuild[3][10] = false;
                descList[3][10] = "The dragonfly serves a scouting role for a vespidian hive, though it is still very capable of hit-and-run attacks.";
                
        //Faction 4: Crystallid
            //Main Base:
                healthList[4][0] = 1000;
                speedList[4][0] = 0;
                sightRangeList[4][0] = 3;
                damageList[4][0] = 0;
                attkRangeList[4][0] = 0;
                imgStubList[4][0] = "src\\Images\\Gameplay\\Structures\\GamePiece\\CrystallidMainHiveTile.png";
                PortraitList[4][0] = "src\\Images\\Gameplay\\Structures\\Portrait\\CrystallidMainHivePortrait.png";
                canBuild[4][0] = true;
                descList[4][0] = "The main hive of a Crystallid swarm. Destruction of this leads to a victory for the opposing hive."; 
            //Bio Collect:
                healthList[4][1] = 250;
                speedList[4][1] = 0;
                sightRangeList[4][1] = 2;
                damageList[4][1] = 50;
                attkRangeList[4][1] = 4;
                imgStubList[4][1] = "src\\Images\\Gameplay\\Structures\\GamePiece\\CrystallidBiomassTile.png";
                PortraitList[4][1] = "src\\Images\\Gameplay\\Structures\\Portrait\\CrystallidBiomassDeposit.png";
                canBuild[4][1] = false;
                descList[4][1] = "Though the crystallid have no need for biomass, these specialized structures can still convert it to a potent acid which can be launched at far ranges to discourage would-be invaders.";
            //Min Collect:
                healthList[4][2] = 250;
                speedList[4][2] = 0;
                sightRangeList[4][2] = 2;
                damageList[4][2] = 0;
                attkRangeList[4][2] = 0;
                imgStubList[4][2] = "src\\Images\\Gameplay\\Structures\\GamePiece\\CrystallidMineralTile.png";
                PortraitList[4][2] = "src\\Images\\Gameplay\\Structures\\Portrait\\CrystallidMineralDeposit.png";
                canBuild[4][2] = false;
                descList[4][2] = "Due to their unique biology, crystallids depend on mineral deposits like this one instead of organic matter.";
            //Shard den ()
                healthList[4][3] = 500;
                speedList[4][3] = 0;
                sightRangeList[4][3] = 2;
                damageList[4][3] = 0;
                attkRangeList[4][3] = 0;
                imgStubList[4][3] = "src\\Images\\Gameplay\\Structures\\GamePiece\\CrystallidBasicWarNestTile.png";
                PortraitList[4][3] = "src\\Images\\Gameplay\\Structures\\Portrait\\CrystallidBasicWarNestPortrait.png";
                canBuild[4][3] = true;
                descList[4][3] = "Home of the crystallid shards, the smallest of the crystallid warrior castes.";
            //Prism warren ()
                healthList[4][4] = 500;
                speedList[4][4] = 0;
                sightRangeList[4][4] = 2;
                damageList[4][4] = 0;
                attkRangeList[4][4] = 0;
                imgStubList[4][4] = "src\\Images\\Gameplay\\Structures\\GamePiece\\CrystallidRangedWarNestTile.png";
                PortraitList[4][4] = "src\\Images\\Gameplay\\Structures\\Portrait\\CrystallidRangedWarNestPortrait.png";
                canBuild[4][4] = true;
                descList[4][4] = "Crystallid prisms are made here, creatures capable of focusing light into a weapon.";
            //Geode cavern ()
                healthList[4][5] = 750;
                speedList[4][5] = 0;
                sightRangeList[4][5] = 2;
                damageList[4][5] = 0;
                attkRangeList[4][5] = 0;
                imgStubList[4][5] = "src\\Images\\Gameplay\\Structures\\GamePiece\\CrystallidHeavyWarNestTile.png";
                PortraitList[4][5] = "src\\Images\\Gameplay\\Structures\\Portrait\\CrystallidHeavyWarNestPortrait.png";
                canBuild[4][5] = true;
                descList[4][5] = "This massive nest houses the behemoth crystallid geodes.";
            //Nucleator (worker (based on 1st stage of crystal formation))
                healthList[4][6] = 50;
                speedList[4][6] = 1;
                sightRangeList[4][6] = 1;
                damageList[4][6] = 30;
                attkRangeList[4][6] = 1;
                imgStubList[4][6] = "src\\Images\\Gameplay\\Units\\GamePiece\\CrystallidWorkerTile.png";
                PortraitList[4][6] = "src\\Images\\Gameplay\\Units\\Portrait\\CrystallidWorkerPortrait.png";
                canBuild[4][6] = true;
                descList[4][6] = "The crystallid nucleators work tirelessly to form the massive crystalline structures that the crystallids call home.";
            //Lens (scout)
                healthList[4][7] = 70;
                speedList[4][7] = 3;
                sightRangeList[4][7] = 3;
                damageList[4][7] = 20;
                attkRangeList[4][7] = 1;
                imgStubList[4][7] = "src\\Images\\Gameplay\\Units\\GamePiece\\CrystallidScoutTile.png";
                PortraitList[4][7] = "src\\Images\\Gameplay\\Units\\Portrait\\CrystallidWorkerPortrait.png";
                canBuild[4][7] = false;
                descList[4][7] = "Lenses are quite fast for crystallid, using their speed and sight to scout for minerals to feed an ever growing hive.";
            //Shard (basic)
                healthList[4][8] = 100;
                speedList[4][8] = 2;
                sightRangeList[4][8] = 1;
                damageList[4][8] = 40;
                attkRangeList[4][8] = 1;
                imgStubList[4][8] = "src\\Images\\Gameplay\\Units\\GamePiece\\CrystallidBasicWarriorTile.png";
                PortraitList[4][8] = "src\\Images\\Gameplay\\Units\\Portrait\\CrystallidBasicWarriorPortrait.png";
                canBuild[4][8] = false;
                descList[4][8] = "Though they are the smallest of the crystallid warriors, shards are still very durable thanks to their crystal-like shell.";
            //Prism (ranged)
                healthList[4][9] = 85;
                speedList[4][9] = 2;
                sightRangeList[4][9] = 2;
                damageList[4][9] = 70;
                attkRangeList[4][9] = 3;
                imgStubList[4][9] = "src\\Images\\Gameplay\\Units\\GamePiece\\CrystallidRangedWarriorTile.png";
                PortraitList[4][9] = "src\\Images\\Gameplay\\Units\\Portrait\\CrystallidRangedWarriorPortrait.png";
                canBuild[4][9] = false;
                descList[4][9] = "Unique even among the exotic crystallid, the crysallid prisms are capable of focusing the harsh sunlight of their desert home into dangerous rays of energy.";
            //Geode (heavy armor, melee)
                healthList[4][10] = 300;
                speedList[4][10] = 1;
                sightRangeList[4][10] = 1;
                damageList[4][10] = 125;
                attkRangeList[4][10] = 1;
                imgStubList[4][10] = "src\\Images\\Gameplay\\Units\\GamePiece\\CrystallidHeavyWarriorTile.png";
                PortraitList[4][10] = "src\\Images\\Gameplay\\Units\\Portrait\\CrystallidHeavyWarriorPortrait.png";
                canBuild[4][10] = false;
                descList[4][10] = "Incredibly sluggish, the titanic crystallid geode is incredibly durable, and has strength to match.";
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
