import java.util.Scanner;

public class Shopping {
    /**
     * 选购商品界面
     *
     * @param namePassword
     * @param index
     */

    public static Scanner scanner = new Scanner(System.in);
    public static int count = 0;
    public static double totalPrice = 0;
    public static String[][] shopTotalPrice = new String[10][4];

    public static void shopping(String[][] namePassword, int index) {
        System.out.println("欢迎" + namePassword[index][0]);
        String[][] name_price = new String[][]{
                {"1.可乐", "单价：2.5元/瓶"},
                {"2.薯片", "单价：6.0元/包"},
                {"3.可爱多", "单价：3.5元/瓶"},
                {"4.雪碧", "单价：3.0元/瓶"}
        };
        toString(name_price);

        while (true) {
            System.out.println("请选择您要购买的商品：输入0结束！");
            int shop = scanner.nextInt();
            if (shop == 0) {
                break;
            }
            System.out.println("请输入您要购买的数量:");
            int shopNumber = scanner.nextInt();

            GWC_Shop(name_price, shop - 1, shopNumber);
        }
        toString(shopTotalPrice);

        System.out.println("请选择是否结账：y/n");
        if (scanner.next().equals("y")) {
            System.out.println("目前账单：" + totalPrice + "\n输入y确认付款");
            if (totalPrice == 0) {
                System.out.println("当前账单为空，无需付款，即将返回主页面");
                RegisterLogin.indexChoose(namePassword, index);
            }
            if (scanner.next().equals("y")) {
                System.out.println("付款成功,欢迎下次光临");
                totalPrice = 0;
                count = 0;
                shopTotalPrice = new String[10][4];
                RegisterLogin.indexChoose(namePassword, index);
            } else if (scanner.next().equals("n")) {
                System.out.println("付款失败，请选择操作！");
            }
        } else {
            System.out.println("取消付款，即将返回详情页面");
            shopping(shopTotalPrice, index);
        }


    }

    /**
     * 购物车函数
     *
     * @param name_price
     * @param index
     */
    public static String[][] GWC_Shop(String[][] name_price, int index, int shopNumber) {

        Double[] shopMenu = new Double[]{2.5, 6.0, 3.5, 3.0};
        shopTotalPrice[count][0] = name_price[index][0];
        shopTotalPrice[count][1] = name_price[index][1];
        shopTotalPrice[count][2] = String.valueOf(shopNumber);
        shopTotalPrice[count][3] = String.valueOf(shopMenu[index] * shopNumber);
        count++;
        totalPrice += shopMenu[index] * shopNumber;

        return shopTotalPrice;
    }

    /**
     * 重写toString方法
     *
     * @param name_price
     */
    public static void toString(String[][] name_price) {
        for (int i = 0; i < name_price.length; i++) {

            if (name_price[i] == null) break;

            for (int j = 0; j < name_price[i].length; j++) {
                System.out.print(name_price[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
