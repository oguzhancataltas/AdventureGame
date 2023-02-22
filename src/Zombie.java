public class Zombie extends Obstacle{

    public Zombie() {
        super(1, 3, 10,4, "Zombi");
    }

    @Override
    public void gain() {
        int gainMoney = this.getMoney();
        System.out.println("Kazanılan Altın : " + gainMoney);
    }
}
