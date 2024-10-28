package com.xhonell.date1025.HomeWork;

import com.xhonell.date1025.DataFileStream;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

import static com.xhonell.date1025.DataFileStream.PATH;

/**
 * <p>Project:JavaProject - LoginRegister
 * <p>POWER by xhonell on 2024-10-25 19:10
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class LoginRegister {
    public static Scanner sc = new Scanner(System.in);
    private static final String[] FINGER = {"拳头", "剪刀", "布"};

    public void menu() {
        System.out.println("请选择登录或者注册: \n\t1.登陆\n\t2.注册");

        System.out.print("我直接选择:");

        switch (sc.next()) {
            case "1":
                login();
                break;
            case "2":
                register();
                break;
            default:
                System.out.println("输入失败，请重新选择");
                menu();
        }

    }

    /**
     * 登录界面
     */
    public void login() {
        System.out.println("请输入您要登录的账号：");
        String username = sc.next();
        System.out.println("请输入您要登录的密码：");
        String password = sc.next();

        DataFileStream dataFileStream = new DataFileStream();
        User[] users = dataFileStream.readDataInputStream();

        for (User user : users) {
            if (user == null || user.equals("")) {
                System.out.println("没找到该用户，请重新注册");
                register();
            }

            if (user.getName().equals(username) && user.getPassword().equals(password)) {

                index(user, users);
                return;
            }
        }
        System.out.println("账号密码错误，请重新尝试");
        menu();
    }

    /**
     * 注册用户
     */
    public void register() {
        System.out.println("请输入您要注册的账号：");
        String username = sc.next();
        System.out.println("请输入您要注册的密码：");
        String password = sc.next();

        DataFileStream dataFileStream = new DataFileStream();
        try {
            dataFileStream.saveDataOutputStream(new User(username, password));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            File file = new File(PATH);
            try {
                System.out.println("文件创建" + (file.createNewFile() ? "成功" : "失败"));
            } catch (IOException ex) {
                System.out.println(e.getMessage() + "请重新尝试！");
                register();
            }
            register();
        }
        menu();
    }

    /**
     * 主页面
     *
     * @param user
     * @param users
     */
    public void index(User user, User[] users) {

        while (true) {
            System.out.println("登录成功，请选择您要进行的操作:\n\t1.查询用户\n\t2.划拳游戏\n\t3.战绩查询\n\t4.数字炸弹");
            switch (sc.next()) {
                case "1":
                    inquireByName(user, users);
                    continue;
                case "2":
                    fingerGuessing(user, users);
                    continue;
                case "3":
                    inquireByRocord(user);
                    continue;
                case "4":
                    bombForNumber(user, users);
                    continue;
                default:
                    System.out.println("输入错误，即将退出系统！");
                    menu();
            }
        }

    }

    /**
     * 划拳游戏
     *
     * @param user
     * @param users
     */
    public void fingerGuessing(User user, User[] users) {
        Game game = user.getGame(0);
        if (game == null) {
            game = new Game("划拳");

        }
        Random random = new Random();
        System.out.println("欢迎" + user.getName() + "进入游戏，请从以下单词选择输入:\n\t石头\t剪刀\t布");
        while (true) {
            String fingerSys = FINGER[random.nextInt(FINGER.length)];
            System.out.println("请输入一个你认为可以胜利的手势：");
            String fingerStr = sc.next();
            if (fingerStr.equals("退出")) {
                user.setGame(game, 0);
                saveGameProcess(users);
                index(user, users);
                break;
            }
            if (fingerStr.equals(fingerSys)) {
                System.out.println("棋逢对手!");
                game.setDefeat(game.getDefeat() + 1);
            } else if (fingerStr.equals("剪刀") && fingerSys.equals("石头")) {
                System.out.println("小垃圾你输了");
                game.setDefeat(game.getDefeat() + 1);
            } else if (fingerStr.equals("石头") && fingerSys.equals("布")) {
                System.out.println("小垃圾你输了");
                game.setDefeat(game.getDefeat() + 1);
            } else if (fingerStr.equals("布") && fingerSys.equals("剪刀")) {
                System.out.println("小垃圾你输了");
                game.setDefeat(game.getDefeat() + 1);
            } else {
                System.out.println("让你赢一局吧");
                game.setVictory(game.getVictory() + 1);
            }
        }
    }

    public void bombForNumber(User user, User[] users) {
        Game game = user.getGame(1);
        if (game == null) {
            game = new Game("数字炸弹");
            user.setGame(game, 1);
        }

        int random = (int) (Math.random() * 100);
        System.out.println("请输入0~100中您认为是炸弹的数字：");
        int scRandom = sc.nextInt();
        int count = 0;
        while (count < 3) {
            if (scRandom < random) {
                System.out.println("您的数字略小于炸弹，请重新尝试：");
            } else if (scRandom == random) {
                System.out.println("您就是今天的幸运玩家！");
                game.setVictory(game.getVictory() + 1);
                saveGameProcess(users);
                return;
            } else {
                System.out.println("您输入的数字略大于炸弹：");
            }
            count++;
            if (count < 3) {
                scRandom = sc.nextInt();
            }
        }
        game.setDefeat(game.getDefeat() + 1);
        System.out.println("游戏结束，正确答案是" + random);
        System.out.println("是否继续游戏：y/n");
        if (sc.next().equals("y")) {
            bombForNumber(user, users);
        }

    }


    /**
     * 查询战绩
     *
     * @param user
     */
    public void inquireByRocord(User user) {
        if (user.getGame(0) == null || user.getGame(1) == null) {
            System.out.println("当前任务未开始游戏");
            return;
        }
        System.out.println(user.getGame(1).toString() + "\n" + user.getGame(0).toString());
    }

    /**
     * 保存成绩
     *
     * @param users
     */
    public void saveGameProcess(User[] users) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(PATH)))) {
            objectOutputStream.writeObject(users);
            objectOutputStream.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void inquireByName(User user, User[] users) {
        System.out.println("请输入您要查询的用户名称");
        String name = sc.next();
        for (User userIndex : users) {
            if (userIndex == null) break;

            if (userIndex.getName().contains(name)) {
                System.out.println(user);
            }
        }
    }
}
