package com.microbenchmark;

import java.util.Random;

/**
 * This microbenchmark is based on thoughts explained on
 * Java Performance - The definitive guide book and some source code
 * being tested came from "Beyond Java blog". The following URL must be referenced
 * to see the original source code:
 *
 * https://www.beyondjava.net/a-close-look-at-javas-jit-dont-waste-your-time-on-local-optimizations
 *
**/
public class MicrobenchSimpleMath {
    private volatile int l; // avoid some improvements by JIT
    private int[] input;
    private Random random;

    public MicrobenchSimpleMath(int n) {
        input = new int[n];
        random = new Random();
        // preparing random values to test later
        for (int i=0; i<n; i++) {
            input[i] = random.nextInt(10000);
        }
    }

    public static void main(String[] args) {
        int problemSize = 2000;
        MicrobenchSimpleMath p = new MicrobenchSimpleMath(problemSize);

        int nLoops = Integer.parseInt(args[0]);

        // warm up
        for (int i=1;i<=nLoops;i++)
          p.testPerformance();

        // starting the test
        for (int outer=1; outer<=nLoops; outer++) {
            long start = System.nanoTime();
            p.testPerformance();
            long duration = System.nanoTime()-start;
            System.out.println("Loop # " + outer + " took " + ((duration)/1000.0d) + " µs");
        }
    }

    private void testPerformance() {
        long sum = 0;
        for (int i = 1; i < input.length; i++) {
            // using the value returned by benchmarked function
            l = random(input[i]+1);
        }
    }

    private static int random(int i) {
        int x = (int)(i*2.3d/2.7d); // This is a simulation
        int y = (int)(i*2.36d);     // of time-consuming
        return x%y;                 // business logic.
    }
}
