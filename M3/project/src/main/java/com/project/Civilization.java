import java.util.ArrayList;

public class Civilization {
    private static Civilization instance;
    private int technologyDefense;
    private int technologyAttack;
    private int wood;
    private int iron;
    private int food;
    private int mana;
    private int magicTower;
    private int church;
    private int farm;
    private int smithy;
    private int carpentry;
    private int battles;
    private ArrayList<AttackUnit> army;

    private Civilization() {
        army = new ArrayList<>(9);
    }

    public static Civilization getInstance() {
        if (instance == null) {
            instance = new Civilization();
        }
        return instance;
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

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public ArrayList<AttackUnit> getArmy() {
        return army;
    }

    public void setArmy(ArrayList<AttackUnit> army) {
        this.army = army;
    }


    public void newChurch() {
        if (wood < ??) {
            // excepción
        }
        church++;
        wood -= ??;
    }

    public void newMagicTower() {
        if (mana < ??) {
            // excepción
        }
        magicTower++;
        mana -= 50;
    }

    public void newFarm() {
        if (wood < 50) {
            // excepción
        }
        farm++;
        wood -= 50;
    }

    public void newCarpentry() {
        if (wood < ??) {
            // excepción
        }
        carpentry++;
        wood -= ??;
    }

    public void newSmithy() {
        if (iron < ??) {
            // excepción
        }
        smithy++;
        iron -= ??;
    }

    public void upgradeTechnologyDefense() {
        int cost = calculateCost(technologyDefense);
        if (iron < cost) {
            // excepción
        }
        technologyDefense++;
        iron -= cost;
    }

    public void upgradeTechnologyAttack() {
        int cost = calculateCost(technologyAttack);
        if (iron < cost) {
            // excepción
        }
        technologyAttack++;
        iron -= cost;
    }

    private int calculateCost(int level) {
        return 100 + (10 * level);
    }


}
