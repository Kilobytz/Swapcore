package com.github.kilobytz.swapcore;

import com.github.kilobytz.swapcore.commands.SwapCommand;
import com.github.kilobytz.swapcore.framework.GameManager;
import com.github.kilobytz.swapcore.listeners.MobSpawnListener;
import com.github.kilobytz.swapcore.listeners.PlayerListener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Swapcore extends JavaPlugin {

    private static Swapcore instance;
    private static GameManager gameManager;

    public static Swapcore getInstance() {
        return instance;
    }


    @Override
    public void onEnable() {
        gameManager = new GameManager();
        registerCommand("swap", new SwapCommand());
        registerEvent(new PlayerListener());
        registerEvent(new MobSpawnListener());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerEvent(Listener event) {
        this.getServer().getPluginManager().registerEvents(event, this);
    }

    private void registerCommand(String command, CommandExecutor executor) {
        this.getServer().getPluginCommand(command).setExecutor(executor);
    }

}
