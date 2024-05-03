package com.project;

public class ArrowTower extends DefenseUnit {

    public ArrowTower() {
        this.armor = (int)(ARMOR_ARROWTOWER * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY/100.0));
        this.initialArmor = armor;
        this.baseDamage = (int)(BASE_DAMAGE_ARROWTOWER * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ATTACK_ARROWTOWER_BY_TECHNOLOGY/100.0));
    }

    @Override
    public int attack() {
        return (int)(baseDamage+baseDamage*experience*PLUS_ATTACK_UNIT_PER_EXPERIENCE_POINT/100);
    }

    @Override
    public int getActualArmor() {
        return (int)(armor+initialArmor*experience*PLUS_ARMOR_UNIT_PER_EXPERIENCE_POINT/100);
    }

    @Override
    public int getChanceAttackAgain() {
        return CHANCE_ATTACK_AGAIN_ARROWTOWER;
    }

    @Override
    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATNG_WASTE_ARROWTOWER;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public int getFoodCost() {
       return FOOD_COST_ARROWTOWER;
    }

    @Override
    public int getIronCost() {
        return IRON_COST_ARROWTOWER;
    }

    @Override
    public int getManaCost() {
        return MANA_COST_ARROWTOWER;
    }

    @Override
    public int getWoodCost() {
        return WOOD_COST_ARROWTOWER;
    }

    @Override
    public void resetArmor() {
        armor = initialArmor;
    }

    @Override
    public void setExperience(int exp) {
        experience = exp;
    }
    @Override
    public void takeDamage(int receivedDamage) {
        armor -= receivedDamage;
    }
    
}
