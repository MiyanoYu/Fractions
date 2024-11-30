package fractions;
public class TesterClass
{
	public static void test()
	{		
		Fraction f1 = new Fraction(1, 5);
		Fraction f2 = new Fraction(3, 5);
		
//		Fraction f1 = new Fraction(3, 8);
//		Fraction f2 = new Fraction(1, 4);
		
		System.out.println("Are there any logic errors in your Fraction class???\n");
		
		System.out.println("Let's begin with the fractions:");
		System.out.println("f1 = " + f1.toFraction() + " or " + f1.toDouble());
		System.out.println("f2 = " + f2.toFraction() + " or " + f2.toDouble() + "\n");
		
		System.out.println(f1.toFraction() + " + " + f2.toFraction() + " = " + Fraction.add(f1, f2).toFraction());
		System.out.println(f1.toFraction() + " - " + f2.toFraction() + " = " + Fraction.subtract(f1, f2).toFraction());
		System.out.println(f1.toFraction() + " x " + f2.toFraction() + " = " + Fraction.multiply(f1, f2).toFraction());
		System.out.println(f1.toFraction() + " / " + f2.toFraction() + " = " + Fraction.divide(f1, f2).toFraction());
		
		System.out.println("\nLet's make sure that the original fractions have not been changed:");
		System.out.println("f1 = " + f1.toFraction() + " or " + f1.toDouble());
		System.out.println("f2 = " + f2.toFraction() + " or " + f2.toDouble() + "\n\n\n");
		
		System.out.println("Let's change f1 so that it is now its reciprocal");
		System.out.println("and let's change the numerator of f2 to 13 and try our calculations again:\n");
		
		f1.reciprocal();
		f2.setNumerator(13);
		
		System.out.println("The two original fractions are now:");
		System.out.println("f1 = " + f1.toFraction() + " or " + f1.toDouble());
		System.out.println("f2 = " + f2.toFraction() + " or " + f2.toDouble() + "\n");
		
		System.out.println(f1.toFraction() + " + " + f2.toFraction() + " = " + Fraction.add(f1, f2).toFraction());
		System.out.println(f1.toFraction() + " - " + f2.toFraction() + " = " + Fraction.subtract(f1, f2).toFraction());
		System.out.println(f1.toFraction() + " x " + f2.toFraction() + " = " + Fraction.multiply(f1, f2).toFraction());
		System.out.println(f1.toFraction() + " / " + f2.toFraction() + " = " + Fraction.divide(f1, f2).toFraction());
		
		System.out.println("\nLet's make sure that the original fractions have not been changed:");
		System.out.println("f1 = " + f1.toFraction() + " or " + f1.toDouble());
		System.out.println("f2 = " + f2.toFraction() + " or " + f2.toDouble() + "\n");
		
		System.out.println("I suppose we should also check for equality:");
		if(f1.equals(f2))
			System.out.println("The fractions are equal.\n");
		else
			System.out.println("The fractions are not equal.\n");
	}
}