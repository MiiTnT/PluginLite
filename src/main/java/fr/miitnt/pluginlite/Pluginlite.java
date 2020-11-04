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
        getCommand("litereload").setExecutor(new CommandLitereload(this));
        getCommand("day").setExecutor(new CommandDay(this));
        getCommand("night").setExecutor(new CommandNight(this));
        getCommand("sun").setExecutor(new CommandTime(this));
        getCommand("rain").setExecutor(new CommandRain(this));
        getCommand("gm").setExecutor(new CommandGamemode(this));
        getCommand("craft").setExecutor(new CommandCraft());
        getCommand("furnace").setExecutor(new CommandFurnace(this));
        getCommand("setservername").setExecutor(new CommandSetServerName(this));


        saveDefaultConfig();
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[PluginLite] Le plugin s'éteint !");
    }
}
