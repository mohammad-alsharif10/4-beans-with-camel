package com.example.bean.routes;

import com.example.bean.bean.HelloBean;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoodBeanExample extends RouteBuilder {

   private final HelloBean helloBean;

   public void configure() throws Exception {
      from("direct:goodBean")
              .bean(helloBean, "hello");
   }
}
