package seven.eight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("src/seven/eight/test.txt"));
        ArrayList<Student> stu = new ArrayList<>();
        while (br.ready()) {
            String[] temp = br.readLine().split(",");
            stu.add(new Student(temp[0], Integer.parseInt(temp[1]), temp[2]));
        }
        while (true) {
            System.out.println("请输入你要查找的学生姓名:");
            String name = scan.next();
            for (Student student : stu) {
                if (student.getName().equals(name)) {
                    System.out.println(student);
                    System.out.println("查找成功!");
                }
            }
        }
    }
}

class Student {
    private final String name;//姓名
    private final int age;//年龄
    private final String sex;//性别
    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "学生信息{" +
                "姓名='" + name + '\'' +
                ", 年龄=" + age +
                ", 性别='" + sex + '\'' +
                '}';
    }
}