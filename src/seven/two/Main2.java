package seven.two;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        File file = new File("src/seven/two/test.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            System.out.println("文件内容如下:");
            while (fis.available() > 0) {
                char data = (char) (fis.read());
                System.out.print(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

