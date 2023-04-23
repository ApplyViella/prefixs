package ru.belyimedved;

import org.bukkit.plugin.java.JavaPlugin;
import ru.belyimedved.listener.ChatListener;

public final class Beber0task extends JavaPlugin {

    private static Beber0task instance;
    public static Beber0task getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
