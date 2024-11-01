package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public static double getTotalArea(List<Rectangle> rectangles) {
        double totalArea = 0;
        for (Rectangle rectangle : rectangles) {
            totalArea = totalArea+ rectangle.area();
        }
        return totalArea;
    }


    public static int calcEqualRect(List<Rectangle> list) {
        HashSet<Rectangle> hs = new HashSet<>(list);
        HashMap<Rectangle, Integer> hm = new HashMap<>();
        for (Rectangle rec : hs) {
            int count = Collections.frequency(list, rec);
            hm.put(rec, count);
        }
        int countOfPairs = 0;
        for (Map.Entry<Rectangle, Integer> entry : hm.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                countOfPairs = countOfPairs + entry.getValue() / 2;
            } else countOfPairs = countOfPairs + (entry.getValue() - 1) / 2;
        }


        return countOfPairs;
    }

    public static int countNumbersOfPairs(List<Rectangle> rectangleList) {
        Map<Rectangle, Integer> countMap = new HashMap<>();


        for (Rectangle rex : rectangleList) {

            countMap.put( rex, countMap.getOrDefault(rex, 0) + 1);
        }

        int countPairs = 0;

        for (int count : countMap.values()) {
            countPairs += count / 2;
        }

        return countPairs;
    }

    public static int countEqualRectPairs(List<Rectangle> rectangleList) {
        int count=0;
        for (int i = 0; i < rectangleList.size(); i++) {
            Rectangle iRec = rectangleList.get(i);
            for (int j = i+1; j < rectangleList.size(); j++) {
                if(rectangleList.get(j).equals(iRec))
                    count++;
            }
        }
        return count;
    }
}