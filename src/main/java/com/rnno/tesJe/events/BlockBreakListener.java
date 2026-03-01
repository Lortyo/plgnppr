package com.rnno.tesJe.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onDirtBreak(BlockBreakEvent e){
        if (e.getBlock().getType() == Material.DIRT) {
            e.setDropItems(false);
            ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), diamond);
            e.getPlayer().sendMessage("§bLucky! You found a Diamond in the dirt!");
        }
    }
}
