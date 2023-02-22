import java.util.Random;

public class Snake extends Obstacle{

    public Snake() {
        super(4, 0, 12, 0, "Yılan");
        Random r = new Random();
        this.setDamage(r.nextInt(3,6)+1);
    }

    @Override
    public void gain() {
        Random r = new Random();
        int chance = r.nextInt(101);
        if (chance <= 15){
            int changeItem = r.nextInt(101);
            if (changeItem <= 20){
                System.out.println("Kılıç Kazandın.");
            }else if (changeItem <= 50){
                System.out.println("Yay Kazandın.");
            }else {
                System.out.println("Bıçak Kazandın.");
            }
        } else if (chance <= 30) {
            int changeItem = r.nextInt(101);
            if (changeItem <= 20){
                System.out.println("Ağır Zırh Kazandın.");
            }else if (changeItem <= 50){
                System.out.println("Orta Zırh Kazandın.");
            }else {
                System.out.println("Hafif Zırh Kazandın.");
            }
        } else if (chance <= 55) {
            int changeItem = r.nextInt(101);
            if (changeItem <= 20){
                System.out.println("10 Altın Kazandın.");
                this.setMoney(10);
            }else if (changeItem <= 50){
                System.out.println("5 Altın Kazandın.");
                this.setMoney(5);
            }else {
                System.out.println("1 Altın Kazandın.");
                this.setMoney(1);
            }
        } else {
            System.out.println("Herhangi bir İtem ya da Altın Kazanamadın.");
        }
    }
}
