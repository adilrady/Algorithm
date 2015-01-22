package com.sqli.training.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ex4 {

    public static void main(String[] args) {
        String intervals = "[2.2, 21] [1,3.3]";
        List<Intervale> listIntervales = parseIntervals(intervals);
        
        char c = 'D';
        if(c > 'A' && c < 'Z')
            System.out.println("Upper");
        else
            System.out.println("Lower");
        
        
        for (Intervale intervale : listIntervales) {
            System.out.print(intervale+" ");
        }
        Intervale longestIntervale = longestInterval(listIntervales);
        System.out.println("\n"+longestIntervale);
    }

    private static List<Intervale> parseIntervals(String intervals) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(intervals);
        Double intervalStart = null;
        List<Intervale> listIntervales = new ArrayList<Intervale>();
        while (matcher.find()) {
            if(intervalStart == null){
                intervalStart = Double.parseDouble(matcher.group());
            }else{
                Intervale intervale = new Intervale(intervalStart, Double.parseDouble(matcher.group()));
                listIntervales.add(intervale);
                intervalStart = null;
            }
        }
        return listIntervales;
    }
    
    public static Intervale longestInterval(List<Intervale> intervals){
        Stack<Intervale> intervalStack = intervalsWithoutOverlap(intervals);
        Intervale longestIntervale = intervalStack.pop();
        while( ! intervalStack.empty()){
            if(longestIntervale.narrowerThan(intervalStack.peek())){
                longestIntervale = intervalStack.pop();
            }else{
                intervalStack.pop();
            }
        }
        return longestIntervale;
    }

    private static Stack<Intervale> intervalsWithoutOverlap(List<Intervale> intervals) {
        Collections.sort(intervals, Intervale.INTERVAL_START_COMPARATOR);
        Stack<Intervale> intervalStack = new Stack<Intervale>();
        intervalStack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if(intervalStack.peek().overlap(intervals.get(i))){
                Intervale newIntervale =  intervalStack.pop().merge(intervals.get(i));
                intervalStack.push(newIntervale);
            }else{
                intervalStack.push(intervals.get(i));
            }
        }
        return intervalStack;
    }
}
