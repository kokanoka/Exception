package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product first = new Book(1, "Flowers for Algernon", 100, "D. Keyes");
    private Product second = new Book(2, "Jane Eyre", 200, "C. Brontë");
    private Product third = new TShirt(3, "black", 300, "Uniqlo");
    private Product fourth = new TShirt(4, "blue", 400, "Zara");

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    void shouldRemoveByExistId() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {second, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNotExist() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(22);
        });
    }
}