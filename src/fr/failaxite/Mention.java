package fr.failaxite;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Mention implements Listener {
  String Prefix = ChatColor.translateAlternateColorCodes('&', "&bGlacierStaff ");
  
  @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
  public void onChat(AsyncPlayerChatEvent e) {
    for (Player p : e.getRecipients()) {
      if (e.getMessage().toLowerCase().contains("@staff")) {
        if (p.hasPermission(Main12.getInstance().getConfig().getString("Staff-Help-Request-Permission"))) {
          e.setCancelled(true);
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main12.getInstance().getConfig().getString("Player-Requested-Help")));
        } else {
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main12.getInstance().getConfig().getString("No-Permission-Request-Request")));
        } 
        if (p.hasPermission(Main12.getInstance().getConfig().getString("Staff-Receive-Help-Permission"))) {
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main12.getInstance().getConfig().getString("Staff-Received-Help-Request").replace("{player}", e.getPlayer().getName())));
          p.playSound(p.getLocation(), Sound.NOTE_PLING, 10.0F, 10.0F);
          return;
        } 
      } 
    } 
  }
}
