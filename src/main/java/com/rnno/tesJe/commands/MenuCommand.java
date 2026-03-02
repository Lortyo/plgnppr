package com.rnno.tesJe.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NonNull @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory gui = Bukkit.createInventory(null, 9, "§8Menu");

            ItemStack healButton = new ItemStack(Material.DIAMOND);
            ItemMeta metaHeal = healButton.getItemMeta();
            metaHeal.setDisplayName("§aHeal");
            healButton.setItemMeta(metaHeal);

            ItemStack closeButton = new ItemStack(Material.BARRIER);
            ItemMeta metaClose = closeButton.getItemMeta();
            metaClose.setDisplayName("§cClose Menu");
            closeButton.setItemMeta(metaClose);

            gui.setItem(3, healButton);
            gui.setItem(5, closeButton);

            player.openInventory(gui);
        }
        return true;
    }
}
