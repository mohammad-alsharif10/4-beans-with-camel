package com.example.bean.routes;

import com.example.bean.bean.HelloBean;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class BadBeanExample extends RouteBuilder {

   // this is an example of how not to use beans with camel
   @Override
   public void configure() throws Exception {
      from("direct:badBean").process(exchange -> {
         // extract the name parameter from the Camel message which we want to use
         // when invoking the bean
         String name = exchange.getIn().getBody(String.class);

         // now create an instance of the bean
         HelloBean hello = new HelloBean();
         // and invoke it with the name parameter
         String answer = hello.hello(name);

         // store the reply from the bean on the OUT message
         exchange.getIn().setBody(answer);
      });
   }
}
