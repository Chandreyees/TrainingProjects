package com.producer.controller;

import com.producer.entity.Producer;
import com.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/")
    public List<Producer> getProducer(){
        List<Producer> producerList=this.producerService.getProducer();
        return producerList;
    }
}
