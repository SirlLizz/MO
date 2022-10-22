package org.example;

import org.example.laba_1.Laba_1;

public class Main {
    public static void main(String[] args) {
        Laba_1 laba_1 = new Laba_1(-1, 2);
        laba_1.dichotomy(0.0001, 0.001);
        laba_1.goldenRatio(0.001);
        laba_1.fibonacci(15);
    }
}