package me.keksiz_.staffx.commands;

import me.keksiz_.staffx.StaffX;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {

    ArrayList<Player> invisible_list = new ArrayList<>();

    StaffX plugin;

    public VanishCommand(StaffX plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
                if (invisible_list.contains(p)) {
                    invisible_list.remove(p);
                    p.sendMessage(ChatColor.RED + "You are no longer vanished.");
                } else if (!invisible_list.contains(p)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.hidePlayer(p);
                    }
                    invisible_list.add(p);
                    p.sendMessage(ChatColor.GREEN + "You are now vanished.");
                }
            }
        return true;
    }
}
