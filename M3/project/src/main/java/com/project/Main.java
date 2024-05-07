package com.project;

import java.sql.Time;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class Main {
    
    public static Scanner input = new Scanner(System.in);
    public static int UPS = 1;
    public static float deltaTime = 1.0f/UPS;
    public static Civilization civilization;
    public static Boolean stoped = false;
    public static TimerTask MainLoop = new TimerTask() {
        @Override
        public void run() {
            if (!stoped)
                Update();
        }
    };

    public static void main(String[] args) {
        civilization = Civilization.getInstance();
        Timer timer = new Timer();
        timer.schedule(MainLoop, 0, UPS);
        stoped = false;
        MainMenu();
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
                    break;
                default:
                    System.out.println("\nInvalid option");
                    menu = false;
                    break;
            }
        }
    }

    private static void CreateBuildingMenu() {

    }

    private static void TrainUnitMenu() {

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
        stoped = true;
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
        stoped = false;
    }

}