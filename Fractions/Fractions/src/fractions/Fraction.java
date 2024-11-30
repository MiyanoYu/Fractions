/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fractions;

import java.util.Random;

/**
 *
 * @author ldesr5
 */
public class Fraction {

    private int numerator;
    private int denominator;
    final private int min = 1;
    final private int max = 10;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    public Fraction() {
        this(1, 1);
    }

    public void userInput(int num, int deno){
    this.setNumerator(num);
    this.setDenominator(deno);
    this.reduce();        
    }
    
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public static Fraction multiply(Fraction f1, Fraction f2) {
        Fraction product = new Fraction();
        product.setNumerator(f1.getNumerator() * f2.getNumerator());
        product.setDenominator(f1.getDenominator() * f2.getDenominator());
        product.reduce();
        return (product);
    }

    public static Fraction divide(Fraction f1, Fraction f2) {
        Fraction product = new Fraction();
        product.setNumerator(f1.getNumerator() * f2.getDenominator());
        product.setDenominator(f1.getDenominator() * f2.getNumerator());
        product.reduce();
        return (product);
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        Fraction product = new Fraction();
        product.setNumerator(f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator());
        product.setDenominator(f1.getDenominator() * f2.getDenominator());
        product.reduce();
        return (product);
    }

    public static Fraction subtract(Fraction f1, Fraction f2) {
        Fraction product = new Fraction();
        product.setNumerator(f1.getNumerator() * f2.getDenominator() - f2.getNumerator() * f1.getDenominator());
        product.setDenominator(f1.getDenominator() * f2.getDenominator());
        product.reduce();
        return (product);
    }

    public void multiply(Fraction f) {
        this.setNumerator(this.getNumerator() * f.getNumerator());
        this.setDenominator(this.getDenominator() * f.getDenominator());
        this.reduce();
    }

    // Logic error if divided by its self
    public void divide(Fraction f) {
        this.setNumerator(this.getNumerator() * f.getDenominator());
        this.setDenominator(this.getDenominator() * f.getNumerator());
        this.reduce();
    }

    public void add(Fraction f) {
        this.setNumerator(this.getNumerator() * f.getDenominator() + f.getNumerator() * this.getDenominator());
        this.setDenominator(this.getDenominator() * f.getDenominator());
        this.reduce();
    }

    public void subtract(Fraction f) {
        this.setNumerator(this.getNumerator() * f.getDenominator() - f.getNumerator() * this.getDenominator());
        this.setDenominator(this.getDenominator() * f.getDenominator());
        this.reduce();
    }

    public void reciprocal() {
        int num = this.getDenominator();
        int deno = this.getNumerator();
        this.setDenominator(deno);
        this.setNumerator(num);
        this.reduce();
    }

    public static Fraction reciprocal(Fraction f) {
        Fraction product = new Fraction();
        product.setNumerator(f.getDenominator());
        product.setDenominator(f.getNumerator());
        product.reduce();
        return (product);

    }

    private void reduce() {
        boolean stop = false;
        boolean isNeg = false;
        int num = this.getNumerator();
        int deno = this.getDenominator();
        int lower;

        if (num < 0 && deno < 0) {
            num = num * -1;
            deno = deno * -1;
        } else if (num < 0) {
            num = num * -1;
            isNeg = true;
        } else if (deno < 0) {
            deno = deno * -1;
            isNeg = true;
        }

        if (num >= deno) {
            lower = deno;
        } else {
            lower = num;
        }

        for (int c = lower; stop == false; c--) {

            if (num % c == 0 && deno % c == 0) {
                this.setDenominator(deno / c);

                if (isNeg) {
                    this.setNumerator((num / c) * -1);
                } else {
                    this.setNumerator(num / c);
                }

                break;

            }
        }
    }

    public double toDouble() {
        double product = (double) this.getNumerator() / (double) this.getDenominator();
        return (product);
    }

    public String toFraction() {
        return (this.getNumerator() + "/" + this.getDenominator());
    }

    @Override
    public String toString() {
        return ("The Numerator is: " + this.getNumerator() + " The Denominator is: " + this.getDenominator());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fraction) {
            Fraction f = (Fraction) o;
            if (this.getDenominator() == f.getDenominator() && this.getNumerator() == f.getNumerator()) {
                return (true);
            }
        }
        return (false);
    }
    
    public int compareTo(Fraction f) {
        if (this.toDouble() == f.toDouble()) {
            return (0);
        } else if (this.toDouble() - f.toDouble() > 0) {
            return (1);
        } else {
            return (-1);
        }
    }

    //https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
    public void random(){
    
        
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    int randomDeno = rand.nextInt((max - min) + 1) + min;
    
    this.setNumerator(randomNum);
    this.setDenominator(randomDeno);
    this.reduce();
    }
}
//- numerator: int
//- denominator: int
//+ Fraction()
//+ Fraction(int n, int d)
//+ getNumerator(): int
//+ getDenominator(): int
//+ setNumerator(int n): void
//+ setDenominator(int d): void

//+ multiply(Fraction f1, Fraction f2):  Fraction
//+ divide(Fraction f1, Fraction f2):  Fraction
//+ add(Fraction f1, Fraction f2):  Fraction
//+ subtract(Fraction f1, Fraction f2):  Fraction
//+ multiply(Fraction f): void
//+ divide(Fraction f): void
//+ add(Fraction f): void
//+ subtract(Fraction f): void
//+ reciprocal(): void
//+ reciprocal(Fraction f): Fraction
//- reduce(): void
//+ toDouble(): double
//+ toFraction(): String
//+ toString(): String
//+ equals(Object o): boolean
//+ compareTo(Fraction f): int

