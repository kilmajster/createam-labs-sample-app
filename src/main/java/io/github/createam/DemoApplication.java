package io.github.createam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@SpringBootApplication
@Controller
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public RedirectView redirectToSwaggerUi(RedirectAttributes attributes, HttpServletRequest request) {

        log.info("Redirecting from {}, to {}", request.getRequestURL(), request.getRemoteAddr());

        return new RedirectView("/swagger-ui.html");
    }
}
