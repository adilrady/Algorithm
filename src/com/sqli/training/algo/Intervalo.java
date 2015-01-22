package com.sqli.training.algo;

import java.util.Comparator;


public class Intervalo {

    private double start;
    private double end;
    public static final Comparator<Intervalo> INTERVAL_START_COMPARTOR = new Comparator<Intervalo>() {

        @Override
        public int compare(Intervalo o1, Intervalo o2) {
            return (int) (o1.start - o2.start);
        }
    };
    
    public Intervalo(double start, double end) {
        this.start = start;
        this.end = end;
    }
    
    
    public boolean overLapWith(Intervalo intervalo){
        if(contains(intervalo.start) || contains(intervalo.end) ){
            return true;
        }
        return false;
    }

    
    private boolean contains(double point) {
        return point >= start && point <= end;
    }


    public Intervalo merge(Intervalo interval) {
        return new Intervalo(Math.min(start, interval.start), Math.max(end, interval.end));

    }


    public boolean narrawerThan(Intervalo interval) {
        return (end - start) < (interval.end - interval.start) ;
    }
    
    @Override
    public String toString() {
        return "["+start+","+end+"]";
    }
    
    
}
