package com.project;

public class Spearman extends AttackUnit {
    private static final int ARMOR_SPEARMAN = 1000;
    private static final int BASE_DAMAGE_SPEARMAN = 150;

    public Spearman(int technologyDefenseLevel, int technologyAttackLevel) {
        this.armor = ARMOR_SPEARMAN + (int)(PLUS_ARMOR_SPEARMAN_BY_TECHNOLOGY*technologyDefenseLevel)*ARMOR_SPEARMAN/100;
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_SPEARMAN + (int)(PLUS_ATTACK_SPEARMAN_BY_TECHNOLOGY * technologyAttackLevel)*BASE_DAMAGE_SPEARMAN/100;
        this.experience = 0;
        this.sanctified = false;
    }

    public Spearman() {
        this.armor = ARMOR_SPEARMAN;
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_SPEARMAN;
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
    public void takeDamage(int receivedDamage) {
        if (sanctified)
            receivedDamage *= (1-Variables.PLUS_ARMOR_UNIT_SANCTIFIED/100);
        armor -= receivedDamage;
    }

    @Override
    public int getActualArmor() {
        return (int)(armor+initialArmor*experience*PLUS_ARMOR_UNIT_PER_EXPERIENCE_POINT/100);
    }

    @Override
    public int getFoodCost() {
        return FOOD_COST_SPEARMAN;
    }

    @Override
    public int getWoodCost() {
        return WOOD_COST_SPEARMAN;
    }

    @Override
    public int getIronCost() {
        return IRON_COST_SPEARMAN;
    }

    @Override
    public int getManaCost() {
        return MANA_COST_SPEARMAN;
    }

    @Override
    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATING_WASTE_SPEARMAN;
    }

    @Override
    public int getChanceAttackAgain() {
        return CHANCE_ATTACK_AGAIN_SPEARMAN;
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
    public int getExperience() {
        return experience;
    }

    @Override
    public UnitTypes getType() {
        return UnitTypes.SPEARMAN;
    }


    public boolean isSanctified() {
        return sanctified;
    }

    public void setSanctified(boolean sanctified) {
        this.sanctified = sanctified;
    }

}