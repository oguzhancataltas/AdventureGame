public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "firewood",3);
    }

    @Override
    public void takeAward() {
        System.out.println("Odun İtemini Aldınız.");
        getPlayer().getInventory().setFireWood(true);
    }

    @Override
    public boolean completedLoc() {
        if (getPlayer().getInventory().isFireWood()) {
            return true;
        }else{
            return false;
        }
    }


}
