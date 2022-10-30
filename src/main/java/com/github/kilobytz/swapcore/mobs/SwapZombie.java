package com.github.kilobytz.swapcore.mobs;

import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class SwapZombie extends EntityZombie {

    public static void spawn(Location loc){
        org.bukkit.World world = loc.getWorld();
        World mcWorld = ((CraftWorld) world).getHandle();
        SwapZombie zombie = new SwapZombie(mcWorld);
        mcWorld.addEntity(zombie, CreatureSpawnEvent.SpawnReason.CUSTOM);
        zombie.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(zombie.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue()*3);
    }

    public SwapZombie(World world){
        super(world);
    }


}
