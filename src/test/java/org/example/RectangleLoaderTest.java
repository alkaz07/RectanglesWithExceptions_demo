package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangleLoaderTest {

    @Test
    void loadOk1() throws Exception {
        String s = "src/test/resources/ok1.txt";
        List<Rectangle> actual = RectangleLoader.load(s);
        List<Rectangle> expected = new ArrayList<>();
        expected.add(new Rectangle(4, 3.5));
        Assertions.assertIterableEquals(expected, actual);
    }
    @Test
    void loadOk2() throws Exception {
        String s = "src/test/resources/ok2.txt";
        List<Rectangle> actual = RectangleLoader.load(s);
        List<Rectangle> expected = new ArrayList<>();
        expected.add(new Rectangle(4, 3));//4 3
        expected.add(new Rectangle(6, 9));
        expected.add(new Rectangle(17, 18));
        expected.add(new Rectangle(25, 25));
        Assertions.assertIterableEquals(expected, actual);
    }
    @Test
    void loadOk0() throws Exception {
        String s = "src/test/resources/ok0.txt";
        List<Rectangle> actual = RectangleLoader.load(s);
        List<Rectangle> expected = new ArrayList<>();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void loadBad0(){
        String s = "src/test/resources/abracadabra";
        Assertions.assertThrows(FileNotFoundException.class, ()-> RectangleLoader.load(s));
    }

    @Test
    void loadBad1(){
        String s = "src/test/resources/bad1.txt";
        Assertions.assertThrows(Exception.class, ()-> RectangleLoader.load(s));
    }

    @Test
    void loadBad2(){
        String s = "src/test/resources/bad2.txt";
        Assertions.assertThrows(InputMismatchException.class, ()-> RectangleLoader.load(s));
    }

    @Test
    void loadBad3() throws IOException {
        //Подготовить файлы и вообще окружение
        String s = "src/test/resources/bad3.txt";
        FileWriter fileWriter = new FileWriter(s);
        fileWriter.write("10 -1");
        fileWriter.close();
        //Выполняем проверку
        Assertions.assertThrows(NegativeLengthException.class, ()-> RectangleLoader.load(s));
        //Важно!!! подчистить за собой, удалить файл
        Files.delete(Path.of(s));
    }

    @Test
    void loadBad4() throws IOException {
        //Подготовить файлы и вообще окружение
        String s = "src/test/resources/bad4.txt";
        FileWriter fileWriter = new FileWriter(s);
        fileWriter.write("0 1");
        fileWriter.close();
        //Выполняем проверку
        Assertions.assertThrows(ZeroLengthException.class, ()-> RectangleLoader.load(s));
        //Важно!!! подчистить за собой, удалить файл
        Files.delete(Path.of(s));
    }

    @BeforeAll
    static void setupOkManySpaces() throws IOException {
        //Подготовить файлы и вообще окружение
        String s = "src/test/resources/ok3.txt";
        FileWriter fileWriter = new FileWriter(s);
        fileWriter.write("2 1\n");
        fileWriter.write("1  2\n");
        fileWriter.write("1         2\n");
        fileWriter.write("  3    4    \n");
        fileWriter.close();
    }

    @AfterAll
    static void tearDownManySpaces() throws IOException {
        //Важно!!! подчистить за собой, удалить файл
        Files.delete(Path.of("src/test/resources/ok3.txt"));
    }

    @Test
    void loadOkManySpaces1() throws IOException, GeometryException {
        String s = "src/test/resources/ok3.txt";
        //Выполняем проверку
        Assertions.assertDoesNotThrow( ()-> RectangleLoader.load(s));
    }
    @Test
    void loadOkManySpaces2() throws IOException, GeometryException {
        String s = "src/test/resources/ok3.txt";
        //Заготовка ожидаемого результата
        List<Rectangle> expected = new ArrayList<>(4);
        expected.add(new Rectangle(2, 1));
        expected.add(new Rectangle(1, 2));
        expected.add(new Rectangle(1, 2));
        expected.add(new Rectangle(3, 4));
        //Выполняем проверку
        Assertions.assertIterableEquals(expected, RectangleLoader.load(s));
    }
}