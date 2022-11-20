package ru.job4j.pojo;

public class Shop {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Eggs", 12);
        products[1] = new Product("Milk", 10);
        products[2] = new Product("Chocolate", 100);
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getName());
            }
        }
    }

    public static int indexOfNull(Product[] products) {
        int index = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }
}
