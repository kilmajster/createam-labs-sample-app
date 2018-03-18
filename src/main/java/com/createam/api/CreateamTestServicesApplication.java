package com.createam.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class CreateamTestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateamTestServicesApplication.class, args);
	}

	@GetMapping("/")
	public String index(final ModelMap modelMap) {
		modelMap.addAttribute("message", "It works!");
		return "index";
	}
}
