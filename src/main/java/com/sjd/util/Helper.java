package com.sjd.util;

import com.sjd.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public List<Task> getTasksList() {

        List<Task> tasks = new ArrayList<>();

        Task task1 = new Task();
        task1.getMice().add(1);
        task1.getMice().add(2);
        task1.getMice().add(3);

        task1.getHoles().add(5);
        task1.getHoles().add(6);
        task1.getHoles().add(7);

        Task task2 = new Task();
        task2.getMice().add(11);
        task2.getMice().add(2);
        task2.getMice().add(34);

        task2.getHoles().add(-5);
        task2.getHoles().add(65);
        task2.getHoles().add(78);

        tasks.add(task1);
        tasks.add(task2);

        return tasks;
    }
}