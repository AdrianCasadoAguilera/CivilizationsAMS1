package com.project;

public class Priest extends SpecialUnit {

    public Priest(){
        this.armor = 1;
        this.initialArmor = armor;
        this.baseDamage = 1;
        this.experience = 0;
    }


    @Override
    public int attack() {
        return (int)(baseDamage * (1+experience * PLUS_ATTACK_UNIT_PER_EXPERIENCE_POINT / 100));
    }

    @Override
    public void takeDamage(int receivedDamage) {
        armor -= receivedDamage;
    }

    @Override
    public int getActualArmor() {
        return (int)(armor+initialArmor*experience*PLUS_ARMOR_UNIT_PER_EXPERIENCE_POINT/100);
    }

    @Override
    public int getFoodCost() {
        return FOOD_COST_PRIEST;
    }

    @Override
    public int getWoodCost() {
        return WOOD_COST_PRIEST;
    }

    @Override
    public int getIronCost() {
        return IRON_COST_PRIEST;
    }

    @Override
    public int getManaCost() {
        return MANA_COST_PRIEST;
    }

    @Override
    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATING_WASTE_PRIEST;
    }

    @Override
    public int getChanceAttackAgain() {
        return CHANCE_ATTACK_AGAIN_PRIEST;
    }

    @Override
    public void resetArmor() {
        armor = initialArmor;
    }

    @Override
    public void setExperience(int n) {
        experience = n;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override 
    public UnitTypes getType(){
        return UnitTypes.PRIEST;
    }
    @Override
    public boolean isSanctified() {
        return false;
    }
    @Override
    public void setSanctified(boolean b) {
        
    }
}
