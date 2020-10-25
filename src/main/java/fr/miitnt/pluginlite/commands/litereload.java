package fr.miitnt.pluginlite.commands;

import fr.miitnt.pluginlite.Pluginlite;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class litereload implements CommandExecutor {
    private final Pluginlite main;

    public litereload(Pluginlite pluginlite) {
        this.main = pluginlite;
    }

    @Override
    public boolean onCommand(CommandSender sender, final Command cmd, final String msg, final String[] args) {
        main.reloadConfig();
        sender.sendMessage("§2[PluginLite] §cLa configuration a été rechargée");
        return false;
    }

}
