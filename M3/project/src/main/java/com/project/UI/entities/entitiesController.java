package com.project.UI.entities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

import com.project.*;

public class entitiesController {
    
    SeeEntitiesView seeEntitiesView;
    Civilization civilization;

    public entitiesController(SeeEntitiesView seeEntitiesView){
        this.seeEntitiesView = seeEntitiesView;
        civilization = Civilization.getInstance();

        setTimer();
    }

    private void setTimer(){
        int delay = 1000; 
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                seeEntitiesView.smithyQuantity.setText(String.valueOf(civilization.getSmithy()));
                seeEntitiesView.carpentryQuantity.setText(String.valueOf(civilization.getCarpentry()));
                seeEntitiesView.farmQuantity.setText(String.valueOf(civilization.getFarm()));
                seeEntitiesView.magicTowerQuantity.setText(String.valueOf(civilization.getMagicTower()));
                seeEntitiesView.churchQuantity.setText(String.valueOf(civilization.getChurch()));

                Map<String,Integer> army = getArmy();

                if(army.get("SWORDSMAN")!=null){
                    seeEntitiesView.swordsmanQuantity.setText(army.get("SWORDSMAN").toString());
                }else{
                    seeEntitiesView.swordsmanQuantity.setText("0");
                }
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    private Map<String,Integer> getArmy(){
        Map<String,Integer> quantities = new HashMap();
        for(MilitaryUnit unit : civilization.getArmy()){
            System.out.println(unit.getType().toString());
            if(quantities.get(unit.getType().toString())==null){
                quantities.put(unit.getType().toString(), 1);
            }else{
                quantities.put(unit.getType().toString(),quantities.get(unit.getType().toString())+1);
            }
            // quantities.put(unit.getType().toString(),(quantities.get(unit.getType().toString()).equals(null) ? 0 : (int)quantities.get(unit.getType().toString()))+1);
        }
        System.out.println(quantities);
        return quantities;
        
    }
}
