package com.project;

public class Catapult extends DefenseUnit{

    public Catapult() {
        this.armor = (int)(ARMOR_CATAPULT * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ARMOR_CATAPULT_BY_TECHNOLOGY/100.0));
        this.initialArmor = armor;
        this.baseDamage = (int)(BASE_DAMAGE_CATAPULT * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ATTACK_CATAPULT_BY_TECHNOLOGY/100.0));
        this.experience = 0;
        this.sanctified = false;
    }

    @Override
    public int attack() {
        int calculatedDamage = (int)(baseDamage * (1+experience * PLUS_ATTACK_UNIT_PER_EXPERIENCE_POINT / 100));
        if (sanctified) {
            calculatedDamage += baseDamage * PLUS_ATTACK_UNIT_SANCTIFIED / 100;
        }
        return calculatedDamage;
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
        if (sanctified)
            receivedDamage *= (1-Variables.PLUS_ARMOR_UNIT_SANCTIFIED/100);
        armor -= receivedDamage;
    }


    @Override
    public UnitTypes getType(){
        return UnitTypes.CATAPULT;
    }


    public boolean isSanctified() {
        return sanctified;
    }

    public void setSanctified(boolean sanctified) {
        this.sanctified = sanctified;
    }

}