package org.frc2846.PrimeBenchtest;

public class Benchmark {

    int SIZE;
    int prime[];
    int numPrimes = 0;

    /** Construct a Benchmark object containing some primes. */
    public Benchmark(int size) {
        SIZE = size;
        prime = new int[SIZE];
        prime[numPrimes++] = 2;

        int n = 3;
        while (numPrimes < SIZE) {
            if (isPrime(n))  { prime[numPrimes++] = n; }
            n += 2;
        }
    }

    /** Determine if a number is prime. */
    public boolean isPrime(int n) {
        int i=0;
        while (i < numPrimes) {
             int p = prime[i]; 
             if (n == p) { return true; }
             if (n % p == 0) { return false; }
             if (p * p > n) { return true; }
            i += 1;
        }
        return true;
    }

    /** Count out the prime numbers. */
    public void test(int count) {
        long time = System.currentTimeMillis();
        int n = 2;
        while (count > 0) {
            n++;
            if (isPrime(n))  { count--; }
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Found prime number " + n 
                + " in " + time + " milliseconds");
    }

}
