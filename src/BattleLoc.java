import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public abstract void takeAward();

    public abstract boolean completedLoc();

    @Override
    public boolean onLocation() {
        if (this.completedLoc()) {
            System.out.println("Bu Bölgeyi Tamamladınız!!!");
            return true;
        }
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan Bulunduğunuz Bölge : " + this.getName());
        System.out.println("Burada Bulunan Düşman : " + obsNumber + " " + this.obstacle.getName());
        System.out.println("<S>avaş yada <K>aç");
        System.out.print("Seçiminiz : ");
        String selectCase = input.nextLine().toUpperCase();

        if (selectCase.equals("S")) {
            System.out.println("Savaş Başlıyor!!!");
            if (!combat(obsNumber)) {
                System.out.println(this.getName() + " Temizlendi.");
                this.takeAward();
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<V>ur veya <Kaç> : ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    System.out.println();
                    if (this.randomAttack() > 50) {
                        System.out.println(getPlayer().getName() + " vurdu.");
                        System.out.println();
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit(i);
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println(getObstacle().getName() + " " + this.getPlayer().getName() + " vurdu.");
                            System.out.println();
                            int blockDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (blockDamage < 0) {
                                blockDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - blockDamage);
                            afterHit(i);
                        }
                    } else {
                        System.out.println(getObstacle().getName() + " " + this.getPlayer().getName() + " vurdu.");
                        int blockDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (blockDamage < 0) {
                            blockDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - blockDamage);
                        afterHit(i);

                        if (this.getPlayer().getHealth() > 0) {
                            System.out.println(getPlayer().getName() + " vurdu.");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit(i);
                        }
                    }
                } else {
                    return false;
                }
            }
            if (this.getPlayer().getHealth() > 0) {
                this.getObstacle().gain();
                int gainMoney = this.getObstacle().getMoney();
                this.getPlayer().setMoney(this.getPlayer().getMoney() + gainMoney);
                System.out.println("Altın : " + this.getPlayer().getMoney());
            }
            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("Game Over!!!");
                return true;
            }
        }
        return false;
    }

    public void afterHit(int i) {
        if (this.getPlayer().getHealth() < 0) {
            System.out.println();
            System.out.println(this.getPlayer().getName() + " ÖLDÜ");
        } else {
            System.out.println(this.getPlayer().getName() + " Sağlığı : " + this.getPlayer().getHealth());
        }
        if (this.getObstacle().getHealth() < 0) {
            System.out.println();
            System.out.println(i + ". " + this.getObstacle().getName() + " ÖLDÜ");
        } else {
            System.out.println(i + ". " + this.getObstacle().getName() + " Sağlığı : " + this.getObstacle().getHealth());
        }
        System.out.println();
    }

    public void playerStats() {
        System.out.println(this.getPlayer().getName() + " Değerleri");
        System.out.println("----------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth() +
                "\n Hasar : " + this.getPlayer().getTotalDamage() +
                "\n Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock() +
                "\n Altın : " + this.getPlayer().getMoney() +
                "\n Silah : " + this.getPlayer().getInventory().getWeapon().getName() +
                "\n Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println();

    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("----------------------------");
        System.out.println("Sağlık : " + (Math.max(this.getObstacle().getHealth(), 0)) +
                "\n Hasar : " + this.getObstacle().getDamage());
        System.out.println();
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public int randomAttack() {
        Random r = new Random();
        return r.nextInt(100);
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
