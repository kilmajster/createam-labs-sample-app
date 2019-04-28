package io.github.createam.web;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;


@Api(value = DummyResource.URL_DUMMY_CONTROLLER, description = "Dummy resource.", authorizations = @Authorization("Spring auth"))
@Slf4j
@RequestMapping(DummyResource.URL_DUMMY_CONTROLLER)
@RestController
public class DummyResource {

    static final String URL_DUMMY_CONTROLLER = "/api/dummy";

    @ApiOperation(
            value = "Produces dummy json",
            authorizations = @Authorization("Spring auth"),
            protocols = "https",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @GetMapping
    public ResponseEntity<String> get(HttpServletRequest request) {
        log.info("Request from {}", request.getRequestURL().toString());

        return ResponseEntity.ok("{\"requestFrom\":\"" + request.getRequestURL().toString() + "\"}");
    }

    @ApiOperation(
            value = "Dummy post operation",
            authorizations = @Authorization("Spring auth"),
            protocols = "https",
            consumes = "DummyDto",
            response = DummyDto.class)
    @ApiResponses({
            @ApiResponse(code = 200, response = DummyDto.class, message = "aaaa aaa aa"),
            @ApiResponse(code = 200, response = DummyDto.class, message = "bbbb bbb bbb "),
            @ApiResponse(code = 200, response = DummyDto.class, message = "cc ccc ccc ccc")
    })
    @PostMapping
    public ResponseEntity<DummyDto> post(@RequestBody @Valid DummyDto dummy) {
        dummy.setId(UUID.randomUUID().toString());

        log.info("Created dummy object = {}", dummy);

        return ResponseEntity.ok(dummy);
    }
}
