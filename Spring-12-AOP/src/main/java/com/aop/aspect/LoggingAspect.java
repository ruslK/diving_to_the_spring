package com.aop.aspect;

import com.aop.controller.ProductController;
import com.aop.entiry.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

//    logger.info("Before -> Controller:{} - Method:{} - Input Parameter :{}", "ProductController", "getProducts()");
//logger.info("After -> Controller:{} - Method:{} - Output Parameters:{}", "ProductController", "getProducts", products.toString());


//    @Pointcut("execution(* com.aop.controller.ProductController.*(..))")
//    public void pointcut() {};
//
//    @Before("pointcut()")
//    public void log() {
//        logger.info("----------------");
//    }
//
//    @After("pointcut()")
//    public void logAfter() {
//        logger.info("----------------");
//    }
//
//    @Before("execution(* com.aop.controller.ProductController.*(..))")
//    public void beforeAdvise() {
//        logger.info("----------------");
//    }

    // execution
    @Pointcut("execution(* com.aop.controller.ProductController.up*(..))")
    public void pointcut1() {}

    @Pointcut("execution(* com.aop.repository.ProductRepository.findById(Long))")
    public void pointcut2() {}

    @Before("pointcut1()")
    public void adviseBeforePointCut1(JoinPoint joinPoint) {
        logger.info("Before -> Method:{} - Arguments:{} - Target:{}",
                joinPoint, joinPoint.getArgs(),joinPoint.getTarget());
    }

    @Before("pointcut2()")
    public void adviseBeforePointCut2(JoinPoint joinPoint) {
        logger.info("Before(findById) -> Method:{} - Arguments:{} - Target:{}",
                joinPoint, joinPoint.getArgs(),joinPoint.getTarget());
    }


    @Pointcut("within(com.aop.controller..*)")
    public void anyControllerOperation() {}

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void anyServiceAnnotatedOperation() {}


    @Before("anyServiceAnnotatedOperation() || anyControllerOperation()")
    public void beforeControllerOrServices(JoinPoint joinPoint) {
        logger.info("Before(combined) -> Method:{} - Arguments:{} - Target:{}",
                joinPoint, joinPoint.getArgs(),joinPoint.getTarget());
    }


    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void anyDeleteMethodPointCut() {}

    @Before("anyDeleteMethodPointCut()")
    public void beforeAnyDeleteMethodPointCut(JoinPoint joinPoint) {
        logger.info("Before(delete) -> Method:{} - Arguments:{} - Target:{}",
                joinPoint, joinPoint.getArgs(),joinPoint.getTarget());
    }


    //after returning
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetProductOperation(){}

    @AfterReturning(pointcut = "anyGetProductOperation()",returning = "results")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, ResponseEntity<Product> results){
        logger.info("After Returning(Mono Result) -> Method : {} - results :{}",joinPoint.getSignature().toShortString(),results);
    }

    @AfterReturning(pointcut = "anyGetProductOperation()",returning = "results")
    public void afterReturningControllerAdvice2(JoinPoint joinPoint, ResponseEntity<List<Product>> results){
        logger.info("After Returning(List Result) -> Method : {} - results :{}",joinPoint.getSignature().toShortString(),results);
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation(){}

    @AfterThrowing(pointcut = "anyGetPutProductOperation()", throwing = "exception")
    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception) {
        logger.warn("After Throwing (Send email to L2 Team -> Method:{} - Exception:{}",
                joinPoint.getSignature().toShortString(), exception.getMessage());
    }

    @After("anyGetPutProductOperation()")
    public void afterControllerAdvice(JoinPoint joinPoint) {
        logger.warn("After (Finally) -> Method:{} - Results:{}",
                joinPoint.getSignature().toLongString(), joinPoint.getTarget().toString());
    }


}
