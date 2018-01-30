package io.github.createam.testservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class TestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestServicesApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
