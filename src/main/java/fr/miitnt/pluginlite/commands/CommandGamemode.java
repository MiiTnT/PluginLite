package fr.miitnt.pluginlite.commands;

public class CommandGamemode implements CommandExecutor {
    
    private Pluginlite main;
    
    public CommandGamemode(Pluginlite main) {
        this.main = main;
    }
    
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (msg.startsWith("/gms")) {
				if (player.hasPermission("pluginlite.gamemode.survival")) {
					if (args.length == 0) {
						player.sendMessage(Objects.requireNonNull(main.getConfig().getString("ServerName")) + " "
								+ Objects.requireNonNull(main.getConfig().getString("messages.gamemode0")));
						player.setGameMode(GameMode.SURVIVAL);
						player.setHealth(20F);
						player.setSaturation(20);
						player.setFoodLevel(20);
					}
				} else {
					player.sendMessage("§cErreur: §7Vous n'avez pas la permission.");
				}

				return true;
			} else if (msg.startsWith("/gmc")) {
				if (player.hasPermission("pluginlite.gamemode.creative")) {
					if (args.length == 0) {
						player.sendMessage(Objects.requireNonNull(main.getConfig().getString("ServerName")) + " "
								+ Objects.requireNonNull(main.getConfig().getString("messages.gamemode1")));
						player.setGameMode(GameMode.CREATIVE);
						player.setHealth(20F);
						player.setSaturation(20);
						player.setFoodLevel(20);
					}
				} else {
					player.sendMessage("§cErreur: §7Vous n'avez pas la permission.");
				}
				return true;
			} else if (msg.startsWith("/gma")) {
				if (player.hasPermission("pluginlite.gamemode.adventure")) {
					if (args.length == 0) {
						player.sendMessage(Objects.requireNonNull(main.getConfig().getString("ServerName")) + " "
								+ Objects.requireNonNull(main.getConfig().getString("messages.gamemode2")));
						player.setGameMode(GameMode.ADVENTURE);
						player.setHealth(20F);
						player.setSaturation(20);
						player.setFoodLevel(20);
					}
				} else {
					player.sendMessage("§cErreur: §7Vous n'avez pas la permission.");
				}
				return true;
			} else if (msg.startsWith("/gm ")) {
				String servername = this.main.getConfig().getString("ServerName");

				String gmerror = this.main.getConfig().getString("messages.gamemode_error");
				String gmonline = this.main.getConfig().getString("messages.gamemode_online_error");
				String gmValidation = this.main.getConfig().getString("messages.gamemode_validation");
				String gm0 = this.main.getConfig().getString("messages.gamemode0");
				String gm1 = this.main.getConfig().getString("messages.gamemode1");
				String gm2 = this.main.getConfig().getString("messages.gamemode2");
				String gm3 = this.main.getConfig().getString("messages.gamemode3");

				if (args.length == 0) {
					player.sendMessage("§cVous devez indiquer un nombre !");
				}
				if (args[0].length() >= 1) {
					if (args.length >= 2) {
						Player player2 = Bukkit.getPlayerExact(args[1]);
						if (Bukkit.getServer().getPlayerExact(args[1]) != null) {
							if (args[0].equals("0")) {
								if (player.isOp() || player.hasPermission("pluginlite.gamemode.survival.other")) {
									player2.setGameMode(GameMode.SURVIVAL);
									player.sendMessage(
											servername + " " + gmValidation.replace("{ARG}", player2.getDisplayName()));
									player2.sendMessage(servername + " " + gm0);
								}
							}
							if (args[0].equals("1")) {
								if (player.isOp() || player.hasPermission("pluginlite.gamemode.creative.other")) {
									player2.setGameMode(GameMode.CREATIVE);
									player.sendMessage(
											servername + " " + gmValidation.replace("{ARG}", player2.getDisplayName()));
									player2.sendMessage(servername + " " + gm1);
								}
							}
							if (args[0].equals("2")) {
								if (player.isOp() || player.hasPermission("pluginlite.gamemode.adventure.other")) {
									player2.setGameMode(GameMode.ADVENTURE);
									player.sendMessage(
											servername + " " + gmValidation.replace("{ARG}", player2.getDisplayName()));
									player2.sendMessage(servername + " " + gm2);
								}
							}
							if (args[0].equals("3")) {
								if (player.isOp() || player.hasPermission("pluginlite.gamemode.spectator.other")) {
									player2.setGameMode(GameMode.SPECTATOR);
									player.sendMessage(
											servername + " " + gmValidation.replace("{ARG}", player2.getDisplayName()));
									player2.sendMessage(servername + " " + gm3);
								}
							}
							if (!args[0].equals("0") && !args[0].equals("1") && !args[0].equals("2")
									&& !args[0].equals("3")) {
								player.sendMessage(servername + " " + gmerror);
							}
						} else {
							player.sendMessage(servername + " " + gmonline);
						}

					} else {
						if (args[0].equals("0")) {
							if (player.isOp() || player.hasPermission("pluginlite.gamemode.survival")) {
								player.setGameMode(GameMode.SURVIVAL);
								player.sendMessage(servername + " " + gm0);
							}
						}
						if (args[0].equals("1")) {
							if (player.isOp() || player.hasPermission("pluginlite.gamemode.creative")) {
								player.setGameMode(GameMode.CREATIVE);
								player.sendMessage(servername + " " + gm1);
							}
						}
						if (args[0].equals("2")) {
							if (player.isOp() || player.hasPermission("pluginlite.gamemode.adventure")) {
								player.setGameMode(GameMode.ADVENTURE);
								player.sendMessage(servername + " " + gm2);
							}
						}
						if (args[0].equals("3")) {
							if (player.isOp() || player.hasPermission("pluginlite.gamemode.spectator")) {
								player.setGameMode(GameMode.SPECTATOR);
								player.sendMessage(servername + " " + gm3);
							}
						}
						if (!args[0].equals("0") && !args[0].equals("1") && !args[0].equals("2")
								&& !args[0].equals("3")) {
							player.sendMessage(servername + " " + gmerror);
						}
					}
				}
			}
		}

		return false;
	}
}
