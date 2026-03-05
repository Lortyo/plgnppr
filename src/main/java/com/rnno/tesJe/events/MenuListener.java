package com.rnno.tesJe.events;

import com.rnno.tesJe.TesJe;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (e.getView().getTitle().equals("§8Menu")) {
            e.setCancelled(true);

            if (e.getCurrentItem() == null) return;
            Player p = (Player) e.getWhoClicked();

            org.bukkit.plugin.java.JavaPlugin plugin = org.bukkit.plugin.java.JavaPlugin.getPlugin(TesJe.class);
            String moneyLine = "coin." + p.getUniqueId();
            int moneyNow = plugin.getConfig().getInt(moneyLine, 0);

            // heal
            if (e.getCurrentItem().getType() == Material.DIAMOND) {
                if (moneyNow >= 50) {
                    plugin.getConfig().set(moneyLine, moneyNow - 50);
                    plugin.saveConfig();
                    p.setHealth(20.0);
                } else {
                    p.sendMessage("§cNot enough coins!");
                }
            }

            else if (e.getCurrentItem().getType() == Material.CHEST) {
                if (moneyNow >= 100) {
                    plugin.getConfig().set(moneyLine, moneyNow - 100);

                    int lucky = new java.util.Random().nextInt(100) + 1;

                    if (lucky <= 50) {
                        p.sendMessage("§cYou get a dirt!");
                        p.getInventory().addItem(new ItemStack(Material.DIRT,1));
                    } else if (lucky <= 85) {
                        p.sendMessage("§aYou get 200 Coins");
                        plugin.getConfig().set(moneyLine, (moneyNow - 100) + 200);
                    } else {
                        p.sendMessage("§d§lJACKPOT! You get 3 Diamond Block");
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK,3));
                        // e.getWhoClicked().getServer().broadcastMessage("§d§l" + p.getName() + " Win a JACKPOT Gacha!");
                    }
                    plugin.saveConfig();
                    p.closeInventory();
                } else {
                    p.sendMessage("§cNot enough coins!");
                }
            } else if (e.getCurrentItem().getType() == Material.GOLDEN_SWORD) {
                if (moneyNow >= 300) {
                    plugin.getConfig().set(moneyLine, moneyNow - 300);
                    plugin.saveConfig();

                    ItemStack sword = new ItemStack(Material.GOLDEN_SWORD);
                    ItemMeta meta = sword.getItemMeta();
                    meta.setDisplayName("§e§lThunder Sword");
                    sword.setItemMeta(meta);

                    p.getInventory().addItem(sword);
                } else {
                    p.sendMessage("§cNot enough coins!");
                }
            } else if (e.getCurrentItem().getType() == Material.BARRIER) {
                p.closeInventory();
            }
        }
    }
}
