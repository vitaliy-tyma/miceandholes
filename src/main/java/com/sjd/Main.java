package com.sjd;

import com.sjd.task.TaskSolver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private final static String loggingProperties = "logging.properties";
    private static String taskFileName = "tasks.list"; //Default name of the file with tasks - arguments are used also

    public static void main(String[] args) throws InterruptedException {

        if (args.length > 0) {
            taskFileName = args[0];
        }


        System.setProperty("java.util.logging.config.file", loggingProperties);
        Logger logger = Logger.getLogger(Main.class.getName());

        logger.log(Level.INFO, String.format("************************* %s **********************", "Mice and holes task STARTED"));

        new TaskSolver().startTaskSolving(taskFileName);

        logger.log(Level.INFO, String.format("************************* %s **********************", "Mice and holes task STOPPED"));
    }
}
