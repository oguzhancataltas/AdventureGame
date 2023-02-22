public class Weapon {
    private int id;
    private int damage;
    private int money;
    private String name;

    public Weapon(int id,String name, int damage, int money ) {
        this.id = id;
        this.damage = damage;
        this.money = money;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int price) {
        this.money = price;
    }
}
