package io.github.createam.web;

import io.github.createam.dao.WebRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private final WebRequestRepository webRequestRepository;

    public RequestInterceptor(WebRequestRepository webRequestRepository) {
        this.webRequestRepository = webRequestRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        WebRequest saved = webRequestRepository.save(WebRequest.from(request));

        log.info("Saved new request = {}", saved);

        return true;
    }
}
