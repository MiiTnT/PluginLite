package fr.miitnt.pluginlite.commands;

import fr.miitnt.pluginlite.Pluginlite;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.List;


public class Commandes implements Listener {

    List<String> forbiddenCommands = Arrays.asList("plugins", "pl", "ver", "version", "help", "?");

    //Bloquer avec le tab

    public Commandes(Pluginlite pluginlite) {
    }

    @EventHandler
    public void onCommands(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage().toLowerCase();
        String[] args = msg.split(" ");
        args[0] = args[0].substring(1);
        String[] commandNames = args[0].split(":");

        String commandName = commandNames[commandNames.length - 1];

        if (forbiddenCommands.contains(commandName)) {
            p.sendMessage("§cErreur: §7Cette commande a été désactivée par §2[PluginLite]");
            e.setCancelled(true);
        }
    }
}
