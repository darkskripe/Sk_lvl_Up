package com.darkskripe.mod_core.events;

import com.darkskripe.mod_core.ModCore;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE;

@Mod.EventBusSubscriber(modid = ModCore.MODID)

public class UsableWeaponsChanges  {
    @SubscribeEvent
    public static void onEntitySpawn(EntityJoinLevelEvent event) {


        if (event.getEntity() instanceof ThrownTrident trident) {
            ItemAttributeModifiers itemAttributeModifiers = trident.getWeaponItem().getComponents().get(DataComponents.ATTRIBUTE_MODIFIERS);
            for (ItemAttributeModifiers.Entry entry : itemAttributeModifiers.modifiers()) {
                if (entry.attribute().is(ATTACK_DAMAGE)) {
                    double  itemAttack=entry.modifier().amount();
                    trident.setBaseDamage(itemAttack);
                    ModCore.LOGGER.info("Attack "+itemAttack);
                    break;
                }
            }



        }
    }

}
