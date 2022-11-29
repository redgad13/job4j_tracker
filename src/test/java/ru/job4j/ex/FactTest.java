package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class FactTest {

    @Test
    void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Fact().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }

    @Test
    void whenN10NoException() {
        int n = 10;
        int out = new Fact().calc(n);
        int expected = 3_628_800;
        assertThat(out).isEqualTo(expected);
    }

    @Test
    void whenN5NoException() {
        int n = 5;
        int out = new Fact().calc(n);
        int expected = 120;
        assertThat(out).isEqualTo(expected);
    }
}