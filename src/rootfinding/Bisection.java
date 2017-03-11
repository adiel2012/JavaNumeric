/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rootfinding;

import core.IFunction1Variable;

/**
 *
 * @author adiel
 */
public class Bisection {
    public static void main(String[] args){
        double start = -20;
        double end = 20;
        double error = 0.0001;
        IFunction1Variable f = new IFunction1Variable() {
            @Override
            public double eval(double x) {
                 return 1.0/(1+Math.exp(-x+5.65))  -0.5;  // moved si
            }
        };
        double result = doBisection(start, end, f, error);
        System.out.println("The root is located at: "+result+" where f("+result+")="+f.eval(result));
        
    }

    private static double doBisection(double start, double end, IFunction1Variable f, double error) {
        double curr_error = Math.abs( Math.min(f.eval(start), f.eval(end)));
        
        double temp = 0;
        while(curr_error > error){
            temp = (start+end)/2;
            if(f.eval(temp)>0){end = temp;}else{start = temp;}
            curr_error = Math.abs( Math.min(f.eval(start), f.eval(end)));
            System.out.println("start: "+start+" end: "+end);
        }
        
        return Math.abs(f.eval(start)) < Math.abs(f.eval(end))? start:end;
    }
    
    
}
