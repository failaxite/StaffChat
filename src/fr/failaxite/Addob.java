package fr.failaxite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Addob implements Listener {
  @EventHandler
  public void onChat(AsyncPlayerChatEvent e) {
    Player p = e.getPlayer();
    String Prefix = ChatColor.translateAlternateColorCodes('&', Main12.getInstance().getConfig().getString("StaffChat-Prefix"));
    String msgcolor = ChatColor.translateAlternateColorCodes('&', Main12.getInstance().getConfig().getString("StaffChat-Message-Color"));
    String Suffix = ChatColor.translateAlternateColorCodes('&', Main12.getInstance().getConfig().getString("StaffChat-Suffix"));
    String msg = e.getMessage();
    if (StaffChatCommand.one.contains(p)) {
      e.setCancelled(true);
      for (Player staff : Bukkit.getServer().getOnlinePlayers()) {
        if (staff.hasPermission(Main12.getInstance().getConfig().getString("StaffChat-Permission")))
          staff.sendMessage(String.valueOf(Prefix) + p.getDisplayName() + Suffix + msgcolor + msg); 
      } 
    } 
  }
}
