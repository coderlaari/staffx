package me.keksiz_.staffx.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UnbanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p = (Player) commandSender;
        if (args.length == 0) {
            p.sendMessage(ChatColor.RED + "Please provide valid player.");
            p.sendMessage(ChatColor.YELLOW + "Example: /unban Notch");
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target.isBanned()) {
                String targetName = target.getName();
                Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(targetName);
                p.sendMessage(ChatColor.GREEN + "You unbanned successfully player " + targetName);
            } else {
                p.sendMessage(ChatColor.RED + "This player is not banned!");
            }
        }
        return true;
    }
}
