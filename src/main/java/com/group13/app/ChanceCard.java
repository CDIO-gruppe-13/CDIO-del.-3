package com.group13.app;

public class ChanceCard {

    private String name;
    private String desctiption;
    private int value;
    private boolean stash;
    public final int index;

    public ChanceCard(String name, String description, int value, boolean stash, int index) {
        this.name = name;
        this.desctiption = description;
        this.value = value;
        this.stash = stash;
        this.index = index;
    }
    public String getDesctiption() {
        return desctiption;
    }
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
}