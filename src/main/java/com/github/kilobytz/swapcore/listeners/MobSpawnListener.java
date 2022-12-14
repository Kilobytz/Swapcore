package com.github.kilobytz.swapcore.listeners;

import com.github.kilobytz.swapcore.mobs.SwapSkeleton;
import com.github.kilobytz.swapcore.mobs.SwapZombie;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobSpawnListener implements Listener {

    @EventHandler
    public void onMobSpawn(EntitySpawnEvent e) {

        int chance = (int) (Math.random() * 100);
        Location loc = e.getLocation();

        switch (e.getEntityType()) {
            case ZOMBIE: {
                if (chance < 50) {
                    e.setCancelled(true);
                    SwapZombie.spawn(loc);
                }
                break;
            }
            case SKELETON: {
                if (chance < 66) {
                    e.setCancelled(true);
                    SwapSkeleton.spawn(loc);
                }
                break;
            }
            case CREEPER: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapCreeper.spawn(loc);
                }
                break;
            }
            case ENDERMAN: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapEnderman.spawn(loc);
                }
                break;
            }
            default:
                return;
        }
    }

}
