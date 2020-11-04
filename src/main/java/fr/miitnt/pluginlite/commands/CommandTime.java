package fr.miitnt.pluginlite.commands;

import fr.miitnt.pluginlite.Pluginlite;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class CommandTime implements CommandExecutor {
    private Pluginlite main;

    public CommandTime(Pluginlite pluginlite) {
        this.main = pluginlite;
    }


    @Override
    public boolean onCommand(CommandSender sender, final Command cmd, final String msg, final String[] args) {
        for (World world : Bukkit.getServer().getWorlds()) {
            world.setStorm(false);
            world.setThundering(false);

        }
        sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("ServerName")) + " " + Objects.requireNonNull(main.getConfig().getString("messages.sun")));
        return true;
    }


}
