package com.coneill.rsa;

import java.math.BigInteger;
import java.util.List;

class App {

    public static void main(String[] args) throws NoSuchInverseException {
        System.out.println(expm(new BigInteger("33"), new BigInteger("27"), new BigInteger("17")));
    }

    /**
     * Practical 1: GCD
     * Calculates great common divisor of a & b
     * @param a
     * @param b
     * @return
     */

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
    }


    /**
     * Practical 2: XGCD
     * Extended Euclidean Algorithm
     * Solves the equation ax + by = gcd(a, b) for x
     * Note assumes gcd(a, mod) = 1
     * @param a
     * @param mod
     * @return
     */

    private static BigInteger[] xgcd(BigInteger a, BigInteger mod) {
        BigInteger x = a;
        BigInteger y = mod;
        BigInteger x0 = BigInteger.ONE;
        BigInteger x1 = BigInteger.ZERO;
        BigInteger y0 = BigInteger.ZERO;
        BigInteger y1 = BigInteger.ONE;
        BigInteger[] qrem;
        BigInteger[] result = new BigInteger[3]; // todo : I"m only interested in one of these aX

        while (true) {
            qrem = x.divideAndRemainder(y);
            x = qrem[1];
            x0 = x0.subtract(y0.multiply(qrem[0]));
            x1 = x1.subtract(y1.multiply(qrem[0]));

            if (x.equals(BigInteger.ZERO)) {
                result[0] = y;
                result[1] = y0;
                result[2] = y1;
                return result;
            }

            qrem = y.divideAndRemainder(x);
            y = qrem[1];
            y0 = y0.subtract(x0.multiply(qrem[0]));
            y1 = y1.subtract(x1.multiply(qrem[0]));

            if (y.equals(BigInteger.ZERO)) {
                result[0] = x;
                result[1] = x0;
                result[2] = x1;
                return result;
            }
        }
    }

    /**
     * Practical 3:
     * Calculates the multiplicative inverse of a mod n (if it exists)
     * @param a candidate
     * @param n modulus
     * @return
     * @throws NoSuchInverseException if a multiplicitive inverse doesn't exist in Zn for a
     */
    private static BigInteger invm(BigInteger a, BigInteger n) throws NoSuchInverseException {
        if (!gcd(a, n).equals(BigInteger.ONE)) {
            throw new NoSuchInverseException("A multiplicitive inverse does not exist for: " + a + " in Z" + n);
        }
        return xgcd(a, n)[1].mod(n);
    }

    /**
     * Practical 4:
     * Division mod n
     * Calculates a * pow(b, -1) (mod mod)
     * @param mod
     * @param a
     * @param b
     *
     */

    private static BigInteger divm(BigInteger mod, BigInteger a, BigInteger b) throws NoSuchInverseException {
        return a.multiply(invm(b, mod)).mod(mod);
    }

    /**
     * Practical 5:
     * Exponentiation modulo m
     * ST. expm(m,a,k) computes a(to the k) modulo m
     * (Square & Multiply Implementation)
     * @param mod modulus
     * @param a
     * @param k
     * @return result of the exponentiation
     */

    private static BigInteger expm(BigInteger mod, BigInteger a, BigInteger k ) {
        String exponentAsString = k.toString(2);
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < exponentAsString.length(); i++) {
            if (exponentAsString.charAt(i) == '1') {
                result = result.multiply(a).mod(mod);
            }
            a = a.multiply(a).mod(mod);
        }
        return result;
    }

    /**
     * Practical 6 :
     * factors (x) will return a list of integer values that are the factors of x.
     * Note : If a prime p has a power e > 0 in the factorization of x, then p should appear e times in the result
     * @param number number to be factored
     * @return factorization of number
     */
    private static List<BigInteger> factors(BigInteger number) {
        return null;
    }

    /**
     * Practical 7 :
     * The Euler Totient Function PHI(n) is defined as
     * the number of integers in the range [1,n] that are relatively prime to n
     * @param n
     * @return number of multiplicitive inverses in Zn
     */

    private static BigInteger phi(BigInteger n) {
        BigInteger count = BigInteger.ZERO;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) != 1; i = i.add(BigInteger.ONE)) {
            if (gcd(i, n).equals(BigInteger.ONE)) {
                count = count.add(BigInteger.ONE);
            }
        }
        return count;
    }
}
