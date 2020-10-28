package fr.miitnt.pluginlite;

import fr.miitnt.pluginlite.commands.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pluginlite extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[PluginLite] Le plugin démarre !");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Commandes(this), this);
        getCommand("gmc").setExecutor(new gamemode1(this));
        getCommand("gms").setExecutor(new gamemode0(this));
        getCommand("gma").setExecutor(new gamemode2(this));
        getCommand("gmsp").setExecutor(new gamemode3(this));
        getCommand("litereload").setExecutor(new litereload(this));
        getCommand("day").setExecutor(new day(this));
        getCommand("night").setExecutor(new night(this));
        getCommand("sun").setExecutor(new time(this));
        getCommand("rain").setExecutor(new rain(this));
        getCommand("gm").setExecutor(new gm(this));
        getCommand("craft").setExecutor(new craft());
        getCommand("furnace").setExecutor(new furnace(this));
        getCommand("setservername").setExecutor(new setServerName(this));
        getServer().getPluginManager().registerEvents(new EventListeners(this), this);


        saveDefaultConfig();
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[PluginLite] Le plugin s'éteint !");
    }
}
