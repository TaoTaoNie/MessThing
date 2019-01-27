/**
 * A class that represents a rational number.
 *
 * @author Charles Hoot
 * @version 4.0
 */

public class Rational {
    // PUT PRIVATE DATA FIELDS HERE
    private int numerator;
    private int denominator;

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational() {
        // ADD CODE TO THE CONSTRUCTOR
        numerator = 1;
        denominator = 1;
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     *
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */
    public Rational(int n, int d) {
        // ADD CODE TO THE ALTERNATE CONSTRUCTOR
        int c;
        if (d == 0)
            throw new ZeroDenominatorException("zero denominator");
        if (n == 0) {
            numerator = 0;
            denominator = 1;
        }
        if (n < 0 && d > 0) {
            c = gcd(-n, d);
        }
        else if (n > 0 && d < 0) {
            c = gcd(n, -d);
        }
        else if (n < 0 && d < 0) {
            c = gcd(-n, -d);
        }
        else {
            c = gcd(n, d);
        }
        numerator = n / c;
        denominator = d / c;
        normalize();
    }

    /**
     * Get the value of the Numerator
     *
     * @return the value of the numerator
     */
    public int getNumerator() {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return numerator;
    }

    /**
     * Get the value of the Denominator
     *
     * @return the value of the denominator
     */
    public int getDenominator() {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return denominator;
    }


    /**
     * Negate a rational number r
     *
     * @return a new rational number that is negation of this number -r
     */
    public Rational negate() {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return new Rational(-numerator, denominator);
    }


    /**
     * Invert a rational number r
     *
     * @return a new rational number that is 1/r.
     */
    public Rational invert() {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return new Rational(denominator, numerator);
    }


    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */
    public Rational add(Rational other) {
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
        int a = other.numerator;
        int b = other.denominator;
        int newNumerator = numerator * b + denominator * a;
        int newDenominator = denominator * b;
        return new Rational(newNumerator, newDenominator);
    }

    /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */
    public Rational subtract(Rational other) {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        int a = other.numerator;
        int b = other.denominator;
        int newNumerator = numerator * b - denominator * a;
        int newDenominator = denominator * b;
        return new Rational(newNumerator, newDenominator);
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */
    public Rational multiply(Rational other) {
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return new Rational(numerator * other.numerator, denominator * other.denominator);
    }


    /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */
    public Rational divide(Rational other) {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return new Rational(numerator * other.denominator, denominator * other.numerator);
    }


    /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * is negative.
     */
    private void normalize() {
        // ADD CODE TO NORMALIZE THE RATIONAL NUMBER
        if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        if (numerator > 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b) {
        int result = 0;
        if (a < b)
            result = gcd(b, a);
        else if (b == 0)
            result = a;
        else {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
}
