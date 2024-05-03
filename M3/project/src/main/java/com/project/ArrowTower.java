package com.project;

public class ArrowTower extends DefenseUnit {

    public ArrowTower() {
        this.armor = (int)(ARMOR_ARROWTOWER * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ARMOR_ARROWTOWER_BY_TECHNOLOGY/100.0));
        this.initialArmor = armor;
        this.baseDamage = (int)(BASE_DAMAGE_ARROWTOWER * (1+Civilization.getInstance().getTechnologyDefense()*PLUS_ATTACK_ARROWTOWER_BY_TECHNOLOGY/100.0));;
    }

    @Override
    public int attack() {
        return baseDamage;
    }

    @Override
    public int getActualArmor() {
        return armor;
    }

    @Override
    public int getChanceAttackAgain() {
        return CHANCE_ATTACK_AGAIN_ARROWTOWER;
    }

    @Override
    public int getChanceGeneratinWaste() {
        return CHANCE_GENERATNG_WASTE_ARROWTOWER;
    }

    @Override
    public void getExperience() {
        
    }

    @Override
    public int getFoodCost() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getIronCost() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getManaCost() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getWoodCost() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void resetArmor() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setExperience(int n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void takeDamage(int receivedDamage) {
        // TODO Auto-generated method stub
        
    }
    
}
