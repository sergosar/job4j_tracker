package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int k = 0; k < Math.min(left.length(), right.length()); k++) {
            if (left.charAt(k) != right.charAt(k)) {
                return Character.compare(left.charAt(k), right.charAt(k));
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}