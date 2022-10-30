package com.github.kilobytz.swapcore.mobs;

import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class SwapSkeleton extends EntitySkeleton {

    public static void spawn(Location loc){
        org.bukkit.World world = loc.getWorld();
        World mcWorld = ((CraftWorld) world).getHandle();
        SwapSkeleton skeleton = new SwapSkeleton(mcWorld);
        mcWorld.addEntity(skeleton, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    public SwapSkeleton(World world){
        super(world);
    }

    @Override
    protected void a(DifficultyDamageScaler difficultydamagescaler) {
        super.a(difficultydamagescaler);
        ItemStack bow = new ItemStack(org.bukkit.Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_KNOCKBACK,2);
        this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(bow));

    }

}
