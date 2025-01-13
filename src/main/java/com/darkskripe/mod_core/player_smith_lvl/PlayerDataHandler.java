package com.darkskripe.mod_core.player_smith_lvl;

import com.darkskripe.mod_core.ModCore;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class PlayerDataHandler {

    public static final String SK_DATA_KEY = "sk_lvl_up";
    public static final String SK_SMITH_LVL = "sk_smith_lvl";
    public static final String SK_SMITH_EXP = "sk_smith_exp";
    public static final String SK_ACHIEVEMENT_EXP_COEF = "sk_achievement_exp_coef";
    public static final String DISPONIBLE_ASPECTS = "disponible_aspects_by_id";

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        CompoundTag playerData = player.getPersistentData().getCompound(SK_DATA_KEY);

        if (!playerData.contains(SK_SMITH_LVL)) {
            playerData.putInt(SK_SMITH_LVL, 1);
            playerData.putFloat(SK_SMITH_EXP, 0);
            playerData.putFloat(SK_ACHIEVEMENT_EXP_COEF, 1);
            List<Integer> disponibleAspectsByIdAspects = new ArrayList<>();
            playerData.putIntArray(DISPONIBLE_ASPECTS, disponibleAspectsByIdAspects.stream().mapToInt(Integer::intValue).toArray());
            player.getPersistentData().put(SK_DATA_KEY, playerData);
        }
    }








}
