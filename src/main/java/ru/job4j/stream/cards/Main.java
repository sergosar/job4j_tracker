package ru.job4j.stream.cards;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Card> cards = Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(v -> new Card(s, v)))
                .collect(Collectors.toList());
        cards.forEach(System.out::println);
    }
}
