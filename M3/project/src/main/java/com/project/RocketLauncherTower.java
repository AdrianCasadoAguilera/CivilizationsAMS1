package com.project;

public class RocketLauncherTower extends DefenseUnit{

    public RocketLauncherTower() {
        this.armor = (int)(ARMOR_ROCKETLAUNCHERTOWER * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ARMOR_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY/100.0));
        this.initialArmor = armor;
        this.baseDamage = (int)(BASE_DAMAGE_ROCKETLAUNCHERTOWER * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ATTACK_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY/100.0));
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
        return CHANCE_ATTACK_AGAIN_ROCKETLAUNCHERTOWER;
    }

    @Override
    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATING_WASTE_ROCKETLAUNCHERTOWER;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public int getFoodCost() {
       return FOOD_COST_ROCKETLAUNCHERTOWER;
    }

    @Override
    public int getIronCost() {
        return IRON_COST_ROCKETLAUNCHERTOWER;
    }

    @Override
    public int getManaCost() {
        return MANA_COST_ROCKETLAUNCHERTOWER;
    }

    @Override
    public int getWoodCost() {
        return WOOD_COST_ROCKETLAUNCHERTOWER;
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
        return UnitTypes.ROCKETLAUNCHERTOWER;
    }

    @Override
    public boolean isSanctified() {
        return sanctified;
    }

    @Override
    public void setSanctified(boolean b) {
        sanctified = b;
    }
    
}