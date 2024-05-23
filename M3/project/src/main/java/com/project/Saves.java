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

    public String[] GetSaveNames() {
        String[] names = new String[savedata.size()];
        for (int i = 0; i < savedata.size(); i++) {
            names[i] = savedata.get(i).getName();
        }
        return names;
    }

    public int GetSaveCount() {
        return savedata.size();
    }

    public void LoadSavesFromDB() {
        CivilizationDao dao = new CivilizationDao();
        ArrayList<SaveData> saves = dao.getSaves();
        for (SaveData save : saves) {
            savedata.add(save);
        }
    }
    
    public void SaveDataToDB(int index) {
        CivilizationDao dao = new CivilizationDao();
        SaveData data = savedata.get(index);
        dao.updateSave(data);
    }
    
    private void DeleleSaveFromDB(int index) {
        CivilizationDao dao = new CivilizationDao();
        SaveData data = savedata.get(index);
        dao.deleteSave(data);
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
        //On DB
        DeleleSaveFromDB(index);
        savedata.remove(index);
    }

    public int AddNewSaveData(String name) {
        SaveData save = new SaveData();
        save.setName(name);
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
        ArrayList<MilitaryUnit> enemyArmy = Main.NewEnemyArmy();
        save.setEnemyArmy(enemyArmy);

        // CivilizationDao dao = new CivilizationDao();
        // dao.addSave(save);
        savedata.add(save);
        return savedata.size() - 1;
    }
    
}