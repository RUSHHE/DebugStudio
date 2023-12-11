package seven.one;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("src/seven/one/test.txt");
            System.out.println("文件名称:" + file.getName());
            System.out.println("相对路径:" + file.getCanonicalPath());
            System.out.println("绝对路径:" + file.getAbsolutePath());
            System.out.println("文件大小:" + file.length());
            System.out.println("文件最后修改日期:" + file.lastModified());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}