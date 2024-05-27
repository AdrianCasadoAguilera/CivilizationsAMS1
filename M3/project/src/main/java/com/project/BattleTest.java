// package com.project;

// import java.util.*;

// public class BattleTest {
//     public static void main(String[] args) {
//         Map<UnitTypes,Integer> civArmy = new HashMap<UnitTypes,Integer>() {{
//             put(UnitTypes.SWORDSMAN,40);
//             put(UnitTypes.SPEARMAN,30);
//             put(UnitTypes.CROSSBOW,30);
//             put(UnitTypes.CANNON,10);
//             put(UnitTypes.ARROWTOWER,20);
//             put(UnitTypes.CATAPULT,10);
//             put(UnitTypes.ROCKETLAUNCHERTOWER,10);
//             put(UnitTypes.MAGICIAN,10);
//             put(UnitTypes.PRIEST,10);
//         }};
//         Map<UnitTypes,Integer> enemyArmy = new HashMap<UnitTypes,Integer>() {{
//             put(UnitTypes.SWORDSMAN,50);
//             put(UnitTypes.SPEARMAN,50);
//             put(UnitTypes.CROSSBOW,30);
//             put(UnitTypes.CANNON,10);
//         }};
//         ArrayList<MilitaryUnit> armyUnits = GenerateUnits(civArmy);
//         ArrayList<MilitaryUnit> enemyUnits = GenerateUnits(enemyArmy);
//         Battle battle = new Battle(armyUnits,enemyUnits);
//         battle.startBattle();
//         while (true) {
//             System.out.println("1. Report");
//             System.out.println("2. Detailed Report");
//             try {
//                 int choice = Integer.parseInt(new Scanner(System.in).nextLine());
//                 if (choice == 1) {
//                     System.out.println(battle.getReport());
//                     System.out.println(battle.isWin());
//                 }
//                 else if (choice == 2)
//                     System.out.println(battle.getDeteiledReport());
//             } catch (Exception e) {
//                 System.out.println("Invalid choice");
//             }
//         }
//     }

//     private static ArrayList<MilitaryUnit> GenerateUnits(Map<UnitTypes,Integer> army) {
//         ArrayList<MilitaryUnit> generatedUnits = new ArrayList<>();
//         for (Map.Entry<UnitTypes,Integer> entry : army.entrySet()) {
//             int quantity = entry.getValue();
//             UnitTypes type = entry.getKey();
//             for (int i = 0; i < quantity; i++) {
//                 generatedUnits.add(getNewUnit(type));
//             }
//         }

//         return generatedUnits;
//     }

//     private static MilitaryUnit getNewUnit(UnitTypes type) {
//         switch (type) {
//             case SWORDSMAN:
//                 return new Swordsman();
//             case SPEARMAN:
//                 return new Spearman();
//             case CROSSBOW:
//                 return new Crossbow();
//             case CANNON:
//                 return new Cannon();
//             case ARROWTOWER:
//                 return new ArrowTower();
//             case CATAPULT:
//                 return new Catapult();
//             case ROCKETLAUNCHERTOWER:
//                 return new RocketLauncherTower();
//             case MAGICIAN:
//                 return new Magician();
//             case PRIEST:
//                 return new Priest();
//             default:
//                 throw new IllegalStateException("Unexpected value: " + type);
//         }
//     }

//     /*
//      * FOUND 

//      */
// }
