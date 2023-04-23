package ru.belyimedved.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.entity.Player;
import ru.belyimedved.Beber0task;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Configuration config = Beber0task.getInstance().getConfig();
        Player player = event.getPlayer();
        String msg = null;
        for(String key : config.getConfigurationSection("prefix").getKeys(false)) {
            if(player.hasPermission("group."+key)){
                msg = config.getString("prefix."+key) + " " + player.getName() + ": " + event.getMessage();
            }
        }

        msg = ChatColor.translateAlternateColorCodes('&', msg);
        Bukkit.broadcastMessage(msg);
        event.setCancelled(true);
    }

}
