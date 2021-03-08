package com.gsoft.aop;

public class ArithemeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {
        int resule=i+j;
        return resule;
    }

    @Override
    public int sub(int i, int j) {
        int resule=i-j;
        return resule;
    }

    @Override
    public int mul(int i, int j) {
        int resule=i*j;
        return resule;
    }

    @Override
    public int div(int i, int j) {
        int resule=i/j;
        return resule;
    }
}
