package fr.miitnt.pluginlite.commands;

public class CommandGamemode implements CommandExecutor {
    
    private Pluginlite main;
    
    public CommandGamemode(Pluginlite main) {
        this.main = main;
    }
    
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (msg.startsWith("/gms")) {
				if (p.hasPermission("pluginlite.gamemode.survival")) {
					if (args.length == 0) {
						p.sendMessage(Objects.requireNonNull(main.getConfig().getString("ServerName")) + " "
								+ Objects.requireNonNull(main.getConfig().getString("messages.gamemode0")));
						p.setGameMode(GameMode.SURVIVAL);
						p.setHealth(20);
						p.setSaturation(20);
						p.setFoodLevel(20);
					}
				} else {
					p.sendMessage("§cErreur: §7Vous n'avez pas la permission.");
				}

				return true;
			} else if (msg.startsWith("/gmc")) {
				if (p.hasPermission("pluginlite.gamemode.creative")) {
					if (args.length == 0) {
						p.sendMessage(Objects.requireNonNull(main.getConfig().getString("ServerName")) + " "
								+ Objects.requireNonNull(main.getConfig().getString("messages.gamemode1")));
						p.setGameMode(GameMode.CREATIVE);
						p.setHealth(20);
						p.setSaturation(20);
						p.setFoodLevel(20);
					}
				} else {
					p.sendMessage("§cErreur: §7Vous n'avez pas la permission.");
				}
			} else if (msg.startsWith("/gma")) {
				if (p.hasPermission("pluginlite.gamemode.adventure")) {
					if (args.length == 0) {
						p.sendMessage(Objects.requireNonNull(main.getConfig().getString("ServerName")) + " "
								+ Objects.requireNonNull(main.getConfig().getString("messages.gamemode2")));
						p.setGameMode(GameMode.CREATIVE);
						p.setHealth(20);
						p.setSaturation(20);
						p.setFoodLevel(20);
					}
				} else {
					p.sendMessage("§cErreur: §7Vous n'avez pas la permission.");
				}
			}
		}

		return false;
	}
}
