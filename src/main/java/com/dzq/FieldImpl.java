package com.dzq;

public class FieldImpl implements Field{

    private long id;
    private String name;
    private String key;
    private int length;
    private String type;
    private Comparable value;

    public FieldImpl(String key, String type, Comparable value) {
        this.key = key;
        this.type = type;
        this.value = value;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public String type() {
        return this.type;
    }

    @Override
    public Comparable<? extends Comparable> defaultValue() {
        return null;
    }

    @Override
    public Comparable<? extends Comparable> value() {
        return value;
    }

    @Override
    public boolean nullable() {
        return false;
    }
}
