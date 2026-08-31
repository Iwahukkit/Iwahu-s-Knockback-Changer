package me.iwahu.kbc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
public class IwahusKnockbackChanger extends JavaPlugin implements Listener, CommandExecutor {

    private double horizontal;
    private double vertical;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfigValues();

        getServer().getPluginManager().registerEvents(this, this);
        getCommand("ikb").setExecutor(this);

        getLogger().info("Iwahu's Knockback Changer has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Iwahu's Knockback Changer has been disabled!");
    }

    public void loadConfigValues() {
        reloadConfig();

        horizontal = getConfig().getDouble("knockback.horizontal", 0.38);
        vertical = getConfig().getDouble("knockback.vertical", 0.36);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) return;
        if (!(event.getDamager() instanceof Player)) return;

        Entity damaged = event.getEntity();
        if (damaged instanceof Player) {
            Player damager = (Player) event.getDamager();
            Player target = (Player) damaged;


            Bukkit.getScheduler().runTaskLater(this, () -> {
                if (target.isDead()) return;


                Vector direction = damager.getLocation().getDirection();
                direction.setY(0).normalize();

                double x = direction.getX() * horizontal;
                double z = direction.getZ() * horizontal;
                double y = vertical;


                if (!target.isOnGround()) {
                    y = vertical * 0.65;
                }

                Vector finalVelocity = new Vector(x, y, z);
                target.setVelocity(finalVelocity);
            }, 1L);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ikb")) {
            if (!sender.hasPermission("iwahukb.admin")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return true;
            }

            if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
                loadConfigValues();
                sender.sendMessage(ChatColor.GREEN + "Iwahu's Knockback Changer config file has been reloaded!");
                return true;
            }

            sender.sendMessage(ChatColor.YELLOW + "--- Iwahu's Knockback Changer ---");
            sender.sendMessage(ChatColor.GRAY + "Horizontal Multiplier: " + ChatColor.WHITE + horizontal);
            sender.sendMessage(ChatColor.GRAY + "Vertical Multiplier: " + ChatColor.WHITE + vertical);
            sender.sendMessage(ChatColor.GRAY + "To reload: " + ChatColor.GOLD + "/ikb reload");
            return true;
        }
        return false;
    }
}