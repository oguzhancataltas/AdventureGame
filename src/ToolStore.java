public class ToolStore extends NormalLoc {

    Weapon knife = new Weapon(1, "Bıçak", 2, 25);
    Weapon bow = new Weapon(2, "Yay",3, 35 );
    Weapon sword = new Weapon(3, "Kılıç", 7, 45);
    Weapon[] weaponList = {knife, bow, sword};

    Armor light = new Armor(1, "Hafif Zırh", 1, 15);
    Armor medium = new Armor(2, "Orta Zırh", 3, 25);
    Armor heavy = new Armor(3, "Ağır Zırh", 5, 40);

    Armor[] armorList = {light, medium, heavy};
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("############ Mağazaya Hoşgeldiniz ############");
        System.out.println();
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");
            System.out.print("Seçiminiz : ");
            int selectCase = input.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz İşlem seçtiniz!!!");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Seninle Alışveriş Yapmak Güzeldi.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("######## Silahlar ########");
        for (Weapon weapon : weaponList) {
            System.out.println("ID : " + weapon.getId() + " \t Silah : " + weapon.getName() + " \t Hasar : " + weapon.getDamage() + " \t Fiyat : " + weapon.getMoney());
        }
        System.out.println("0 - Çıkış");
    }
    public void buyWeapon() {

        System.out.print("Seçiminiz : ");
        int selectWeapon = input.nextInt();
        while (selectWeapon < 0 || selectWeapon > weaponList.length) {
            System.out.println("Geçerli bir silah ID giriniz !!!");
            selectWeapon = input.nextInt();
        }
        if (selectWeapon != 0){
            for (Weapon w : weaponList){
                if (selectWeapon == w.getId()){
                    if (w.getMoney() > this.getPlayer().getMoney()){
                        System.out.println("Yeterli Altınınız Bulunmamaktadır !!!");
                    }else {
                        //Satın Alma İşleminin Gerçekleştiği Alan
                        System.out.println(w.getName() + " silahını satın aldınız");
                        int balance = this.getPlayer().getMoney() - w.getMoney();
                        this.getPlayer().setMoney(balance);
                        System.out.println("Kalan altınınız : " + this.getPlayer().getMoney());
                        System.out.println("Önceki Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                        this.getPlayer().getInventory().setWeapon(w);
                        System.out.println();
                        System.out.println("Yeni Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());

                    }
                }
            }
        }else {

        }
    }

    public void printArmor() {
        System.out.println("######## Zırhlar ########");
        for (Armor a : armorList) {
            System.out.println("ID : " + a.getId() + " \t Zırh : " + a.getName() + " \t Engelleme : " + a.getBlock() + " \t Fiyat : " + a.getMoney());
        }
        System.out.println("0 - Çıkış");
    }
    public void buyArmor(){
        System.out.print("Seçiminiz : ");
        int selectArmor = input.nextInt();
        while (selectArmor < 0 || selectArmor > armorList.length) {
            System.out.println("Geçerli bir silah ID giriniz !!!");
            selectArmor = input.nextInt();
        }
        if (selectArmor != 0){
            for (Armor a : armorList){
                if (selectArmor == a.getId()){
                    if (a.getMoney() > this.getPlayer().getMoney()){
                        System.out.println("Yeterli Altınınız Bulunmamaktadır !!!");
                    }else {
                        //Satın Alma İşleminin Gerçekleştiği Alan
                        System.out.println(a.getName() + " zırhını satın aldınız");
                        int balance = this.getPlayer().getMoney() - a.getMoney();
                        this.getPlayer().setMoney(balance);
                        System.out.println("Kalan altınınız : " + this.getPlayer().getMoney());
                        System.out.println("Önceki Zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                        this.getPlayer().getInventory().setArmor(a);
                        System.out.println();
                        System.out.println("Yeni Silahınız : " + this.getPlayer().getInventory().getArmor().getName());

                    }
                }
            }
        }
    }
}

