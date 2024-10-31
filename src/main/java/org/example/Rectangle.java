package org.example;

import java.util.Objects;

public class Rectangle {
    double width, length;

    public Rectangle(double width, double length) throws Exception {
        if (width <= 0 || length <= 0)
                throw new Exception("Отрицательный размер отрезка");
        this.width = width;
        this.length = length;
    }

    public double perimeter(){
        return 2*(width+length);
    }

    public double area(){
        return width*length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0 && Double.compare(length, rectangle.length) == 0
            ||  Double.compare(width, rectangle.length) == 0 && Double.compare(length, rectangle.width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }
}
