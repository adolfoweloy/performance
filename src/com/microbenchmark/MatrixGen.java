package com.microbenchmark;

import java.util.Random;

public class MatrixGen {

  public static void main(String[] args) {
    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);

    Random random  = new Random();

    double[][] matrix = new double[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = random.nextDouble() * 10;
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(String.format("%.2f", matrix[i][j]) + " ");
      }
      System.out.println();
    }

  }
}
