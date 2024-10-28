package com.xhonell.date1025;

import com.xhonell.date1025.HomeWork.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * <p>Project:JavaProject - DataFileStream
 * <p>POWER by xhonell on 2024-10-25 14:59
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class DataFileStream {


    public static final String PATH = "F:\\Users\\xhonell\\Documents\\Projects\\IdeaProjects\\JavaProject\\GxaJavaLeason\\src\\main\\java\\com\\xhonell\\date1025\\User.data";
    private static final User[] users = new User[100];

    public User[] readDataInputStream() {


        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(PATH)))) {
            Object obj = ois.readObject();
            return (User[]) obj;
        } catch (ClassNotFoundException e){
            System.out.println("文件未找到");
            return users;
        } catch (IOException e) {
            // 捕获 EOFException，表示文件已经读到末尾
            System.out.println("Reached end of file, returning default array.");
            return users; // 或者 return users;
        }
    }

    public void saveDataOutputStream(User user) throws IOException {
        boolean isFlag = false;
        User[] localUsers = readDataInputStream();
        FileOutputStream fos = new FileOutputStream(PATH);
        ObjectOutputStream dos = new ObjectOutputStream(fos);
        for (int i = 0; i < localUsers.length; i++) {
            if (localUsers[i] ==null){
                isFlag = true;
                localUsers[i] = user;
                break;
            }if (localUsers[i].getName().equals(user.getName())){
                System.out.println("用户名已存在");
                break;
            }
        }
        if (!isFlag) {
            System.out.println("注册失败");
        }else System.out.println("注册成功");
        dos.writeObject(localUsers);
        dos.flush();
        dos.close();
    }
}
