package com.coneill.rsa;

import java.math.BigInteger;
import java.util.List;

public class App {

    public static void main(String[] args) {
        for(int i = 1; i < 8; i++) {
            System.out.println(phi(new BigInteger(Integer.toString(i))));
        }
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
     * @param a
     * @param b
     * @return
     */

    private static BigInteger xgcd(BigInteger a, BigInteger b){
        return null; // todo
    }

    /**
     * Practical 3:
     * Calculates the multiplicative inverse of a mod n
     * @param a
     * @param n
     * @return
     * @throws NoSuchInverseException
     */
    private static BigInteger invm(BigInteger a, BigInteger n) throws NoSuchInverseException {
        if (!gcd(a, n).equals(BigInteger.ONE)) {
            throw new NoSuchInverseException();
        }
        return null; // todo
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

    private static BigInteger divm(BigInteger mod, BigInteger a, BigInteger b) {
        return null; // todo
    }
//
//    /**
//     * Square & Multiply implementation of modular exponentiation
//     * @return
//     */
//
//    private static BigInteger expm(BigInteger mod, ) {
//        return null;
//    }
//
//    private static BigInteger modularExponentiation(String modulus, int exponent, byte [] password){
//        BigInteger result = BigInteger.ONE;
//        BigInteger mod = new BigInteger(modulus,16);
//        BigInteger pw = new BigInteger(password);
//        String exponentBinRep = Integer.toBinaryString(exponent);
//
//        for(int i = 0; i < exponentBinRep.length(); i++){
//            if(exponentBinRep.charAt(i) == '1'){
//                result = result.multiply(pw).mod(mod);
//            }
//            pw = pw.multiply(pw).mod(mod);
//        }
//        return result;
//    }
//
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
