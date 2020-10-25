package fr.miitnt.pluginlite;

import fr.miitnt.pluginlite.commands.*;
import fr.miitnt.pluginlite.commands.rain;
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

        saveDefaultConfig();
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[PluginLite] Le plugin s'éteint !");
    }
}
