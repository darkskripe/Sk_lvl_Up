package com.darkskripe.mod_core.sword_smith_lvl.sword_classes;


import java.util.ArrayList;
import java.util.List;

public class SwordClasses {
    public static SwordClass CLASS_I=new SwordClass(
            "I","#9B9B9B",10,0,0,0,0.75f
    ,-0.35);
    public static SwordClass CLASS_II=new SwordClass(
            "II","#B5D8D8",15,0,0,0,0.9f
    ,-0.15);
    public static SwordClass CLASS_III=new SwordClass(
            "III","#3583D6",20,15,0,0,1f
    ,0);
    public static SwordClass CLASS_IV=new SwordClass(
            "IV","#2833D3",25,17,0,0,1.15f
    ,0.05);
    public static SwordClass CLASS_V=new SwordClass(
            "V","#424EB1",35,15,0,0,1.34f
    ,0.1);
    public static SwordClass CLASS_VI=new SwordClass(
            "VI","#4280B1",45,20,0,0,1.63f
    ,0.15);
    public static SwordClass CLASS_VII=new SwordClass(
            "VII","#9080B1",55,15,0,0,1.9f
    ,0.25);
    public static SwordClass CLASS_VIII=new SwordClass(
            "VIII","#CB80B1",65,20,0,0,2.2f
    ,0.35);
    public static SwordClass CLASS_IX=new SwordClass(
            "IX","#CBDAB1",85,20,0,0,3.4f
    ,0.5);
    public static SwordClass CLASS_X=new SwordClass(
            "X","#FFFF59",100,20,0,0,4.5f
    ,0.65);




    public static List<SwordClass> SWORD_CLASSES=new ArrayList<>();
    static {
        SWORD_CLASSES.add(CLASS_I);
        SWORD_CLASSES.add(1,CLASS_I);
        SWORD_CLASSES.add(2,CLASS_II);
        SWORD_CLASSES.add(3,CLASS_III);
        SWORD_CLASSES.add(4,CLASS_IV);
        SWORD_CLASSES.add(5,CLASS_V);
        SWORD_CLASSES.add(6,CLASS_VI);
        SWORD_CLASSES.add(7,CLASS_VII);
        SWORD_CLASSES.add(8,CLASS_VIII);
        SWORD_CLASSES.add(9,CLASS_IX);
        SWORD_CLASSES.add(10,CLASS_X);
    }

}
