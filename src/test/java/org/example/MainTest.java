package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void areaSum1() throws GeometryException, FileNotFoundException {
        List<Rectangle> rectanglelist = RectangleLoader.load("src/test/resources/ok2.txt");
        Assertions.assertEquals(997, Main.getTotalArea(rectanglelist));
    }

    @Test
    void areaSum2() throws GeometryException, FileNotFoundException {
        List<Rectangle> rectanglelist = new ArrayList<>();
        rectanglelist.add(new Rectangle(2, 3));
        Assertions.assertEquals(6, Main.getTotalArea(rectanglelist));
    }
    @Test
    void calcEqualRect() throws GeometryException {
        List<Rectangle> list = new ArrayList<>();
        Collections.addAll(list , new Rectangle(10,15)
                                , new Rectangle(12,21)
                                , new Rectangle(10,15)
                                , new Rectangle(15,10)
                                , new Rectangle(10,98)
                                , new Rectangle(10,98)
                                , new Rectangle(10,15));

        Assertions.assertEquals(7,Main.calcEqualRect(list));
    }

    @Test
    void testCountUnqueRectangles1() throws GeometryException {
        ArrayList<Rectangle> arr = new ArrayList<>();
        arr.add(new Rectangle(3, 4));
        arr.add(new Rectangle(3, 4));
        Assertions.assertEquals(1, Main.countUniqueRectangles(arr));
    }

    @Test
    void testCountUnqueRectangles2() throws GeometryException {
        ArrayList<Rectangle> arr = new ArrayList<>();
        arr.add(new Rectangle(3, 4));
        arr.add(new Rectangle(4, 4));
        arr.add(new Rectangle(3, 4));
        Assertions.assertEquals(2, Main.countUniqueRectangles(arr));
    }

    @Test
    void testCountUnqueRectangles3() throws GeometryException {
        ArrayList<Rectangle> arr = new ArrayList<>();
        arr.add(new Rectangle(3, 4));
        arr.add(new Rectangle(4, 4));
        arr.add(new Rectangle(4, 3));
        Assertions.assertEquals(2, Main.countUniqueRectangles(arr));
    }
}