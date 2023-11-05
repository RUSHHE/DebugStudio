package one.two;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("What is your name?");
        String name = scan.next();
        System.out.print("How old are you?");
        int age = scan.nextInt();

        System.out.println("Hello " + name + ". Next year, you will be " + (age + 1) + " years old.");
    }
}
