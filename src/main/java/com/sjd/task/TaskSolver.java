package com.sjd.task;

import com.sjd.model.Task;
import com.sjd.util.FileReaderClass;

import java.util.*;
import java.util.logging.Logger;

public class TaskSolver {
private final static Logger logger = Logger.getLogger(TaskSolver.class.getName());

    public void startTaskSolving(String taskFileName) {


        logger.info("*********************** SOLVER WORKS ******************");

        //get tasks from file
        List<Task> tasks = new FileReaderClass().readTasksFromFile(taskFileName);
        logger.info("All tasks = " + tasks.toString());

        //solve 1 by 1
        for (Task task : tasks){
            solveTask(task);
        }
    }

    private void solveTask(Task task) {
        logger.info("Task = " + task.toString());

        NavigableMap<Integer, Boolean> holesMap = new TreeMap<>();
        for (Integer hole : task.getHoles()){
            holesMap.put(hole, Boolean.FALSE);
        }

        Map<Integer, Integer> miceMap = new LinkedHashMap<>();
        for (Integer mouse : task.getMice()){
            holesMap.put(mouse, null);
        }


        for (Integer currentMouse : miceMap.keySet())
        {
            Integer ceilingKey = holesMap.ceilingKey(currentMouse); // greater or equal
            if (ceilingKey != null) {
                Integer diffToCeiling = ceilingKey - currentMouse;
            }

            Integer floorKey = holesMap.floorKey(currentMouse); //less or equal
            if (floorKey != null) {
                Integer diffToFloor = currentMouse - floorKey;
            }

            if (diff <= 0) {
                //select lower

            } else {
                //select higher

            }


        }

        //TODO print results to the log
    }
}
