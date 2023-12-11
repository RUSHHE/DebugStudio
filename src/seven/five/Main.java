package seven.five;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入要统计的字符串:");
        System.out.println("字符串在test.txt文件中出现的次数为:" + count("src/seven/five/test.txt", new Scanner(System.in).nextLine()) + "次");
    }

    public static int count(String filename, String target) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        int count = 0;
        while (line.contains(target)) {
            line = line.replaceFirst(target, "");
            count++;
        }
        return count;
    }
}
