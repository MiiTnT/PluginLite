package fr.miitnt.pluginlite.commands;

import fr.miitnt.pluginlite.Pluginlite;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.List;


public class PlayersListener implements Listener {

    private List<String> forbiddenCommands = Arrays.asList("plugins", "pl", "ver", "version", "help", "?");

    public PlayersListener(Pluginlite pluginlite) {
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (forbiddenCommands.contains(e.getMessage().toLowerCase().replace("/", "").replaceAll(" ",""))) {
            p.sendMessage("§cErreur: §7Cette commande a été désactivée par §2[PluginLite]");
            e.setCancelled(true);
        }
    }
}
