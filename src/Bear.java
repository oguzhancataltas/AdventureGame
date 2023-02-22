public class Bear extends Obstacle{
    public Bear() {
        super(3, 7, 20,12, "Ayı");
    }

    @Override
    public void gain() {
        int gainMoney = this.getMoney();
        System.out.println("Kazanılan Altın : " + gainMoney);
    }
}
