package com.project;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    public static Scanner input = new Scanner(System.in);
    public static int UPS = 1;
    public static float deltaTime = 1.0f/UPS;
    public static Civilization civilization;
    public static Boolean stopped = false;
    public static float BattleTimer = 175;
    public static TimerTask MainLoop = new TimerTask() {
        @Override
        public void run() {
            if (!stopped)
                Update();
                //System.out.println("update Active");
        }
    };
    public static ArrayList<MilitaryUnit> NextEnemyArmy = new ArrayList<>();
    public static int wave = 0;
    public static String ActiveMenu = "";

    public static void main(String[] args) {
        civilization = Civilization.getInstance();
        createEnemyArmy(); 
        Timer timer = new Timer();
        timer.schedule(MainLoop, 0, 1000/UPS);
        stopped = false;
        MainMenu();
        timer.cancel();
    }

    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }

    public static String title(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            titleCase.append(c);
        }

        return titleCase.toString();
    }

    private static void Update() {
        //Updates values about the civilization (resources, enemy army, battles)
        civilization.GenerateResources(deltaTime);
        BattleTimer += deltaTime;
        if (BattleTimer >= 180) {
            BattleTimer = 0;
            wave++;
            Battle battle = new Battle(civilization.getArmy(), NextEnemyArmy);
            battle.startBattle();
            battle.recollectWaste(civilization);
            battle.civilizationArmyAfter(civilization);
            createEnemyArmy();
            if (ActiveMenu == "Main")
                System.out.println("\n\nA battle Happened\n");
        }
    }

    private static void createEnemyArmy() {
        NextEnemyArmy.clear();
        int food = Variables.FOOD_BASE_ENEMY_ARMY + Variables.FOOD_BASE_ENEMY_ARMY*Variables.ENEMY_FLEET_INCREASE/100*wave;
        int wood = Variables.WOOD_BASE_ENEMY_ARMY + Variables.WOOD_BASE_ENEMY_ARMY*Variables.ENEMY_FLEET_INCREASE/100*wave;
        int iron = Variables.IRON_BASE_ENEMY_ARMY + Variables.IRON_BASE_ENEMY_ARMY*Variables.ENEMY_FLEET_INCREASE/100*wave;
        /*Para crear el ejército enemigo, dispondremos de unos recursos iniciales, que conforme vayan
        sucediendo batallas, serán mayores .
        Iremos creando unidades enemigas aleatoriamente pero con las siguientes probabilidades:
        Swordsman 35%, Spearman 25%, Crossbow 20%, Cannon 20%.
        Mientras tengamos suficientes recursos para crear la unidad con menor coste, es decir, Swordsman
        iremos creando unidades aleatoriamente según las probabilidades anteriores. */
        Random random = new Random();
        while (food >= Variables.FOOD_COST_SWORDSMAN && wood >= Variables.WOOD_COST_SWORDSMAN && iron >= Variables.IRON_COST_SWORDSMAN) {
            int r = random.nextInt(100);
            if (r < 35) {
                food -= Variables.FOOD_COST_SWORDSMAN;
                wood -= Variables.WOOD_COST_SWORDSMAN;
                iron -= Variables.IRON_COST_SWORDSMAN;
                NextEnemyArmy.add(new Swordsman());
            } else if (r < 60) {
                food -= Variables.FOOD_COST_SPEARMAN;
                wood -= Variables.WOOD_COST_SPEARMAN;
                iron -= Variables.IRON_COST_SPEARMAN;
                NextEnemyArmy.add(new Spearman());
            } else if (r < 80) {
                food -= Variables.FOOD_COST_CROSSBOW;
                wood -= Variables.WOOD_COST_CROSSBOW;
                iron -= Variables.IRON_COST_CROSSBOW;
                NextEnemyArmy.add(new Crossbow());
            } else {
                food -= Variables.FOOD_COST_CANNON;
                wood -= Variables.WOOD_COST_CANNON;
                iron -= Variables.IRON_COST_CANNON;
                NextEnemyArmy.add(new Cannon());
            }
        }
    }

    private static void MainMenu() {
        Boolean menu = true;
        Boolean error = true;
        ActiveMenu = "Main";
        while (true) {
            if (menu) {
                clearConsole();
                System.out.println("1. Create a Building");
                System.out.println("2. Train a new Unit");
                System.out.println("3. Research a Technology");
                System.out.println("4. See Stats");
                System.out.println("5. Pause");
                System.out.println("6. Quit\n");
                System.out.print("Choose an option: ");
            }
            menu = true;
            try {
                int option = input.nextInt();
                error = true;
                switch (option) {
                    case 1:
                        CreateBuildingMenu();
                        break;
                    case 2:
                        TrainUnitMenu();
                        break;
                    case 3:
                        TechnologyMenu();
                        break;
                    case 4:
                        error = false;
                        StatsMenu();
                        break;
                    case 5:
                        PauseMenu();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("\nInvalid option");
                        menu = false;
                        break;
                }
            } catch (Exception e) {
                if (error) {
                    System.out.println("\nInvalid option type");
                    menu = false;
                }
                input.next();
            }
        }
    }

    private static void CreateBuildingMenu() {
        ActiveMenu = "Building";
        String option;
        input.nextLine();
        while(true){
            System.out.println("Smithy");
            System.out.println("Carpentry");
            System.out.println("Farm");
            System.out.println("Magic Tower");
            System.out.println("Church");
            System.out.println("Exit");
            System.out.println("What do you want to build?");
            option = input.nextLine().toLowerCase();
            switch (option) {
                case "smithy":
                    civilization.newSmithy();
                    break;
                case "carpentry":
                    civilization.newCarpentry();
                    break;
                case "farm":
                    civilization.newFarm();
                    break;
                case "magic tower":
                    civilization.newMagicTower();
                    break;
                case "church":
                    civilization.newChurch();
                    break;
                case "exit":
                    return;
                default:
                    break;
            }
        }
    }

    private static void TrainUnitMenu() {
        ActiveMenu = "Train";
        String option;
        int amount;
        Boolean exit = false;
        while(!exit){
            input.nextLine();
            ArrayList<String> units = new ArrayList<>(Arrays.asList("Swordsman","Spearman","Crossbow","Cannon","Arrow tower","Catapult","Rocket launcher","Magician","Priest"));
            for(int i = 0;i < units.size();i++){
                System.out.println(units.get(i));
            }
            System.out.println("Exit");
            System.out.println("What unit do you want to train?");
            option = input.nextLine();
            if(option.toLowerCase().equals("exit")){
                exit = true;
                break;
            }
            if(units.contains(option.substring(0,1).toUpperCase()+option.substring(1).toLowerCase())){
                System.out.println("How many "+option+"s do you want to train?");
                amount = input.nextInt();
                switch (option.toLowerCase()) {
                    case "swordsman":
                        civilization.AddUnit(UnitTypes.SWORDSMAN, amount);
                        break;
                    case "spearman":
                        civilization.AddUnit(UnitTypes.SPEARMAN, amount);
                        break;
                    case "crossbow":
                        civilization.AddUnit(UnitTypes.CROSSBOW, amount);
                        break;
                    case "cannon":
                        civilization.AddUnit(UnitTypes.CANNON, amount);
                        break;
                    case "arrow tower":
                        civilization.AddUnit(UnitTypes.ARROWTOWER, amount);
                        break;
                    case "catapult":
                        civilization.AddUnit(UnitTypes.CATAPULT, amount);
                        break;
                    case "rocket launcher":
                        civilization.AddUnit(UnitTypes.ROCKETLAUNCHERTOWER, amount);
                        break;
                    case "magician":
                        civilization.AddUnit(UnitTypes.MAGICIAN, amount);
                        break;
                    case "priest":
                        civilization.AddUnit(UnitTypes.PRIEST, amount);
                        break;
                    case "exit":
                        exit = true;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static void TechnologyMenu() {
        ActiveMenu = "Tech";
    }

    private static void StatsMenu() {
        ActiveMenu = "Stats";
        clearConsole();
        
        Timer timer = new Timer();
        
    
        TimerTask displayStatsTask = new TimerTask() {
            @Override
            public void run() {
                clearConsole();
                System.out.println("Stats");
                System.out.println("\nResources:");
                System.out.println("Food: " + civilization.getFood());
                System.out.println("Wood: " + civilization.getWood());
                System.out.println("Iron: " + civilization.getIron());
                System.out.println("Mana: " + civilization.getMana());
                System.out.println("\nTechnology:");
                System.out.println("Attack: " + civilization.getTechnologyAttack());
                System.out.println("Defense: " + civilization.getTechnologyDefense());
                System.out.println("\nBuildings:");
                System.out.println("Frms: " + civilization.getFarm());
                System.out.println("Carpentry: " + civilization.getCarpentry());
                System.out.println("Smithy: " + civilization.getSmithy());
                System.out.println("Magic Tower: " + civilization.getMagicTower());
                System.out.println("Church: " + civilization.getChurch());
                System.out.println("\nArmy:");
                for(UnitTypes type : UnitTypes.values()) {
                    System.out.println(title(type.toString()) + ": " + civilization.CountUnits(type));
                }
                System.out.println("\nPress Enter to return");
            }
        };
    
        timer.scheduleAtFixedRate(displayStatsTask, 0, 1000/UPS);

        try {
            System.in.read();
        } catch (Exception e) {

        }
        timer.cancel();
    }

    private static void PauseMenu() {
        ActiveMenu = "Pause";
        stopped = true;
        while (true) {
            System.out.println("1. Resume");
            System.out.println("2. Quit");
            int choice = input.nextInt();
            if (choice == 1) {
                break;
            } 
            else if (choice == 2) {
                System.exit(0);
            }
        }
        stopped = false;
    }

}