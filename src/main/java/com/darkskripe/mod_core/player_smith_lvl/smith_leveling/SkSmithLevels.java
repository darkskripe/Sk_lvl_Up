package com.darkskripe.mod_core.player_smith_lvl.smith_leveling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkSmithLevels {
    public final static SkSmithLevel SMITH_LVL_I=new SkSmithLevel(1,1,250f);
    public final static SkSmithLevel SMITH_LVL_II=new SkSmithLevel(2,4,500f);
    public final static SkSmithLevel SMITH_LVL_III=new SkSmithLevel(3,10,1400f);
    public final static SkSmithLevel SMITH_LVL_IV=new SkSmithLevel(4,13,2200f);
    public final static SkSmithLevel SMITH_LVL_V=new SkSmithLevel(5,15,3300f);
    public final static SkSmithLevel SMITH_LVL_VI=new SkSmithLevel(6,17,7000f);
    public final static SkSmithLevel SMITH_LVL_VII=new SkSmithLevel(7,20,10000f);
    public final static SkSmithLevel SMITH_LVL_VIII=new SkSmithLevel(8,25,25000f);
    public final static SkSmithLevel SMITH_LVL_IX=new SkSmithLevel(9,35,50000f);
    public final static SkSmithLevel SMITH_LVL_X=new SkSmithLevel(10,0,0);


    public static final List<SkSmithLevel> LEVELS = new ArrayList<SkSmithLevel>();
    static {
        LEVELS.add(SMITH_LVL_I);
        LEVELS.add(1,SMITH_LVL_I);
        LEVELS.add(2,SMITH_LVL_II);
        LEVELS.add(3,SMITH_LVL_III);
        LEVELS.add(4,SMITH_LVL_IV);
        LEVELS.add(5,SMITH_LVL_V);
        LEVELS.add(6,SMITH_LVL_VI);
        LEVELS.add(7,SMITH_LVL_VII);
        LEVELS.add(8,SMITH_LVL_VIII);
        LEVELS.add(9,SMITH_LVL_IX);
        LEVELS.add(10,SMITH_LVL_X);
    }
}
