package com.darkskripe.mod_core.player_smith_lvl.smith_leveling;

public class SkSmithLevel {
    int smith_level;
    int necessary_player_level;
    float necessary_smith_exp;


    public void setNecessary_player_level(int necessary_player_level) {
        this.necessary_player_level = necessary_player_level;
    }

    public void setNecessary_smith_exp(float necessary_smith_exp) {
        this.necessary_smith_exp = necessary_smith_exp;
    }

    public SkSmithLevel(int smith_level, int necessary_player_level, float necessary_smith_exp) {
        this.smith_level = smith_level;
        this.necessary_player_level = necessary_player_level;
        this.necessary_smith_exp = necessary_smith_exp;
    }

    public float getNecessary_smith_exp() {
        return this.necessary_smith_exp;
    }

    public int getNecessary_player_level() {
        return necessary_player_level;
    }

    public int getSmith_level() {
        return smith_level;
    }
}
