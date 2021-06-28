
public class Test {

    public static Good[] createList() {
        Good[] list = new Good[5];

        list[0] = new Good("Кольцо", "золотой кубический цирконий, стандарт 585", 11090);
        list[1] = new Good("Серьги", "золото с топазами 0,263 К и бриллиантами 0,0022 К, стандарт 585", 6090);
        list[2] = new Good("Браслет", "rolex, золото, стандарт 585", 8850);
        list[3] = new Good("Наручные часы", "Талант, бижутерия из сплава, кварц", 3290);
        list[4] = new Good("Кулон", "серебряная сова с эмалью и кубическим цирконием, стандарт 925", 1320);

        return list;
    }

    public static void main(String[] args) {
        try {
            Administrator admin1 = new Administrator("YuriyVladislavovich",
                    "shop.dat", "blacklist.dat");

            admin1.addGood(createList());

            Client client1 = new Client("Nevskii", "shop.dat");
            Client client2 = new Client("Molochin", "shop.dat");
            client2.order();
            client2.pay(0);
            admin1.register(client2);

            //shop
            System.out.println("Shop");
            ConnectorGoods con2 = admin1.getShop();
            Good[] mas2 = con2.read();
            for(Good e : mas2) {
                System.out.println(e);
            }
            System.out.println();

            //basket
            System.out.println("Basket of client");
            ConnectorGoods con1 = client1.getBasket();
            Good[] mas1 = con1.read();
            for(Good e : mas1) {
                System.out.println(e);
            }
            System.out.println();

            //black_list
            System.out.println("Чёрный лист");
            ConnectorClients con3 = admin1.getBlackList();
            Client[] mas3 = con3.read();
            for(Client e : mas3) {
                System.out.println(e);
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}