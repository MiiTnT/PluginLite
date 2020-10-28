package fr.miitnt.pluginlite.commands;

import fr.miitnt.pluginlite.Pluginlite;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class setServerName implements CommandExecutor {
    private Pluginlite main;


    public setServerName(Pluginlite main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String servername = this.main.getConfig().getString("ServerName");
        if(args.length >= 1){
            this.main.getConfig().set("ServerName", args[0].replace("&", "§"));
            this.main.saveConfig();
            this.main.reloadConfig();
            servername = this.main.getConfig().getString("ServerName");
            String finalServername = servername;
            Bukkit.getScheduler().runTaskLater(main, new Runnable() {
                @Override
                public void run() {
                    sender.sendMessage(finalServername + " §eNom du serveur configuré avec succès !");
                }
            }, 60);

        }else{
            sender.sendMessage(servername + " §cErreur: §7Veuillez indiquez un nom !");
        }
        return false;
    }
}
