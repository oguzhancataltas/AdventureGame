public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "food",3);

    }

    @Override
    public void takeAward() {
        System.out.println("food itemini aldınız.");
        getPlayer().getInventory().setFood(true);
    }

    @Override
    public boolean completedLoc() {
        if (getPlayer().getInventory().isFood()) {
            return true;
        }else{
            return false;
        }
    }
}
