package com.project;

import java.util.TimerTask;
import java.util.Timer;

public class Main {
    public static Civilization civilization;
    public static final int UPS = 1; //updatesPerSecond
    public static void main(String[] args) {
        civilization = Civilization.getInstance();
        TimerTask mainLoop = new TimerTask() {
            
        };
        Timer timer = new Timer();
        timer.schedule(mainLoop, 0, 1000/UPS);
    }
}