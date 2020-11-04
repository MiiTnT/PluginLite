package fr.miitnt.pluginlite.commands;

import fr.miitnt.pluginlite.Pluginlite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class CommandFurnace implements CommandExecutor {
    private Pluginlite main;

    public CommandFurnace(Pluginlite main) {
        this.main = main;
    }
   
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        if(sender instanceof Player){
            player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "NE FERMEZ PAS CE FOUR AVANT D'AVOIR TOUT RECUPERER SOUS PEINE DE TOUT PERDRE !");
        }
        Bukkit.getScheduler().runTaskLater(main, new Runnable() {
            @Override
            public void run() {
                Inventory inv = Bukkit.createInventory(player, InventoryType.FURNACE);
                player.openInventory(inv);
            }
        }, 60);


        return false;
    }

}
