package de.signitem.signature.main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import de.signitem.signature.cmd.SignCMD;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Signature extends JavaPlugin {
    public static String prefix;

    public void onEnable() {
        this.loadConfig();
        File SB = new File("plugins/FSign/config.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SB);
        prefix = cfg.getString("messages.prefix").replace("&", "§");
        this.getCommand("sign").setExecutor(new SignCMD());
        this.sendLoadMessage();
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + " §cFSign is now Disabled!");
        Bukkit.getConsoleSender().sendMessage(prefix + " §6" + this.getDescription().getVersion() + " by §2" + this.getDescription().getAuthors());
    }

    private void sendLoadMessage() {
        CommandSender console = Bukkit.getConsoleSender();
        console.sendMessage("§6-------- [FSign] --------");
        console.sendMessage("§bProgrammed by Freestyler431");
        console.sendMessage("§6Version: " + this.getDescription().getVersion());
        console.sendMessage("§4You are not allowed to distribute the plugin further.");
        console.sendMessage("§4You are not allowed to claim the plugin as yours.");
        console.sendMessage("§6-------- [FSign] --------");
    }

    public void loadConfig() {
        File SB = new File("plugins/FSign/config.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SB);
        cfg.addDefault("config.version", 1.1);
        cfg.addDefault("messages.prefix", "&7[&cFSign&7]");
        cfg.addDefault("messages.success", "&aDein Item wurde signiert.");
        cfg.addDefault("messages.ItemSignTrue", "&cDas Item ist bereits signiert.");
        cfg.addDefault("messages.set", "&cBitte nutze: &e/sign <Signierung>");
        cfg.addDefault("messages.noplayer", "You can only run this command from ingame!");
        cfg.addDefault("messages.iteminhand", "&cDu musst ein Item in der Hand haben.");
        cfg.addDefault("signature.lengthmsg", " &cDeine Signierung darf maximal 50 Zeichen lang sein.");
        cfg.addDefault("signature.length", "50");
        cfg.addDefault("signature.lines", "true");
        cfg.addDefault("signature.line", "&7&m------------------------");
        cfg.addDefault("signature.date.format", "eu");
        cfg.addDefault("signature.user.1", "&f&lSigniert von &6Example1 &7| &e%PLAYER% &f&lam &c%DATE%");
        cfg.addDefault("signature.user.2", "&f&lSigniert von &6Example2 &7| &e%PLAYER% &f&lam &c%DATE%");
        cfg.addDefault("signature.user.3", "&f&lSigniert von &6Example3 &7| &e%PLAYER% &f&lam &c%DATE%");
        cfg.addDefault("signature.user.4", "&f&lSigniert von &6Example4 &7| &e%PLAYER% &f&lam &c%DATE%");
        cfg.addDefault("signature.user.5", "&f&lSigniert von &6Example5 &7| &e%PLAYER% &f&lam &c%DATE%");
        cfg.addDefault("signature.user.6", "&f&lSigniert von &6Example6 &7| &e%PLAYER% &f&lam &c%DATE%");
        cfg.addDefault("signature.user.7", "&f&lSigniert von &6Example7 &7| &e%PLAYER% &f&lam &c%DATE%");
        cfg.addDefault("signature.user.8", "&f&lSigniert von &6Example8 &7| &e%PLAYER% &f&lam &c%DATE%");
        cfg.addDefault("Blocked.Message.Sign", "&cDu darfst das Item nicht signieren!");
        cfg.addDefault("Blocked.Items.Blacklisted", Arrays.asList("GRASS", "STONE"));
        cfg.options().copyDefaults(true);

        try {
            cfg.save(SB);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }
}