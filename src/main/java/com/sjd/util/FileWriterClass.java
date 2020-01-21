package com.sjd.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sjd.model.Task;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

//        Example for TaskSolver:
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
//        LocalDateTime now = LocalDateTime.now();
//        new FileWriterClass().WriteTasksToFile(dtf.format(now) + taskFileName);
public class FileWriterClass {

    public void WriteTasksToFile(String taskFileName) throws IOException {

        List<Task> tasksList = new Helper().getTasksList();

        try (Writer writer = new FileWriter(taskFileName)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            gson.toJson(tasksList, writer);
        }
    }
}
