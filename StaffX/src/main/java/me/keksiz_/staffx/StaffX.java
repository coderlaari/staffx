package me.keksiz_.staffx;

import me.keksiz_.staffx.commands.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffX extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("StaffX is starting...");

        // Debugging command registration
        debugCommand("gms", new GmsCommand());
        debugCommand("gmc", new GmcCommand());
        debugCommand("gmsp", new GmspCommand());
        debugCommand("gma", new GmaCommand());
        debugCommand("vanish", new VanishCommand(this));
        debugCommand("broadcast", new BroadcastCommand());
        debugCommand("glow", new GlowCommand(this));
        debugCommand("check", new CheckCommand());
        debugCommand("unban", new UnbanCommand());
    }

    private void debugCommand(String commandName, CommandExecutor executor) {
        PluginCommand command = getCommand(commandName);
        if (command == null) {
            getLogger().warning("Failed to register command: " + commandName);
        } else {
            command.setExecutor(executor);
            getLogger().info("Registered command '" + commandName + "' successfully!");
        }
    }
}
