/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numericintegration;

import core.IFunction;
import core.IFunction1Variable;
import java.util.Random;

/**
 *
 * @author adiel
 */
public class Montecarlo {

    public static void main(String[] args) {
        IFunction1Variable f = new IFunction1Variable() {
            @Override
            public double eval(double x) {
                return Math.cos(x);
            }
        };

        double start = 0.5;
        double end = 1; //Math.PI;
        double result = doMonteCarlo(f, start, end);

        System.out.println("Result: " + result);
    }

    private static double doMonteCarlo(IFunction1Variable f, double start, double end) {
        double mm = -1;
        for (double i = start; i < end; i += 0.001) {
            mm = Double.max(mm, f.eval(i));
        }
        mm += 0.2;
        int times = 1000000;
        int cont = 0;
        Random rnd = new Random();
        for (int i = 0; i < times; i++) {
            double y = mm * rnd.nextDouble();
            double x = start + (end - start) * rnd.nextDouble();
            if (f.eval(x) >= y) {
                cont++;
            }
        }
        return (double) cont / times * (end - start) * mm;

    }
}
