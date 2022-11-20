package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book0 = new Book("Java for dummies", 100);
        Book book1 = new Book("Clean Code", 200);
        Book book2 = new Book("Head First Java", 100);
        Book book3 = new Book("Algorithms", 1000);
        Book[] books = new Book[4];
        books[0] = book0;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book " + books[i].getTitle() + " has " + books[i].getPages() + " pages");
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book " + books[i].getTitle() + " has " + books[i].getPages() + " pages");
        }
        System.out.println();
        for (Book b : books
        ) {
            if (b.getTitle().equals("Clean Code")) {
                System.out.println("Book " + b.getTitle() + " has " + b.getPages() + " pages");
            }
        }
    }
}
