package com.project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import oracle.sql.NUMBER;

import java.sql.*;

public class CivilizationDao {

    public void addSave(SaveData save) {
        AppData db = AppData.getInstance();
        /*iron_amount NUMBER NOT NULL, 
        food_amount NUMBER NOT NULL, 
        mana_amount NUMBER NOT NULL, 
        magicTower_counter NUMBER NOT NULL, 
        church_counter NUMBER NOT NULL, 
        farm_counter NUMBER NOT NULL, 
        smithy_counter NUMBER NOT NULL, 
        carpentry_counter NUMBER NOT NULL, 
        technology_defence_level NUMBER, 
        technology_attack_level NUMBER, 
        battles_counter NUMBER,
        --battle_timer NUMBER,
        NextBattleIn */
        String sql = "INSERT INTO civilization_stats (name,wood_amount,iron_amount,food_amount,mana_amount,magicTower_counter,church_counter,farm_counter,smithy_counter,carpentry_counter,technology_defence_level,technology_attack_level,battles_counter,battle_timer,NextBattleIn) VALUES (";
        sql += "'" + save.getName() + "',";
        sql += save.getWood() + ",";
        sql += save.getIron() + ",";
        sql += save.getFood() + ",";
        sql += save.getMana() + ",";
        sql += save.getMagicTower() + ",";
        sql += save.getChurch() + ",";
        sql += save.getFarm() + ",";
        sql += save.getSmithy() + ",";
        sql += save.getCarpentry() + ",";
        sql += save.getTechnologyDefense() + ",";
        sql += save.getTechnologyAttack() + ",";
        sql += save.getWave() + ",";
        sql += save.getBattleTimer() + ",";
        sql += save.getNextBattleIn() + ");";
        int civId = db.insertAndGetId(sql);
        save.setSaveId(civId);
        //Battles
            //Is eamty so we don't do anything
        //OwnArmy
            //We start with no army
        //EnemyArmy
        for (MilitaryUnit unit : save.getEnemyArmy()) {
            sql = "INSERT INTO enemy_unit  (civilization_id, type,experience) VALUES (";
            sql += civId + ",";
            sql += "'" + unit.getType() + "',";
            sql += unit.getExperience() + ");";
            db.update(sql);
        }
    }

    public ArrayList<SaveData> getSaves() {
       return null;
    }

    public void updateSave(SaveData save) {
        AppData db = AppData.getInstance();
        int id = save.getSaveId();
        //Civilization
        String sql = "UPDATE civilization_stats SET";
        sql += " wood_amount = " + save.getWood() + ",";
        sql += " iron_amount = " + save.getIron() + ",";
        sql += " food_amount = " + save.getFood() + ",";
        sql += " mana_amount = " + save.getMana() + ",";
        sql += " magicTower_counter = " + save.getMagicTower() + ",";
        sql += " church_counter = " + save.getChurch() + ",";
        sql += " farm_counter = " + save.getFarm() + ",";
        sql += " smithy_counter = " + save.getSmithy() + ",";
        sql += " carpentry_counter = " + save.getCarpentry() + ",";
        sql += " technology_defence_level = " + save.getTechnologyDefense() + ",";
        sql += " technology_attack_level = " + save.getTechnologyAttack() + ",";
        sql += " battles_counter = " + save.getWave() + ",";
        sql += " battle_timer = " + save.getBattleTimer() + ",";
        sql += " NextBattleIn = " + save.getNextBattleIn() + " ";
        sql += " WHERE id = " + id + ";";
        db.update(sql);
        //Army
        List<Map<String, Object>> army = db.query("SELECT * FROM units WHERE civilization_id = " + id + ";");
        if (save.getOwnArmy().size() > army.size()) {
            for (int i = 0; i < army.size(); i++) {
                sql = "UPDATE units SET";
                sql += " type = '" + save.getOwnArmy().get(i).getType() + "',";
                sql += " experience = " + save.getOwnArmy().get(i).getExperience() + " ";
                sql += " WHERE unit_id = " + army.get(i).get("id") + "and civilization_id = "+id+";";
                db.update(sql);
            }
            //insert the rest
            for (int i = army.size(); i < save.getOwnArmy().size(); i++) {
                sql = "INSERT INTO units (civilization_id, type, experience) VALUES (";
                sql += id + ",";
                sql += "'" + save.getOwnArmy().get(i).getType() + "',";
                sql += save.getOwnArmy().get(i).getExperience() + ");";
                db.update(sql);
            }
        }
        else {
            for (int i = 0; i < save.getOwnArmy().size(); i++) {
                sql = "UPDATE units SET";
                sql += " type = '" + save.getOwnArmy().get(i).getType() + "',";
                sql += " experience = " + save.getOwnArmy().get(i).getExperience() + " ";
                sql += " WHERE unit_id = " + army.get(i).get("id") + "and civilization_id = "+id+";";
                db.update(sql);
            }
            for (int i = save.getOwnArmy().size(); i < army.size(); i++) {
                db.update("DELETE FROM units WHERE unit_id = " + army.get(i).get("id") + "and civilization_id = "+id+";");
            }
            //delete the rest
        }
        //Enemy
        List<Map<String, Object>> enemy =  db.query("SELECT * FROM enemy_unit WHERE civilization_id = " + id + ";");
        if (save.getEnemyArmy().size() > enemy.size()) {
            for (int i = 0; i < enemy.size(); i++) {
                sql = "UPDATE enemy_unit SET";
                sql += " type = '" + save.getEnemyArmy().get(i).getType() + "',";
                sql += " experience = " + save.getEnemyArmy().get(i).getExperience() + " ";
                sql += " WHERE unit_id = " + enemy.get(i).get("id") + "and civilization_id = "+id+";";
                db.update(sql);
            }
            //insert the rest
            for (int i = enemy.size(); i < save.getEnemyArmy().size(); i++) {
                sql = "INSERT INTO enemy_unit (civilization_id, type, experience) VALUES (";
                sql += id + ",";
                sql += "'" + save.getEnemyArmy().get(i).getType() + "',";
                sql += save.getEnemyArmy().get(i).getExperience() + ");";
                db.update(sql);
            }
        }
        else {
            for (int i = 0; i < save.getEnemyArmy().size(); i++) {
                sql = "UPDATE enemy_unit SET";
                sql += " type = '" + save.getEnemyArmy().get(i).getType() + "',";
                sql += " experience = " + save.getEnemyArmy().get(i).getExperience() + " ";
                sql += " WHERE id = " + enemy.get(i).get("id") + "and civilization_id = "+id+";";
                db.update(sql);
            }
            //delete the rest
            for (int i = save.getEnemyArmy().size(); i < enemy.size(); i++) {
                db.update("DELETE FROM enemy_unit WHERE unit_id = " + enemy.get(i).get("id") + "and civilization_id = "+id+";");
            }
        }
        //Battles
        List<Map<String, Object>> battles = db.query("Select * FROM battles_stats WHERE civilization_id = " + id + ";");
        if (save.getBattles().size() > battles.size()) {
            //Insert the new Battles
            for (int i = battles.size(); i < save.getBattles().size(); i++) {
                Battle battle = save.getBattles().get(i);
                //battles_stats
                sql = "INSERT INTO battles_stats (civilization_id, num_battle, wood_acquired,iron_acquired,win,civilizationLoses,EnemyLoses) VALUES (";
                sql += id + ",";
                sql += (i+1) + ",";
                sql += battle.getWoodWaste() + ",";
                sql += battle.getIronWaste() + ",";
                sql += battle.isWin() + ",";
                sql += "TABLE(";
                Integer[] civLoses = (Integer[])battle.getCivilizationLoses().toArray();
                for (int j = 0; j < civLoses.length; j++) {
                    sql += civLoses[j] + ",";
                }
                sql += "),";
                sql += "TABLE(";
                Integer[] enemyLoses = (Integer[])battle.getEnemyLoses().toArray();
                for (int j = 0; j < enemyLoses.length; j++) {
                    sql += enemyLoses[j] + ",";
                }
                sql += "));";
                db.update(sql);
                //civilization_unit_stats
                ArrayList<ArrayList<MilitaryUnit>> orderedInitialUnits = battle.orderByUnitType(battle.getCivilizationArmy());
                ArrayList<ArrayList<MilitaryUnit>> orderedDropsUnits = battle.getCivilizationArmyOrdered();
                for (int j = 0; j < UnitTypes.values().length; j++) {
                    sql = "INSERT INTO civilization_unit_stats (civilization_id, num_battle, type, initial, drops) VALUES (";
                    sql += id + ",";
                    sql += (i+1) + ",";
                    sql += "'" + UnitTypes.values()[j].toString().substring(0,1).toUpperCase() + UnitTypes.values()[j].toString().substring(1) + "',";
                    sql += orderedInitialUnits.get(j).size() + ",";
                    sql += orderedDropsUnits.get(j).size() + ");";
                    db.update(sql);
                }
                //enemy_unit_stats
                ArrayList<ArrayList<MilitaryUnit>> orderedInitialEnemyUnits = battle.orderByUnitType(battle.getEnemyArmy());
                ArrayList<ArrayList<MilitaryUnit>> orderedDropsEnemyUnits = battle.getEnemyArmyOrdered();
                for (int j = 0; j < UnitTypes.values().length; j++) {
                    sql = "INSERT INTO enemy_unit_stats (civilization_id, num_battle, type, initial, drops) VALUES (";
                    sql += id + ",";
                    sql += (i+1) + ",";
                    sql += "'" + UnitTypes.values()[j].toString().substring(0, 1).toUpperCase() + UnitTypes.values()[j].toString().substring(1) + "',";
                    sql += orderedInitialEnemyUnits.get(j).size() + ",";
                    sql += orderedDropsEnemyUnits.get(j).size() + ");";
                    db.update(sql);
                }
                //battle_log
                sql = "INSERT INTO battle_log (civilization_id, num_battle, log_entry) VALUES (";
                sql += id + ",";
                sql += (i+1) + ",";
                sql += "TO_CLOB('" + battle.getDeteiledReport() + "'));";

            }
        }

    }

    public void deleteSave(SaveData save) {
        AppData db = AppData.getInstance();
        //Army
        db.update("DELETE FROM units WHERE civilization_id = " + save.getSaveId());
        //Enemy
        db.update("DELETE FROM enemy_unit WHERE civilization_id = " + save.getSaveId());
        //Battles
        db.update("DELETE FROM civilization_unit_stats WHERE civilization_id = " + save.getSaveId());
        db.update("DELETE FROM enemy_unit_stats WHERE civilization_id = " + save.getSaveId());
        db.update("DELETE FROM battle_log WHERE civilization_id = " + save.getSaveId());
        db.update("DELETE FROM battles_stats WHERE civilization_id = " + save.getSaveId());
        //Civilization
        db.update("DELETE FROM civilization_stats WHERE name = '" + save.getName() + "'");
    }
    
}
