package seven.three;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader filein = new FileReader("src/seven/three/test1.txt");
        File fileout = new File("src/seven/three/test2.txt");

        try {
            BufferedReader in = new BufferedReader(filein);
            BufferedWriter out = new BufferedWriter(new FileWriter(fileout));
            in.mark(1000);
            System.out.println("test1.txt的内容为:");
            System.out.println(in.readLine());
            in.reset();
            out.write(in.readLine());
            out.close();
            System.out.println("复制成功!");
            System.out.println("test2.txt的内容为:");
            System.out.println(new BufferedReader(new FileReader(fileout)).readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
