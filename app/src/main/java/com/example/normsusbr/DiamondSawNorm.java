package com.example.normsusbr;

public class DiamondSawNorm {
    private String sawMaterial;
    private int diameter;
    private int countDisks;
    private String measure;
    private double consumption;
    private String normNumber;



    public DiamondSawNorm(sawMaterials sawMaterial, int diameter,
                          int countDisks, normMeasures measure, double consumption, String normNumber) {

        this.sawMaterial =sawMaterial.toString();
        this.diameter = diameter;
        this.countDisks = countDisks;
        this.measure = measure.toString();
        this.consumption = consumption;
        this.normNumber= normNumber;
    }

    public String getSawMaterial() {
        return sawMaterial;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getCountDisks() {
        return countDisks;
    }

    public String getMeasure() {
        return measure;
    }

    public double getConsumption() {
        return consumption;
    }

    public String getNormNumber() {
        return normNumber;
    }
}
