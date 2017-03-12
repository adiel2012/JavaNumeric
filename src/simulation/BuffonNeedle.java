/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.util.Random;

/**
 *
 * @author adiel
 */
public class BuffonNeedle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int A = 0;
        int N = 1000000;
        int cantidad_franjas = 1000;

        double t = 3;
        double l = 2;
        Random rnd = new Random();
        //double y = 1;
        for (int i = 0; i < N; i++) {
            double x = rnd.nextDouble() * cantidad_franjas * t;            
            double angle = rnd.nextDouble()*Math.PI*2;            
            double seno = Math.sin(angle) ;
            double x2 = x + seno*l;
            if ((((int) (x / t))) != ((int) (x2 / t))) {
                A++;
            }
        }
        System.out.println("The Pi value is: "+(2.0*N*l/(A*t)));
        
    }

}
