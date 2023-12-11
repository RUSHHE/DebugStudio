package seven.nine;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("src/seven/nine/test.txt"));
        ArrayList<Student> stu = new ArrayList<>();
        while (br.ready()) {
            String[] temp = br.readLine().split(",");
            stu.add(new Student(temp[0], Integer.parseInt(temp[1]), temp[2]));
        }
        while (true) {
            System.out.println("----欢迎来到学生信息管理系统—---\n" +
                    "请输入你想要进行的操作\n" +
                    "1：查看所有学生信息\n" +
                    "2：添加学生信息\n" +
                    "3：删除学生信息\n" +
                    "4：修改学生信息\n" +
                    "5：查找学生信息\n" +
                    "6：退出");
            switch (scan.nextInt()) {
                case 1:
                    System.out.println("姓名\t年龄\t性别");
                    for (Student student : stu) {
                        System.out.println(student);
                    }
                    break;
                case 2:
                    System.out.println("请输入姓名:");
                    String newStuName = scan.next();
                    System.out.println("请输入年龄:");
                    int newStuAge = scan.nextInt();
                    System.out.println("请输入性别:");
                    String newStuSex = scan.next();
                    stu.add(new Student(newStuName, newStuAge, newStuSex));
                    System.out.println("添加信息成功!");
                    break;
                case 3:
                    System.out.println("请输入你要删除的学生姓名:");
                    String removeStuName = scan.next();
                    stu.removeIf(student -> student.getName().equals(removeStuName));
                    System.out.println("删除学生信息成功!");
                    break;
                case 4:
                    System.out.println("请输入你要修改的学生姓名:");
                    String oldName = scan.next();
                    for (Student student : stu) {
                        if (student.getName().equals(oldName)) {
                            System.out.println("请输入新的姓名:");
                            student.setName(scan.next());
                            System.out.println("请输入新的年龄:");
                            student.setAge(scan.nextInt());
                            System.out.println("请输入新的性别:");
                            student.setSex(scan.next());
                            System.out.println("修改信息成功!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("请输入你要查找的学生姓名:");
                    String name = scan.next();
                    for (Student student : stu) {
                        if (student.getName().equals(name)) {
                            System.out.println(student);
                            System.out.println("查找成功!");
                        }
                    }
                    break;
                case 6:
                    StringBuilder sb = new StringBuilder();
                    for (Student student : stu) {
                        sb.append(student.getName()).append(",")
                                .append(student.getAge()).append(",")
                                .append(student.getSex()).append("\n");
                    }
                    BufferedWriter bw = new BufferedWriter(new FileWriter("src/seven/nine/test.txt"));
                    bw.write(sb.toString());
                    bw.close();
                    System.exit(0);
            }
        }
    }
}

class Student {
    private String name;//姓名
    private int age;//年龄
    private String sex;//性别

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Student setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String toString() {
        return name + "\t" + age + "\t" + sex;
    }
}