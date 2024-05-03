package com.project;

public class    Swordsman extends AttackUnit {
    private static final int ARMOR_SWORDSMAN = 400;
    private static final int BASE_DAMAGE_SWORDSMAN = 80;

    public Swordsman(int technologyDefenseLevel, int technologyAttackLevel) {
        this.armor = ARMOR_SWORDSMAN + (int)(ARMOR_SWORDSMAN * technologyDefenseLevel * 5);
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_SWORDSMAN + (int)(BASE_DAMAGE_SWORDSMAN * technologyAttackLevel * );
        this.experience = 0;
        this.sanctified = false;
    }

    public Swordsman() {
        this.armor = ARMOR_SWORDSMAN;
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_SWORDSMAN;
        this.experience = 0;
        this.sanctified = false;
    }

}