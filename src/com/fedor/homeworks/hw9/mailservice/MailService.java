package com.fedor.homeworks.hw9.mailservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Despatchable<T>> {
    private HashMap<String, List<T>> mailBox = new HashMap<String, List<T>>() {

        @Override
        public List<T> get(Object key) {
            if(this.containsKey(key)) {
                return super.get(key);
            }
            else
                return Collections.emptyList();
        }
    };

    public HashMap<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Despatchable<T> despatch) {
        List<T> tmp = mailBox.get(despatch.getTo());
        if (tmp.size() == 0) {
            tmp = new ArrayList<>();
            tmp.add(despatch.getContent());
            mailBox.put(despatch.getTo(), tmp);
        }
    }
}
