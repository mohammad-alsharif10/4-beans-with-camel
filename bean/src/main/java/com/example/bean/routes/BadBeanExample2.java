package com.example.bean.routes;

import com.example.bean.bean.HelloBean;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BadBeanExample2 extends RouteBuilder {
    // this is an example of how not to use beans with camel

    private final HelloBean helloBean;

    @Override
    public void configure() throws Exception {
        from("direct:badBean2").process(exchange -> {
            // extract the name parameter from the Camel message which we want to use
            // when invoking the bean
            String name = exchange.getIn().getBody(String.class);

            // and invoke it with the name parameter
            String answer = helloBean.hello(name, null);

            // store the reply from the bean on the OUT message
            exchange.getIn().setBody(answer);
        });
    }
}
