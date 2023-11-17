package four.three;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ComplexNumber cn1 = new ComplexNumber(scan.nextInt(), scan.nextInt());
        ComplexNumber cn2 = new ComplexNumber(scan.nextInt(), scan.nextInt());
        ComplexNumber cn3;

        cn3 = new ComplexNumber(cn1);
        cn3.complexAdd(cn2);
        System.out.println(cn3);

        cn3 = new ComplexNumber(cn1);
        cn3.complexMinus(cn2);
        System.out.println(cn3);

        cn3 = new ComplexNumber(cn1);
        cn3.complexMulti(cn2);
        System.out.println(cn3);
    }
}

class ComplexNumber {
    public double realPart;

    public double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber(ComplexNumber complexNumber) {
        this.realPart = complexNumber.realPart;
        this.imaginaryPart = complexNumber.imaginaryPart;
    }

    public void complexAdd(ComplexNumber complexNumber) {
        realPart += complexNumber.realPart;
        imaginaryPart += complexNumber.imaginaryPart;
    }


    public void complexMinus(ComplexNumber complexNumber) {
        realPart -= complexNumber.realPart;
        imaginaryPart -= complexNumber.imaginaryPart;
    }

    public void complexMulti(ComplexNumber complexNumber) {
        double tempRealPart = realPart; // 对象属性在下一步操作会被改变
        realPart *= complexNumber.realPart;
        realPart -= imaginaryPart * complexNumber.imaginaryPart;

        imaginaryPart *= complexNumber.realPart;
        imaginaryPart += tempRealPart * complexNumber.imaginaryPart;
    }

    @Override
    public String toString() {
        return realPart + "+" + imaginaryPart + "i";
    }
}
