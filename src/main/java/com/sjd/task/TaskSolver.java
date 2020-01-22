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
        logger.info("*************************************************************** " + task.toString());

        NavigableMap<Integer, Boolean> holesMap = new TreeMap<>();
        for (Integer hole : task.getHoles()){
            holesMap.put(hole, Boolean.FALSE);
        }

        Map<Integer, Integer> miceMap = new LinkedHashMap<>();
        for (Integer mouse : task.getMice()){
            miceMap.put(mouse, null);
        }


        for (Integer currentMouse : miceMap.keySet())
        {
            Integer diffToCeiling = null;
            Integer diffToFloor = null;

            Boolean isCeilingExists = Boolean.FALSE;
            Boolean isFloorExists = Boolean.FALSE;

            Boolean takeCeiling = Boolean.FALSE;
            Boolean takeFloor = Boolean.FALSE;
            Boolean noSolution = Boolean.FALSE;


            Integer ceilingKey = holesMap.ceilingKey(currentMouse); // greater or equal
            if (ceilingKey != null) {
                diffToCeiling = ceilingKey - currentMouse;
                isCeilingExists = Boolean.TRUE;
            }

            Integer floorKey = holesMap.floorKey(currentMouse); //less or equal
            if (floorKey != null) {
                diffToFloor = currentMouse - floorKey;
                isFloorExists = Boolean.TRUE;
            }

            if (isCeilingExists & isFloorExists) {
                  if (diffToCeiling < diffToFloor){
                      //select lower
                      takeCeiling = Boolean.FALSE;
                      takeFloor = Boolean.TRUE;
                  } else {
                      //select higher
                      takeCeiling = Boolean.TRUE;
                      takeFloor = Boolean.FALSE;
                 }
            } else if (isCeilingExists) {
                //select higher
                takeCeiling = Boolean.TRUE;
                takeFloor = Boolean.FALSE;
            } else if (isFloorExists) {
                //select lower
                takeCeiling = Boolean.FALSE;
                takeFloor = Boolean.TRUE;
            } else {
                noSolution = Boolean.TRUE;
            }

            if (!noSolution & takeCeiling) {
                miceMap.put(currentMouse, ceilingKey);
                holesMap.remove(ceilingKey);
            } else if (!noSolution & takeFloor) {
                miceMap.put(currentMouse, floorKey);
                holesMap.remove(floorKey);
            } else if (noSolution) {
                miceMap.put(currentMouse, null);
            }

//            logger.info("Results for mouse: " + currentMouse);
        }

        //Print results to the log
        logger.info("********************************************************* Results for MiceMap = " + miceMap.toString());

        //TODO - Make analysis of the results...
    }
}
