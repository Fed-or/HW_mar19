package com.fedor.homeworks.hw9.mailservice;

public class MailMessage extends AbstractDespatch<String> {

    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}
