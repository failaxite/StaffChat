package fr.failaxite;


import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main12 extends JavaPlugin implements Listener {
  private static Main12 instance;
  
  public static Main12 getInstance() {
    return instance;
  }
  
  public void onEnable() {
    getCommand("staffchat").setExecutor(new StaffChatCommand());
    registerEvents();
    loadConfig();
    instance = this;
  }
  
  public void onDisable() {
    instance = null;
  }
  
  public void registerEvents() {
    PluginManager pm = Bukkit.getServer().getPluginManager();
    pm.registerEvents(new Addob(), (Plugin)this);
    pm.registerEvents(new Mention(), (Plugin)this);
  }
  
  private void loadConfig() {
    File configFile = new File(getDataFolder(), "config.yml");
    if (!configFile.exists()) {
      getServer().getConsoleSender().sendMessage("Creating Config...");
      saveDefaultConfig();
    } else {
      getServer().getConsoleSender().sendMessage("Config already made, loading config...");
    } 
  }
}
