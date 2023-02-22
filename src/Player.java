import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void initPlayer(GameCharacter gameCharacter){
        System.out.println("-----------------------------------------------------------");
        System.out.println(gameCharacter.getName() + " Karakterini Seçtiniz");
        this.setCharName(gameCharacter.getName());
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        System.out.println("Karakter Özellikleri ");

    }

    public void selectChar(){

        GameCharacter samurai = new GameCharacter("Samuray", 5, 21, 15, 1);
        GameCharacter archer = new GameCharacter("Okçu   ", 7, 18, 20, 2);
        GameCharacter knight = new GameCharacter("Şovalye", 8, 24, 5, 3);
        GameCharacter[] charList = {samurai, archer, knight};

        System.out.println("-----------------------------------------------------------");
        System.out.println("Karakterler");
        for (GameCharacter gameChar : charList) {
            System.out.println("ID : " + gameChar.getId() + " \t Karakter : " + gameChar.getName() + " \t Hasar : " + gameChar.getDamage() + " \t Sağlık : " + gameChar.getHealth() + " \t Para : " + gameChar.getMoney());
        }
        System.out.print("Seçtiğiniz Karakterin ID değerini giriniz : ");
        int select = input.nextInt();

        switch (select){
            case 2:
                initPlayer(archer);
                break;
            case 3:
                initPlayer(knight);
                break;
            case 1:
            default:
                initPlayer(samurai);
                break;
        }
    }

    public void printPlayerInfo(){
        System.out.println("Karakter : " + this.getCharName() +
                " \t Hasar : " + this.getTotalDamage() +
                " \t Blocklama : " + this.getInventory().getArmor().getBlock() +
                " \t Sağlık : " + this.getHealth() +
                " \t Altın : " + this.getMoney() +
                " \t Silah : " + this.getInventory().getWeapon().getName() +
                " \t Zırh : " + this.getInventory().getArmor().getName());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotalDamage(){
        return damage + getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

}
