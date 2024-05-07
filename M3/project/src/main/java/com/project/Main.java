package com.project;

import java.sql.Time;
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
    public static TimerTask MainLoop = new TimerTask() {
        @Override
        public void run() {
            if (!stopped)
                Update();
        }
    };

    public static void main(String[] args) {
        civilization = Civilization.getInstance();
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


    private static void Update() {
        //Updates values about the civilization (resources, enemy army, battles)
        civilization.GenerateResources(deltaTime);
    }

    private static void MainMenu() {
        Boolean menu = true;
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
            int option = input.nextInt();
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
        }
    }

    private static void CreateBuildingMenu() {
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
        String option;
        int amount;
        Boolean exit = false;
        input.nextLine();
        while(!exit){
            ArrayList<String> units = new ArrayList<>(Arrays.asList("Swordsman","Spearman","Crossbow","Cannon","Arrow tower","Catapult","Rocket launcher","Magician","Priest"));
            for(int i = 0;i < units.size();i++){
                System.out.println(units.get(i));
            }
            System.out.println("Exit");
            System.out.println("What unit do you want to train?");
            option = input.nextLine();
            if(option.toLowerCase().equals("exit")){
                System.out.println("ENTRA ENTRA ENTRA ENTRA ENTRA ENTRA ENTRA");
                exit = true;
                break;
            }
            if(units.contains(option.toUpperCase())){
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
                        System.out.println("ENTRA ENTRA ENTRA ENTRA ENTRA ENTRA ENTRA");
                        exit = true;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static void TechnologyMenu() {

    }

    private static void StatsMenu() {
        Timer timer = new Timer();
        CountDownLatch latch = new CountDownLatch(1);
        TimerTask displayStatsTask = new TimerTask() {
            @Override
            public void run() {
                //print stats
                clearConsole();
                System.out.println("Stats");

                System.out.println("Press Anything to return");
                //view input
                if (input.hasNextLine()) {
                    timer.cancel();
                    latch.countDown();
                    return;
                }

            }
        };
        timer.scheduleAtFixedRate(displayStatsTask, 0, UPS);
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void PauseMenu() {
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