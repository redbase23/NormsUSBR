package com.example.normsusbr;

public class Material {
    private String name;
    private String measure;
    private double requirement;

    public Material(String name, String measure,double requirement){
        this.name = name;
        this.measure=measure;
        this.requirement = requirement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public double getRequirement() {
        return requirement;
    }

    public void setRequirement(double requirement) {
        this.requirement = requirement;
    }
}
