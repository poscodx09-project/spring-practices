package aop.aspect;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Before("execution(public aop.domain.Product aop.service.ProductService.find(String))")
    public void adviceBefore(){
        System.out.println("-- Before Advice --");
    }

    @After("execution(public aop.domain.Product aop.service.ProductService.find(String))")
    public void adviceAfter(){
        System.out.println("-- After Advice --");
    }

    @AfterReturning("execution(public aop.domain.Product aop.service.ProductService.find(..))")
    public void adviceAfterReturning(){
        System.out.println("-- AfterReturning Advice --");
    }

    @AfterThrowing(value ="execution(public aop.domain.Product aop.service.ProductService.find(..))",throwing = "ex")
    public void adviceAfterThrowing(Throwable ex){
        System.out.println("-- AfterThrowing[" + ex.getMessage() +"] Advice --");
    }
}
