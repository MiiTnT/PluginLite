package fr.miitnt.pluginlite;

import fr.miitnt.pluginlite.commands.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pluginlite extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[PluginLite] Le plugin démarre !");
        getServer().getPluginManager().registerEvents(new PlayersListener(this), this);
        getCommand("litereload").setExecutor(new litereload(this));
        getCommand("day").setExecutor(new day(this));
        getCommand("night").setExecutor(new night(this));
        getCommand("sun").setExecutor(new time(this));
        getCommand("rain").setExecutor(new rain(this));
        getCommand("gm").setExecutor(new CommandGamemode(this));
        getCommand("craft").setExecutor(new craft());
        getCommand("furnace").setExecutor(new furnace(this));
        getCommand("setservername").setExecutor(new setServerName(this));


        saveDefaultConfig();
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[PluginLite] Le plugin s'éteint !");
    }
}
