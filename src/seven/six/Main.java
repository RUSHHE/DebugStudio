package seven.six;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/seven/six/test.txt"));
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要替换的字符串:");
        String origin = scan.nextLine();
        System.out.println("请输入替换后的字符串");
        String newStr = scan.nextLine();
        String read = br.readLine();
        System.out.println("修改前的文本内容为:" + read);
        read = read.replaceAll(origin, newStr);
        System.out.println("修改后的文本内容为:" + read);
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/seven/six/test.txt"));
        bw.write(read);
        bw.close();
    }
}
