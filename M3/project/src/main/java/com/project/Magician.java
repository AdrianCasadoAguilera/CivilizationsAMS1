package com.project;

public class Magician extends SpecialUnit {

    public Magician(int armor,int baseDamage){
        this.armor = 0;
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_MAGICIAN + (Civilization.getInstance().getTechnologyAttack()*BASE_DAMAGE_MAGICIAN/100);
        this.experience = 0;
    }
    public Magician(){
        this.armor = (int)(1 * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ARMOR_MAGICIAN_BY_TECHNOLOGY/100.0));
        this.initialArmor = armor;
        this.baseDamage = (int)(BASE_DAMAGE_MAGICIAN * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ARMOR_MAGICIAN_BY_TECHNOLOGY/100.0));
    }


    @Override
    public int attack() {
        int calculatedDamage = (int)(baseDamage + baseDamage * experience * PLUS_ATTACK_UNIT_PER_EXPERIENCE_POINT / 100);
        return calculatedDamage;
    }

    @Override
    public void takeDamage(int receivedDamage) {
        armor -= receivedDamage;
    }

    @Override
    public int getActualArmor() {
        return (int)(armor+initialArmor*experience*PLUS_ARMOR_UNIT_PER_EXPERIENCE_POINT/100);    }

    @Override
    public int getFoodCost() {
        return FOOD_COST_MAGICIAN;
    }

    @Override
    public int getWoodCost() {
        return WOOD_COST_MAGICIAN;
    }

    @Override
    public int getIronCost() {
        return IRON_COST_MAGICIAN;
    }

    @Override
    public int getManaCost() {
        return MANA_COST_MAGICIAN;
    }

    @Override
    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATING_WASTE_MAGICIAN;
    }

    @Override
    public int getChanceAttackAgain() {
        return CHANCE_ATTACK_AGAIN_MAGICIAN;
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
        return UnitTypes.MAGICIAN;
    }
    
}