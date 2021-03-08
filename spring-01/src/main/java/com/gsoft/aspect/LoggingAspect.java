package com.gsoft.aspect;


        import org.aspectj.lang.annotation.Aspect;
        import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    public void beforeMethod(){
        System.out.println("the method begins");
    }
}
