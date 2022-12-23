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
        int customersCount = 0;
        String name = null;
        for (Customer customer : queue) {
            customersCount++;
            if (customersCount == count) {
                name = customer.name();
                break;
            }
        }
        return name;
    }

    public String getLastUpsetCustomer() {
        int customersCount = 0;
        String name = null;
        for (Customer customer : queue) {
            customersCount++;
            if (customersCount > count) {
                name = customer.name();
                break;
            }
        }
        return name;
    }
}
