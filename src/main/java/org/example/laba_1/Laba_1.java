package org.example.laba_1;

public class Laba_1 {

    private final double eps;
    private final double delta;
    private final double a;
    private final double b;

    public Laba_1(double eps, double delta, double a, double b) {
        this.eps = eps;
        this.delta = delta;
        this.a = a;
        this.b = b;
    }

    public void dichotomy(){
        System.out.println("Dichotomy:\n");
        int counter = 0;
        double xLeft = a;
        double xRight = b;
        System.out.println("Left: \t" + xLeft + " \tRight: \t" + xRight);
        do{
            double xLeftNew = (xLeft + xRight - eps) / 2;
            double xRightNew = (xLeft + xRight + eps) / 2;
            if(myFunction(xLeftNew)> myFunction(xRightNew)){
                xLeft = xLeftNew;
            }else{
                xRight = xRightNew;
            }
            System.out.println("Left: \t" + xLeft + " \tRight: \t" + xRight);
            counter+=2;
        }while((xRight - xLeft) > (2 * delta));
        System.out.println("Min: " + (xLeft + xRight) / 2);
        System.out.println("Iteration: " + counter + "\n");
    }

    public void goldenRatio(){
        System.out.println("Golden Ratio:\n");
        double xLeft = a;
        double xRight = b;
        double xNearLeft = xRight - (xRight - xLeft) / 1.618;
        double xNearRight = xLeft + (xRight - xLeft) / 1.618;
        int counter = 2;
        System.out.println("Left: \t" + xLeft + "\tNear Left: \t"+ xNearLeft + " \tNear Right: \t" + xNearRight  + " \tRight: \t" + xRight );
        do{
            if(myFunction(xLeft) > myFunction(xRight)){
                xLeft = xNearLeft;
                xNearLeft = xNearRight;
                xNearRight = xLeft + (xRight - xLeft) / 1.618;
            }else{
                xRight = xNearRight;
                xNearRight = xNearLeft;
                xNearLeft = xRight - (xRight - xLeft) / 1.618;
            }
            System.out.println("Left: \t" + xLeft + "\tNear Left: \t" + xNearLeft + " \tNear Right: \t" + xNearRight + " \tRight: \t" + xRight );
            counter+=1;
        }while((xRight - xLeft) > delta);
        System.out.println("Min: " + (xLeft + xRight) / 2);
        System.out.println("Iteration: " + counter + "\n");
    }


    private double myFunction(double x){
        return Math.sinh(2 * x) * Math.sinh(2 * x);
    }
}
