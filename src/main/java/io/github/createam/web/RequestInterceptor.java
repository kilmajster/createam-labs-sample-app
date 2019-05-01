package io.github.createam.web;

import com.google.common.collect.Sets;
import io.github.createam.dao.WebRequestRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@Slf4j
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private final WebRequestRepository webRequestRepository;

    static Set<String> IGNORED_URIS_FRAGMENTS = Sets.newHashSet("springfox-swagger-ui", "swagger-resources");

    public RequestInterceptor(WebRequestRepository webRequestRepository) {
        this.webRequestRepository = webRequestRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if(notContainsIgnoredFragment(request.getRequestURI())) {

            WebRequest saved = webRequestRepository.save(WebRequest.from(request));

            log.info("Saved new request = {}", saved);
        }

        return true;
    }

    private boolean notContainsIgnoredFragment(String requestURI) {
        return IGNORED_URIS_FRAGMENTS
                .stream()
                .noneMatch(fragment -> StringUtils.contains(requestURI, fragment));
    }
}
