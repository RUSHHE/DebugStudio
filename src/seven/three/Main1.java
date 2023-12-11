package seven.three;

import java.io.*;

public class Main1 {
    public static void main(String[] args) {
        File filein = new File("src/seven/three/test1.txt");
        File fileout = new File("src/seven/three/test2.txt");

        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filein));
            OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(fileout));
            System.out.println("test1.txt的内容为:");
            while (isr.ready()) {
                char in = (char) isr.read();
                System.out.print(in);
                osr.append(in);
            }
            osr.close();
            System.out.println("\n复制成功!");
            System.out.println("test2.txt的内容为:");
            InputStreamReader isr2 = new InputStreamReader(new FileInputStream(fileout));
            while (isr2.ready()) {
                System.out.print((char) isr2.read());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}