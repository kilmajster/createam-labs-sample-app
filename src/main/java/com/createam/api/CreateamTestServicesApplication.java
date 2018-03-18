package com.createam.api;


import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

@Controller
@SpringBootApplication
public class CreateamTestServicesApplication {

	private static final System.Logger LOGGER =
			System.LoggerFinder.getLoggerFinder()
					.getLogger("CreateamTestServicesApplicationLogger", CreateamTestServicesApplication.class.getModule());

	public static void main(String[] args) {
		SpringApplication.run(CreateamTestServicesApplication.class, args);
	}

	@GetMapping("/")
	public String index(final ModelMap modelMap) throws URISyntaxException, IOException, InterruptedException {
		modelMap.addAttribute("message", "It works!");
		modelMap.addAttribute("processInfo", ProcessHandle.current().info().toString());

		Stream.of(1,2,3,4,5,6,7,8,9,10)
				.takeWhile(i -> i < 5 )
				.forEach(modelMap::addAttribute);



//
//
//		modelMap.addAttribute("httpResponse", response.body());
		modelMap.addAttribute("actuator", httpGet("https://createam-labs.herokuapp.com/actuator/"));
		modelMap.addAttribute("health", httpGet("https://createam-labs.herokuapp.com/actuator/health"));
		modelMap.addAttribute("info", httpGet("https://createam-labs.herokuapp.com/actuator/info"));

		return "index";
	}

	private String httpGet(final String addr) throws IOException, InterruptedException, URISyntaxException {
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(new URI( addr))
				.version(HttpClient.Version.HTTP_2)
				.GET()
				.build();

		HttpResponse<String> response = HttpClient
				.newBuilder()
				.proxy(ProxySelector.getDefault())
				.build()
				.send(httpRequest, HttpResponse.BodyHandler.asString());
		return response.body();
	}
}
