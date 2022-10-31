package com.github.kilobytz.swapcore.mobs;

import com.github.kilobytz.swapcore.framework.GameManager;
import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.EntityZombie;
import net.minecraft.server.v1_12_R1.GenericAttributes;
import net.minecraft.server.v1_12_R1.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SwapZombie extends EntityZombie {

    public SwapZombie(World world) {
        super(world);
    }

    public static void spawn(Location loc) {
        org.bukkit.World world = loc.getWorld();
        World mcWorld = ((CraftWorld) world).getHandle();
        SwapZombie zombie = new SwapZombie(mcWorld);
        mcWorld.addEntity(zombie, CreatureSpawnEvent.SpawnReason.CUSTOM);
        zombie.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(zombie.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue() * 3);
    }

    @Override
    public boolean B(Entity entity) {
        boolean flag = super.B(entity);
        if (entity.getBukkitEntity() instanceof Player)
            GameManager.getRunningGame().swapPlayerWithRandomPlayer((Player) entity);
        return flag;
    }


}
