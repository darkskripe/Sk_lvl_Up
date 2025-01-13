package com.darkskripe.mod_core.player_smith_lvl;


import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.aspects.Aspect;

import com.darkskripe.mod_core.aspects.Aspects;
import com.darkskripe.mod_core.player_smith_lvl.smith_leveling.SkSmithLevels;
import com.darkskripe.mod_core.sword_smith_lvl.SwordDataHelper;
import com.darkskripe.mod_core.sword_smith_lvl.component.SkComponents;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import java.util.ArrayList;
import java.util.List;

import static com.darkskripe.mod_core.player_smith_lvl.PlayerDataHandler.*;
@Mod.EventBusSubscriber(modid = ModCore.MODID)
public class PlayerDataHelper {

    public static void addExpToSmithPlayer(Player player,float exp) {
        CompoundTag playerData = player.getPersistentData().getCompound(SK_DATA_KEY);
        if(exp!=0)setSmithExp(playerData, exp+getSmithExp(playerData));
        if(checkIfCanUpdatePlayerSmithLevel(playerData,player)) {
            updatePlayerSmithLevel(playerData,player);
            addExpToSmithPlayer(player,0);
        }

    }

    public static boolean checkIfCanUpdatePlayerSmithLevel(CompoundTag playerData,Player player) {
        int smithLevel=getSmithLvl(playerData);
        float necessary_smith_exp = SkSmithLevels.LEVELS.get(smithLevel).getNecessary_smith_exp();
        float necessary_player_lvl = SkSmithLevels.LEVELS.get(smithLevel).getNecessary_player_level();
        if (necessary_smith_exp <= getSmithExp(playerData) && player.experienceLevel >= necessary_player_lvl && smithLevel != 10) {
            return true;
        }
        return false;
    }

    public static void updatePlayerSmithLevel(CompoundTag playerData,Player player) {
        int smithLevel=getSmithLvl(playerData);
        float necessary_smith_exp=SkSmithLevels.LEVELS.get(smithLevel).getNecessary_smith_exp();
        float rest_exp=getSmithExp(playerData)-necessary_smith_exp;
        playerData.putInt(SK_SMITH_LVL, 1+smithLevel);
        playerData.putFloat(SK_SMITH_EXP, rest_exp);
        player.experienceLevel-=SkSmithLevels.LEVELS.get(smithLevel).getNecessary_player_level();
    }



    public static int getSmithLvl(CompoundTag playerData) {
        return playerData.getInt(SK_SMITH_LVL);
    }

    public static void setSmithLvl(CompoundTag playerData,int level) {
        playerData.putInt(SK_SMITH_LVL, level);
    }

    public static float getSmithExp(CompoundTag playerData) {
        return playerData.getFloat(SK_SMITH_EXP);
    }

    public static void setSmithExp(CompoundTag playerData,float exp) {
        playerData.putFloat(SK_SMITH_EXP,exp);
    }

    public static float getAchievementExpCoef(CompoundTag playerData) {
        return playerData.getFloat(SK_ACHIEVEMENT_EXP_COEF);
    }

    public static List<Aspect> getDisponibleAspectsFromPlayerData(Player playerData){
        List<Integer> disponible_aspects_id = new ArrayList<>();
        int[] disponible_aspects_array = playerData.getPersistentData().getIntArray(DISPONIBLE_ASPECTS);
        for (int id : disponible_aspects_array) {
            disponible_aspects_id.add(id);
        }
        return integerListToAspectListById(disponible_aspects_id);
    }

    private static List<Aspect> integerListToAspectListById(List<Integer> integerList){
        List<Aspect> aspects = new ArrayList<>();
        for (Aspect aspect : Aspects.ALL_ASPECTS) {
            if (integerList.contains(aspect.getId())) {
                aspects.add(aspect);
            }
        }
        return aspects;
    }



}
