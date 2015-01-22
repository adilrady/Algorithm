package com.sqli.training.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ex8 {

    public static void main(String[] args) {
        String intervals = "[10,21] [1,3] [6,7] [8.4,12] [2,3] ";// ==> [8.4,21]
        System.out.println(longestInterval(parseIntervals(intervals)));
        
    }
    
    
    private static List<Intervalo> parseIntervals(String input) {
        List<Intervalo> listIntervals = new ArrayList<Intervalo>();
        Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = p.matcher(input);
        Double start = null;
        while(matcher.find()){
            if(start == null){
                start = Double.parseDouble(matcher.group());
            }else{
                Intervalo interval = new Intervalo(start, Double.parseDouble(matcher.group()));
                listIntervals.add(interval);
                start = null;
            }
        }
        return listIntervals;
    }
    
    private static Intervalo longestInterval(List<Intervalo> listInterval) {
        Stack<Intervalo> stackIntervals = intervalsWithoutOverlap(listInterval);
        
        Intervalo interval = stackIntervals.pop();
        while( ! stackIntervals.empty()){
            if(interval.narrawerThan(stackIntervals.peek())){
                interval = stackIntervals.pop();
            }else{
                stackIntervals.pop();
            }
        }
        
        return interval;
    }


    private static Stack<Intervalo> intervalsWithoutOverlap(List<Intervalo> listInterval) {
        Collections.sort(listInterval, Intervalo.INTERVAL_START_COMPARTOR);
        Stack<Intervalo> stackIntervals = new Stack<Intervalo>();
        stackIntervals.push(listInterval.get(0));
        for (int i = 1; i < listInterval.size(); i++) {
            if(stackIntervals.peek().overLapWith(listInterval.get(i))){
                Intervalo newInterval = stackIntervals.pop().merge(listInterval.get(i));
                stackIntervals.push(newInterval);
            }else{
                stackIntervals.push(listInterval.get(i));
            }
        }
        return stackIntervals;
    }
    
}
