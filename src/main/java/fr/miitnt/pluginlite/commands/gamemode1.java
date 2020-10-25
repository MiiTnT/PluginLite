package fr.miitnt.pluginlite.commands;

import fr.miitnt.pluginlite.Pluginlite;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class gamemode1 implements CommandExecutor {

    private final Pluginlite main;

    public gamemode1(Pluginlite pluginlite) {
        this.main = pluginlite;
    }

    @Override
    public boolean onCommand(CommandSender sender,final Command cmd,final String msg,final String[] args) {
        if(sender instanceof Player) {
            final Player p = (Player) sender;
            if(p.isOp() || p.hasPermission("pluginlite.gamemode.creative")){
                if(args.length == 0) {
                    p.sendMessage(Objects.requireNonNull(main.getConfig().getString("ServerName")) + " " + Objects.requireNonNull(main.getConfig().getString("messages.gamemode1")));
                    p.setGameMode(GameMode.CREATIVE);
                    p.setHealth(20);
                    p.setSaturation(20);
                    p.setFoodLevel(20);
                }
            }else {
                p.sendMessage("§cErreur: §7Vous n'avez pas la permission.");
            }
        }

        return false;
    }
}
