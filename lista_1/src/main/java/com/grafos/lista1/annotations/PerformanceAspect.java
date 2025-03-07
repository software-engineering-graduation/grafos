package com.grafos.lista1.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PerformanceAspect {
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";

    @Around("@annotation(performance)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint, Performance performance) throws Throwable {
        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        long endTime = System.nanoTime();
        
        String description = performance.description().isEmpty() ? 
            joinPoint.getSignature().getName() : performance.description();
            
        System.out.println(ANSI_YELLOW + 
            String.format("Performance [%s]: %.3f ms", 
                description, (endTime - startTime) / 1_000_000.0) + 
            ANSI_RESET);
            
        return result;
    }
}
