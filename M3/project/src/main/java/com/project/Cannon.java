package com.project;

public class Cannon extends AttackUnit {
    private static final int ARMOR_CANNON = 8000;
    private static final int BASE_DAMAGE_CANNON = 700;

    public Cannon(int technologyDefenseLevel, int technologyAttackLevel) {
        this.armor = ARMOR_CANNON + (int)(ARMOR_CANNON * technologyDefenseLevel * 0.7);
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_CANNON + (int)(BASE_DAMAGE_CANNON * technologyAttackLevel * 0.9);
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
}