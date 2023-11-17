package four.four;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dorm dorm = new Dorm(114, "和兴苑514");
        while (true) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("请选择菜单：");
            System.out.println("1.新增学生");
            System.out.println("2.移出学生");
            System.out.println("3.显示寝室信息");
            System.out.println("4.结束");
            switch (scan.nextInt()) {
                case 1:
                    dorm.addStudent();
                    break;
                case 2:
                    System.out.println("和蔼！你要赶谁走？");
                    dorm.removeStudent(scan.next());
                    break;
                case 3:
                    dorm.showDorm();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("你是来找茬的吗？");
            }
        }
    }
}

class Student {
    private final String name;//姓名
    private final String gender;//性别
    private final int age;//年龄
    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name = " + name + ", age = " + age + ", gender = " + gender;
    }
}

class Dorm {
    private final Scanner scan = new Scanner(System.in);
    private final int dormId;//宿舍的ID号
    private final String dormLocation;//宿舍的位置
    //注意，这里是学生对象的列表哦
    //可以存放多个学生对象，来表示寝室里住着多个学生
    private final ArrayList<Student> students;

    public Dorm(int dormId, String dormLocation) {
        this.dormId = dormId;
        this.dormLocation = dormLocation;
        students = new ArrayList<>();
    }

    public void addStudent() {
        System.out.print("请输入新增学生姓名：");
        String name = scan.next();
        System.out.print("请输入新增学生的年龄：");
        int age = scan.nextInt();
        System.out.print("请输入新增学生性别：");
        String gender = scan.next();
        students.add(new Student(name, gender, age));
        System.out.println("新同学入住成功！");
    }

    public void removeStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                students.remove(i);
                return;
            }
        }
        System.out.println("宿舍里没有这个人捏");
    }

    public void showDorm() {
        System.out.println(dormId + "号寝室，位于" + dormLocation);
        System.out.println("宿舍里的成员有：");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}