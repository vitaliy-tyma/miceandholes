package com.sjd.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Task {
    private List<Integer> Mice;
    private List<Integer> Holes;

    public Task(){
        Mice = new ArrayList<>();
        Holes = new ArrayList<>();
    }

    public List<Integer> getMice() {
        return Mice;
    }

    public List<Integer> getHoles() {
        return Holes;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Mice=" + Mice +
                ", Holes=" + Holes +
                '}';
    }
}
