public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }
    @Override
    public boolean onLocation() {

        System.out.println("Güvenli Evdesiniz.");
        System.out.println("Canınız Yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        if (getPlayer().getInventory().isFood() && getPlayer().getInventory().isFireWood() && getPlayer().getInventory().isWater()){
            System.out.println("Tebrikler Oyunu Bitirdiniz!!!");
            return false;
        }
        return true;
    }
}
