package seven.four;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<File> list = getAllFiles(new Scanner(System.in).nextLine());
        for (File file : list) {
            if (file.getName().endsWith(".java")) {
                System.out.println(file.getAbsoluteFile());
            }
        }
    }

    public static List<File> getAllFiles(String path) {
        List<File> files = new ArrayList<>();
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            RecursionFile(file, files);
        }
        return files;
    }

    public static void RecursionFile(File file, List<File> files) {
        if (file == null) {
            return;
        }
        File[] fileList = file.listFiles();
        if (fileList != null) {
            for (File fs : fileList) {
                files.add(fs);
                if (!fs.isFile()) {
                    RecursionFile(fs, files);
                }
            }
        }
    }
}
