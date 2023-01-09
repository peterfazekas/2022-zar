package hu.lock.controller;

import hu.lock.model.domain.Key;

import java.util.List;

public class KeyService {

    private final List<Key> keys;

    public KeyService(List<Key> keys) {
        this.keys = keys;
    }
}
