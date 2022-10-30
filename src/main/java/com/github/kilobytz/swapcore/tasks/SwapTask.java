package com.github.kilobytz.swapcore.tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SwapTask extends BukkitRunnable {
    List<UUID> list;
    List<Integer> offline = new ArrayList<>();

    public SwapTask(List<UUID> list) {
        this.list = list;
    }

    public void run() {
        for (UUID id : list) {
            if (Bukkit.getPlayer(id) == null)
                offline.add(list.indexOf(id));
            continue;
        }
        if (Bukkit.getOnlinePlayers().size() < 2 || list.size()-offline.size() < 2) {
            Bukkit.getLogger().info(ChatColor.RED + "Error. Not enough players online.");
            return;
        }
        int rand1 = (int) (Math.random() * list.size());
        int rand2 = (int) (Math.random() * list.size());
        while (rand1 == rand2 && offline.contains(rand1)) {
            rand1 = (int) (Math.random() * list.size());
        }
        while (rand1 == rand2 && offline.contains(rand2)) {
            rand2 = (int) (Math.random() * list.size());
        }

        Player p1 = Bukkit.getPlayer(list.get(rand1));
        Player p2 = Bukkit.getPlayer(list.get(rand2));
        Location p1Loc = p1.getLocation();
        Location p2Loc = p2.getLocation();
        p1.teleport(p2Loc);
        p2.teleport(p1Loc);
    }
}
