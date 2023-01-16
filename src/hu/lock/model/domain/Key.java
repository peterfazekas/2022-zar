package hu.lock.model.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class Key {

    private final int id;
    private final String value;

    public Key(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public boolean isEqual(String otherValue) {
        return value.equals(otherValue);
    }

    public boolean hasSameDigit() {
        return getCharacterMap().values().stream()
                .anyMatch(i -> i > 1);
    }

    private Map<String, Long> getCharacterMap() {
        return value.chars()
                .mapToObj(String::valueOf)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }
}
