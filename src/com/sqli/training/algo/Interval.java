package com.sqli.training.algo;


public class Interval {

    private double from;
    private double to;
    
    public Interval(double from, double to) {
        this.from = from;
        this.to = to;
    }
    
    @Override
    public String toString() {
        return "["+this.from+",+"+this.to+"]";
    }

    public boolean overlap(Interval interval) {
        if(this.contains(interval.from) || this.contains(interval.to) )
            return true;
        return false;
    }

    private boolean contains(double number) {
        
        return false;
    }

    public static Interval merge(Interval interval, Interval interval2) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
}
