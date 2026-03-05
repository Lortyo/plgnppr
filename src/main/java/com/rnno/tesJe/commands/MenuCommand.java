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

import java.util.ArrayList;
import java.util.List;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NonNull @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory gui = Bukkit.createInventory(null, 9, "§8Menu");

            // Heal
            ItemStack healButton = new ItemStack(Material.DIAMOND);
            ItemMeta metaHeal = healButton.getItemMeta();
            metaHeal.setDisplayName("§aHeal");
            List<String> loreHeal = new ArrayList<>();
            loreHeal.add("§7Price: §e50 Coins");
            metaHeal.setLore(loreHeal);
            healButton.setItemMeta(metaHeal);

            // Mystery Box
            ItemStack mBoxButton = new ItemStack(Material.CHEST);
            ItemMeta metaMBox = mBoxButton.getItemMeta();
            metaMBox.setDisplayName("§dMystery Box (Gacha)");
            List<String> loreMBox = new ArrayList<>();
            loreMBox.add("§7Price: §e100 Coins");
            metaMBox.setLore(loreMBox);
            mBoxButton.setItemMeta(metaMBox);

            // Thunder Sword
            ItemStack tSwordButton = new ItemStack(Material.GOLDEN_SWORD);
            ItemMeta metaTSword = tSwordButton.getItemMeta();
            metaTSword.setDisplayName("§e§lThunder Sword");
            List<String> loreTSword = new ArrayList<>();
            loreTSword.add("§7Price: §e300 Coins");
            metaTSword.setLore(loreTSword);
            tSwordButton.setItemMeta(metaTSword);

            // Close
            ItemStack closeButton = new ItemStack(Material.BARRIER);
            ItemMeta metaClose = closeButton.getItemMeta();
            metaClose.setDisplayName("§cClose Menu");
            closeButton.setItemMeta(metaClose);

            gui.setItem(1, healButton);
            gui.setItem(3, mBoxButton);
            gui.setItem(5, tSwordButton);
            gui.setItem(7, closeButton);

            player.openInventory(gui);
        }
        return true;
    }
}
