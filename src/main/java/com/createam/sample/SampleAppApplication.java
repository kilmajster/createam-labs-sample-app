package com.createam.sample;

import java.util.Date;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SampleAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(SampleAppApplication.class, args);
  }

  @GetMapping("/")
  public String displayGreeting(Map<String, Object> model) {
    model.put("message", "Hi, it works!");
    model.put("time", new Date());
    return "index";
  }
}
