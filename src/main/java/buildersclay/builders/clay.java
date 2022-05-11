package buildersclay.builders;

import buildersclay.builders.claycmd;
import buildersclay.builders.claylistener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public final class clay extends JavaPlugin {

    @Override
    public void onEnable() {

        Objects.requireNonNull(getCommand("builderclay")).setExecutor(new claycmd());
        getServer().getPluginManager().registerEvents(new claylistener(), this);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {

                    ItemStack item = player.getInventory().getHelmet();

                    if(item == null) return;
                    if (!item.hasItemMeta()) return;
                    if( item.getItemMeta().getDisplayName() == null) return;

                    ItemMeta meta = item.getItemMeta();
                    String ItemName = item.getItemMeta().getDisplayName();
                    if (ItemName.equals(ChatColor.RED + "The Builder's Clay")) {
                        item.setItemMeta(meta);
                    }
                }
            }
        }.runTaskTimer(this, 20, 20);
    }
}