public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean food;
    private boolean fireWood;
    private boolean water;

    public Inventory() {
        this.weapon = new Weapon(-1, "Yumruk",0, 0 );
        this.armor = new Armor(-1, "Gömlek", 0, 0);
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFireWood() {
        return fireWood;
    }

    public void setFireWood(boolean fireWood) {
        this.fireWood = fireWood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }
}
