package com.rnno.tesJe.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;

public class WandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NonNull @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack wand = new ItemStack(Material.STICK, 1);
            ItemMeta meta = wand.getItemMeta();

            if (meta != null) {
                meta.setDisplayName("§6Fire Wand");
                List<String> lore = new ArrayList<>();
                lore.add("§7Right Click to Launch FireBall");
                meta.setLore(lore);

                wand.setItemMeta(meta);
            }
            player.getInventory().addItem(wand);
            player.sendMessage("§aYou Get a Fire Wand!");
        }
        return true;
    }
}
