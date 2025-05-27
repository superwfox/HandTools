package sudark2.Sudark.handTools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import static sudark2.Sudark.handTools.SkulkerBox.isShulkerBox;

public final class HandTools extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new HandToolListener(), this);
        Bukkit.getPluginManager().registerEvents(new SkulkerBox(), this);
    }

    public class HandToolListener implements org.bukkit.event.Listener {

        @EventHandler
        public void onHandToolUse(org.bukkit.event.player.PlayerToggleSneakEvent event) {
            Player pl = event.getPlayer();
            if (pl.isSneaking()) {
                switch (pl.getItemInHand().getType()){
                    case CRAFTING_TABLE -> pl.openWorkbench(null, true);
                    case ANVIL -> pl.openAnvil(null, true);
                    default -> isShulkerBox(pl);
                }
            }

        }
    }

    public static Plugin get(){
        return Bukkit.getPluginManager().getPlugin("HandTools");
    }
}
