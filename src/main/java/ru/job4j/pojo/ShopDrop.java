package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        if (index != products.length - 1) {
            for (int i = 0; i < products.length - index; i++) {
                products[index] = products[index + 1];
                index++;
            }
        } else {
            products[index] = null;
        }
        products[products.length - 1] = null;
        return products;
    }
}
