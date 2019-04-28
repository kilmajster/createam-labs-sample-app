package io.github.createam.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.util.UUID;

@Api(value = "Dummy resource API documentation.",
        authorizations = @Authorization("This resource needs authentication."),
        protocols = "https",
        basePath = "/api/dummy"
)
@Slf4j
@RequestMapping(DummyController.URL_DUMMY_CONTROLLER)
@RestController
public class DummyController {


    static final String URL_DUMMY_CONTROLLER = "/api/dummy";

    @GetMapping
    public ResponseEntity<String> get(HttpServletRequest request) {
        log.info("Request from {}", request.getRequestURL().toString());

        return ResponseEntity.ok("{\"requestFrom\":\"" + request.getRequestURL().toString() + "\"}");
    }

    @SneakyThrows
    @GetMapping("/1")
    public void test1() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/2")
    public void test2() {
        throw new RuntimeException();
    }

    @SneakyThrows
    @GetMapping("/3")
    public void test3() {
        throw new AccessDeniedException("Not allowed \uD83D\uDD95\uD83C\uDFFB");
    }

    @ApiOperation("Dummy post operation")
    @PostMapping
    public ResponseEntity<DummyDto> post(@RequestBody @Valid DummyDto dummy) {
        dummy.setId(UUID.randomUUID().toString());

        log.info("Created dummy object = {}", dummy);

        return ResponseEntity.ok(dummy);
    }
}
