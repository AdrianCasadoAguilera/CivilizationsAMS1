package com.project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Battle {
    private ArrayList<MilitaryUnit> civilizationArmy;
    private ArrayList<MilitaryUnit> enemyArmy;
    private ArrayList<ArrayList<MilitaryUnit>> civilizationArmyOrdered;
    private ArrayList<ArrayList<MilitaryUnit>> enemyArmyOrdered;
    private int initialCivilizationArmySize;
    private int initialEnemyArmySize;

    private int WoodWaste;
    private int IronWaste;

    private ArrayList<Integer> civilizationLoses = new ArrayList<>(); //Food, Wood, Iron
    private ArrayList<Integer> enemyLoses = new ArrayList<>(); //Food, Wood, Iron
    private int civilizationTotalLoses;
    private int enemyTotalLoses;

    private String DeteiledReport = "";
    private boolean Win;

    public Battle(ArrayList<MilitaryUnit> civilizationArmy, ArrayList<MilitaryUnit> enemyArmy) {
        this.civilizationArmy = civilizationArmy;
        this.enemyArmy = enemyArmy;

        this.civilizationArmyOrdered = orderByUnitType(civilizationArmy);
        this.enemyArmyOrdered = orderByUnitType(enemyArmy);
        this.initialCivilizationArmySize = civilizationArmy.size();
        this.initialEnemyArmySize = enemyArmy.size();
        civilizationTotalLoses = 0;
        enemyTotalLoses = 0;
    }

    public ArrayList<ArrayList<MilitaryUnit>> orderByUnitType(ArrayList<MilitaryUnit> army) {
        ArrayList<ArrayList<MilitaryUnit>> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            result.add(new ArrayList<>());
        }
        System.out.println(result);
        for (int i = 0; i < army.size(); i++) {
            MilitaryUnit unit = army.get(i);
            switch (unit.getType()) {
                case SWORDSMAN:
                    result.get(0).add(unit);
                    break;
                case SPEARMAN:
                    result.get(1).add(unit);
                    break;
                case CROSSBOW:
                    result.get(2).add(unit);
                    break;
                case CANNON:
                    result.get(3).add(unit);
                    break;
                case ARROWTOWER:
                    result.get(4).add(unit);
                    break;
                case CATAPULT:
                    result.get(5).add(unit);
                    break;
                case ROCKETLAUNCHERTOWER:
                    result.get(6).add(unit);
                    break;
                case MAGICIAN:
                    result.get(7).add(unit);
                    break;
                case PRIEST:
                    result.get(8).add(unit);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + unit.getType());
            }
        }
        return result;
    }

    public void startBattle() {
        Random random = new Random();
        boolean turn = random.nextBoolean();
        if (civilizationArmy.size() > 0) {
            while (civilizationArmyOrdered.size() > initialCivilizationArmySize*0.2 || enemyArmyOrdered.size() > initialEnemyArmySize*0.2) {
                AddLineToDeteiledReport("********************CHANGE ATTACKER********************");
                ArrayList<ArrayList<MilitaryUnit>> AttackArmy = turn ? civilizationArmyOrdered : enemyArmyOrdered;
                ArrayList<ArrayList<MilitaryUnit>> DefenseArmy = turn ? enemyArmyOrdered : civilizationArmyOrdered;
                boolean repeatAttack = false;
                ArrayList<MilitaryUnit> AttackGroup = SelectAttackGroup(AttackArmy,turn);
                MilitaryUnit attackUnit = AttackGroup.get(random.nextInt(AttackGroup.size()));
                while (repeatAttack) {
                    MilitaryUnit defenseUnit = SelectDefenseUnit(DefenseArmy);
                    AddLineToDeteiledReport("Attacks: " + (turn ? "civilization" : "enemy army: ") + attackUnit.getType().toString() + " attacks " + defenseUnit.getType().toString());
                    AddLineToDeteiledReport(attackUnit.getType().toString() + " deals damage = " + attackUnit.attack());
                    defenseUnit.takeDamage(attackUnit.attack());
                    AddLineToDeteiledReport(defenseUnit.getType().toString() + " stays with armor = " + defenseUnit.getActualArmor());
                    if (defenseUnit.getActualArmor() <= 0) {
                        RemoveUnit(defenseUnit, turn ? enemyArmyOrdered : civilizationArmyOrdered);
                        AddToLosses(defenseUnit, turn);
                        GenerateWaste(defenseUnit);
                        repeatAttack = attackUnit.getChanceAttackAgain() > random.nextInt(100);
                    }
                }
            }
            Win = civilizationTotalLoses < enemyTotalLoses;
        }
        else {
            Win = false;
        }
        AddLineToDeteiledReport("The battle was win by: " + (Win ? "Civilization" : "Enemy"));
    }

    private void AddToLosses(MilitaryUnit defenseUnit, boolean turn) {
        if (turn) {
            enemyLoses.set(0, enemyLoses.get(0) + defenseUnit.getFoodCost());
            enemyLoses.set(1, enemyLoses.get(1) + defenseUnit.getWoodCost());
            enemyLoses.set(2, enemyLoses.get(2) + defenseUnit.getIronCost());

            enemyTotalLoses += defenseUnit.getIronCost();
            enemyTotalLoses += defenseUnit.getWoodCost()/5;
            enemyTotalLoses += defenseUnit.getFoodCost()/10;
        }
        else {
            civilizationLoses.set(0, civilizationLoses.get(0) + defenseUnit.getFoodCost());
            civilizationLoses.set(1, civilizationLoses.get(1) + defenseUnit.getWoodCost());
            civilizationLoses.set(2, civilizationLoses.get(2) + defenseUnit.getIronCost());

            civilizationTotalLoses += defenseUnit.getIronCost();
            civilizationTotalLoses += defenseUnit.getWoodCost()/5;
            civilizationTotalLoses += defenseUnit.getFoodCost()/10;
        }
    }

    private void GenerateWaste(MilitaryUnit defenseUnit) {
        if (defenseUnit.getChanceGeneratinWaste() > new Random().nextInt(100)) {
            WoodWaste += defenseUnit.getWoodCost()*Variables.PERCENTATGE_WASTE/100;
            IronWaste += defenseUnit.getIronCost()*Variables.PERCENTATGE_WASTE/100;
        }
        AddLineToDeteiledReport("generated waste: wood = " + WoodWaste + ", iron = " + IronWaste);
    }

    private void RemoveUnit(MilitaryUnit unit, ArrayList<ArrayList<MilitaryUnit>> army) {
        AddLineToDeteiledReport("we remove " + unit.getType().toString());
        army.get(unit.getType().ordinal()).remove(unit);
    }

    private MilitaryUnit SelectDefenseUnit(ArrayList<ArrayList<MilitaryUnit>> defenseArmy) {
        ArrayList<MilitaryUnit> allUnits = new ArrayList<>();
        for (int i = 0; i < defenseArmy.size(); i++) {
            allUnits.addAll(defenseArmy.get(i));
        }
        return allUnits.get(new Random().nextInt(allUnits.size()));
    }

    private ArrayList<MilitaryUnit> SelectAttackGroup(ArrayList<ArrayList<MilitaryUnit>> attackArmy, boolean turn) {
        int[] probabilities = turn ? Variables.CHANCE_ATTACK_CIVILIZATION_UNITS : Variables.CHANCE_ATTACK_ENEMY_UNITS;
        int random = new Random().nextInt(100);
        int index = 0;
        int cumulativeProv = probabilities[0];
        while (random >= cumulativeProv) {
            cumulativeProv += probabilities[index + 1];
            index++;
        }
        return attackArmy.get(index);
    }

    public String getReport() {
        /*Army planet Units Drops                       Initial Army Enemy Units Drops
        Sordsman      11    8                           Sordsman           19    17
        Spearman      3     1                           Spearman           7     5
        Crossbow 1 0                                    Crossbow 1 1
        Cannon 1 0                                      Cannon 1 0
        Arrow Tower 11 9
        Catapult 1 1
        Rocket Launcher Tower 1 0
        Magician 1 0
        Priest 1 1
        **************************************************************************************
        Cost Army Civilization                                      Cost Army Enemy
        Food: 203500                                                Food: 177500
        Wood: 28200                                                 Wood: 23300
        Iron: 35000                                                 Iron: 32000
        **************************************************************************************
        Losses Army Civilization                                    Losses Army Enemy
        Food: 52000                                                 Food: 128500
        Wood: 950                                                   Wood: 8100
        Iron: 23000                                                 Iron: 29000
        **************************************************************************************
        Waste Generated:
        Wood 22150
        Iron 12000
        Battle Winned by Civilization, We Collect Rubble
        ##########################################################################
        View Battle development?(S\n) */
        //TODO: reports
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-" + 25 + "s", "Civilization's Army"));
        sb.append(String.format("%-" + 6 + "s", "Units"));
        sb.append(String.format("%-" + 10 + "s", "Casualties"));
        sb.append(" ".repeat(40));
        sb.append(String.format("%-" + 25 + "s", "Enemy's Army"));
        sb.append(String.format("%-" + 6 + "s", "Units"));
        sb.append(String.format("%-" + 10 + "s", "Casualties") + "\n");
        ArrayList<ArrayList<MilitaryUnit>> InitialCivilizationArmyOrdered = orderByUnitType(civilizationArmy);
        ArrayList<ArrayList<MilitaryUnit>> InitialEnemyArmyOrdered = orderByUnitType(enemyArmy);
        for (int i = 0; i < 9; i++) {
            sb.append(String.format("%-" + 25 + "s", UnitTypes.values()[i].toString()));
            sb.append(String.format("%-" + 6 + "s", InitialCivilizationArmyOrdered.get(i).size()));
            sb.append(String.format("%-" + 10 + "s", InitialCivilizationArmyOrdered.get(i).size()-civilizationArmyOrdered.get(i).size()));
            if (i < 4) {
                sb.append(" ".repeat(40));
                sb.append(String.format("%-" + 25 + "s", UnitTypes.values()[i].toString()));
                sb.append(String.format("%-" + 6 + "s", InitialEnemyArmyOrdered.get(i).size()));
                sb.append(String.format("%-" + 10 + "s", InitialEnemyArmyOrdered.get(i).size()-enemyArmyOrdered.get(i).size()));
            }
            sb.append("\n");
        }
        sb.append("*".repeat(25+6+10+40+25+6+10) + "\n");
        //Cost
        sb.append(String.format("%-" + 25+6+10+40 + "s", "Cost Army Civilization"));
        sb.append(String.format("%-" + 25 + "s", "Cost Army Enemy") + "\n");
        ArrayList<Integer> civCost = new ArrayList<>(Arrays.asList(0,0,0));
        ArrayList<Integer> enemyCost = new ArrayList<>(Arrays.asList(0,0,0));
        System.out.println(enemyArmy.size());
        for (MilitaryUnit unit : civilizationArmy) {
            civCost.set(0, civCost.get(0) + unit.getFoodCost());
            civCost.set(1, civCost.get(1) + unit.getWoodCost());
            civCost.set(2, civCost.get(2) + unit.getIronCost());
        }
        for (MilitaryUnit unit :enemyArmy) {
            enemyCost.set(0, enemyCost.get(0) + unit.getFoodCost());
            enemyCost.set(1, enemyCost.get(1) + unit.getWoodCost());
            enemyCost.set(2, enemyCost.get(2) + unit.getIronCost());
        }
        sb.append(String.format("%-" + 25+6+10+40 + "s", "Food: " + civCost.get(0)));
        sb.append(String.format("%-" + 25 + "s", "Food: " + enemyCost.get(0)) + "\n");
        sb.append(String.format("%-" + 25+6+10+40 + "s", "Wood: " + civCost.get(1)));
        sb.append(String.format("%-" + 25 + "s", "Wood: " + enemyCost.get(1)) + "\n");
        sb.append(String.format("%-" + 25+6+10+40 + "s", "Iron: " + civCost.get(2)));
        sb.append(String.format("%-" + 25 + "s", "Iron: " + enemyCost.get(2)) + "\n");
        sb.append("*".repeat(25+6+10+40+25+6+10) + "\n");
        //Losses
        sb.append(String.format("%-" + 25+6+10+40 + "s", "Losses Army Civilization"));
        sb.append(String.format("%-" + 25 + "s", "Losses Army Enemy") + "\n");
        sb.append(String.format("%-" + 25+6+10+40 + "s", "Food: " + civilizationTotalLoses));
        sb.append(String.format("%-" + 25 + "s", "Food: " + enemyTotalLoses) + "\n");
        sb.append(String.format("%-" + 25+6+10+40 + "s", "Wood: " + civilizationTotalLoses/5));
        sb.append(String.format("%-" + 25 + "s", "Wood: " + enemyTotalLoses/5) + "\n");
        sb.append(String.format("%-" + 25+6+10+40 + "s", "Iron: " + civilizationTotalLoses/10));
        sb.append(String.format("%-" + 25 + "s", "Iron: " + enemyTotalLoses/10) + "\n");
        sb.append("*".repeat(25+6+10+40+25+6+10) + "\n");
        //Waste Generated
        sb.append(String.format("%-" + 25+6+10+40 + "s", "Waste Generated") + "\n");
        sb.append(String.format("%-" + 25+6+10+40 + "s", "Wood: " + WoodWaste));
        sb.append(String.format("%-" + 25 + "s", "Iron: " + IronWaste) + "\n");
        sb.append("\n");
        //Win and ask detailed
        if (Win)
            sb.append("Battle Winned by Civilization, We Collect Rubble" + "\n");
        else
            sb.append("Battle Lost by Civilization, We Collect Rubble" + "\n");
        sb.append("\n");
        sb.append("#".repeat(25+6+10+40+25+6+10) + "\n");
        sb.append("\n");
        sb.append("View Battle development?(S/n)" + "\n");

        return sb.toString();
    }

    public void AddLineToDeteiledReport(String line) {
        DeteiledReport += line+"\n";
    }

    public String getDeteiledReport() {
        return DeteiledReport;
    }

    public void recollectWaste(Civilization civilization) {

    }

    public void civilizationArmyAfter(Civilization civilization) {

    }
}
