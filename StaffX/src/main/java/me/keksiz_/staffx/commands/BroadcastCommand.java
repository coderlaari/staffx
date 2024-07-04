package me.keksiz_.staffx.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "You need to provide text!");
                p.sendMessage(ChatColor.YELLOW + "Example: /broadcast Hello, world!");
            } else if (args.length == 1) {
                String broadcast = args[0];
                Bukkit.broadcast(ChatColor.RED + "[Broadcast] " + ChatColor.GOLD + broadcast, "staffx.broadcast");
                p.sendMessage(ChatColor.GREEN + "You'r broadcast published successfully!");
            }
        }
        return true;
    }
}
