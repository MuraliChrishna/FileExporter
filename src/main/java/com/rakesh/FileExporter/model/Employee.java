package com.rakesh.FileExporter.model;

import java.util.LinkedList;
import java.util.List;

public class Employee {
    public double id;
    public List<String> profession;
    public List<String> specialization;

    public Employee(){
        profession = new LinkedList<>();
        specialization = new LinkedList<>();
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

}
