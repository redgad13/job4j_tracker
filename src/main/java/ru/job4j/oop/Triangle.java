package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public double semiPerimeter(double ab, double bc, double ac) {
        return (ab + bc + ac) / 2;
    }

    public boolean exist(double a, double b, double c) {
        return (a + b > c && a + c > b && b + c > a);
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double bc = second.distance(third);
        double ac = third.distance(first);
        if (this.exist(ab, bc, ac)) {
            double p = semiPerimeter(ab, bc, ac);
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
