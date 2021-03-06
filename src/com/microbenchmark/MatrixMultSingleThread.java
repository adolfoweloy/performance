package com.microbenchmark;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * this is the single threaded version of matrix multiplication which
 * does not make a good CPU usage which in turn, makes the program to run about
 * twice lower than multi threaded version.
**/
public class MatrixMultSingleThread {
  public static void main(String[] args) {
    MatrixMultSingleThread mm = new MatrixMultSingleThread();

    List<Matrix> matrices = mm.loadMatrices();
    long start = System.currentTimeMillis();
    Matrix result = mm.multiply(
      matrices.get(0),
      matrices.get(1));
    long duration = System.currentTimeMillis() - start;
    System.out.println("elapsed time " + ((duration)/1000.0d) + " s");
  }

  public Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) {

    Matrix result = new Matrix(firstMatrix.rows, secondMatrix.cols);
    for (int i = 0; i < firstMatrix.rows; i++) {
      for (int j = 0; j < secondMatrix.cols; j++) {
        double sum = 0.0;
        for (int k = 0; k < secondMatrix.rows; k++) {
          sum += firstMatrix.get(i, k) * secondMatrix.get(k, j);
        }
        result.set(i, j, sum);
      }
    }

    return result;
  }

  private List<Matrix> loadMatrices() {
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
