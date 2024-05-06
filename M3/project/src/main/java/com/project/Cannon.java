package com.project;

public class Cannon extends AttackUnit {
    private static final int ARMOR_CANNON = 8000;
    private static final int BASE_DAMAGE_CANNON = 700;

    public Cannon(int technologyDefenseLevel, int technologyAttackLevel) {
        this.armor = ARMOR_CANNON + (int)(ARMOR_CANNON * technologyDefenseLevel * 0.7);
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_CANNON + (int)(BASE_DAMAGE_CANNON * technologyAttackLevel * 0.9);
        this.experience = 0;
        this.sanctified = false;
    }

    public Cannon() {
        this.armor = ARMOR_CANNON;
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_CANNON;
        this.experience = 0;
        this.sanctified = false;
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
        return CHANCE_ATTACK_AGAIN_CANNON;
    }

    @Override
    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATING_WASTE_CANNON;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public int getFoodCost() {
       return FOOD_COST_CANNON;
    }

    @Override
    public int getIronCost() {
        return IRON_COST_CANNON;
    }

    @Override
    public int getManaCost() {
        return MANA_COST_CANNON;
    }

    @Override
    public int getWoodCost() {
        return WOOD_COST_CANNON;
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
    @Override
    public UnitTypes getType(){
        return UnitTypes.CANNON;
    }
}