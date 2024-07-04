package me.keksiz_.staffx.commands;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Date;

public class CheckBanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /checkban <player>");
            return false;
        }

        String playerName = args[0];
        OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);

        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        BanList banList = Bukkit.getBanList(BanList.Type.NAME);
        BanEntry banEntry = banList.getBanEntry(player.getName());

        if (banEntry == null) {
            sender.sendMessage(ChatColor.GREEN + playerName + " is not banned.");
        } else {
            String banReason = banEntry.getReason();
            Date banExpiry = banEntry.getExpiration();
            sender.sendMessage(ChatColor.RED + playerName + " is banned.");
            sender.sendMessage(ChatColor.RED + "Reason: " + (banReason == null ? "No reason provided" : banReason));
            sender.sendMessage(ChatColor.RED + "Expiry: " + (banExpiry == null ? "Permanent" : banExpiry.toString()));
        }

        return true;
    }
}
