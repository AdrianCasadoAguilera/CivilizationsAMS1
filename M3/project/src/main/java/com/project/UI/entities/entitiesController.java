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
                if(army.get("SPEARMAN")!=null){
                    seeEntitiesView.spearmanQuantity.setText(army.get("SPEARMAN").toString());
                }else{
                    seeEntitiesView.spearmanQuantity.setText("0");
                }
                if(army.get("CROSSBOW")!=null){
                    seeEntitiesView.crossbowQuantity.setText(army.get("CROSSBOW").toString());
                }else{
                    seeEntitiesView.crossbowQuantity.setText("0");
                }
                if(army.get("CANNON")!=null){
                    seeEntitiesView.cannonQuantity.setText(army.get("CANNON").toString());
                }else{
                    seeEntitiesView.cannonQuantity.setText("0");
                }
                if(army.get("ARROWTOWER")!=null){
                    seeEntitiesView.arrowTowerQuantity.setText(army.get("ARROWTOWER").toString());
                }else{
                    seeEntitiesView.arrowTowerQuantity.setText("0");
                }
                if(army.get("CATAPULT")!=null){
                    seeEntitiesView.catapultQuantity.setText(army.get("CATAPULT").toString());
                }else{
                    seeEntitiesView.catapultQuantity.setText("0");
                }
                if(army.get("ROCKETLAUNCHERTOWER")!=null){
                    seeEntitiesView.rocketLauncherQuantity.setText(army.get("ROCKETLAUNCHERTOWER").toString());
                }else{
                    seeEntitiesView.rocketLauncherQuantity.setText("0");
                }
                if(army.get("MAGICIAN")!=null){
                    seeEntitiesView.magicianQuantity.setText(army.get("MAGICIAN").toString());
                }else{
                    seeEntitiesView.magicianQuantity.setText("0");
                }
                if(army.get("PRIEST")!=null){
                    seeEntitiesView.priestQuantity.setText(army.get("PRIEST").toString());
                }else{
                    seeEntitiesView.priestQuantity.setText("0");
                }

            }
        };
        new Timer(delay, taskPerformer).start();
    }

    private Map<String,Integer> getArmy(){
        Map<String,Integer> quantities = new HashMap<String,Integer>();
        for(MilitaryUnit unit : civilization.getArmy()){
            if(quantities.get(unit.getType().toString())==null){
                quantities.put(unit.getType().toString(), 1);
            }else{
                quantities.put(unit.getType().toString(),quantities.get(unit.getType().toString())+1);
            }
        }
        return quantities;
        
    }
}
