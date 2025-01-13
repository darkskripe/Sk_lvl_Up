package com.darkskripe.mod_core.sword_smith_lvl.sword_classes;

import com.darkskripe.mod_core.aspects.Aspect;
import com.darkskripe.mod_core.aspects.Aspects;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class SwordClass {
    String name;
    String color;
    int max_lvl;
    int aspect_lvl_up_factor;
    int exp_coef;
    int start_necessary_exp;
    float quality_coef;
    double attack_speed_coef;

    public SwordClass(String name,String color, int max_lvl, int aspect_lvl_up_factor, int exp_coef,int start_necessary_exp, float quality_coef,double attack_speed_coef) {
        this.name = name;
        this.color = color;
        this.max_lvl = max_lvl;
        this.aspect_lvl_up_factor = aspect_lvl_up_factor;
        this.exp_coef = exp_coef;
        this.start_necessary_exp = start_necessary_exp;
        this.quality_coef = quality_coef;
        this.attack_speed_coef=attack_speed_coef;
    }

    public String getColor() {
        return color;
    }

    public float getQuality_coef() {
        return quality_coef;
    }

    public int getMax_lvl() {
        return max_lvl;
    }

    public String getName() {
        return name;
    }

    public int getAspect_lvl_up_factor() {
        return aspect_lvl_up_factor;
    }

    public int getExp_coef() {
        return this.exp_coef;
    }

    public int getStart_necessary_exp() {
        return start_necessary_exp;
    }

    public double getAttack_speed_coef() {
        return attack_speed_coef;
    }

    public void setStart_necessary_exp(int start_necessary_exp) {
        this.start_necessary_exp = start_necessary_exp;
    }

    public void setExp_coef(int exp_coef) {
        this.exp_coef = exp_coef;
    }


}
