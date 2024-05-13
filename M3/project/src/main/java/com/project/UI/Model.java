package com.project.UI;

import com.project.Civilization;

public class Model {
    public Civilization civilization;
    public int food;
    public int wood;
    public int iron;
    public int mana;

    public int techAttack;
    public int techDefense;

    public Model(Civilization civilization){
        this.civilization = civilization;
    }

    public void update(){
        this.wood = civilization.getWood();
        this.food = civilization.getFood();
        this.iron = civilization.getIron();
        this.mana = civilization.getMana();
    }
}
