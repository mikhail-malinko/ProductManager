package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book book1 = new Book(1, "Чужак", 200, "Зингер");
    Book book2 = new Book(2, "Побег", 100, "Штель");
    Book book3 = new Book(3, "Побег из Шоушенка", 300, "Кинг");
    Smartphone smartphone1 = new Smartphone(4, "Samsung 1", 10_000, "Samsung");
    Smartphone smartphone2 = new Smartphone(5, "Samsung 2", 10_000, "Samsung");
    Smartphone smartphone3 = new Smartphone(6, "Xiaomi", 10_000, "Xiaomi");

    @Test
    public void searchByNameWhenThereAreNoMatches() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameWhenOneMatch() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Samsung 1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameWhenMultipleMatch() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book2, book3};
        Product[] actual = manager.searchBy("Побег");

        Assertions.assertArrayEquals(expected, actual);
    }

}
