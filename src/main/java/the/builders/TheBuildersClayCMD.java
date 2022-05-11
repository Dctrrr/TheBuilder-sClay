package the.builders;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class TheBuildersClayCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length >= 1) {
            String playerName = args[0];
            Player targetPlayer = Bukkit.getPlayer(playerName);
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                String playerName = args[0];
                player = Bukkit.getPlayer(playerName);
            }

            assert player != null;
            if (player.hasPermission("specialgift.buildersclay")) {
                ItemStack itemStack = new ItemStack(Material.TERRACOTTA);

                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "The Builder's Clay");

                itemMeta.setLore(Arrays.asList(
                        ChatColor.GRAY + "" + ChatColor.ITALIC + "The block which was used to",
                        ChatColor.GRAY + "" + ChatColor.ITALIC + "build the world around you.",
                        " ",
                        ChatColor.DARK_GRAY + "To: " + player.getDisplayName(),
                        ChatColor.DARK_GRAY + "From: " + ChatColor.RED + "[ADMIN] " + ((Player)sender).getDisplayName(),
                        " ",
                        ChatColor.DARK_GRAY + "Edition: Year 2022",
                        " ",
                        ChatColor.RED + "" + ChatColor.BOLD + "SPECIAL"
                ));

                itemStack.setItemMeta(itemMeta);
                player.getInventory().setHelmet(new ItemStack(itemStack));
                player.sendMessage("§eYou have been given a§e §cThe Builder's Clay!§c §e(2022)§e");
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have access to this command!"));
            }
        }
        return true;
    }
}
