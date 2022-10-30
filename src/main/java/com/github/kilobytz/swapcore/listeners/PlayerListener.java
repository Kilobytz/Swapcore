package com.github.kilobytz.swapcore.listeners;

import com.github.kilobytz.swapcore.framework.GameManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (GameManager.getRunningGame() == null) {
            return;
        }
        if (GameManager.isPlayerPartOfGame(e.getPlayer()))
            return;
        e.getPlayer().setGameMode(GameMode.SPECTATOR);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (GameManager.getRunningGame() == null) {
            return;
        }
        Player deadPlayer = e.getEntity();
        if (GameManager.isPlayerPartOfGame(deadPlayer)) {
            deadPlayer.setGameMode(GameMode.SPECTATOR);
            GameManager.removePlayer(deadPlayer);
        }
    }


}
