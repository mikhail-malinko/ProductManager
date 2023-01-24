package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    @Test
    public void addingProducts() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "Чужак", 200, "Зингер");
        Book book2 = new Book(2, "Побег", 100, "Штель");
        Book book3 = new Book(3, "Побег из Шоушенка", 300, "Кинг");
        Smartphone smartphone1 = new Smartphone(4, "Samsung 1", 10_000, "Samsung");
        Smartphone smartphone2 = new Smartphone(5, "Samsung 2", 10_000, "Samsung");
        Smartphone smartphone3 = new Smartphone(6, "Xiaomi", 10_000, "Xiaomi");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void deletingABookByID() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "Чужак", 200, "Зингер");
        Book book2 = new Book(2, "Побег", 100, "Штель");
        Book book3 = new Book(3, "Побег из Шоушенка", 300, "Кинг");
        Smartphone smartphone1 = new Smartphone(4, "Samsung 1", 10_000, "Samsung");
        Smartphone smartphone2 = new Smartphone(5, "Samsung 2", 10_000, "Samsung");
        Smartphone smartphone3 = new Smartphone(6, "Xiaomi", 10_000, "Xiaomi");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.removeById(1);

        Product[] expected = {book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}