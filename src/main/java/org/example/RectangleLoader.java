package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RectangleLoader {
    public static List<Rectangle> load(String fname) throws GeometryException, FileNotFoundException {
        List<Rectangle> rectangles = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(fname))){
           while (sc.hasNextLine()){
               String s = sc.nextLine();

//               String[] mas = s.split(" ");
//               double x = Double.parseDouble(mas[0]);
//               double y = Double.parseDouble(mas[1]);
               s = s.replace(".", ",");
               Scanner strscan = new Scanner(s);
               double x = strscan.nextDouble();
               double y = strscan.nextDouble();
               Rectangle r = new Rectangle(x, y);
               rectangles.add(r);
           }
        }
        return rectangles;
    }
}
