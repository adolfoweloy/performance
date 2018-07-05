package com.microbenchmark;

public class MicrobenchFibonacci {
    private int nLoops;
    private volatile double l;

    public static void main(String[] args) {
      int outerLoop = Integer.parseInt(args[0]);
      MicrobenchFibonacci benchmark = new MicrobenchFibonacci(50);
      for (int i=0; i<outerLoop; i++)
        benchmark.doTest();
    }

    public MicrobenchFibonacci(int n) {
      nLoops = n;
    }

    public void doTest() {
      long start = System.currentTimeMillis();
      for (int i = 0; i < nLoops; i++) {
        fibImpl(30);
      }
      long end = System.currentTimeMillis();
      System.out.println(String.format("Elapsed time in ms: %d", (end - start)));
    }

    // trying a recursive approach
    private double fibImpl(int n) {
      if (n < 0) throw new IllegalArgumentException("Must be > 0");
      if (n == 0) return 0;
      if (n == 1) return 1;
      double d = fibImpl(n - 2) + fibImpl(n - 1);
      if (Double.isInfinite(d)) throw new ArithmeticException("Overflow");
      return d;
    }

    // trying iterative approach
    private double fibImplIt(int n) {
      if (n < 0) throw new IllegalArgumentException("Must be > 0");
      if (n == 0) return 0;
      if (n == 1) return 1;
      double[] fib = new double[n];
      fib[0] = 1;
      fib[1] = 1;
      for (int i=2; i<n; i++) {
        fib[i] = fib[i-1] + fib[i-2];
      }
      if (Double.isInfinite(fib[n-1])) throw new ArithmeticException("Overflow");
      return fib[n-1];
    }

}
