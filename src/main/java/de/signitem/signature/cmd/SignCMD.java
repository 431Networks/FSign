package de.signitem.signature.cmd;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SignCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        File file = new File("plugins/FSign/config.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Player p = (Player)sender;
        String prefix = cfg.getString("messages.prefix").replace("&", "§");
        prefix = prefix + " §7";
        String signset = cfg.getString("messages.set").replace("&", "§");
        String getIteminHand = cfg.getString("messages.iteminhand").replace("&", "§");
        String dateform = cfg.getString("signature.date.format").replace("&","§");
        String lines = cfg.getString("signature.lines").replace("&", "§");
        String liness = cfg.getString("signature.line").replace("&", "§");
        String ItemSignTrue = cfg.getString("messages.ItemSignTrue").replace("&", "§");
        String sign = cfg.getString("signature.user.1").replace("&", "§");
        String sign2 = cfg.getString("signature.user.2").replace("&", "§");
        String sign3 = cfg.getString("signature.user.3").replace("&", "§");
        String sign4 = cfg.getString("signature.user.4").replace("&", "§");
        String sign5 = cfg.getString("signature.user.5").replace("&", "§");
        String sign6 = cfg.getString("signature.user.6").replace("&", "§");
        String sign7 = cfg.getString("signature.user.7").replace("&", "§");
        String sign8 = cfg.getString("signature.user.8").replace("&", "§");
        String blockedmsg = cfg.getString("Blocked.Message.Sign").replace("&", "§");
        //-

        if (dateform.equalsIgnoreCase("eu")) {
            String timeStamp = (new SimpleDateFormat("dd.MM.yyyy")).format(Calendar.getInstance().getTime());
            //-
            sign = sign.replace("%PLAYER%", p.getName());
            sign = sign.replace("%DISPLAYNAME%", p.getDisplayName());
            sign = sign.replace("%DATE%", timeStamp);
            //-
            sign2 = sign2.replace("%PLAYER%", p.getName());
            sign2 = sign2.replace("%DISPLAYNAME%", p.getDisplayName());
            sign2 = sign2.replace("%DATE%", timeStamp);
            //-
            sign3 = sign3.replace("%PLAYER%", p.getName());
            sign3 = sign3.replace("%DISPLAYNAME%", p.getDisplayName());
            sign3 = sign3.replace("%DATE%", timeStamp);
            //-
            sign4 = sign4.replace("%PLAYER%", p.getName());
            sign4 = sign4.replace("%DISPLAYNAME%", p.getDisplayName());
            sign4 = sign4.replace("%DATE%", timeStamp);
            //-
            sign5 = sign5.replace("%PLAYER%", p.getName());
            sign5 = sign5.replace("%DISPLAYNAME%", p.getDisplayName());
            sign5 = sign5.replace("%DATE%", timeStamp);
            //-
            sign6 = sign6.replace("%PLAYER%", p.getName());
            sign6 = sign6.replace("%DISPLAYNAME%", p.getDisplayName());
            sign6 = sign6.replace("%DATE%", timeStamp);
            //-
            sign7 = sign7.replace("%PLAYER%", p.getName());
            sign7 = sign7.replace("%DISPLAYNAME%", p.getDisplayName());
            sign7 = sign7.replace("%DATE%", timeStamp);
            //-
            sign8 = sign8.replace("%PLAYER%", p.getName());
            sign8 = sign8.replace("%DISPLAYNAME%", p.getDisplayName());
            sign8 = sign8.replace("%DATE%", timeStamp);
            //-
        }else if (dateform.equalsIgnoreCase("us")){
            String timeStamp = (new SimpleDateFormat("MM/dd/yyyy")).format(Calendar.getInstance().getTime());
            //-
            sign = sign.replace("%PLAYER%", p.getName());
            sign = sign.replace("%DISPLAYNAME%", p.getDisplayName());
            sign = sign.replace("%DATE%", timeStamp);
            //-
            sign2 = sign2.replace("%PLAYER%", p.getName());
            sign2 = sign2.replace("%DISPLAYNAME%", p.getDisplayName());
            sign2 = sign2.replace("%DATE%", timeStamp);
            //-
            sign3 = sign3.replace("%PLAYER%", p.getName());
            sign3 = sign3.replace("%DISPLAYNAME%", p.getDisplayName());
            sign3 = sign3.replace("%DATE%", timeStamp);
            //-
            sign4 = sign4.replace("%PLAYER%", p.getName());
            sign4 = sign4.replace("%DISPLAYNAME%", p.getDisplayName());
            sign4 = sign4.replace("%DATE%", timeStamp);
            //-
            sign5 = sign5.replace("%PLAYER%", p.getName());
            sign5 = sign5.replace("%DISPLAYNAME%", p.getDisplayName());
            sign5 = sign5.replace("%DATE%", timeStamp);
            //-
            sign6 = sign6.replace("%PLAYER%", p.getName());
            sign6 = sign6.replace("%DISPLAYNAME%", p.getDisplayName());
            sign6 = sign6.replace("%DATE%", timeStamp);
            //-
            sign7 = sign7.replace("%PLAYER%", p.getName());
            sign7 = sign7.replace("%DISPLAYNAME%", p.getDisplayName());
            sign7 = sign7.replace("%DATE%", timeStamp);
            //-
            sign8 = sign8.replace("%PLAYER%", p.getName());
            sign8 = sign8.replace("%DISPLAYNAME%", p.getDisplayName());
            sign8 = sign8.replace("%DATE%", timeStamp);
            //-
        }else{
            Bukkit.shutdown();
        }


        //Start
            if (args.length == 0) {
                p.sendMessage(prefix + signset);
                return true;
            }

            if (p.getInventory().getItemInHand().getType().equals(Material.AIR)) {
                sender.sendMessage(prefix + getIteminHand);
                return true;
            }

            Iterator var19 = cfg.getStringList("Blocked.Items.Blacklisted").iterator();

            while(var19.hasNext()) {
                String items = (String)var19.next();
                if (p.getInventory().getItemInHand().getType() == Material.matchMaterial(items)) {
                    sender.sendMessage(prefix + blockedmsg);
                    return true;
                }
            }

            if (p.getInventory().getItemInHand().getAmount() > 1) {
                sender.sendMessage(prefix + "§cDu darfst nur ein Item gleichzeitig signieren.");
                return true;
            }

            StringBuilder builder = new StringBuilder("");

            for(int i = 0; i < args.length; ++i) {
                if (i == args.length - 1) {
                    builder.append(args[i]);
                } else {
                    builder.append(args[i]).append(" ");
                }
            }

            String msg = ChatColor.translateAlternateColorCodes('&', builder.toString());
            String success = cfg.getString("messages.success").replace("&", "§");
            ItemStack item = p.getItemInHand();
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.getLore();
            if (lore != null) {
                p.sendMessage(prefix + ItemSignTrue);
                return true;
            }


            if(p.hasPermission("fsign.sign.1")){
                    List<String> Lore = new ArrayList();
                    Lore.add("");
                    Lore.add(msg);
                    if (lines.equalsIgnoreCase("true")) {
                        Lore.add(liness);
                        Lore.add(sign);
                    } else {
                        Lore.add(sign);
                    }

                    meta.setLore(Lore);
                    item.setItemMeta(meta);
                    p.sendMessage(prefix + success);
        }
        if(p.hasPermission("fsign.sign.2")){
            List<String> Lore = new ArrayList();
            Lore.add("");
            Lore.add(msg);
            if (lines.equalsIgnoreCase("true")) {
                Lore.add(liness);
                Lore.add(sign2);
            } else {
                Lore.add(sign2);
            }

            meta.setLore(Lore);
            item.setItemMeta(meta);
            p.sendMessage(prefix + success);
        }
        if(p.hasPermission("fsign.sign.3")){
            List<String> Lore = new ArrayList();
            Lore.add("");
            Lore.add(msg);
            if (lines.equalsIgnoreCase("true")) {
                Lore.add(liness);
                Lore.add(sign3);
            } else {
                Lore.add(sign3);
            }

            meta.setLore(Lore);
            item.setItemMeta(meta);
            p.sendMessage(prefix + success);
        }
        if(p.hasPermission("fsign.sign.4")){
            List<String> Lore = new ArrayList();
            Lore.add("");
            Lore.add(msg);
            if (lines.equalsIgnoreCase("true")) {
                Lore.add(liness);
                Lore.add(sign4);
            } else {
                Lore.add(sign4);
            }

            meta.setLore(Lore);
            item.setItemMeta(meta);
            p.sendMessage(prefix + success);
        }
        if(p.hasPermission("fsign.sign.5")){
            List<String> Lore = new ArrayList();
            Lore.add("");
            Lore.add(msg);
            if (lines.equalsIgnoreCase("true")) {
                Lore.add(liness);
                Lore.add(sign5);
            } else {
                Lore.add(sign5);
            }

            meta.setLore(Lore);
            item.setItemMeta(meta);
            p.sendMessage(prefix + success);
        }
        if(p.hasPermission("fsign.sign.6")){
            List<String> Lore = new ArrayList();
            Lore.add("");
            Lore.add(msg);
            if (lines.equalsIgnoreCase("true")) {
                Lore.add(liness);
                Lore.add(sign6);
            } else {
                Lore.add(sign6);
            }

            meta.setLore(Lore);
            item.setItemMeta(meta);
            p.sendMessage(prefix + success);
        }
        if(p.hasPermission("fsign.sign.7")){
            List<String> Lore = new ArrayList();
            Lore.add("");
            Lore.add(msg);
            if (lines.equalsIgnoreCase("true")) {
                Lore.add(liness);
                Lore.add(sign7);
            } else {
                Lore.add(sign7);
            }

            meta.setLore(Lore);
            item.setItemMeta(meta);
            p.sendMessage(prefix + success);
        }
        if(p.hasPermission("fsign.sign.8")){
            List<String> Lore = new ArrayList();
            Lore.add("");
            Lore.add(msg);
            if (lines.equalsIgnoreCase("true")) {
                Lore.add(liness);
                Lore.add(sign8);
            } else {
                Lore.add(sign8);
            }

            meta.setLore(Lore);
            item.setItemMeta(meta);
            p.sendMessage(prefix + success);
        }

        return false;
    }
}