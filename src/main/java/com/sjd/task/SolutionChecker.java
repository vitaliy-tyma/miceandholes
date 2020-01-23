package com.sjd.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolutionChecker {

    public List<Integer> check(Map<Integer, Integer> miceMap){

        List<Integer> result = new ArrayList<>(miceMap.size());

        for (Map.Entry<Integer, Integer> e : miceMap.entrySet()){
            result.add(e.getValue() - e.getKey());
        }

        return result;
    }
}
