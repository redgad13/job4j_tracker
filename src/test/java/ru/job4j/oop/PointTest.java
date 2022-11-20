package ru.job4j.oop;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void whenx1is0y1is0x2is2y2is2then2dot82() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 2);
        double out = point1.distance(point2);
        double expected = 2.82;
        assertThat(out).isCloseTo(expected, Offset.offset(0.01));
    }

    @Test
    void whenx1is33y1is41x2is15y2is6then39dot35() {
        Point point1 = new Point(33, 41);
        Point point2 = new Point(15, 6);
        double out = point1.distance(point2);
        double expected = 39.35;
        assertThat(out).isCloseTo(expected, Offset.offset(0.01));
    }

    @Test
    void whenx1is0y1is0z1is3x2is3y2is3z2is9then7dot34() {
        Point point1 = new Point(0,0,3);
        Point point2 = new Point(3,3,9);
        double out = point1.distance3d(point2);
        double expected = 7.34;
        assertThat(out).isEqualTo(expected, Offset.offset(0.01));
    }

    @Test
    void whenx1is10y1is6z1is54x2isminus9y2is13z2is9then49dot34() {
        Point point1 = new Point(10,6,54);
        Point point2 = new Point(-9,13,9);
        double out = point1.distance3d(point2);
        double expected = 49.34;
        assertThat(out).isEqualTo(expected, Offset.offset(0.01));
    }

    @Test
    void whenx1is10y1is6z1is54x2is9y2is13z2is9then45dot55() {
        Point point1 = new Point(10,6,54);
        Point point2 = new Point(9,13,9);
        double out = point1.distance3d(point2);
        double expected = 45.55;
        assertThat(out).isEqualTo(expected, Offset.offset(0.01));
    }
}