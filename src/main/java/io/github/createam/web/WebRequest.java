package io.github.createam.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@ApiModel(value = "Web request", description = "Dummy DTO for testing.")
@Data
@Entity
public class WebRequest implements Serializable {

    @ApiModelProperty(value = "Generated identifier of given request", required = false, example = "1234-6789-abcd-efgh")
    @Id
    private String id;

    @CreatedDate
    private LocalDateTime created;

    @ApiModelProperty(value = "Request source host", required = false, example = "127.0.0.1 ")
    private String remoteHost;

    private String remoteAddr;

    private String remoteUser;

    private String requestUri;

    private String authType;

    private String serverName;


    @PrePersist
    public void prePersist() {
        if(StringUtils.isEmpty(this.id)) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public static WebRequest from(HttpServletRequest servletRequest) {
        WebRequest webRequest = new WebRequest();

        webRequest.setRemoteHost(servletRequest.getRemoteHost());
        webRequest.setRemoteAddr(servletRequest.getRemoteAddr());
        webRequest.setRemoteUser(servletRequest.getRemoteUser());
        webRequest.setRequestUri(servletRequest.getRequestURI());
        webRequest.setAuthType(servletRequest.getAuthType());
        webRequest.setServerName(servletRequest.getServerName());

        return webRequest;
    }

}