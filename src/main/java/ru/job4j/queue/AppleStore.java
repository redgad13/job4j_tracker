package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String clientName = null;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.poll().amount() >= count) {
                clientName = queue.poll().name();
            }
        }
        return clientName;
    }

    public String getLastUpsetCustomer() {
        return "";
    }
}
