package com.github.kilobytz.swapcore.framework;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameManager {

    private static Game game;

    public static Game getRunningGame() {
        if (game != null)
            return game;
        else
            return null;
    }

    public static void startGame(CommandSender sender) {
        if (game != null) {
            sender.sendMessage(ChatColor.RED + "Error, game already in progress.");
            return;
        }
        game = new Game();
        game.startUpGame();
        sender.sendMessage(ChatColor.GREEN + "Swapcore starting!.");
    }

    public static void stopGame(CommandSender sender) {
        if (game == null) {
            sender.sendMessage(ChatColor.RED + "Error, game has not yet been started.");
            return;
        }
        game.closeDownGame();
        sender.sendMessage(ChatColor.GREEN + "Swapcore ending!.");
    }

    public static void stopGame() {
        if (game == null)
            return;

        game.closeDownGame();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(ChatColor.GREEN + "Swapcore ending!.");
        }
    }

    public static void addPlayer(Player p) {
        if (game == null)
            return;
        game.addPlayer(p);
    }

    public static void removePlayer(Player p) {
        if (game == null)
            return;
        game.removePlayer(p);
    }

    public static boolean isPlayerPartOfGame(Player p) {
        if (game == null)
            return false;
        if (game.players.contains(p))
            return true;
        return false;
    }

}
