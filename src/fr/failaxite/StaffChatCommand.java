package fr.failaxite;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChatCommand implements CommandExecutor {
  public static ArrayList<Player> one = new ArrayList<>();
  
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
    if (cmd.getName().equalsIgnoreCase("staffchat")) {
      if (!(sender instanceof Player)) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main12.getInstance().getConfig().getString("Sender-Not-A-Player")));
        return true;
      } 
      Player p = (Player)sender;
      if (args.length == 0) {
        if (!p.hasPermission(Main12.getInstance().getConfig().getString("StaffChat-Permission"))) {
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main12.getInstance().getConfig().getString("No-Permission")));
          return true;
        } 
        if (one.contains(p)) {
          one.remove(p);
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main12.getInstance().getConfig().getString("StaffChat-Disabled")));
          return true;
        } 
        one.add(p);
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main12.getInstance().getConfig().getString("StaffChat-Enabled")));
        return true;
      } 
      if (args.length == 1) {
        if (args[0].equalsIgnoreCase("reload")) {
          if (!sender.hasPermission("staffchat.reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lStaffChat &fYou do not have enough permissions to run this command!"));
            return false;
          } 
          Main12.getInstance().reloadConfig();
          Main12.getInstance().getConfig().options().copyDefaults(true);
          Main12.getInstance().saveDefaultConfig();
          Main12.getInstance().saveConfig();
          sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lStaffChat &fConfig reloaded!"));
          return true;
        } 
        return true;
      } 
      if (args.length > 1)
        p.sendMessage(ChatColor.RED + "Incorrect Usage Try /staffchat"); 
    } 
    return false;
  }
}
