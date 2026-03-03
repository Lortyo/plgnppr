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
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin TesAja dimatikan. Bye-bye!");    }
}
