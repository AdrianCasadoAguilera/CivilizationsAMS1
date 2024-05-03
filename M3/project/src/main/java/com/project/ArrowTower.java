package com.project;

public class ArrowTower extends DefenseUnit {

    public ArrowTower(int armor, int baseDamage) {
        this.armor = armor;
        this.initialArmor = armor;
        this.baseDamage = baseDamage;
    }

    @Override
    public int attack() {
        return baseDamage+Civilization.getInstance().getTechnologyAttack()*PLUS_ATTACK_ARROWTOWER_BY_TECHNOLOGY;
    }

    @Override
    public int getActualArmor() {
        return armor;
    }

    @Override
    public int getChanceAttackAgain() {
        return 0;
    }

    @Override
    public int getChanceGeneratinWaste() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void getExperience() {
        // TODO Auto-generated method stub
        
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
