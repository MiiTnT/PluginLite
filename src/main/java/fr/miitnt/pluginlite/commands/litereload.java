package fr.miitnt.pluginlite.commands;

import fr.miitnt.pluginlite.Pluginlite;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandLitereload implements CommandExecutor {
    private Pluginlite main;

    public CommandLitereload(Pluginlite pluginlite) {
        this.main = pluginlite;
    }

    @Override
    public boolean onCommand(CommandSender sender, final Command cmd, final String msg, final String[] args) {
        main.reloadConfig();
        sender.sendMessage(ChatColor.getByChar('2') + "[PluginLite] " + ChatColor.RED + "La configuration a été rechargée");
        return true;
    }

}
