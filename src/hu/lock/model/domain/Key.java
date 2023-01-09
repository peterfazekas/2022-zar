package hu.lock.model.domain;

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
}
