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
    private Pluginlite main;
    
    public PlayersListener(Pluginlite pluginlite) {
        this.main = pluginlite;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (forbiddenCommands.contains(e.getMessage().toLowerCase().replace("/", "").replaceAll(" ",""))) {
            p.sendMessage("§cErreur: §7Cette commande a été désactivée par §2[PluginLite]");
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String message = this.main.getConfig().getString("messages.join_message");
        if (message != null)
            event.setJoinMessage(message.replace("{PLAYER}", p.getDisplayName()));
        
        if(p.hasPermission("tab.prefix.joueur")){
            p.setPlayerListName(ChatColor.DARK_GREEN + "{J} " + p.getName());
        }
        if(p.hasPermission("tab.prefix.guerrier")){
            p.setPlayerListName(ChatColor.RED + "{G} " + p.getName());
        }
        if(p.hasPermission("tab.prefix.admin")){
            p.setPlayerListName(ChatColor.DARK_RED + "{A} " + p.getName());
        }
        if(p.hasPermission("tab.prefix.moderateur")){
            p.setPlayerListName(ChatColor.DARK_GREEN + "{M} " + p.getName());
        }
        if(p.hasPermission("tab.prefix.helper")){
            p.setPlayerListName(ChatColor.LIGHT_PURPLE + "{H} " + p.getName());
        }
        if(p.hasPermission("tab.prefix.responsable")){
            p.setPlayerListName(ChatColor.BLUE + "{R} " + p.getName());
        }
        if(p.hasPermission("tab.prefix.builder")){
            p.setPlayerListName(ChatColor.GOLD + "{B} " + p.getName());
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        String message = this.main.getConfig().getString("messages.quit_message");

        if (message != null)
            event.setQuitMessage(message.replace("{PLAYER}", p.getDisplayName()));
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        String message = event.getMessage();
        if (p.hasPermission("chat.format.joueur")) {
            event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_GREEN + "Joueur" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_GREEN + p.getDisplayName() + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + message);
        } else if (p.hasPermission("chat.format.guerrier")) {
            event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Guerrier" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + p.getDisplayName() + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + message);
            //This will give the player with that permission node that Chat format.
        } else if (p.hasPermission("chat.format.admin")) {
            event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Admin" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + p.getDisplayName() + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + message);
        } else if (p.hasPermission("chat.format.moderateur")) {
            event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Modérateur" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + p.getDisplayName() + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + message);
        } else if (p.hasPermission("chat.format.helper")) {
            event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.LIGHT_PURPLE + "Helper" + ChatColor.DARK_GRAY + "] " + ChatColor.LIGHT_PURPLE + p.getDisplayName() + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + message);
        } else if (p.hasPermission("chat.format.responsable")) {
            event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Responsable" + ChatColor.DARK_GRAY + "] " + ChatColor.BLUE + p.getDisplayName() + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + message);
        } else if (p.hasPermission("chat.format.builder")) {
            event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Builder" + ChatColor.DARK_GRAY + "] " + ChatColor.GOLD + p.getDisplayName() + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + message);
        } else {
            event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "UNKNOWN" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + p.getDisplayName() + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + message);
        }
    }
}
