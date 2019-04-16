package com.fedor.homeworks.hw9.mailservice;

interface Despatchable<T> {

    String getFrom();
    String getTo();
    T getContent();
}
