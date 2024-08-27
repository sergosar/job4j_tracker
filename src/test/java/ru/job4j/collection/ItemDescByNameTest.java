package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void whenSortWithReverseOrder() {
        List<Item> items = new ArrayList<>
                (Arrays.asList(new Item("aaa"), new Item("bbb"), new Item("xxx"), new Item("ddd")));
        items.sort(new ItemDescByName());
        List<Item> expected = new ArrayList<>
                (Arrays.asList(new Item("xxx"), new Item("ddd"), new Item("bbb"), new Item("aaa")));
        assertThat(items).isEqualTo(expected);
    }
}