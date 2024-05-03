package com.project;

public class Spearman extends AttackUnit {
    private static final int ARMOR_SPEARMAN = 1000;
    private static final int BASE_DAMAGE_SPEARMAN = 150;

    public Spearman(int technologyDefenseLevel, int technologyAttackLevel) {
        this.armor = ARMOR_SPEARMAN + (int)(ARMOR_SPEARMAN * technologyDefenseLevel * 3);
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_SPEARMAN + (int)(BASE_DAMAGE_SPEARMAN * technologyAttackLevel * );
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
}