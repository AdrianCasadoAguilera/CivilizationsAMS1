package com.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CivilizationDao {

    private String title (String str) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : str.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            titleCase.append(c);
        }

        return titleCase.toString();
    }

    public void addSave(SaveData save) {
        Connection con = AppData.getConnection();
        String sql = "INSERT INTO civilization_stats (name, wood_amount, iron_amount, food_amount, mana_amount, magicTower_counter, church_counter, farm_counter, smithy_counter, carpentry_counter, technology_defence_level, technology_attack_level, battles_counter, battle_timer, NextBattleIn) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "SELECT civilization_id FROM civilization_stats ORDER BY civilization_id DESC FETCH FIRST 1 ROWS ONLY";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int civId = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, save.getName());
            ps.setInt(2, save.getWood());
            ps.setInt(3, save.getIron());
            ps.setInt(4, save.getFood());
            ps.setInt(5, save.getMana());
            ps.setInt(6, save.getMagicTower());
            ps.setInt(7, save.getChurch());
            ps.setInt(8, save.getFarm());
            ps.setInt(9, save.getSmithy());
            ps.setInt(10, save.getCarpentry());
            ps.setInt(11, save.getTechnologyDefense());
            ps.setInt(12, save.getTechnologyAttack());
            ps.setInt(13, save.getWave());
            ps.setInt(14, (int)save.getBattleTimer());
            ps.setInt(15, save.getNextBattleIn());
            ps.executeUpdate();
            con.commit();
            Statement s = con.createStatement();
            rs = s.executeQuery(sql2);
            if (rs.next()) {
                civId = rs.getInt("civilization_id");
                save.setSaveId(civId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //save.setSaveId(civId);
        //Battles
            //Is eamty so we don't do anything
        //OwnArmy
            //We start with no army
        //EnemyArmy
        AppData db = AppData.getInstance();
        for (MilitaryUnit unit : save.getEnemyArmy()) {
            sql = "INSERT INTO enemy_unit (civilization_id, type,experience) VALUES (";
            sql += civId + ",";
            sql += "'" + title(unit.getType().toString()) + "',";
            sql += unit.getExperience() + ")";
            db.update(sql);
        }
    }

    public ArrayList<SaveData> getSaves() {
       ArrayList<SaveData> saves = new ArrayList<SaveData>();
       AppData db = AppData.getInstance();
       List<Map<String, Object>> savesList = db.query("SELECT * FROM civilization_stats");
       //System.out.println(savesList);
       for (Map<String, Object> save : savesList) {
            SaveData newSave = new SaveData();
            newSave.setSaveId(((Number)save.get("civilization_id")).intValue());
            newSave.setName((String) save.get("name"));
            newSave.setWood(((Number) save.get("wood_amount")).intValue());
            newSave.setIron(((Number) save.get("iron_amount")).intValue());
            newSave.setFood(((Number) save.get("food_amount")).intValue());
            newSave.setMana(((Number) save.get("mana_amount")).intValue());
            newSave.setMagicTower(((Number) save.get("magictower_counter")).intValue());
            newSave.setChurch(((Number) save.get("church_counter")).intValue());
            newSave.setFarm(((Number) save.get("farm_counter")).intValue());
            newSave.setSmithy(((Number) save.get("smithy_counter")).intValue());
            newSave.setCarpentry(((Number) save.get("carpentry_counter")).intValue());
            newSave.setTechnologyDefense(((Number) save.get("technology_defence_level")).intValue());
            newSave.setTechnologyAttack(((Number) save.get("technology_attack_level")).intValue());
            newSave.setWave(((Number) save.get("battles_counter")).intValue());
            newSave.setBattleTimer(((Number) save.get("battle_timer")).intValue());
            newSave.setNextBattleIn(((Number) save.get("nextbattlein")).intValue());
            //OwnArmy
            ArrayList<MilitaryUnit> army = new ArrayList<MilitaryUnit>();
            List<Map<String, Object>> armyList = db.query("SELECT * FROM units WHERE civilization_id = " + newSave.getSaveId());
            for (Map<String, Object> unit : armyList) {
                MilitaryUnit armyUnit = getNewUnit(UnitTypes.valueOf(((String) unit.get("type")).toUpperCase()));
                armyUnit.setExperience(((Number) unit.get("experience")).intValue());
                army.add(armyUnit);
            }
            newSave.setOwnArmy(army);
            //EnemyArmy
            ArrayList<MilitaryUnit> enemyArmy = new ArrayList<MilitaryUnit>();
            List<Map<String, Object>> enemyArmyList = db.query("SELECT * FROM enemy_unit WHERE civilization_id = " + newSave.getSaveId());
            for (Map<String, Object> unit : enemyArmyList) {
                MilitaryUnit enemyUnit = getNewUnit(UnitTypes.valueOf(((String) unit.get("type")).toUpperCase()));
                enemyUnit.setExperience(((Number) unit.get("experience")).intValue());
                enemyArmy.add(enemyUnit);
            }
            newSave.setEnemyArmy(enemyArmy);
            //Battles
            //battles_stats
            ArrayList<Battle> battles = new ArrayList<Battle>();
            List<Map<String, Object>> battlesList = db.query("SELECT * FROM battle_stats WHERE civilization_id = " + newSave.getSaveId() + " order by num_battle asc");
            for (Map<String,Object> battle : battlesList) {
                Battle newBattle = new Battle();
                newBattle.setWoodWaste(((Number) battle.get("wood_acquired")).intValue());
                newBattle.setIronWaste(((Number) battle.get("iron_acquired")).intValue());
                newBattle.setWin(((Number)battle.get("win")).intValue() == 1);
                Number[] civilizationLoses = null;
                Number[] enemyLoses = null;
                try {
                    civilizationLoses = (Number[])((java.sql.Array)battle.get("civilizationloses")).getArray();
                    enemyLoses = (Number[])((java.sql.Array)battle.get("enemyloses")).getArray();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ArrayList<Integer> civilizationLosesInt = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    civilizationLosesInt.add(civilizationLoses[i].intValue());
                }
                newBattle.setCivilizationLoses(civilizationLosesInt);
                ArrayList<Integer> enemyLosesInt = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    enemyLosesInt.add(enemyLoses[i].intValue());
                }
                newBattle.setEnemyLoses(enemyLosesInt);
                //civilization_unit_stats
                //.println("loading civilization_unit_stats");
                List<Map<String, Object>> civilizationUnitStats = db.query("SELECT * FROM civilization_unit_stats WHERE num_battle = " + battle.get("num_battle") + " and civilization_id = " + newSave.getSaveId());
                ArrayList<MilitaryUnit> initialUnits = new ArrayList<>();
                ArrayList<MilitaryUnit> dropsUnits = new ArrayList<>();
                for (Map<String, Object> unitStats : civilizationUnitStats) {
                    int initial = ((Number)unitStats.get("initial")).intValue();
                    int drops = ((Number)unitStats.get("drops")).intValue();
                    for (int i = 0; i < initial; i++) {
                        initialUnits.add(getNewUnit(UnitTypes.valueOf(((String) unitStats.get("type")).toUpperCase())));
                    }
                    for (int i = 0; i < drops; i++) {
                        dropsUnits.add(getNewUnit(UnitTypes.valueOf(((String) unitStats.get("type")).toUpperCase())));
                    }
                }
                newBattle.setCivilizationArmy(initialUnits);
                ArrayList<ArrayList<MilitaryUnit>> orderDrops = newBattle.orderByUnitType(dropsUnits);
                newBattle.setCivilizationArmyOrdered(orderDrops);
                //enemy_unit_stats
                List<Map<String, Object>> enemyUnitStats = db.query("SELECT * FROM enemy_unit_stats WHERE num_battle = " + battle.get("num_battle") + " and civilization_id = " + newSave.getSaveId());
                ArrayList<MilitaryUnit> initialEUnits = new ArrayList<>();
                ArrayList<MilitaryUnit> dropsEUnits = new ArrayList<>();
                for (Map<String, Object> unitStats : enemyUnitStats) {
                    int initial = ((Number)unitStats.get("initial")).intValue();
                    int drops = ((Number)unitStats.get("drops")).intValue();
                    for (int i = 0; i < initial; i++) {
                        initialEUnits.add(getNewUnit(UnitTypes.valueOf(((String) unitStats.get("type")).toUpperCase())));
                    }
                    for (int i = 0; i < drops; i++) {
                        dropsEUnits.add(getNewUnit(UnitTypes.valueOf(((String) unitStats.get("type")).toUpperCase())));
                    }
                }
                newBattle.setEnemyArmy(initialEUnits);
                ArrayList<ArrayList<MilitaryUnit>> orderEDrops = newBattle.orderByUnitType(dropsUnits);
                newBattle.setEnemyArmyOrdered(orderEDrops);
                //battle_log
                Connection con = AppData.getConnection();
                PreparedStatement ps = null;
                try {
                    ps = con.prepareStatement("SELECT * FROM battle_log WHERE num_battle = ? and civilization_id = ?");
                    ps.setInt(1, ((Number) battle.get("num_battle")).intValue());
                    ps.setInt(2, newSave.getSaveId());
                    ps.executeQuery();
                    ResultSet rs = ps.getResultSet();
                    if (rs.next()) {
                        Clob clob = rs.getClob("log_entry");
                        String log = clob.getSubString(1, (int) clob.length());
                        newBattle.setDetailedReport(log);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                battles.add(newBattle);
            }
            newSave.setBattles(battles);
            saves.add(newSave);
        }
        return saves;
    }

    private MilitaryUnit getNewUnit(UnitTypes type) {
        switch (type) {
            case SWORDSMAN:
                return new Swordsman();
            case SPEARMAN:
                return new Spearman();
            case CROSSBOW:
                return new Crossbow();
            case CANNON:
                return new Cannon();
            case ARROWTOWER:
                return new ArrowTower();
            case CATAPULT:
                return new Catapult();
            case ROCKETLAUNCHERTOWER:
                return new RocketLauncherTower();
            case MAGICIAN:
                return new Magician();
            case PRIEST:
                return new Priest();
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    public void updateSave(SaveData save) {
        try{
            System.out.println("Saving civilization stat");
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
            sql += " WHERE civilization_id = " + id;
            System.out.println(sql);
            db.update(sql);
            //Army
            System.out.println("Saving own army");
            List<Map<String, Object>> army = db.query("SELECT * FROM units WHERE civilization_id = " + id);
            if (save.getOwnArmy().size() > army.size()) {
                for (int i = 0; i < army.size(); i++) {
                    sql = "UPDATE units SET";
                    sql += " type = '" + title(save.getOwnArmy().get(i).getType().toString()) + "',";
                    sql += " experience = " + save.getOwnArmy().get(i).getExperience() + " ";
                    sql += " WHERE unit_id = " + army.get(i).get("unit_id") + "and civilization_id = "+id;
                    db.update(sql);
                }
                //insert the rest
                for (int i = army.size(); i < save.getOwnArmy().size(); i++) {
                    sql = "INSERT INTO units (civilization_id, type, experience) VALUES (";
                    sql += id + ",";
                    sql += "'" + title(save.getOwnArmy().get(i).getType().toString()) + "',";
                    sql += save.getOwnArmy().get(i).getExperience() + ")";
                    db.update(sql);
                }
            }
            else {
                for (int i = 0; i < save.getOwnArmy().size(); i++) {
                    sql = "UPDATE units SET";
                    sql += " type = '" + title(save.getOwnArmy().get(i).getType().toString()) + "',";
                    sql += " experience = " + save.getOwnArmy().get(i).getExperience() + " ";
                    sql += " WHERE unit_id = " + army.get(i).get("unit_id") + "and civilization_id = "+id;
                    db.update(sql);
                }
                for (int i = save.getOwnArmy().size(); i < army.size(); i++) {
                    db.update("DELETE FROM units WHERE unit_id = " + army.get(i).get("unit_id") + "and civilization_id = "+id);
                }
                //delete the rest
            }
            //Enemy
            System.out.println("Saving enemy army");
            List<Map<String, Object>> enemy =  db.query("SELECT * FROM enemy_unit WHERE civilization_id = " + id);
            if (save.getEnemyArmy().size() > enemy.size()) {
                for (int i = 0; i < enemy.size(); i++) {
                    sql = "UPDATE enemy_unit SET";
                    sql += " type = '" + title(save.getEnemyArmy().get(i).getType().toString()) + "',";
                    sql += " experience = " + save.getEnemyArmy().get(i).getExperience() + " ";
                    sql += " WHERE unit_id = " + enemy.get(i).get("unit_id") + "and civilization_id = "+id;
                    db.update(sql);
                }
                //insert the rest
                for (int i = enemy.size(); i < save.getEnemyArmy().size(); i++) {
                    sql = "INSERT INTO enemy_unit (civilization_id, type, experience) VALUES (";
                    sql += id + ",";
                    sql += "'" + title(save.getEnemyArmy().get(i).getType().toString()) + "',";
                    sql += save.getEnemyArmy().get(i).getExperience() + ")";
                    db.update(sql);
                }
            }
            else {
                for (int i = 0; i < save.getEnemyArmy().size(); i++) {
                    sql = "UPDATE enemy_unit SET";
                    sql += " type = '" + title(save.getEnemyArmy().get(i).getType().toString()) + "',";
                    sql += " experience = " + save.getEnemyArmy().get(i).getExperience() + " ";
                    sql += " WHERE unit_id = " + enemy.get(i).get("unit_id") + "and civilization_id = "+id;
                    db.update(sql);
                }
                //delete the rest
                for (int i = save.getEnemyArmy().size(); i < enemy.size(); i++) {
                    db.update("DELETE FROM enemy_unit WHERE unit_id = " + enemy.get(i).get("id") + "and civilization_id = "+id);
                }
            }
            //Battles
            System.out.println("Saving battles");
            List<Map<String, Object>> battles = db.query("Select * FROM battle_stats WHERE civilization_id = " + id);
            if (save.getBattles().size() > battles.size()) {
                //Insert the new Battles
                for (int i = battles.size(); i < save.getBattles().size(); i++) {
                    Battle battle = save.getBattles().get(i);
                    //battles_stats
                    sql = "INSERT INTO battle_stats (civilization_id, num_battle, wood_acquired,iron_acquired,win,civilizationLoses,EnemyLoses) VALUES (";
                    sql += id + ",";
                    sql += (i+1) + ",";
                    sql += battle.getWoodWaste() + ",";
                    sql += battle.getIronWaste() + ",";
                    sql += (battle.isWin() ? 1 : 0) + ",";
                    sql += "number_array(";
                    ArrayList<Integer> civLoses = battle.getCivilizationLoses();
                    for (int j = 0; j < civLoses.size(); j++) {
                        sql += civLoses.get(j);
                        if (j != civLoses.size() - 1) {
                            sql += ",";
                        }
                    }
                    sql += "),";
                    sql += "number_array(";
                    ArrayList<Integer> enemyLoses = battle.getEnemyLoses();
                    for (int j = 0; j < enemyLoses.size(); j++) {
                        sql += enemyLoses.get(j);
                        if (j != enemyLoses.size() - 1) {
                            sql += ",";
                        }
                    }
                    sql += "))";
                    db.update(sql);
                    //civilization_unit_stats
                    System.out.println("saving battle civilization units");
                    ArrayList<ArrayList<MilitaryUnit>> orderedInitialUnits = battle.orderByUnitType(battle.getCivilizationArmy());
                    ArrayList<ArrayList<MilitaryUnit>> orderedDropsUnits = battle.getCivilizationArmyOrdered();
                    for (int j = 0; j < UnitTypes.values().length; j++) {
                        sql = "INSERT INTO civilization_unit_stats (civilization_id, num_battle, \"type\", \"initial\", drops) VALUES (";
                        sql += id + ",";
                        sql += (i+1) + ",";
                        sql += "'" + title(UnitTypes.values()[j].toString()) + "',";
                        sql += orderedInitialUnits.get(j).size() + ",";
                        sql += orderedDropsUnits.get(j).size() + ")";
                        db.update(sql);
                    }
                    //enemy_unit_stats
                    System.out.println("saving battle enemy units");
                    ArrayList<ArrayList<MilitaryUnit>> orderedInitialEnemyUnits = battle.orderByUnitType(battle.getEnemyArmy());
                    ArrayList<ArrayList<MilitaryUnit>> orderedDropsEnemyUnits = battle.getEnemyArmyOrdered();
                    for (int j = 0; j < UnitTypes.values().length; j++) {
                        if (j == 4)
                            break;
                        sql = "INSERT INTO enemy_unit_stats (civilization_id, num_battle, \"type\", \"initial\", drops) VALUES (";
                        sql += id + ",";
                        sql += (i+1) + ",";
                        sql += "'" + title(UnitTypes.values()[j].toString()) + "',";
                        sql += orderedInitialEnemyUnits.get(j).size() + ",";
                        sql += orderedDropsEnemyUnits.get(j).size() + ")";
                        db.update(sql);
                    }
                    //battle_log
                    Connection con = AppData.getConnection();
                    PreparedStatement ps = null;
                    try {
                        ps = con.prepareStatement("INSERT INTO battle_log (civilization_id, num_battle, log_entry) VALUES (?, ?, ?)");
                        ps.setInt(1, id);
                        ps.setInt(2, i+1);
                        Clob clob = con.createClob();
                        clob.setString(1, battle.getDeteiledReport());
                        ps.setClob(3, clob);
                        ps.executeUpdate();
                        con.commit();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch(Exception e){
            AppData.getInstance().connect();
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
        db.update("DELETE FROM battle_stats WHERE civilization_id = " + save.getSaveId());
        //Civilization
        db.update("DELETE FROM civilization_stats WHERE civilization_id =" + save.getSaveId());
    }
    
}
