package com.project;

public class Catapult extends DefenseUnit{

    public Catapult() {
        this.armor = (int)(ARMOR_CATAPULT * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ARMOR_CATAPULT_BY_TECHNOLOGY/100.0));
        this.initialArmor = armor;
        this.baseDamage = (int)(BASE_DAMAGE_CATAPULT * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ATTACK_CATAPULT_BY_TECHNOLOGY/100.0));
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
        return CHANCE_ATTACK_AGAIN_CATAPULT;
    }

    @Override
    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATING_WASTE_CATAPULT;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public int getFoodCost() {
       return FOOD_COST_CATAPULT;
    }

    @Override
    public int getIronCost() {
        return IRON_COST_CATAPULT;
    }

    @Override
    public int getManaCost() {
        return MANA_COST_CATAPULT;
    }

    @Override
    public int getWoodCost() {
        return WOOD_COST_CATAPULT;
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
        if (sanctified) {
            armor += (int)(armor * 0.07);
            armor -= receivedDamage;
        }
            armor -= receivedDamage;
    }


    @Override
    public UnitTypes getType(){
        return UnitTypes.CATAPULT;
    }
}