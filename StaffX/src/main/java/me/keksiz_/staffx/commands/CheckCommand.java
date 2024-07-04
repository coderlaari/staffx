package me.keksiz_.staffx.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CheckCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Please provide a valid player.");
                p.sendMessage(ChatColor.YELLOW + "Example: /check Notch");
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    p.sendMessage(ChatColor.YELLOW + "----------------------------");
                    p.sendMessage(ChatColor.GOLD + "Target's name: " + target.getName() + ChatColor.GOLD + ".");
                    p.sendMessage(ChatColor.RED + "Target's health: " + String.format("%.1f", target.getHealth()));
                    TextComponent ban_target = new TextComponent(ChatColor.RED + "Click this to ban target.");
                    ban_target.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponent[] { new TextComponent(ChatColor.RED + "Click this to ban target.") }));
                    ban_target.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ban " + target.getName()));
                    p.spigot().sendMessage(ban_target);

                    TextComponent kick_target = new TextComponent(ChatColor.RED + "Click this to kick target.");
                    kick_target.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponent[] { new TextComponent(ChatColor.RED + "Click this to kick target.") }));
                    kick_target.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kick " + target.getName()));
                    p.spigot().sendMessage(kick_target);
                    p.sendMessage(ChatColor.YELLOW + "----------------------------");
                } else {
                    p.sendMessage(ChatColor.RED + "Player not found.");
                }
            }
        }
        return true;
    }
}

