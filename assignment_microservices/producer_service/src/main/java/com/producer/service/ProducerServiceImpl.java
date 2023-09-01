package com.producer.service;

import com.producer.entity.Producer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService{

    //producerList
    public List<Producer> list=List.of(
            new Producer(1,"name1","data1"),
            new Producer(2,"name2","data2"),
            new Producer(3,"name3","data3"),
            new Producer(4,"name4","data4")
    );



    @Override
    public List<Producer> getProducer() {
        System.out.println(list);
        return this.list;
    }
}
