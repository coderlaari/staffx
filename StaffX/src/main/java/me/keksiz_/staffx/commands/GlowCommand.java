package me.keksiz_.staffx.commands;

import me.keksiz_.staffx.StaffX;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GlowCommand implements CommandExecutor {
    private final ArrayList<Player> glowingList = new ArrayList<>();
    private final StaffX plugin;

    public GlowCommand(StaffX plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (glowingList.contains(player)) {
                glowingList.remove(player);
                player.setGlowing(false);
                player.sendMessage(ChatColor.RED + "You are no longer glowing.");
            } else {
                glowingList.add(player);
                player.setGlowing(true);
                player.sendMessage(ChatColor.GREEN + "You are glowing.");
            }
            return true;
        } else {
            commandSender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return false;
        }
    }
}
