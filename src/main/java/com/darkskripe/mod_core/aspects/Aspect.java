package com.darkskripe.mod_core.aspects;



public class Aspect {
    int id;
    String name;
    String color;
    int aspect_max_lvl;
    int aspect_min_class;


    //All aspects appear if player have neccesary achivement
    public Aspect(int id,String name, String color, int aspect_max_lvl, int aspect_min_class) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.aspect_max_lvl = aspect_max_lvl;
        this.aspect_min_class = aspect_min_class;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAspect_max_lvl() {
        return aspect_max_lvl;
    }

    public void setAspect_max_lvl(int aspect_max_lvl) {
        this.aspect_max_lvl = aspect_max_lvl;
    }

    public int getAspect_min_class() {
        return aspect_min_class;
    }

    public void setAspect_min_class(int aspect_min_class) {
        this.aspect_min_class = aspect_min_class;
    }





}
