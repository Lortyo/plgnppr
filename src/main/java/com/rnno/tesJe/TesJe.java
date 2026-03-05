package com.rnno.tesJe;

import com.rnno.tesJe.commands.BossCommand;
import com.rnno.tesJe.commands.HelloCommand;
import com.rnno.tesJe.commands.MenuCommand;
import com.rnno.tesJe.commands.WandCommand;
import com.rnno.tesJe.events.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class TesJe extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Halo! Plugin TesAja berhasil aktif!");

        saveDefaultConfig();

        getCommand("hello").setExecutor(new HelloCommand());
        getCommand("wand").setExecutor(new WandCommand());
        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("boss").setExecutor(new BossCommand());

        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        getServer().getPluginManager().registerEvents(new WandListener(), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new BossDeathListener(), this);
        getServer().getPluginManager().registerEvents(new WeaponListener(), this);

        new org.bukkit.scheduler.BukkitRunnable() {
            @Override
            public void run() {
                for (org.bukkit.entity.Player p : org.bukkit.Bukkit.getOnlinePlayers()) {
                    updateScoreBoard(p);
                }
            }
        }.runTaskTimer(this, 0, 40L);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin TesAja dimatikan. Bye-bye!");
    }

    public void updateScoreBoard(org.bukkit.entity.Player player) {
        org.bukkit.scoreboard.ScoreboardManager manager = org.bukkit.Bukkit.getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();

        org.bukkit.scoreboard.Objective obj = board.registerNewObjective("Info", "dummy", "§6§lTESJE SERVER");
        obj.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);

        int money = getConfig().getInt("coin." + player.getUniqueId(), 0);

        obj.getScore(" ").setScore(3);
        obj.getScore("§fMoney: §e" + money + " Coins").setScore(2);
        obj.getScore(" ").setScore(1);

        player.setScoreboard(board);
    }
}
