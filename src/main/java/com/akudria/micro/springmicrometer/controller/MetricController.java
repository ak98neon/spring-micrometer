package com.akudria.micro.springmicrometer.controller;

import com.akudria.micro.springmicrometer.service.MicrometerService;
import io.micrometer.core.instrument.Measurement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requestMetrics")
public class MetricController {
    private MicrometerService micrometerService;

    public MetricController(MicrometerService micrometerService) {
        this.micrometerService = micrometerService;
    }

    @GetMapping
    public Iterable<Measurement> getNumberOfRequests() {
        return micrometerService.getNumberOfRequests();
    }
}
