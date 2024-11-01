package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountNumberOfPairs {
    @Test
    public void testCountNumberOfPairs() throws GeometryException {
        List<Rectangle> rectangleList = List.of(
                new Rectangle(5, 10),
                new Rectangle(5, 10),
                new Rectangle(3, 4),
                new Rectangle(3, 4),
                new Rectangle(6, 2)
        );

        int countOfPairs = Main.countNumbersOfPairs(rectangleList);

        Assertions.assertEquals(2, countOfPairs); // Две пары: (5x10) и (3x4)
    }

    @Test
    public void testNoPairs() throws GeometryException {
        List<Rectangle> rectangles = List.of(
                new Rectangle(5, 10),
                new Rectangle(3, 4),
                new Rectangle(6, 2)
        );

        int countPairs = Main.countNumbersOfPairs(rectangles);

        Assertions.assertEquals(0, countPairs); // Нет пар
    }@Test
    public void testOnePairs() throws GeometryException {
        List<Rectangle> rectangles = List.of(
                new Rectangle(5, 10),
                new Rectangle(5, 10),
                new Rectangle(6, 2)
        );

        int countPairs = Main.countNumbersOfPairs(rectangles);

        Assertions.assertEquals(1, countPairs); // Одна пара
    }
    @Test
    void testManyPairs() throws GeometryException {
        List<Rectangle> list = new ArrayList<>();
        Collections.addAll(list , new Rectangle(10,15)
                                , new Rectangle(12,21)
                                , new Rectangle(10,15)
                                , new Rectangle(15,10)
                                , new Rectangle(10,98)
                                , new Rectangle(10,98)
                                , new Rectangle(10,15));

        Assertions.assertEquals(7,Main.countNumbersOfPairs(list));
    }
}