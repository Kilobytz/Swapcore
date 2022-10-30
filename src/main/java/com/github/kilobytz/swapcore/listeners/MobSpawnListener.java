package com.github.kilobytz.swapcore.listeners;

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
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapZombie.spawn(loc)
                }
                break;
            }
            case SKELETON: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapSkeleton.spawn(loc)
                }
                break;
            }
            case CREEPER: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapCreeper.spawn(loc)
                }
                break;
            }
            case ENDERMAN: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapEnderman.spawn(loc)
                }
                break;
            }
            case PIG_ZOMBIE: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapPigZombie.spawn(loc)
                }
                break;
            }
            case GHAST: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapGhast.spawn(loc)
                }
                break;
            }
            case WITHER_SKELETON: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapWitherSkeleton.spawn(loc)
                }
                break;
            }
            case BLAZE: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapBlaze.spawn(loc)
                }
                break;
            }
            case WITCH: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapWitch.spawn(loc)
                }
                break;
            }
            case WITHER: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapWither.spawn(loc)
                }
                break;
            }
            case ENDER_DRAGON: {
                if (chance > 50) {
                    e.setCancelled(true);
                    //SwapEnderDragon.spawn(loc)
                }
                break;
            }
            default:
                return;
        }
    }

}
