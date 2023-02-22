import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);


    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Karakter İsmini Giriniz : ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println(player.getName() + " oyuna hoşgeldin.");
        System.out.println("Bir Karakter Seçiniz.");
        player.selectChar();
        Location location = null;

        while(true){
            player.printPlayerInfo();
            System.out.println();
            System.out.println("########### Bölgeler ###########");
            System.out.println();
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Eşya Dükkanı --> Silah ve Zırh alabilirsiniz.");
            System.out.println("3 - Mağara --> Zombi Avlama Alanı. Tamamlama Ödülü : Yemek");
            System.out.println("4 - Orman --> Vampir Avlama Alanı. Tamamlama Ödülü : Odun");
            System.out.println("5 - Nehir --> Ayı Avlama Alanı. Tamamlama Ödülü : Su");
            System.out.println("6 - Maden --> Yılan Avlama Alanı. Tamamlama Ödülü : Rasgele");
            System.out.println("0 - Oyundan Çıkış");
            System.out.print("Gitmek istediğiniz bölgeyi seçiniz : ");
            int selLoc = input.nextInt();

            switch (selLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Geçersiz Değer Güvenli Ev e Gönderildiniz!!!");
                    location = new SafeHouse(player);
                    break;
            }
            if (location == null){
                System.out.println("Oyundan Ayrıldınız.");
                break;
            }
            if (!location.onLocation()){
                //System.out.println("GAME OVER!!!");
                break;
            }
        }
    }
}
