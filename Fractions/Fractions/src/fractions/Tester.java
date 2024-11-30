/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fractions;

/**
 *
 * @author ldesr5
 */
public class Tester {

    // Just a simple tester class to see if it runs and it works.
    public static void test() {
        Fraction f1 = new Fraction(3, 2);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = Fraction.multiply(f1, f2);
        System.out.println(f3.getNumerator() + "/" + f3.getDenominator());
        f3 = Fraction.divide(f1, f2);
        System.out.println(f3.getNumerator() + "/" + f3.getDenominator());
        f3 = Fraction.add(f1, f2);
        System.out.println(f3.getNumerator() + "/" + f3.getDenominator());
        f3 = Fraction.subtract(f1, f2);
        System.out.println(f3.getNumerator() + "/" + f3.getDenominator());
        Fraction f4 = new Fraction(2, 2);
        Fraction f5 = new Fraction(2, 2);
        f4.divide(f5);
        System.out.println(f4.getNumerator() + "/" + f4.getDenominator());
        f4.add(f5);
        System.out.println(f4.getNumerator() + "/" + f4.getDenominator());
        f4.reciprocal();
        System.out.println(f4.getNumerator() + "/" + f4.getDenominator());
        System.out.println(f4.toDouble());
        System.out.println(f4.toFraction());
        System.out.println(f4.toString());
        System.out.print(f5.equals(f4));
    }

}
