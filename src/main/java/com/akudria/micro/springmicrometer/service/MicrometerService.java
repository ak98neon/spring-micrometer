package com.akudria.micro.springmicrometer.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Measurement;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MicrometerService {
    private SimpleMeterRegistry meterRegistry;
    private static final String REQUEST_COUNT = "request.count";

    public MicrometerService(SimpleMeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        Counter.builder(REQUEST_COUNT)
                .register(meterRegistry);
    }

    public void countRequest() {
        meterRegistry.counter(REQUEST_COUNT).increment();
    }

    public Iterable<Measurement> getNumberOfRequests() {
        return meterRegistry.counter(REQUEST_COUNT).measure();
    }
}
