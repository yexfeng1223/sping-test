package com.gsoft.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithemeticCalculatorLoggingProxy {

    private  ArithmeticCalculator target;
    private  ClassLoader loader;
    private  Class[] interfaces;

    public ArithemeticCalculatorLoggingProxy(ArithmeticCalculator target){
        this.target=target;
         this.loader=target.getClass().getClassLoader();
        this.interfaces=new Class[]{ArithmeticCalculator.class};
    }


    public  ArithmeticCalculator getLoggiongProxy(){
        ArithmeticCalculator proxy=null;


        InvocationHandler invocationHandler= new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName=method.getName();
                System.out.println("teh method is "+methodName+" begin with "+ Arrays.asList(args));
                Object result=method.invoke(target,args);
                System.out.println("teh method is "+methodName+" end with "+ result);
                return result;
            }
        };

        proxy= (ArithmeticCalculator) Proxy.newProxyInstance(loader,interfaces,invocationHandler);

        return proxy;
    }
}
