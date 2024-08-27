package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    public void whenSortWithNaturalOrder() {
        List<Item> items = new ArrayList<>
                (Arrays.asList(new Item("aaa"), new Item("bbb"), new Item("xxx"), new Item("ddd")));
        items.sort(new ItemAscByName());
        List<Item> expected = new ArrayList<>
                (Arrays.asList(new Item("aaa"), new Item("bbb"), new Item("ddd"), new Item("xxx")));
        assertThat(items).isEqualTo(expected);
    }
}