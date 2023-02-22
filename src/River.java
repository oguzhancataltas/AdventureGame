public class River extends BattleLoc{
    public River(Player player) {
        super(player, "Nehir", new Bear(), "water", 3);
    }

    @Override
    public void takeAward() {
        System.out.println("Su İtemini Aldınız.");
        getPlayer().getInventory().setWater(true);
    }

    @Override
    public boolean completedLoc() {
        if (getPlayer().getInventory().isWater()) {
            return true;
        }else{
            return false;
        }
    }


}
