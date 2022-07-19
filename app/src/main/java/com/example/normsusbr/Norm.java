package com.example.normsusbr;

import java.util.List;

public class Norm {
    private String name;
    private String measure;
    private int control_number;
    private String section;
    private Material [] materialsRequirement;

    public Norm (String name, String measure,int sectionNumber, int control_number,  Material []materialsRequirement){
        this.name = name;
        this.measure = measure;
        this.section =Sections.allSections[sectionNumber-1];
        this.control_number=control_number;
        this.materialsRequirement = materialsRequirement;
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

    public int getControl_number() {
        return control_number;
    }

    public Material[] getMaterialsRequirement() {
        return materialsRequirement;
    }

    public String getSection() {
        return section;
    }
}
