package com.example.bean.bean;

import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.apache.camel.Header;
import org.apache.camel.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HelloBean {

   Logger logger = LoggerFactory.getLogger(HelloBean.class);

   @Handler
   public String hello(@Body String name, @Headers Map<Object,Object>headers) {
      logger.info("Invoking HelloBean with {}", name);
      logger.info("Invoking HelloBean with headers {}", headers);
      return "Hello " + name;
   }
}
