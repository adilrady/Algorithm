package com.sqli.training.algo;

import java.util.ArrayList;
import java.util.List;


public class Ex3 {

    public static void main(String[] args) {
        
    }
    
//    
//    private Interval longestInterval(List<Interval> intervals) {
//        List<Interval> intervalsWithoutOverlap = intervalsWithoutOverlap(intervals); 
//    }


    private List<Interval> intervalsWithoutOverlap(List<Interval> intervals) {
        List<Interval> intervalsWithoutOverlap = new ArrayList<Interval>();
        boolean isThereAnyOverLap = false;
        for (int i = 0; i < intervals.size() - 1; i++) {
            for (int j = 1; j < intervals.size(); j++) {
                if(intervals.get(i).overlap(intervals.get(j))){
                    Interval newInterval = Interval.merge(intervals.get(i), intervals.get(i + 1));
                    intervals.remove(i);
                    intervals.remove(j);
                    intervals.add(i, newInterval);
                    isThereAnyOverLap = true;
                }
            }
            if(isThereAnyOverLap){
                i = 0;
            }
        }
        return intervalsWithoutOverlap;
    }
    
}
