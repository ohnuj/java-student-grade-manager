package DTO;

import java.util.HashMap;

public class Student {
    private String name;
    private HashMap<String,Integer> scores;

    public Student(String name) {
        this.name = name;
        scores = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HashMap<String,Integer> getScore() {
        return scores;
    }
}
