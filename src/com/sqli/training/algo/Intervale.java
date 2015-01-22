package com.sqli.training.algo;

import java.util.Comparator;


public class Intervale {

    private double start;
    private double end;
    public static final Comparator<Intervale> INTERVAL_START_COMPARATOR = new Comparator<Intervale>() {

        @Override
        public int compare(Intervale o1, Intervale o2) {
            return (int) (o1.start - o2.start);
        }
    };
    
    public static final Comparator<Intervale> INTERVAL_LENGTH_COMPARATOR = new Comparator<Intervale>() {

        @Override
        public int compare(Intervale o1, Intervale o2) {
            return (int) (o1.start - o2.start);
        }
    };
    
    public Intervale(double satrt, double end) {
        super();
        this.start = satrt;
        this.end = end;
    }
    
    
    public boolean overlap(Intervale intervale) {
        if(this.contains(intervale.start) || this.contains(intervale.end)){
            return true;
        }
        return false;
    }


    private boolean contains(double point) {
        if(this.start <= point || this.end >= point){
            return true;
        }
        return false;
    }
    
    public Intervale merge(Intervale intervale){
        return new Intervale(Math.min(this.start, intervale.start), Math.max(this.end, intervale.end));
    }


    public boolean narrowerThan(Intervale intervale) {
        return (this.end - this.start) < (intervale.end - intervale.start);
        
    }
    
    @Override
    public String toString() {
        return "["+this.start+","+this.end+"]";
    }
    
}
