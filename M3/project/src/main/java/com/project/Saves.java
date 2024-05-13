package com.project;

import java.util.ArrayList;
import java.util.Random;

public class Saves {
    public static Saves instance;
    private ArrayList<SaveData> savedata;

    private Saves() {
        savedata = new ArrayList<>();
        LoadSavesFromDB();
    }

    public static Saves getInstance() {
        if (instance == null) {
            instance = new Saves();
        }
        return instance;
    }

    public void LoadSavesFromDB() {
        
    }

    public void SaveDataToDB(int index) {
        
    }

    public void UpdateSaveData(int index) {
        SaveData data = savedata.get(index);
        data.Update();
        SaveDataToDB(index);
    }

    public void LoadSaveData(int index) {
        SaveData data = savedata.get(index);
        data.Load();
    }

    public void DeleteSaveData(int index) {
        savedata.remove(index);
    }

    public int AddNewSaveData() {
        SaveData save = new SaveData();
        save.setFood(0);
        save.setMana(0);
        save.setIron(0);
        save.setWood(0);

        save.setFarm(0);
        save.setSmithy(0);
        save.setCarpentry(0);
        save.setChurch(0);
        save.setMagicTower(0);

        save.setTechnologyAttack(0);
        save.setTechnologyDefense(0);

        save.setBattleTimer(0);
        save.setNextBattleIn(120 + new Random().nextInt(300 - 120 + 1));

        save.setWave(0);
        save.setBattles(new ArrayList<>());
        save.setOwnArmy(new ArrayList<>());
        save.setEnemyArmy(new ArrayList<>());

        //TODO INSERT IN DB
        /*
        * int id from DAO
        * save.setSaveId(id);
        */
        savedata.add(save);
        return savedata.size() - 1;
    }
    
}