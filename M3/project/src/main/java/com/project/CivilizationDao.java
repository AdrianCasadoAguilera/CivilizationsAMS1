package com.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import oracle.sql.NUMBER;

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
            System.out.println(sql);
            db.update(sql);
        }
    }

    public ArrayList<SaveData> getSaves() {
       ArrayList<SaveData> saves = new ArrayList<SaveData>();
       AppData db = AppData.getInstance();
       List<Map<String, Object>> savesList = db.query("SELECT * FROM civilization_stats;");
       for (Map<String, Object> save : savesList) {
            SaveData newSave = new SaveData();
            newSave.setSaveId((int) save.get("id"));
            newSave.setName((String) save.get("name"));
            newSave.setWood((int) save.get("wood_amount"));
            newSave.setIron((int) save.get("iron_amount"));
            newSave.setFood((int) save.get("food_amount"));
            newSave.setMana((int) save.get("mana_amount"));
            newSave.setMagicTower((int) save.get("magicTower_counter"));
            newSave.setChurch((int) save.get("church_counter"));
            newSave.setFarm((int) save.get("farm_counter"));
            newSave.setSmithy((int) save.get("smithy_counter"));
            newSave.setCarpentry((int) save.get("carpentry_counter"));
            newSave.setTechnologyDefense((int) save.get("technology_defence_level"));
            newSave.setTechnologyAttack((int) save.get("technology_attack_level"));
            newSave.setWave((int) save.get("battles_counter"));
            newSave.setBattleTimer((int) save.get("battle_timer"));
            newSave.setNextBattleIn((int) save.get("NextBattleIn"));
            //OwnArmy
            ArrayList<MilitaryUnit> army = new ArrayList<MilitaryUnit>();
            List<Map<String, Object>> armyList = db.query("SELECT * FROM units WHERE civilization_id = " + newSave.getSaveId() + ";");
            for (Map<String, Object> unit : armyList) {
                MilitaryUnit armyUnit = getNewUnit(UnitTypes.valueOf((String) unit.get("type")));
                armyUnit.setExperience((int) unit.get("experience"));
                army.add(armyUnit);
            }
            newSave.setOwnArmy(army);
            //EnemyArmy
            ArrayList<MilitaryUnit> enemyArmy = new ArrayList<MilitaryUnit>();
            List<Map<String, Object>> enemyArmyList = db.query("SELECT * FROM enemy_unit WHERE civilization_id = " + newSave.getSaveId() + ";");
            for (Map<String, Object> unit : enemyArmyList) {
                MilitaryUnit enemyUnit = getNewUnit(UnitTypes.valueOf((String) unit.get("type")));
                enemyUnit.setExperience((int) unit.get("experience"));
                enemyArmy.add(enemyUnit);
            }
            newSave.setEnemyArmy(enemyArmy);
            //Battles
            //battles_stats
            ArrayList<Battle> battles = new ArrayList<Battle>();
            List<Map<String, Object>> battlesList = db.query("SELECT * FROM battles_stats WHERE civilization_id = " + newSave.getSaveId() + " order by id asc;");
            for (Map<String,Object> battle : battlesList) {
                Battle newBattle = new Battle();
                newBattle.setWoodWaste((int) battle.get("wood_acquired"));
                newBattle.setIronWaste((int) battle.get("iron_acquired"));
                newBattle.setWin((boolean) battle.get("win"));
                NUMBER[] civilizationLoses = (NUMBER[]) battle.get("civilizationLoses");
                NUMBER[] enemyLoses = (NUMBER[]) battle.get("EnemyLoses");
                ArrayList<Integer> civilizationLosesInt = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    try {
                        civilizationLosesInt.add(civilizationLoses[i].intValue());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                newBattle.setCivilizationLoses(civilizationLosesInt);
                ArrayList<Integer> enemyLosesInt = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    try {
                        enemyLosesInt.add(enemyLoses[i].intValue());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                newBattle.setEnemyLoses(enemyLosesInt);
                //civilization_unit_stats
                List<Map<String, Object>> civilizationUnitStats = db.query("SELECT * FROM civilization_unit_stats WHERE num_battle = " + battle.get("id") + " and civilization_id = " + newSave.getSaveId() + ";");
                for (Map<String, Object> unitStats : civilizationUnitStats) {
                    ArrayList<MilitaryUnit> initialUnits = new ArrayList<>();
                    ArrayList<MilitaryUnit> dropsUnits = new ArrayList<>();
                    int initial = (int)unitStats.get("initial");
                    int drops = (int)unitStats.get("drops");
                    for (int i = 0; i < initial; i++) {
                        initialUnits.add(getNewUnit(UnitTypes.valueOf((String) unitStats.get("type"))));
                    }
                    for (int i = 0; i < drops; i++) {
                        dropsUnits.add(getNewUnit(UnitTypes.valueOf((String) unitStats.get("type"))));
                    }
                    newBattle.setCivilizationArmy(initialUnits);
                    ArrayList<ArrayList<MilitaryUnit>> orderDrops = newBattle.orderByUnitType(dropsUnits);
                    newBattle.setCivilizationArmyOrdered(orderDrops);

                }
                //enemy_unit_stats
                List<Map<String, Object>> enemyUnitStats = db.query("SELECT * FROM enemy_unit_stats WHERE num_battle = " + battle.get("id") + " and civilization_id = " + newSave.getSaveId() + ";");
                for (Map<String, Object> unitStats : enemyUnitStats) {
                    ArrayList<MilitaryUnit> initialUnits = new ArrayList<>();
                    ArrayList<MilitaryUnit> dropsUnits = new ArrayList<>();
                    int initial = (int)unitStats.get("initial");
                    int drops = (int)unitStats.get("drops");
                    for (int i = 0; i < initial; i++) {
                        initialUnits.add(getNewUnit(UnitTypes.valueOf((String) unitStats.get("type"))));
                    }
                    for (int i = 0; i < drops; i++) {
                        dropsUnits.add(getNewUnit(UnitTypes.valueOf((String) unitStats.get("type"))));
                    }
                    newBattle.setEnemyArmy(initialUnits);
                    ArrayList<ArrayList<MilitaryUnit>> orderDrops = newBattle.orderByUnitType(dropsUnits);
                    newBattle.setEnemyArmyOrdered(orderDrops);
                }
                //battle_log
                List<Map<String, Object>> battleLog = db.query("SELECT * FROM battle_log WHERE num_battle = " + battle.get("id") + "and civilization_id = " + newSave.getSaveId() + ";");
                newBattle.setDetailedReport((String)battleLog.get(0).get("log_entry"));
                battles.add(newBattle);
            }
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
