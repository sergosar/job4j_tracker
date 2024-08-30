package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int len1 = left.length();
        int len2 = right.length();
        int lim = Math.min(len1, len2);
        for (int k = 0; k < lim; k++) {
            if (left.charAt(k) != right.charAt(k)) {
                return Integer.compare(left.charAt(k), right.charAt(k));
            }
        }
        return len1 - len2;
    }
}