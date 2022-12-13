package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    void descendingCompareIsOk() {
        List<Item> list = Arrays.asList(new Item("sad"),
                new Item("getter"),
                new Item("zz"),
                new Item("qqq"),
                new Item("best"));
        list.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("zz"),
                new Item("sad"),
                new Item("qqq"),
                new Item("getter"),
                new Item("best"));
        assertThat(list).isEqualTo(expected);
    }
}