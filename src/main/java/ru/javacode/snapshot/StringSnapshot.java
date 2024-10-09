package ru.javacode.snapshot;

public class StringSnapshot {
    private final String state;

    public StringSnapshot(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}