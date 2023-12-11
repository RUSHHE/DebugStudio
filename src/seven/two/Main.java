package seven.two;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //创建一个File对象，首先判断该文件是否存在，若不存在则创建该文件，然后键入字符串，通过FileOutputStream输出流将字符串写入该文件
        try {
            File file = new File("src/seven/two/test.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            System.out.println("请输入字符串:");
            fileOutputStream.write(new Scanner(System.in).nextLine().getBytes());
            System.out.println("写入文件成功");
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}