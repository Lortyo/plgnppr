package com.rnno.tesJe.commands;

import com.rnno.tesJe.TesJe;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class HelloCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NonNull @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command!");
            return true;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            org.bukkit.plugin.java.JavaPlugin plugin = org.bukkit.plugin.java.JavaPlugin.getPlugin(TesJe.class);
            String message = plugin.getConfig().getString("hello-message");
            if (message != null) {
                message = message.replace("{player}", player.getName());
                message = message.replace("&", "§");
                player.sendMessage(message);
            }
            return true;
        }

        if (args.length == 1) {
            String targetName = args[0];

            Player targetPlayer = Bukkit.getPlayer(targetName);

            if (targetPlayer == null){
                player.sendMessage("§aHello, " + player.getName() + "! Welcome to the server!");
                return true;
            }

            targetPlayer.sendMessage("§e" + player.getName() + " says hello to you!");
            player.sendMessage("§aYou said hello to " + targetPlayer.getName() + "!");
            return true;
        }
        return true;
    }
}
