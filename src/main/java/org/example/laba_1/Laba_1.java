package org.example.laba_1;

public class Laba_1 {

    private final double a;
    private final double b;

    public Laba_1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void dichotomy(double eps, double delta){
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

    public void goldenRatio(double delta){
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

    public void fibonacci(int n){
        System.out.println("Fibonacci:\n");
        double xLeft = a;
        double xRight = b;
        double xNearLeft = a + (b - a)*((double)getFibonacciNumber(n-2)/getFibonacciNumber(n));
        double xNearRight = a + (b - a)*((double)getFibonacciNumber(n-1)/getFibonacciNumber(n));
        System.out.println("Left: \t" + xLeft + "\tNear Left: \t"+ xNearLeft + " \tNear Right: \t" + xNearRight  + " \tRight: \t" + xRight );
        do{
            if(myFunction(xNearLeft)> myFunction(xNearRight)){
                xLeft = xNearLeft;
                xNearLeft = xNearRight;
                xNearRight = xRight - (xNearLeft - xLeft);
            }else{
                xRight = xNearRight;
                xNearRight = xNearLeft;
                xNearLeft = xLeft + (xRight - xNearRight);
            }
            System.out.println("Left: \t" + xLeft + "\tNear Left: \t"+ xNearLeft + " \tNear Right: \t" + xNearRight  + " \tRight: \t" + xRight );
            n--;
        }while(n>1);
        System.out.println("Min: " + (xLeft + xRight) / 2);
    }

    private double myFunction(double x){
        return Math.sinh(2 * x) * Math.sinh(2 * x);
    }

    private int getFibonacciNumber(int n){
        if(n<=2){
            return 1;
        }else{
            int previousNum = 1;
            int nowNum = 1;
            for (int i = 0; i<n-2;i++){
                int tmp = nowNum;
                nowNum +=previousNum;
                previousNum = tmp;
            }
            return nowNum;
        }
    }
}
