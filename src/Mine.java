import java.util.Random;

public class Mine extends BattleLoc{
    public Mine(Player player) {
        super(player, "Maden", new Snake(), "award", 0);
        Random r = new Random();
        this.setMaxObstacle(r.nextInt(1,7));
    }

    @Override
    public void takeAward() {

    }

    @Override
    public boolean completedLoc() {
        return false;
    }
}
