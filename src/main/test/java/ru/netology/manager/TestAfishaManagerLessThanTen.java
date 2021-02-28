package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

public class TestAfishaManagerLessThanTen {
    private AfishaManager manager = new AfishaManager();
    private MovieItem first = new MovieItem(1, "first");
    private MovieItem second = new MovieItem(2, "second");
    private MovieItem third = new MovieItem(3, "third");
    private MovieItem fourth = new MovieItem(4, "fourth");
    private MovieItem fifth = new MovieItem(5, "fifth");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void shouldGetAll() {

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveIfExistsLast() {
        int idToRemove = 5;
        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExistsFirst() {
        int idToRemove = 1;

        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExistsMiddle() {
        int idToRemove = 3;

        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{fifth, fourth, second, first};

        assertArrayEquals(expected, actual);
    }
}