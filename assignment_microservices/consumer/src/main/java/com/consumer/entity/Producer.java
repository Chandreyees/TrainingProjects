package com.consumer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producer {

    @Id
    private long producerId;
    private String name;
    private String data;

    public Producer() {
    }

    public Producer(long producerId, String name, String data) {
        this.producerId = producerId;
        this.name = name;
        this.data = data;
    }

    public long getProducerId() {
        return producerId;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public void setProducerId(long producerId) {
        this.producerId = producerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "producerId=" + producerId +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
