package com.project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.*;

public class CivilizationDao {

    public void addSave(SaveData save) {
        
    }

    public ArrayList<SaveData> getSaves() {
        ArrayList<SaveData> saves = new ArrayList<>();
        AppData db = AppData.getInstance();

        // Call the SQL function
        List<Map<String, Object>> result = db.query("SELECT F_civilizations_stats_quantity(civilization_id) as values FROM civilization_stats");

        // Process the result
        if (!result.isEmpty()) {
            for (Map<String, Object> row : result) {
          
                Array array = (Array) row.get("values"); 

                // Convert the VARRAY to a Java list
                List<Number> numberList = convertArrayToList(array);
                SaveData save = new SaveData();
                save.setWood(numberList.get(0).intValue());
                //TODO the rest
                saves.add(save);
            }
            
        }
        return saves;
    }

     private static List<Number> convertArrayToList(Array array) {
        List<Number> list = new ArrayList<>();
        try {
            // Get the SQL array as a java.sql.Array
            int[] types = array.getArrayTypeInfo();
            int[] sizes = array.getArraySize();
            for (int i = 0; i < sizes.length; i++) {
                list.add((Number) array.getArray(types[i], i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateSave(SaveData data) {
        
    }

    public void deleteSave(SaveData data) {
        
    }
    
}
