package com.example.bean.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloBean {

   Logger logger = LoggerFactory.getLogger(HelloBean.class);

   public String hello(String name) {
      logger.info("Invoking HelloBean with {}", name);
      return "Hello " + name;
   }
}
