package com.github.kilobytz.swapcore.framework;

import com.github.kilobytz.swapcore.Swapcore;
import com.github.kilobytz.swapcore.tasks.SwapTask;
import net.minecraft.server.v1_12_R1.EntityLiving;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Game {

    BukkitTask task;
    List<UUID> players = new LinkedList<>();
    private boolean gameRunning = false;

    public void startUpGame() {
        gameRunning = true;
        addValidPlayers();
        task = new SwapTask(players).runTaskTimer(Swapcore.getInstance(), 20L, 20L);
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void closeDownGame() {
        gameRunning = false;
        task.cancel();
        //cleanup();
    }

    public void addValidPlayers() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getGameMode() != GameMode.SURVIVAL)
                continue;
            players.add(p.getUniqueId());
        }
    }

    public void addPlayer(Player p) {
        players.add(p.getUniqueId());
    }

    public void removePlayer(Player p) {
        players.remove(p.getUniqueId());
    }

    public void swapPlayerWithRandomPlayer(Player p){
        Bukkit.broadcastMessage(p.getName() + " should be swapping with random player");
    }

    public void swapPlayerWithMob(Player p, LivingEntity e){
        Location pLoc = p.getLocation();
        Location eLoc = e.getLocation();
        p.teleport(eLoc);
        e.teleport(pLoc);
    }


}
