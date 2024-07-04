package me.keksiz_.staffx.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GmspCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (args.length == 0) {
                p.setGameMode(GameMode.SPECTATOR);
            }else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                target.setGameMode(GameMode.SPECTATOR);
            }
        }else {
            Entity executer = (Entity) commandSender;
            executer.sendMessage(ChatColor.RED + "Only player can run this command!");
        }
        return true;
    }
}
