package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggerInterceptor {
   private static final  Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);


   @AroundInvoke
   public void logger(InvocationContext invocationContext) {
       Object params = invocationContext.getParameters();
       logger.warn("Parameters passed: {}", params);
   }

}
