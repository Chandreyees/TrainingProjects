package com.consumer.service;

import com.consumer.entity.Producer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "producer-service")
public interface ProducerServiceClient {

    @GetMapping(value = "/producer/")
    public List<Producer> getProducers();
}
