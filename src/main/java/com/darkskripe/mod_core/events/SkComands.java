package com.darkskripe.mod_core.events;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.player_smith_lvl.PlayerDataHelper;
import com.darkskripe.mod_core.sword_smith_lvl.SwordDataHelper;
import com.darkskripe.mod_core.sword_smith_lvl.UsableWeaponClasses;
import com.darkskripe.mod_core.sword_smith_lvl.component.SkComponents;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.darkskripe.mod_core.player_smith_lvl.PlayerDataHandler.SK_DATA_KEY;
import static com.darkskripe.mod_core.player_smith_lvl.PlayerDataHandler.SK_SMITH_LVL;

@Mod.EventBusSubscriber(modid = ModCore.MODID)
public class SkComands {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("sk_lvl_up") // Command name
                        .then(Commands.literal("set_smith_lvl")
                               .then(Commands.argument("target", net.minecraft.commands.arguments.EntityArgument.player()) // Targeted player
                                      .then(Commands.argument("smith_level", IntegerArgumentType.integer(1, 10)) // Attribute value
                                             .executes(
                                                   context -> {
                                                      ServerPlayer targetPlayer = net.minecraft.commands.arguments.EntityArgument.getPlayer(context, "target");
                                                      int value = IntegerArgumentType.getInteger(context, "smith_level");
                                                      CompoundTag playerData = targetPlayer.getPersistentData().getCompound(SK_DATA_KEY);
                                                      if (playerData.contains(SK_SMITH_LVL)) {
                                                        PlayerDataHelper.setSmithLvl(playerData, value);
                                                          PlayerDataHelper.setSmithExp(playerData, 0);
                                                        context.getSource().sendSuccess(() ->
                                                                Component.translatable("commands.sk_lvl_up.set_smith_lvl", targetPlayer.getDisplayName(), value), true
                                                        );
                                                      }else {
                                                        context.getSource().sendFailure(
                                                                Component.translatable("commands.sk_lvl_up.failure_set_smith_lvl")

                                                        );
                                                      }
                                                      return 0;




                                                   }
                                            )
                                    )
                               )
                        )

                        .then(Commands.literal("set_sword_class")
                                .then(Commands.argument("target", net.minecraft.commands.arguments.EntityArgument.player()) // Targeted player
                                        .then(Commands.argument("sword_class", IntegerArgumentType.integer(1, 10)) // Attribute value
                                                .executes(
                                                        context -> {
                                                            ServerPlayer targetPlayer = net.minecraft.commands.arguments.EntityArgument.getPlayer(context, "target");
                                                            int value = IntegerArgumentType.getInteger(context, "sword_class");
                                                            if(UsableWeaponClasses.isInUsedWeaponClasses(targetPlayer.getMainHandItem().getItem())){
                                                                targetPlayer.getMainHandItem().set(SkComponents.SWORD_CLASS.get(),value);
                                                                targetPlayer.getMainHandItem().set(SkComponents.SWORD_CURRENT_LVL.get(),1);
                                                                SwordDataHelper.recreateSwordStatsByClassForCommand(targetPlayer.getMainHandItem(),targetPlayer.getMainHandItem().getItem().getDefaultInstance());
                                                                context.getSource().sendSuccess(() ->
                                                                        Component.translatable("commands.sk_lvl_up.set_sword_class", targetPlayer.getDisplayName(), value), true
                                                                );
                                                            }else {
                                                                context.getSource().sendFailure(
                                                                        Component.translatable("commands.sk_lvl_up.failure_set_sword_class", targetPlayer.getDisplayName())
                                                                );
                                                            }
                                                            return 0;

                                                        }
                                                )
                                        )
                                )
                        )

                        .then(Commands.literal("set_sword_level")
                                .then(Commands.argument("target", net.minecraft.commands.arguments.EntityArgument.player()) // Targeted player
                                        .then(Commands.argument("sword_level", IntegerArgumentType.integer(1, 100)) // Attribute value
                                                .executes(
                                                        context -> {
                                                            ServerPlayer targetPlayer = net.minecraft.commands.arguments.EntityArgument.getPlayer(context, "target");
                                                            int value = IntegerArgumentType.getInteger(context, "sword_level");
                                                            if(UsableWeaponClasses.isInUsedWeaponClasses(targetPlayer.getMainHandItem().getItem())){
                                                                int swordClass=targetPlayer.getMainHandItem().get(SkComponents.SWORD_CLASS.get());
                                                                int swordMaxLevel= SwordDataHelper.getClassMaxLevel(swordClass);
                                                                if(swordMaxLevel>=value){
                                                                    targetPlayer.getMainHandItem().set(SkComponents.SWORD_CURRENT_LVL.get(),value);
                                                                    context.getSource().sendSuccess(() ->
                                                                            Component.translatable("commands.sk_lvl_up.set_sword_level", targetPlayer.getDisplayName(), value), true
                                                                    );
                                                                }else {
                                                                    context.getSource().sendFailure(
                                                                            Component.translatable("commands.sk_lvl_up.failure1_set_sword_level", targetPlayer.getDisplayName())
                                                                    );
                                                                }

                                                            }else {
                                                                context.getSource().sendFailure(
                                                                        Component.translatable("commands.sk_lvl_up.failure2_set_sword_level", targetPlayer.getDisplayName())
                                                                );
                                                            }
                                                            return 0;

                                                        }
                                                )
                                        )
                                )
                        )
                        .then(Commands.literal("add_sword_exp")
                                .then(Commands.argument("target", net.minecraft.commands.arguments.EntityArgument.player()) // Targeted player
                                        .then(Commands.argument("exp", FloatArgumentType.floatArg(0)) // Attribute value
                                                .executes(
                                                        context -> {
                                                            ServerPlayer targetPlayer = net.minecraft.commands.arguments.EntityArgument.getPlayer(context, "target");
                                                            float value = FloatArgumentType.getFloat(context, "exp");
                                                            if(UsableWeaponClasses.isInUsedWeaponClasses(targetPlayer.getMainHandItem().getItem())){
                                                                SwordDataHelper.addExperienceAndUpdateData(targetPlayer.getMainHandItem(),value);
                                                                context.getSource().sendSuccess(() ->
                                                                            Component.translatable("commands.sk_lvl_up.add_sword_exp", targetPlayer.getDisplayName(), value), true
                                                                    );

                                                            }else {
                                                                context.getSource().sendFailure(
                                                                        Component.translatable("commands.sk_lvl_up.add_sword_exp_failure", targetPlayer.getDisplayName())
                                                                );
                                                            }
                                                            return 0;

                                                        }
                                                )
                                        )
                                )
                        )


        );
    }
}
