package com.project;

public class ArrowTower extends DefenseUnit {

    public ArrowTower() {
        this.armor = (int)(ARMOR_ARROWTOWER * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY/100.0));
        this.initialArmor = armor;
        this.baseDamage = (int)(BASE_DAMAGE_ARROWTOWER * (1+Civilization.getInstance().getTechnologyAttack()*PLUS_ATTACK_ARROWTOWER_BY_TECHNOLOGY/100.0));
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
        return CHANCE_ATTACK_AGAIN_ARROWTOWER;
    }

    @Override
    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATING_WASTE_ARROWTOWER;
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
        if (sanctified)
            receivedDamage *= (1-Variables.PLUS_ARMOR_UNIT_SANCTIFIED/100);
        armor -= receivedDamage;
    }
    @Override
    public UnitTypes getType(){
        return UnitTypes.ARROWTOWER;
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
