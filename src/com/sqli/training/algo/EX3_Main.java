package com.sqli.training.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EX3_Main {

    public static void main(String[] args) {
        String intervals = "[10,21] [1,3] [6,7] [8.4,12] [2,3] ";// ==> [8.4,21]
        System.out.println(getLongestInterval(parseIntervals(intervals)));
        
    }
    
    
    private static List<Intervaly> parseIntervals(String input) {
        List<Intervaly> intervalies = new ArrayList<Intervaly>();
        Pattern p = Pattern.compile("\\d+(\\.\\d)?");
        Matcher m = p.matcher(input);
        Double start = null;
        while(m.find()){
            if(start == null){
                start = Double.parseDouble(m.group());
            }else{
                Intervaly i = new Intervaly(start, Double.parseDouble(m.group()));
                intervalies.add(i);
            }
        }
        return intervalies;

    }
    
    private static Intervaly getLongestInterval(List<Intervaly> intervals) {
        Stack<Intervaly> stack = intervalsWithoutOverlap(intervals);
        
        Intervaly longestInterval = stack.pop();
        while( ! stack.empty()){
            if(longestInterval.isNarrawerThan(stack.peek())){
                longestInterval = stack.pop();
            }else{
                stack.pop();
            }
        }
        
        return longestInterval;
    }


    private static Stack<Intervaly> intervalsWithoutOverlap(List<Intervaly> intervals) {
        Collections.sort(intervals, Intervaly.INTERVAL_START_COMPARATOR);
        Stack<Intervaly> stack = new Stack<Intervaly>();
        stack.push(intervals.get(0));
        
        for (int i = 1; i < intervals.size(); i++) {
            if(stack.peek().overlap(intervals.get(i))){
                Intervaly newInterval = stack.pop().merge(intervals.get(i));
                stack.push(newInterval);
            }else{
                stack.push(intervals.get(i));
            }
        }
        return stack;
    }
}
