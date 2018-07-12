package com.microbenchmark;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * This is an example of how making higher CPU usage can be better regarding
 * the optimization of a simple program. When running this code, consider running
 * tools/cpustat.py (and do not forget to change the number of cores of your machine).
 * On my machine the elapsed time to compute the matrix multplication was executed on
 * half the time regarding the MatrixMultSingleThread version. And 4 cores came to run
 * between 95 to 99 %.
**/
public class MatrixMultMultiThread implements Runnable {
  private int firstRow;
  private int lastRow;

  private static List<Matrix> matrices;
  private static Matrix result;
  private static List<Thread> threads = new ArrayList<>();

  public static void main(String[] args) {
    matrices = MatrixMultMultiThread.loadMatrices();
    result = new Matrix(matrices.get(0).rows, matrices.get(1).cols);

    int numberOfRows = matrices.get(0).rows;
    int numberOfThreads = 4; // the number of cores of my machine (considering virtual cores)

    int size = numberOfRows / numberOfThreads;
    int offset = size;

    long start = System.currentTimeMillis();
    for (int i = 0; i < numberOfThreads; i++) {
      Thread t = new Thread(new MatrixMultMultiThread(i * size, offset));
      threads.add(t);
      t.start();
      offset += size;
    }

    threads.forEach(t -> {
      try {
          t.join();
      } catch (InterruptedException e) {}
    });
    long duration = System.currentTimeMillis()-start;
    System.out.println("elapsed time " + ((duration)/1000.0d) + " s");
  }

  public MatrixMultMultiThread(int firstRow, int lastRow) {
    this.firstRow = firstRow;
    this.lastRow = lastRow;
  }

  @Override
  public void run() {
      Matrix firstMatrix = matrices.get(0);
      Matrix secondMatrix = matrices.get(1);

      for (int i = firstRow; i < lastRow; i++) {
        for (int j = 0; j < secondMatrix.cols; j++) {
          double sum = 0.0;
          for (int k = 0; k < secondMatrix.rows; k++) {
            sum += firstMatrix.get(i, k) * secondMatrix.get(k, j);
          }
          result.set(i, j, sum);
        }
      }
  }

  private static List<Matrix> loadMatrices() {
    List<Matrix> matrices = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    int rows = sc.nextInt();
    int cols = sc.nextInt();
    Matrix firstMatrix = new Matrix(rows, cols);

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        firstMatrix.set(i, j, sc.nextDouble());
      }
    }

    rows = sc.nextInt();
    cols = sc.nextInt();
    Matrix secondMatrix = new Matrix(rows, cols);

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        secondMatrix.set(i, j, sc.nextDouble());
      }
    }

    matrices.add(firstMatrix);
    matrices.add(secondMatrix);

    sc.close();

    return matrices;
  }

  public static class Matrix {
    int rows;
    int cols;
    private double[][] matrix;

    public Matrix(int rows, int cols) {
      this.rows = rows;
      this.cols = cols;
      matrix = new double[rows][cols];
    }

    public void set(int row, int col, double value) {
      matrix[row][col] = value;
    }

    public double get(int row, int col) {
      return matrix[row][col];
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          sb.append(String.format("%.2f", matrix[i][j])).append(" ");
        }
        sb.append("\n");
      }
      return sb.toString();
    }
  }

}
