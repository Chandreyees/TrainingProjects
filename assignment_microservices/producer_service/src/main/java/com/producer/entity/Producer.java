package com.producer.entity;

public class Producer {

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
        return "Producer{" +
                "producerId=" + producerId +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
