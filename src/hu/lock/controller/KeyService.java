package hu.lock.controller;

import hu.lock.model.domain.Key;
import hu.lock.model.service.RandomKeyUtil;

import java.util.List;
import java.util.stream.Collectors;

public class KeyService {

    private final List<Key> keys;

    public KeyService(List<Key> keys) {
        this.keys = keys;
    }

    /**
     * 3. feladat
     */
    public String getEqualKeyIds(String actualKey) {
        return keys.stream()
                .filter(i -> i.isEqual(actualKey))
                .map(Key::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    /**
     * 4. feladat
     */
    public String getSameDigitKeyId() {
        return keys.stream()
                .filter(i -> i.hasSameDigit())
                .map(i -> i.getId())
                .map(i -> String.valueOf(i))
                .findFirst()
                .orElse("nem volt ismétlődő számjegy");
    }

    /**
     * 5. feladat
     */
    public String getGeneratedKey(String actualKey) {
        int length = actualKey.length();
        String generatedKey = RandomKeyUtil.generateKey(length);
        return String.format("Egy %d hosszú kódszám: %s", length, generatedKey);
    }
}
