package com.project;

import java.util.ArrayList;

public class SaveData {
    private int saveId;
    //resources
    private int wood;
    private int iron;
    private int food;
    private int mana;
    //building
    private int magicTower;
    private int church;
    private int farm;
    private int smithy;
    private int carpentry;
    //own army
    private ArrayList<MilitaryUnit> ownArmy;
    //enemy army
    private ArrayList<MilitaryUnit> enemyArmy;
    //Timers
    private float battleTimer;
    private int NextBattleIn;
    //technology
    private int technologyDefense;
    private int technologyAttack;
    //Battles
    private ArrayList<Battle> battles;
    //wave
    private int wave;

    public void Update() {
        Civilization civ = Civilization.getInstance();
        wood = civ.getWood();
        iron = civ.getIron();
        food = civ.getFood();
        mana = civ.getMana();

        magicTower = civ.getMagicTower();
        church = civ.getChurch();
        farm = civ.getFarm();
        smithy = civ.getSmithy();
        carpentry = civ.getCarpentry();

        ownArmy = (ArrayList<MilitaryUnit>)civ.getArmy().clone();
        enemyArmy = Main.NextEnemyArmy;
        battleTimer = Main.BattleTimer;
        NextBattleIn = Main.NextBattleIn;
        wave = civ.getBattles();

        technologyDefense = civ.getTechnologyDefense();
        technologyAttack = civ.getTechnologyAttack();

        battles = (ArrayList<Battle>)Main.battlesFaugth.clone();
    }

    public void Load() {
        Civilization civ = Civilization.getInstance();
        civ.setWood(wood);
        civ.setIron(iron);
        civ.setFood(food);
        civ.setMana(mana);

        civ.setMagicTower(magicTower);
        civ.setChurch(church);
        civ.setFarm(farm);
        civ.setSmithy(smithy);
        civ.setCarpentry(carpentry);

        civ.setArmy(ownArmy);
        Main.NextEnemyArmy = enemyArmy;
        Main.BattleTimer = battleTimer;
        Main.NextBattleIn = NextBattleIn;
        civ.setBattles(wave);

        civ.setTechnologyDefense(technologyDefense);
        civ.setTechnologyAttack(technologyAttack);

        Main.battlesFaugth = battles;
    }

    public int getSaveId() {
        return saveId;
    }

    public void setSaveId(int saveId) {
        this.saveId = saveId;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMagicTower() {
        return magicTower;
    }

    public void setMagicTower(int magicTower) {
        this.magicTower = magicTower;
    }

    public int getChurch() {
        return church;
    }

    public void setChurch(int church) {
        this.church = church;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public int getSmithy() {
        return smithy;
    }

    public void setSmithy(int smithy) {
        this.smithy = smithy;
    }

    public int getCarpentry() {
        return carpentry;
    }

    public void setCarpentry(int carpentry) {
        this.carpentry = carpentry;
    }

    public ArrayList<MilitaryUnit> getOwnArmy() {
        return ownArmy;
    }

    public void setOwnArmy(ArrayList<MilitaryUnit> ownArmy) {
        this.ownArmy = ownArmy;
    }

    public ArrayList<MilitaryUnit> getEnemyArmy() {
        return enemyArmy;
    }

    public void setEnemyArmy(ArrayList<MilitaryUnit> enemyArmy) {
        this.enemyArmy = enemyArmy;
    }

    public float getBattleTimer() {
        return battleTimer;
    }

    public void setBattleTimer(float battleTimer) {
        this.battleTimer = battleTimer;
    }

    public int getTechnologyDefense() {
        return technologyDefense;
    }

    public void setTechnologyDefense(int technologyDefense) {
        this.technologyDefense = technologyDefense;
    }

    public int getTechnologyAttack() {
        return technologyAttack;
    }

    public void setTechnologyAttack(int technologyAttack) {
        this.technologyAttack = technologyAttack;
    }

    public ArrayList<Battle> getBattles() {
        return battles;
    }

    public void setBattles(ArrayList<Battle> battles) {
        this.battles = battles;
    }

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }
}