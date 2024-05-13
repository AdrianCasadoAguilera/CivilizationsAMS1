package com.project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static Timer timer;
    public static Saves saves;
    public static Scanner input = new Scanner(System.in);
    public static int UPS = 1;
    public static float deltaTime = 1.0f/UPS;
    public static Civilization civilization;
    public static Boolean stopped = false;
    public static float BattleTimer = 0;
    public static TimerTask MainLoop = new TimerTask() {
        @Override
        public void run() {
            if (!stopped)
            Update();
            //System.out.println("update Active");
        }
    };
    public static ArrayList<Battle> battlesFaugth = new ArrayList<>();
    public static ArrayList<MilitaryUnit> NextEnemyArmy = new ArrayList<>();
    public static int NextBattleIn = 180;
    public static String ActiveMenu = "";
    public static int ActiveSave = -1;

    public static void main(String[] args) {
        AppData data = AppData.getInstance();
        timer = new Timer();
        timer.schedule(MainLoop, 0, 1000/UPS);
        stopped = true;
        civilization = Civilization.getInstance();
        saves = Saves.getInstance();
        stopped = false;

        /*SwingUtilities.invokeLater(()->{
            new MainWindow().setVisible(true);
        });*/

        MainMenu();
        timer.cancel();
        data.close();
        input.close();
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
        if (BattleTimer >= NextBattleIn) {
            NextBattleIn = 5;
            BattleTimer = 0;
            civilization.setBattles(civilization.getBattles()+1);
            Battle battle = new Battle((ArrayList<MilitaryUnit>)civilization.getArmy().clone(), (ArrayList<MilitaryUnit>)NextEnemyArmy.clone());
            battle.startBattle();
            battle.recollectWaste(civilization);
            battle.civilizationArmyAfter(civilization);
            createEnemyArmy();
            battlesFaugth.add(battle);
            if (ActiveMenu == "Main")
                System.out.println("\n\nA battle Happened\n");
        }
    }

    private static void createEnemyArmy() {
        NextEnemyArmy.clear();
        int food = Variables.FOOD_BASE_ENEMY_ARMY + Variables.FOOD_BASE_ENEMY_ARMY*Variables.ENEMY_FLEET_INCREASE/100*civilization.getBattles();
        int wood = Variables.WOOD_BASE_ENEMY_ARMY + Variables.WOOD_BASE_ENEMY_ARMY*Variables.ENEMY_FLEET_INCREASE/100*civilization.getBattles();
        int iron = Variables.IRON_BASE_ENEMY_ARMY + Variables.IRON_BASE_ENEMY_ARMY*Variables.ENEMY_FLEET_INCREASE/100*civilization.getBattles();
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

    private static int CountUnitType(ArrayList<MilitaryUnit> army, UnitTypes unitType) {
        int count = 0;
        for (MilitaryUnit unit : army) {
            if (unit.getType() == unitType) {
                count++;
            }
        }
        return count;
    }

    private static void MainMenu() {
        clearConsole();
        while (true) {
            System.out.println("1. New Game");
            if (saves.GetSaveCount() > 0) {
                System.out.println("2. Continue");
            }
            System.out.println("0. Quit\n");
            System.out.print("Choose an option: ");
            int option = -1;
            try {
                option = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid option");
            }
            clearConsole();
            input.nextLine();
            switch (option) {
                case 0:
                    return;
                case 1: 
                    NewGame();
                    clearConsole();
                    break;
                case 2:
                    if (saves.GetSaveCount() == 0) {
                        System.out.println("Invalid option");
                        break;
                    }
                    ContinueMenu();
                    clearConsole();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        
        }
    }

    private static void NewGame() {
        ActiveSave = saves.AddNewSaveData();
        saves.LoadSaveData(ActiveSave);
        createEnemyArmy();
        MainGameMenu();
    }

    private static void ContinueMenu() {
        while (true) {
            for (int i = 0; i < saves.GetSaveCount(); i++) {
                System.out.println(i + 1 + " Save number " + (i+1));
            }
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            int option = -1;
            try {
                option = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid option");
            }
            input.nextLine();
            if (option == 0) {
                return;
            }
            else if (option < 0 || option > saves.GetSaveCount()) {
                System.out.println("Invalid option");
                continue;
            }
            ContinueGame(option-1);
            return;
        }
    }

    private static void ContinueGame(int index) {
        ActiveSave = index;
        saves.LoadSaveData(index);
        MainGameMenu();
    }

    private static void MainGameMenu() {
        stopped = false;
        Boolean menu = true;
        Boolean error = true;
        while (true) {
            ActiveMenu = "Main";
            if (menu) {
                clearConsole();
                System.out.println("1. Create a Building");
                System.out.println("2. Train a new Unit");
                System.out.println("3. Upgrade Technology Level");
                System.out.println("4. See Stats");
                System.out.println("5. View Thread");
                System.out.println("6. Battle Logs");
                System.out.println("7. Pause");
                System.out.println("0. Quit\n");
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
                        input.nextLine();
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
                        error = false;
                        ViewThreadMenu();
                        break;
                    case 6:
                        BattleLogsMenu();
                        break;
                    case 7:
                        PauseMenu();
                        if (stopped)
                            return;
                        break;
                    case 0:
                        stopped = true;
                        SaveGame();
                        return;
                    default:
                        System.out.println("\nInvalid option");
                        menu = false;
                        break;
                }
            }catch (Exception e) {
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
        Boolean created = false;
        input.nextLine();
        clearConsole();
        while(true){
            if (created) {
                System.out.println("Building created");
                created = false;
            }
            System.out.println("Smithy");
            System.out.println("Carpentry");
            System.out.println("Farm");
            System.out.println("Magic Tower");
            System.out.println("Church");
            System.out.println("Exit");
            System.out.println("What do you want to build?");
            option = input.nextLine().toLowerCase();
            clearConsole();
            int build;
            switch (option) {
                case "smithy":
                build =  civilization.getSmithy();
                civilization.newSmithy();
                created = build < civilization.getSmithy();
                break;
                case "carpentry":
                build = civilization.getCarpentry();
                civilization.newCarpentry();
                created = build < civilization.getCarpentry();
                break;
                case "farm":
                build = civilization.getFarm();
                civilization.newFarm();
                created = build < civilization.getFarm();
                break;
                case "magic tower":
                build = civilization.getMagicTower();
                civilization.newMagicTower();
                created = build < civilization.getMagicTower();
                break;
                case "church":
                build = civilization.getChurch();
                civilization.newChurch();
                created = build < civilization.getChurch();
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
        int total = 0;
        clearConsole();
        while (true) {
            if (total != 0) {
                System.out.println(total + " Units trained");
                total = 0;
            }
            for (UnitTypes type : UnitTypes.values()) {
                System.out.println(title(type.toString()));
            }
            System.out.println("Exit");
            System.out.println("What unit do you want to train?");
            option = input.nextLine();
            if (option.toUpperCase().equals("EXIT"))
                return;
            UnitTypes type;
            try {
                type = UnitTypes.valueOf(option.toUpperCase());
            } catch (Exception e) {
                type = null;
            }
            if (type == null) {
                clearConsole();
                System.out.println("Invalid option. Please choose again.");
                continue;
            }
            System.out.println("How many units do you want to train?");
            int amount = -1;
            try {
                amount = input.nextInt();
                clearConsole();
            }
            catch (Exception e) {
                amount = -1;
                System.out.println("Invalid option. Please choose again.");
            }
            input.nextLine();
            if (amount != -1) {
                total = civilization.AddUnit(type, amount);
            }
        }
    }

    private static void TechnologyMenu() {
        ActiveMenu = "Tech";
        boolean upgraded = false;
        clearConsole();
        while (true) {
            if (upgraded) {
                upgraded = false;
                System.out.println("Technology upgraded");
            }
            System.out.println("Upgrade technology");
            System.out.println("1. Upgrade Technology Defense");
            System.out.println("2. Upgrade Technology Attack");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option;
            try {
                option = input.nextInt();
            } catch (Exception e) {
                option = -1;
                input.next();
            }
            clearConsole();
            int level;
            switch (option) {
                case 1:
                    level = civilization.getTechnologyDefense();
                    civilization.upgradeTechnologyDefense();
                    upgraded = level < civilization.getTechnologyDefense();
                    break;
                case 2:
                    level = civilization.getTechnologyAttack();
                    civilization.upgradeTechnologyAttack();
                    upgraded = level < civilization.getTechnologyAttack();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }

    private static void StatsMenu() {
        ActiveMenu = "Stats";
        clearConsole();
        
        Timer timer = new Timer();
        
    
        TimerTask displayStatsTask = new TimerTask() {
            @Override
            public void run() {
                clearConsole();
                ArrayList<Float> generation = civilization.GetGenerationPerSecond();
                System.out.println("Stats");
                System.out.println("\nResources:");
                System.out.println("Food: " + civilization.getFood() + " (+"+String.format("%.0f", generation.get(0))+"/s)");
                System.out.println("Wood: " + civilization.getWood() + " (+"+String.format("%.0f", generation.get(1))+"/s)");
                System.out.println("Iron: " + civilization.getIron() + " (+"+String.format("%.0f", generation.get(2))+"/s)");
                System.out.println("Mana: " + civilization.getMana() + " (+"+String.format("%.0f", generation.get(3))+"/s)");
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

    public static String formatTime(float seconds) {
        int minutes = (int) (seconds / 60);
        int remainingSeconds = Math.round(seconds % 60);
        return minutes + (minutes != 1 ? " minutes ": " minute ")+ remainingSeconds + (remainingSeconds != 1 ? " seconds": " second");
     }

    private static void ViewThreadMenu() {
        ActiveMenu = "Thread";
        Timer timer = new Timer();
        TimerTask displayThreadTask = new TimerTask() {
            @Override
            public void run() {
                clearConsole();
                System.out.println("Next Battle in " + formatTime(NextBattleIn-BattleTimer));
                System.out.println("Swordsman: " + CountUnitType(NextEnemyArmy, UnitTypes.SPEARMAN));
                System.out.println("Spearman: " + CountUnitType(NextEnemyArmy, UnitTypes.SPEARMAN));
                System.out.println("Crossbow: " + CountUnitType(NextEnemyArmy, UnitTypes.CROSSBOW));
                System.out.println("Cannon: " + CountUnitType(NextEnemyArmy, UnitTypes.CANNON));
                System.out.println("Press Enter to return");
            }
        };
        timer.schedule(displayThreadTask, 0, 1000/UPS);
        try {
            System.in.read();
        } catch (Exception e) {}
        timer.cancel();
    }

    private static void BattleLogsMenu() {
        ActiveMenu = "Battle";
        while (true) {

            System.out.println("You have faught " + battlesFaugth.size() + " battles");
            System.out.println("1. View battle report");
            System.out.println("2. View battle detailed report");
            System.out.println("3. View last battle report");
            System.out.println("4. View last battle detailed report");
            System.out.println("0. Return");
            int choice = input.nextInt();
            int index = -1;
            switch (choice) {
                case 1:
                    System.out.println("Which battle do you want to see?");
                    try {
                        index = input.nextInt();
                        if (index < battlesFaugth.size()) {
                            System.out.println(battlesFaugth.get(index).getReport());
                        }
                        else {
                            System.out.println("Invalid index");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid index");
                    }
                    break;
                case 2:
                    System.out.println("Which battle do you want to see?");
                    index = input.nextInt();
                    if (index < battlesFaugth.size()) {
                        System.out.println(battlesFaugth.get(index).getDeteiledReport());
                    }
                    else {
                        System.out.println("Invalid index");
                    }
                    break;
                case 3:
                    if (battlesFaugth.size() > 0) {
                        System.out.println(battlesFaugth.get(battlesFaugth.size() - 1).getReport());
                    }
                    else {
                        System.out.println("You didn't fight any battles yet");
                    }
                    break;
                case 4:
                    if (battlesFaugth.size() > 0) {
                        System.out.println(battlesFaugth.get(battlesFaugth.size() - 1).getDeteiledReport());
                    }
                    else {
                        System.out.println("You didn't fight any battles yet");
                    }
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    private static void PauseMenu() {
        SaveGame();
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
                return;
            }
        }
        stopped = false;
    }

    private static void SaveGame() {
        saves.UpdateSaveData(ActiveSave);
    }

}