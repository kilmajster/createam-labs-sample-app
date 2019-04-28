package io.github.createam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public RedirectView redirectToSwaggerUi(HttpServletRequest request) {

        log.info("Request from {}", request.getRequestURL());

        log.info("request.getRequestURL() {}", request.getRequestURL());
        log.info("request.getRemoteHost() {}", request.getRemoteHost());
        log.info("request.getRemoteAddr() {}", request.getRemoteAddr());
        log.info("request.getRemoteUser() {}", request.getRemoteUser());
        log.info("request.getRequestURI() {}", request.getRequestURI());
        log.info("request.getAuthType() {}", request.getAuthType());
        log.info("request.getServerName() {}", request.getServerName());

        return new RedirectView("/swagger-ui.html");
    }
}
