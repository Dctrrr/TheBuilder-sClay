package the.builders;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public final class BuildersClay extends JavaPlugin {

    @Override
    public void onEnable() {

        Objects.requireNonNull(getCommand("builderclay")).setExecutor(new TheBuildersClayCMD());
        getServer().getPluginManager().registerEvents(new BuildersClayListener(), this);

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