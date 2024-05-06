package com.project;

public class Crossbow extends AttackUnit {
    private static final int ARMOR_CROSSBOW = 6000;
    private static final int BASE_DAMAGE_CROSSBOW = 1000;

    public Crossbow(int technologyDefenseLevel, int technologyAttackLevel) {
        this.armor = ARMOR_CROSSBOW + (int)(ARMOR_CROSSBOW * technologyDefenseLevel *);
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_CROSSBOW + (int)(BASE_DAMAGE_CROSSBOW * technologyAttackLevel * );
        this.experience = 0;
        this.sanctified = false;
    }

    public Crossbow() {
        this.armor = ARMOR_CROSSBOW;
        this.initialArmor = this.armor;
        this.baseDamage = BASE_DAMAGE_CROSSBOW;
        this.experience = 0;
        this.sanctified = false;
    }
}