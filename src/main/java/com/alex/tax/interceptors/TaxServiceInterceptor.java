package com.alex.tax.interceptors;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Enumeration;
import java.lang.StringBuffer;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.util.Collections;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import org.springframework.stereotype.Component;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TaxServiceInterceptor implements HandlerInterceptor {
    long startTime;
    long endTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        startTime = System.nanoTime();
        System.out.println("Pre Handle method request :\n " + getRawHeaders(request));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        endTime = System.nanoTime();

        System.out.println("Post Handle method response :\n " + getRawHeaders(response) + ". Execution time (ms) = "
                + (endTime - startTime) / 1000000);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception exception) throws Exception {

        System.out.println("Request and Response is completed  response :\n " + getRawHeaders(response));
    }

    public String getRawHeaders(HttpServletRequest request) {
        StringBuffer rawHeaders = new StringBuffer();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            rawHeaders.append(key).append(":").append(value).append("\n");
        }
        rawHeaders.append("URI").append(":").append(request.getRequestURI());
        return rawHeaders.toString();
    }

    public String getRawHeaders(HttpServletResponse response) {
        StringBuffer rawHeaders = new StringBuffer();
        Enumeration headerNames = Collections.enumeration(response.getHeaderNames());
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = response.getHeader(key);
            rawHeaders.append(key).append(":").append(value).append("\n");
        }

        return rawHeaders.toString();
    }

}