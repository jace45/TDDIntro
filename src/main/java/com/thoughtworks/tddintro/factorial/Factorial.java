package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        if (i < 0){
            throw new IllegalArgumentException();
        }
        int total = 1;
        for (int j = 1; j <= i; j++) {
            total *= j;
        }
        return total;

    }
}
