package com.fedor.homeworks.hw9.mailservice;

public class AbstractDespatch<T> implements Despatchable<T> {

    private String from;
    private String to;
    private T content;

    public AbstractDespatch(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContent() {
        return content;
    }
}
