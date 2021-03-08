package com.gsoft.aop;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator target=new ArithemeticCalculatorImpl();
        ArithmeticCalculator proxy=new ArithemeticCalculatorLoggingProxy(target).getLoggiongProxy();

        int result=proxy.add(1,2);
        System.out.println("--->result:"+result);
          result=proxy.sub(5,3);
        System.out.println("--->result:"+result);
          result=proxy.mul(4,2);
        System.out.println("--->result:"+result);

        result=proxy.div(4,2);
        System.out.println("--->result:"+result);

    }
}
