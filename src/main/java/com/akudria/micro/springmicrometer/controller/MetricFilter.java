package com.akudria.micro.springmicrometer.controller;

import com.akudria.micro.springmicrometer.service.MicrometerService;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class MetricFilter implements Filter {
    private MicrometerService micrometerService;

    public MetricFilter(MicrometerService micrometerService) {
        this.micrometerService = micrometerService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);

        micrometerService.countRequest();
    }
}
