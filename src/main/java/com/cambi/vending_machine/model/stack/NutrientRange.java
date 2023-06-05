package com.cambi.vending_machine.model.stack;

public class NutrientRange {
    private int min;
    private int max;
    private double score;

    public NutrientRange(){};
    public NutrientRange(int min, int max, double score) {
        this.min = min;
        this.max = max;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "NutrientRange{" +
                "min=" + min +
                ", max=" + max +
                ", score=" + score +
                '}';
    }
}