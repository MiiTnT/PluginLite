package fr.miitnt.pluginlite.commands;

import fr.miitnt.pluginlite.Pluginlite;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class day implements CommandExecutor {
    private final Pluginlite main;

    public day(Pluginlite pluginlite) {
        this.main = pluginlite;
    }

    @Override
    public boolean onCommand(CommandSender sender, final Command cmd, final String msg, final String[] args) {
        for(World world : Bukkit.getServer().getWorlds()){
            world.setTime(0);

        }
        sender.sendMessage(Objects.requireNonNull(main.getConfig().getString("ServerName")) + " " + Objects.requireNonNull(main.getConfig().getString("messages.day")));
        return true;
    }


}
