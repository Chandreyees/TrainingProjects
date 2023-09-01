package com.consumer.controller;

import com.consumer.entity.Producer;
import com.consumer.repository.ConsumerRepository;
import com.consumer.service.ConsumerServiceImpl;
import com.consumer.service.ProducerServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableFeignClients
public class ConsumerController {

    @Autowired
    private ProducerServiceClient producerServiceClient;

    @Autowired
    private ConsumerServiceImpl consumerService;

    @GetMapping("/consumer")
    public List<Producer> getAll(){
        return consumerService.getProducers();
    }


}
