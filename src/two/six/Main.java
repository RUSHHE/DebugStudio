package two.six;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(toFirstUpperCase(scan.nextLine()));
    }

    private static String toFirstUpperCase(String str){
        char[] stringArr = str.toCharArray();
        for (int i = 0; i < stringArr.length; i++) {
            if (i + 1 < stringArr.length && !Character.isLetter(stringArr[i])) {
                stringArr[i + 1] = Character.toUpperCase(stringArr[i + 1]);
            } else if (i == 0 && Character.isLowerCase(stringArr[0])) {
                stringArr[0] = Character.toUpperCase(stringArr[0]);
            }
        }
        return String.valueOf(stringArr);
    }
}