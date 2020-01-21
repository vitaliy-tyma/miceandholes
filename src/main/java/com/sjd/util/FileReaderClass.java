package com.sjd.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sjd.model.Task;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderClass {

    public List<Task> readTasksFromFile(String taskFileName) {

        List<Task> tasksList = new ArrayList<>();
        try {
            String jsonTasks = new String ( Files.readAllBytes( Paths.get(taskFileName) ) );

            Gson gson = new Gson();
            Type tasksListType = new TypeToken<List<Task>>()
                {}.getType();
            tasksList = gson.fromJson(jsonTasks, tasksListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasksList;
    }
}