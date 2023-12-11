package seven.seven;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("src/seven/seven/test.txt"));
        String[] input = br.readLine().split(",");
        ArrayList<ArrayList<String>> elem = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            elem.add(new ArrayList<>());
            elem.get(i).add(input[i]);
        }
        while (br.ready()) {
            String[] s = br.readLine().split(",");
            for (int i = 0; i < s.length; i++) {
                elem.get(i).add(s[i]);
            }
        }
        while (true) {
            System.out.println("----数据库处理系统----");
            System.out.println("1:修改记录");
            System.out.println("2:删除记录");
            System.out.println("3:删除字段");
            System.out.println("4:退出");
            switch (scan.nextInt()) {
                case 1:
                    System.out.println("请输入你要修改的订单ID:");
                    String oneId = scan.next();
                    for (int i = 1; i < elem.get(0).size(); i++) {
                        if (elem.get(0).get(i).equals(oneId)) {
                            System.out.println("请输入新的ID");
                            String newId = scan.next();
                            System.out.println("请输入新的姓名");
                            String newName = scan.next();
                            System.out.println("请输入新的商品名称");
                            String newGoods = scan.next();
                            System.out.println("请输入新的购买数量");
                            String newNum = scan.next();
                            elem.get(0).set(i, newId);
                            elem.get(1).set(i, newName);
                            elem.get(2).set(i, newGoods);
                            elem.get(3).set(i, newNum);
                            System.out.println("修改订单时间成功");
                        }
                    }
                    break;
                case 2:
                    System.out.println("请输入你要删除的ID");
                    String twoId = scan.next();
                    for (int i = 1; i < elem.get(0).size(); i++) {
                        if (elem.get(0).get(i).equals(twoId)) {
                            for (ArrayList<String> strings : elem) {
                                strings.remove(i);
                            }
                            System.out.println("删除记录成功!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("请输入你要删除的字段名");
                    String threeName = scan.next();
                    for (int i = 0; i < elem.size(); i++) {
                        if (elem.get(i).get(0).equals(threeName)) {
                            elem.remove(i);
                            System.out.println("删除记录成功");
                        }
                    }
                    break;
                case 4:
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < elem.get(0).size(); i++) {
                        for (int j = 0; j < elem.size(); j++) {
                            sb.append(elem.get(j).get(i));
                            if (j != elem.size() - 1) {
                                sb.append(",");
                            }
                        }
                        sb.append("\n");
                    }
                    BufferedWriter bw = new BufferedWriter(new FileWriter("src/seven/seven/test.txt"));
                    bw.write(sb.toString());
                    bw.close();
                    System.exit(0);
                    break;
            }
        }
    }
}