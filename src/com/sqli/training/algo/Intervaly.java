package com.sqli.training.algo;

import java.util.Comparator;


public class Intervaly {

    private double start;
    private double end;
    public static final Comparator<Intervaly> INTERVAL_START_COMPARATOR = new Comparator<Intervaly>() {

        @Override
        public int compare(Intervaly o1, Intervaly o2) {
            return (int) (o1.start - o2.start);
        }
    };

    public Intervaly(double start, double end) {
        this.start = start;
        this.end = end;
    }
    
    
    public boolean overlap(Intervaly interval) {
        return contains(interval.start) || contains(interval.end);
            
    }


    private boolean contains(double point) {
        return point >= start && point <= end;
    }
    
    public Intervaly merge(Intervaly i){
        return new Intervaly(Math.min(start, i.start), Math.max(end, i.end));
    }
    
    public boolean isNarrawerThan(Intervaly i){
        return (end - start) < (i.end - i.start);
    }
    
    
    
}
