package com.microbenchmark;

public class MicrobenchFibonacci {
    private int nLoops;

    public static void main(String[] args) {
      MicrobenchFibonacci benchmark = new MicrobenchFibonacci(Integer.parseInt(args[0]));
      benchmark.doTest();
    }

    public MicrobenchFibonacci(int n) {
      nLoops = n;
    }

    /**
     * This first test presented the following data (fib(10) running 10x):
     * mean of elapsed times: 7035.70
     * median...............: 6874.50
     * standard deviation...: 371.75
     *
     * hardware
     *   Processor: 2.5 GHz Intel Core i5
     *   8 GB Mem. DDR 3
    **/
    public void doTest() {
      double l;
      long start = System.currentTimeMillis();
      for (int i = 0; i < nLoops; i++) {
        l = fibImpl(40);
      }
      long end = System.currentTimeMillis();
      System.out.println(String.format("Elapsed time in ms: %d", (end - start)));
    }

    private double fibImpl(int n) {
      if (n < 0) throw new IllegalArgumentException("Must be > 0");
      if (n == 0) return 0;
      if (n == 1) return 1;
      double d = fibImpl(n - 2) + fibImpl(n - 1);
      if (Double.isInfinite(d)) throw new ArithmeticException("Overflow");
      return d;
    }
}
