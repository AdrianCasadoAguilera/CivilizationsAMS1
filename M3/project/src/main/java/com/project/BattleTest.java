package com.project;

import java.util.*;

public class BattleTest {
    public static void main(String[] args) {
        Map<UnitTypes,Integer> civArmy = new HashMap<UnitTypes,Integer>() {{
            put(UnitTypes.SWORDSMAN,0);
            put(UnitTypes.SPEARMAN,0);
            put(UnitTypes.CROSSBOW,0);
            put(UnitTypes.CANNON,0);
            put(UnitTypes.ARROWTOWER,0);
            put(UnitTypes.CATAPULT,0);
            put(UnitTypes.ROCKETLAUNCHERTOWER,1);
            put(UnitTypes.MAGICIAN,0);
            put(UnitTypes.PRIEST,0);
        }};
        Map<UnitTypes,Integer> enemyArmy = new HashMap<UnitTypes,Integer>() {{
            put(UnitTypes.SWORDSMAN,10);
            put(UnitTypes.SPEARMAN,0);
            put(UnitTypes.CROSSBOW,0);
            put(UnitTypes.CANNON,0);
        }};
        
        ArrayList<MilitaryUnit> armyUnits = GenerateUnits(civArmy);
        ArrayList<MilitaryUnit> enemyUnits = GenerateUnits(enemyArmy);
        Battle battle = new Battle(armyUnits,enemyUnits);
        battle.startBattle();
        battle.getDeteiledReportSwing();
        while (true) {
            System.out.println("1. Report");
            System.out.println("2. Detailed Report");
            try {
                int choice = Integer.parseInt(new Scanner(System.in).nextLine());
                if (choice == 1) {
                    System.out.println(battle.getReport());
                    System.out.println(battle.isWin());
                }
                else if (choice == 2)
                    System.out.println(battle.getDeteiledReport());
            } catch (Exception e) {
                System.out.println("Invalid choice");
                break;
            }

        }
        /*
        int Simulations = 1000;
        int Wins = 0;
        int Loses = 0;
        for (int i = 0; i < Simulations; i++) {
            ArrayList<MilitaryUnit> a = GenerateUnits(civArmy);
            ArrayList<MilitaryUnit> e = GenerateUnits(enemyArmy);
            Battle b = new Battle(a,e);
            b.startBattle();
            if (b.isWin())
                Wins++;
            else
                Loses++;
        }
        System.out.println(Wins + ":" + Loses);*/
    }

    private static ArrayList<MilitaryUnit> GenerateUnits(Map<UnitTypes,Integer> army) {
        ArrayList<MilitaryUnit> generatedUnits = new ArrayList<>();
        for (Map.Entry<UnitTypes,Integer> entry : army.entrySet()) {
            int quantity = entry.getValue();
            UnitTypes type = entry.getKey();
            for (int i = 0; i < quantity; i++) {
                generatedUnits.add(getNewUnit(type));
            }
        }

        return generatedUnits;
    }

    private static MilitaryUnit getNewUnit(UnitTypes type) {
        switch (type) {
            case SWORDSMAN:
                return new Swordsman();
            case SPEARMAN:
                return new Spearman();
            case CROSSBOW:
                return new Crossbow();
            case CANNON:
                return new Cannon();
            case ARROWTOWER:
                return new ArrowTower();
            case CATAPULT:
                return new Catapult();
            case ROCKETLAUNCHERTOWER:
                return new RocketLauncherTower();
            case MAGICIAN:
                return new Magician();
            case PRIEST:
                return new Priest();
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    /*
     * FOUND 

     */
}
