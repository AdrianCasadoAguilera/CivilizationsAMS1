package com.project;

import java.util.ArrayList;

public class Civilization {
    private static Civilization instance;
    private int technologyDefense;
    private int technologyAttack;
    private int wood;
    private int iron;
    private int food;
    private int mana;
    private int magicTower;
    private int church;
    private int farm;
    private int smithy;
    private int carpentry;
    private int battles;
    private ArrayList<AttackUnit> army;

    private Civilization() {
        army = new ArrayList<>(9);
    }

    public static Civilization getInstance() {
        if (instance == null) {
            instance = new Civilization();
        }
        return instance;
    }

    public int getTechnologyDefense() {
        return technologyDefense;
    }

    public void setTechnologyDefense(int technologyDefense) {
        this.technologyDefense = technologyDefense;
    }

    public int getTechnologyAttack() {
        return technologyAttack;
    }

    public void setTechnologyAttack(int technologyAttack) {
        this.technologyAttack = technologyAttack;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMagicTower() {
        return magicTower;
    }

    public void setMagicTower(int magicTower) {
        this.magicTower = magicTower;
    }

    public int getChurch() {
        return church;
    }

    public void setChurch(int church) {
        this.church = church;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public int getSmithy() {
        return smithy;
    }

    public void setSmithy(int smithy) {
        this.smithy = smithy;
    }

    public int getCarpentry() {
        return carpentry;
    }

    public void setCarpentry(int carpentry) {
        this.carpentry = carpentry;
    }

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public ArrayList<AttackUnit> getArmy() {
        return army;
    }

    public void setArmy(ArrayList<AttackUnit> army) {
        this.army = army;
    }


    public void newChurch() {
        if (wood < Variables.WOOD_COST_CHURCH) {
            throw new ResourceException("Mana",  Variables.MANA_COST_CHURCH, mana);
        }
        church++;
        wood -= Variables.WOOD_COST_CHURCH;
    }

    public void newMagicTower() {
        if (mana < Variables.MANA_COST_MAGICTOWER) {
            throw new ResourceException("Mana",  Variables.MANA_COST_CHURCH, mana);
        }
        magicTower++;
        mana -= Variables.MANA_COST_MAGICTOWER;
    }

    public void newFarm() {
        if (wood < Variables.WOOD_COST_FARM) {
            // excepción
        }
        farm++;
        wood -= Variables.WOOD_COST_FARM;
    }

    public void newCarpentry() {
        if (wood < Variables.WOOD_COST_CARPENTRY) {
            // excepción
        }
        carpentry++;
        wood -= Variables.WOOD_COST_CARPENTRY;
    }

    public void newSmithy() {
        if (iron < Variables.IRON_COST_SMITHY) {
            // excepción
        }
        smithy++;
        iron -= Variables.IRON_COST_SMITHY;
    }

    public void upgradeTechnologyDefense() {
        int baseCost = Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST;
        int additionalCost = Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_IRON_COST * technologyDefense;
        int totalCost = baseCost + additionalCost;

        if (iron < totalCost) {
            // excepción
        }
        technologyDefense++;
        iron -= totalCost;
    }

    public void upgradeTechnologyAttack() {
        int baseCost = Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST;
        int additionalCost = Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_IRON_COST * technologyAttack;
        int totalCost = baseCost + additionalCost;

        if (iron < totalCost) {
            // excepción
        }
        technologyAttack++;
        iron -= totalCost;
    }

//Función  de momento no necesaria    private int calculateCost(int level) {
//        return 100 + (10 * level);
//    }

}