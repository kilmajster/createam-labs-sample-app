package io.github.createam.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@Api(
        value = DummyResource.URL_DUMMY_CONTROLLER,
        description = "Just simply spring controller.",
        authorizations = @Authorization("Spring auth")
)@ApiModel(value = "test-1", description = "test-2")
@Slf4j
@RequestMapping(DummyResource.URL_DUMMY_CONTROLLER)
@RestController
public class DummyResource {

    static final String URL_DUMMY_CONTROLLER = "/api/dummy";

    @ApiOperation(
            value = "Produces dummy json",
            authorizations = @Authorization("Spring auth"),
            protocols = "https",
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = WebRequest.class
    )
    @GetMapping
    public @ResponseBody ResponseEntity<WebRequest> get(HttpServletRequest request) {
        log.info("Request from {}", request.getRequestURL().toString());

        WebRequest webRequest = WebRequest.from(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(webRequest);
    }
}
