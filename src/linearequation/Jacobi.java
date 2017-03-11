/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearequation;

import java.util.Random;

/**
 *
 * @author adiel
 */
public class Jacobi {

    public static void main(String[] args) {
        double[][] A = {{2,1},{5,7}};
        double[] b = {11,13};
        double[] xs = doJacobi(A, b);
        System.out.println("Solution");
        for (double x : xs) {
            System.out.print(x + " ");
        }
    }

    private static double[] doJacobi(double[][] A, double[] b) {
        int n = A.length;
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = 1;
        }
        double t = 0;
        int ITERATION_LIMIT = 10000;
        for (int it = 0 ;it < ITERATION_LIMIT; it++) {
            double[] x_p = x.clone();
            for (int i = 0; i < n; i++) {
                t = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        t +=  A[i][j]*x_p[j]; 
                    }
                }
                x[i] = (b[i]-t)/A[i][i];
            }
        }
        return x;
    }


}
