package com.project;

public class Cannon extends AttackUnit {

    public Cannon(int armor, int baseDamage) {
        this.armor = ARMOR_CANNON + (int)(PLUS_ARMOR_CANNON_BY_TECHNOLOGY * Civilization.getInstance().getTechnologyDefense())*ARMOR_CANNON/100;
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_CANNON + (int)(PLUS_ARMOR_CANNON_BY_TECHNOLOGY * Civilization.getInstance().getTechnologyAttack())*BASE_DAMAGE_CANNON/100;
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
        int calculatedDamage = (int)(baseDamage + baseDamage * experience * PLUS_ATTACK_UNIT_PER_EXPERIENCE_POINT / 100);
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
        if (sanctified) {
            armor += (int)(armor * 0.07);
            armor -= receivedDamage;
        }
            armor -= receivedDamage;
    }


    @Override
    public UnitTypes getType(){
        return UnitTypes.CANNON;
    }


    public boolean isSanctified() {
        return sanctified;
    }

    public void setSanctified(boolean sanctified) {
        this.sanctified = sanctified;
    }

}