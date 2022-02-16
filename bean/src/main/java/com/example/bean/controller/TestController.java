package com.example.bean.controller;

import lombok.AllArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

   ProducerTemplate producerTemplate;

   @GetMapping("/badBean")
   public String badBean() {
      return producerTemplate.requestBody("direct:badBean", "camel in action", String.class);
   }

   @GetMapping("/goodBean")
   public String goodBean() {
      return producerTemplate.requestBody("direct:goodBean", "camel in action", String.class);
   }
}
