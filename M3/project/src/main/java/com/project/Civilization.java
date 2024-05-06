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
        try {
            if (food < Variables.FOOD_COST_CHURCH) {
                throw new ResourceException("Food",  Variables.FOOD_COST_CHURCH, food);
            }
            if (wood < Variables.WOOD_COST_CHURCH) {
                throw new ResourceException("wood",  Variables.WOOD_COST_CHURCH, wood);
            }
            if (iron < Variables.IRON_COST_CHURCH) {
                throw new ResourceException("Iron",  Variables.IRON_COST_CHURCH, iron);
            }
            if (mana < Variables.WOOD_COST_CHURCH) {
                throw new ResourceException("Mana",  Variables.MANA_COST_CHURCH, mana);
            }
        } catch (ResourceException e) {
            System.out.println(e.getMessage());
            return;
        }
        church++;
        wood -= Variables.WOOD_COST_CHURCH;
        iron -= Variables.IRON_COST_CHURCH;
        food -= Variables.FOOD_COST_CHURCH;
        mana -= Variables.MANA_COST_CHURCH;
    }

    public void newMagicTower() {
        try {
            if (food < Variables.FOOD_COST_MAGICTOWER) {
                throw new ResourceException("Food", Variables.FOOD_COST_MAGICTOWER, food);
            }
            if (wood < Variables.WOOD_COST_MAGICTOWER) {
                throw new ResourceException("wood", Variables.WOOD_COST_MAGICTOWER, wood);
            }
            if (iron < Variables.IRON_COST_MAGICTOWER) {
                throw new ResourceException("Iron", Variables.IRON_COST_MAGICTOWER, iron);
            }
        } catch (ResourceException e) {
            System.out.println(e.getMessage());
            return;
        }
        magicTower++;
        food -= Variables.FOOD_COST_MAGICTOWER;
        wood -= Variables.WOOD_COST_MAGICTOWER;
        iron -= Variables.IRON_COST_MAGICTOWER;
    }

    public void newFarm() {
        try {
            if (food < Variables.FOOD_COST_FARM) {
                throw new ResourceException("Food", Variables.FOOD_COST_FARM, food);
            }
            if (wood < Variables.WOOD_COST_FARM) {
                throw new ResourceException("wood", Variables.WOOD_COST_FARM, wood);
            }
            if (iron < Variables.IRON_COST_FARM) {
                throw new ResourceException("Iron", Variables.IRON_COST_FARM, iron);
            }
        } catch (ResourceException e) {
            System.out.println(e.getMessage());
            return;
        }
        farm++;
        food -= Variables.FOOD_COST_FARM;
        wood -= Variables.WOOD_COST_FARM;
        iron -= Variables.IRON_COST_FARM;
    }

    public void newCarpentry() {
        try {
            if (food < Variables.FOOD_COST_CARPENTRY) {
                throw new ResourceException("Food", Variables.FOOD_COST_CARPENTRY, food);
            }
            if (wood < Variables.WOOD_COST_CARPENTRY) {
                throw new ResourceException("wood", Variables.WOOD_COST_CARPENTRY, wood);
            }
            if (iron < Variables.IRON_COST_CARPENTRY) {
                throw new ResourceException("Iron", Variables.IRON_COST_CARPENTRY, iron);
            }

        } catch (ResourceException e) {
            System.out.println(e.getMessage());
            return;
        }
        carpentry++;
        food -= Variables.FOOD_COST_CARPENTRY;
        wood -= Variables.WOOD_COST_CARPENTRY;
        iron -= Variables.IRON_COST_CARPENTRY;
    }

    public void newSmithy() {
        if (iron < Variables.IRON_COST_SMITHY) {
            // excepción
        }
        smithy++;
        iron -= Variables.IRON_COST_SMITHY;
    }

    public void upgradeTechnologyDefense() {
        int baseFoodCost = Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_FOOD_COST;
        int plusFoodPercentage = Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_FOOD_COST * technologyDefense;
        int totalFoodCost = baseFoodCost + baseFoodCost*plusFoodPercentage/100;
        
        int baseWoodCost = Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST;
        int plusWoodPercentage = Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_WOOD_COST * technologyDefense;
        int totalWoodCost = baseWoodCost + baseWoodCost*plusWoodPercentage/100;

        int baseIronCost = Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST;
        int plusIronPercentage = Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_IRON_COST * technologyDefense;
        int totalIronCost = baseIronCost + baseIronCost*plusIronPercentage/100;

        try {
            if (food < totalFoodCost) {
                throw new ResourceException("Food", totalFoodCost, food);
            }
            if (wood < totalWoodCost) {
                throw new ResourceException("wood", totalWoodCost, wood);
            }
            if (iron < totalIronCost) {
                throw new ResourceException("Iron", totalIronCost, iron);
            }
        } catch (ResourceException e) {
            System.out.println(e.getMessage());
            return;
        }
        technologyDefense++;
        food -= totalFoodCost;
        wood -= totalWoodCost;
        iron -= totalIronCost;
    }

    public void upgradeTechnologyAttack() {
        int baseFoodCost = Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_FOOD_COST;
        int plusFoodPercentage = Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_FOOD_COST * technologyDefense;
        int totalFoodCost = baseFoodCost + baseFoodCost*plusFoodPercentage/100;
        
        int baseWoodCost = Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST;
        int plusWoodPercentage = Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_WOOD_COST * technologyDefense;
        int totalWoodCost = baseWoodCost + baseWoodCost*plusWoodPercentage/100;

        int baseIronCost = Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST;
        int plusIronPercentage = Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_IRON_COST * technologyDefense;
        int totalIronCost = baseIronCost + baseIronCost*plusIronPercentage/100;

        try {
            if (food < totalFoodCost) {
                throw new ResourceException("Food", totalFoodCost, food);
            }
            if (wood < totalWoodCost) {
                throw new ResourceException("wood", totalWoodCost, wood);
            }
            if (iron < totalIronCost) {
                throw new ResourceException("Iron", totalIronCost, iron);
            }
        } catch (ResourceException e) {
            System.out.println(e.getMessage());
            return;
        }
        technologyAttack++;
        food -= totalFoodCost;
        wood -= totalWoodCost;
        iron -= totalIronCost;
    }

//Función  de momento no necesaria    private int calculateCost(int level) {
//        return 100 + (10 * level);
//    }

}