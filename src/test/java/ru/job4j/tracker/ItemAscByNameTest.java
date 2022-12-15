package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void ascendingCompareIsOk() {
        List<Item> list = Arrays.asList(new Item("sad"),
                new Item("getter"),
                new Item("zz"),
                new Item("qqq"),
                new Item("best"));
        list.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("best"),
                new Item("getter"),
                new Item("qqq"),
                new Item("sad"),
                new Item("zz"));
        assertThat(list).isEqualTo(expected);
    }

}