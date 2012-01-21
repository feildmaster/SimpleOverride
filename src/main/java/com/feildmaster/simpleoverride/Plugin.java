package com.feildmaster.simpleoverride;

import org.bukkit.event.*;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin implements Listener {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    public void onDisable() {}

    @EventHandler(priority = EventPriority.MONITOR)
    public void login(PlayerLoginEvent event) {
        Result result = event.getResult();
        if(result == Result.ALLOWED ||
            (result == Result.KICK_BANNED && !event.getPlayer().hasPermission("Override.BAN"))) return;
        else if(!event.getPlayer().hasPermission("Override")) return;
        
        event.setResult(Result.ALLOWED);
    }
}
