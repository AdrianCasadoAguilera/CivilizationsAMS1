package com.project;

public interface Variables {
    //Battle lost resources percentage after a defeat
    public final float BATTLE_LOST_RESOURCES_PERCENTAGE = 0.3f;
    // resources available to create the first enemy fleet
    public final int IRON_BASE_ENEMY_ARMY = 2000;
    public final int WOOD_BASE_ENEMY_ARMY = 12000;
    public final int FOOD_BASE_ENEMY_ARMY = 15000;
    // percentage increase of resources available to create enemy fleet
    public final int ENEMY_FLEET_INCREASE = 10;
    // resources increment every minute
    public final int CIVILIZATION_IRON_GENERATED = 2500;
    public final int CIVILIZATION_WOOD_GENERATED = 15000;
    public final int CIVILIZATION_FOOD_GENERATED = 20000;
    public final int CIVILIZATION_IRON_GENERATED_PER_SMITHY = (int) (0.15*CIVILIZATION_IRON_GENERATED);
    public final int CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY = (int) (0.15*CIVILIZATION_WOOD_GENERATED);
    public final int CIVILIZATION_FOOD_GENERATED_PER_FARM = (int) (0.15*CIVILIZATION_FOOD_GENERATED);
    public final int CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER = 1000;
    // TECHNOLOGY COST
    public final int UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST = 2000;
    public final int UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST = 2000;
    public final int UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST = 5000;
    public final int UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST = 5000;
    public final int UPGRADE_BASE_DEFENSE_TECHNOLOGY_FOOD_COST = 5000;
    public final int UPGRADE_BASE_ATTACK_TECHNOLOGY_FOOD_COST = 5000;
    //UPGRADE_PLUS
    public final int UPGRADE_PLUS_DEFENSE_TECHNOLOGY_IRON_COST = 20;
    public final int UPGRADE_PLUS_ATTACK_TECHNOLOGY_IRON_COST = 20 ;
    public final int UPGRADE_PLUS_DEFENSE_TECHNOLOGY_WOOD_COST = 15;
    public final int UPGRADE_PLUS_ATTACK_TECHNOLOGY_WOOD_COST = 15;
    public final int UPGRADE_PLUS_DEFENSE_TECHNOLOGY_FOOD_COST = 10;
    public final int UPGRADE_PLUS_ATTACK_TECHNOLOGY_FOOD_COST = 10;
    // COST ATTACK UNITS
    public final int FOOD_COST_SWORDSMAN = 5000;
    public final int WOOD_COST_SWORDSMAN = 3000;
    public final int IRON_COST_SWORDSMAN = 400;
    public final int MANA_COST_SWORDSMAN = 0;
    public final int FOOD_COST_SPEARMAN = 6000;
    public final int WOOD_COST_SPEARMAN = 2000;
    public final int IRON_COST_SPEARMAN = 600;
    public final int MANA_COST_SPEARMAN = 0;
    public final int FOOD_COST_CROSSBOW = 7500;
    public final int WOOD_COST_CROSSBOW = 4500;
    public final int IRON_COST_CROSSBOW = 1000;
    public final int MANA_COST_CROSSBOW = 0;
    public final int FOOD_COST_CANNON = 1000;
    public final int WOOD_COST_CANNON = 10000;
    public final int IRON_COST_CANNON = 30000;
    public final int MANA_COST_CANNON = 0;
    // COST DEFENSES ARROWTOWER, CATAPULT, ROCKETLAUNCHERTOWER
    public final int FOOD_COST_ARROWTOWER = 2000;
    public final int WOOD_COST_ARROWTOWER = 5000;
    public final int IRON_COST_ARROWTOWER = 500;
    public final int MANA_COST_ARROWTOWER = 0;
    public final int FOOD_COST_CATAPULT = 1000;
    public final int WOOD_COST_CATAPULT = 7000;
    public final int IRON_COST_CATAPULT = 750;
    public final int MANA_COST_CATAPULT = 0;
    public final int FOOD_COST_ROCKETLAUNCHERTOWER = 2000;
    public final int WOOD_COST_ROCKETLAUNCHERTOWER = 2000;
    public final int IRON_COST_ROCKETLAUNCHERTOWER = 40000;
    public final int MANA_COST_ROCKETLAUNCHERTOWER = 0;
    //Cost Especial units
    public final int FOOD_COST_MAGICIAN = 4000;
    public final int WOOD_COST_MAGICIAN = 4000;
    public final int IRON_COST_MAGICIAN = 1000;
    public final int MANA_COST_MAGICIAN = 5000;
    public final int FOOD_COST_PRIEST = 5000;
    public final int WOOD_COST_PRIEST = 2000;
    public final int IRON_COST_PRIEST = 500;
    public final int MANA_COST_PRIEST = 7000;              // VALOR DE PRUEBA. CAMBIAR!!!!!!!!!
    // public final int MANA_COST_PRIEST = 15000;
    // array units costs SWORDSMAN, SPEARMAN, CROSSBOW, CANNON, ARROWTOWER, CATAPULT, ROCKETLAUNCHERTOWER
    public final int WOOD_COST_UNITS[] =
    {WOOD_COST_SWORDSMAN,WOOD_COST_SPEARMAN,WOOD_COST_CROSSBOW,WOOD_COST_CANNON,WOOD_COST_ARROWTOWER,WOOD_COST_CATAPULT,WOOD_COST_ROCKETLAUNCHERTOWER,WOOD_COST_MAGICIAN,WOOD_COST_PRIEST};
    public final int IRON_COST_UNITS[] = {IRON_COST_SWORDSMAN,IRON_COST_SPEARMAN,IRON_COST_CROSSBOW,IRON_COST_CANNON,IRON_COST_ARROWTOWER,IRON_COST_CATAPULT,IRON_COST_ROCKETLAUNCHERTOWER,IRON_COST_MAGICIAN,IRON_COST_PRIEST};
    public final int FOOD_COST_UNITS[] = {FOOD_COST_SWORDSMAN,FOOD_COST_SPEARMAN,FOOD_COST_CROSSBOW,FOOD_COST_CANNON,FOOD_COST_ARROWTOWER,FOOD_COST_CATAPULT,FOOD_COST_ROCKETLAUNCHERTOWER,FOOD_COST_MAGICIAN,FOOD_COST_PRIEST};
    //Cost Buildings
    public final int FOOD_COST_FARM = 2000;
    public final int WOOD_COST_FARM = 2000;
    public final int IRON_COST_FARM = 2000;
    public final int FOOD_COST_CARPENTRY = 3000;
    public final int WOOD_COST_CARPENTRY = 2000;
    public final int IRON_COST_CARPENTRY = 4000;
    public final int FOOD_COST_SMITHY = 1000;
    public final int WOOD_COST_SMITHY = 7000;
    public final int IRON_COST_SMITHY = 2500;
    public final int FOOD_COST_CHURCH = 7000;
    public final int WOOD_COST_CHURCH = 2000;
    public final int IRON_COST_CHURCH = 2000;
    public final int MANA_COST_CHURCH = 2000;
    public final int FOOD_COST_MAGICTOWER = 3000;
    public final int WOOD_COST_MAGICTOWER = 5000;
    public final int IRON_COST_MAGICTOWER = 5000;
    public final int MANA_COST_MAGICTOWER = 0;
    // BASE DAMAGE ATTACK UNITS
    public final int BASE_DAMAGE_SWORDSMAN = 210;
    public final int BASE_DAMAGE_SPEARMAN = 400;
    public final int BASE_DAMAGE_CROSSBOW = 400;
    public final int BASE_DAMAGE_CANNON = 2000;
    // BASE DAMAGE DEFENSES
    public final int BASE_DAMAGE_ARROWTOWER = 350;
    public final int BASE_DAMAGE_CATAPULT = 300;
    public final int BASE_DAMAGE_ROCKETLAUNCHERTOWER = 700;
    public final int BASE_DAMAGE_MAGICIAN = 750;
    // ARMOR ATTACK UNITS
    public final int ARMOR_SWORDSMAN = 750;
    public final int ARMOR_SPEARMAN = 400;
    public final int ARMOR_CROSSBOW = 500;
    public final int ARMOR_CANNON = 3000;
    // ARMOR DEFENSES
    public final int ARMOR_ARROWTOWER = 420;
    public final int ARMOR_CATAPULT = 800;
    public final int ARMOR_ROCKETLAUNCHERTOWER = 1250;
    // number of units a priest sanctifies 
    public final int NUMBER_OF_UNITS_SANCTIFIED_BY_PRIEST = 5;
    //Attack Units armor increase percentage per tech level
    public final int PLUS_ARMOR_SWORDSMAN_BY_TECHNOLOGY = 5;
    public final int PLUS_ARMOR_SPEARMAN_BY_TECHNOLOGY = 5;
    public final int PLUS_ARMOR_CROSSBOW_BY_TECHNOLOGY = 5;
    public final int PLUS_ARMOR_CANNON_BY_TECHNOLOGY = 5;
    public final int PLUS_ARMOR_MAGICIAN_BY_TECHNOLOGY = 5;
    // defense armor increase percentage per tech level
    public final int PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY = 5;
    public final int PLUS_ARMOR_CATAPULT_BY_TECHNOLOGY = 5;
    public final int PLUS_ARMOR_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY = 5;
    // attack units power increase percentage per tech level
    public final int PLUS_ATTACK_SWORDSMAN_BY_TECHNOLOGY = 5;
    public final int PLUS_ATTACK_SPEARMAN_BY_TECHNOLOGY = 5;
    public final int PLUS_ATTACK_CROSSBOW_BY_TECHNOLOGY = 5;
    public final int PLUS_ATTACK_CANNON_BY_TECHNOLOGY = 5;
    // Defense attack power increase percentage per tech level
    public final int PLUS_ATTACK_ARROWTOWER_BY_TECHNOLOGY = 5;
    public final int PLUS_ATTACK_CATAPULT_BY_TECHNOLOGY = 5;
    public final int PLUS_ATTACK_ROCKETLAUNCHERTOWER_BY_TECHNOLOGY = 5;
    public final int PLUS_ATTACK_MAGICIAN_BY_TECHNOLOGY = 6;
    public final int PLUS_ARMOR_UNIT_PER_EXPERIENCE_POINT = 4;
    public final int PLUS_ATTACK_UNIT_PER_EXPERIENCE_POINT = 4;
    //Units plus armor/attack increase percentage when sanctified
    public final int PLUS_ARMOR_UNIT_SANCTIFIED = 25;
    public final int PLUS_ATTACK_UNIT_SANCTIFIED = 25;
    public final int SANCTIFIED_AMOUNT_PER_PRIEST = 4;
    // Chance of resurrection by magician
    public final int CHANCE_MAGICIAN_RESSURECT = 2;
    // fleet probability of generating waste
    public final int CHANCE_GENERATING_WASTE_SWORDSMAN = 55;
    public final int CHANCE_GENERATING_WASTE_SPEARMAN = 65;
    public final int CHANCE_GENERATING_WASTE_CROSSBOW = 80;
    public final int CHANCE_GENERATING_WASTE_CANNON = 90;
    // Defense probability of generating waste ARROWTOWER, CATAPULT, ROCKETLAUNCHERTOWER
    public final int CHANCE_GENERATING_WASTE_ARROWTOWER = 55;
    public final int CHANCE_GENERATING_WASTE_CATAPULT = 65;
    public final int CHANCE_GENERATING_WASTE_ROCKETLAUNCHERTOWER = 75;
    // especial Units
    public final int CHANCE_GENERATING_WASTE_PRIEST = 0;
    public final int CHANCE_GENERATING_WASTE_MAGICIAN = 0;
    // AttackUnit chance to attack again
    public final int CHANCE_ATTACK_AGAIN_SWORDSMAN = 5;
    public final int CHANCE_ATTACK_AGAIN_SPEARMAN = 7;
    public final int CHANCE_ATTACK_AGAIN_CROSSBOW = 50;
    public final int CHANCE_ATTACK_AGAIN_CANNON = 0;
    //Defense chance to attack again
    public final int CHANCE_ATTACK_AGAIN_ARROWTOWER = 50;
    public final int CHANCE_ATTACK_AGAIN_CATAPULT = 10;
    public final int CHANCE_ATTACK_AGAIN_ROCKETLAUNCHERTOWER = 70;
    public final int CHANCE_ATTACK_AGAIN_MAGICIAN = 90;
    public final int CHANCE_ATTACK_AGAIN_PRIEST = 0;
    // CHANCE ATTACK EVERY UNIT
    // SWORDSMAN, SPEARMAN, CROSSBOW, CANNON, ARROWTOWER, CATAPULT, ROCKETLAUNCHERTOWER, MAGICIAN, PRIEST
    public final int CHANCE_ATTACK_CIVILIZATION_UNITS[] = {4,9,13,37,4,9,14,10,0}; //MUST ADD TO 100
    // SWORDSMAN, SPEARMAN, CROSSBOW, CANNON
    public final int CHANCE_ATTACK_ENEMY_UNITS[] = {10,20,30,40}; //MUST ADD TO 100
    // percentage of waste that will be generated with respect to the cost of the units
    public final int PERCENTATGE_WASTE = 70;
    }