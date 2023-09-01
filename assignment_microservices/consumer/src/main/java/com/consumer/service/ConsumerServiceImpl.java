package com.consumer.service;

import com.consumer.entity.Producer;
import com.consumer.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsumerServiceImpl {

    @Autowired
    private ProducerServiceClient producerServiceClient;
    @Autowired
    private ConsumerRepository consumerRepository;

    public List<Producer> getProducers(){
        List<Producer> producerList=producerServiceClient.getProducers();
        for(int i=0;i<producerList.size();i++){
            Producer producer= producerList.get(i);
            System.out.println("Hello"+producer);
            consumerRepository.save(producer);
        }

        return producerList;
    }



}
