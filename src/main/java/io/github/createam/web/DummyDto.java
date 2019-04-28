package io.github.createam.web;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class DummyDto implements Serializable {

    private String id;

    @Pattern(regexp = "Y|N")
    private String body;

}
