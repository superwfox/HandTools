package sudark2.Sudark.handTools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

import static sudark2.Sudark.handTools.HandTools.get;

public class SkulkerBox implements Listener {

    static HashMap<UUID, ShulkerSession> shulkerSessionMap = new HashMap<>();

    static void isShulkerBox(Player pl) {
        ItemStack m = pl.getItemInHand();
        if (!m.getType().name().endsWith("SHULKER_BOX")) return;

        BlockStateMeta meta = (BlockStateMeta) m.getItemMeta();
        ShulkerBox box = (ShulkerBox) meta.getBlockState();

        Inventory inv = Bukkit.createInventory(pl, 27, "§r潜影盒");

        // 复制潜影盒内容到新 GUI
        for (int i = 0; i < box.getInventory().getSize(); i++) {
            inv.setItem(i, box.getInventory().getItem(i));
        }

        // 保存到临时缓存以便同步
        shulkerSessionMap.put(pl.getUniqueId(), new ShulkerSession(m, inv));
        pl.openInventory(inv);

    }

    private void syncShulker(Player player, ShulkerSession session) {
        ItemMeta meta = session.item.getItemMeta();
        if (!(meta instanceof BlockStateMeta bsm)) return;
        if (!(bsm.getBlockState() instanceof ShulkerBox box)) return;

        // 将 GUI 内容写入潜影盒内部
        Inventory inv = session.inv;
        for (int i = 0; i < box.getInventory().getSize(); i++) {
            box.getInventory().setItem(i, inv.getItem(i));
        }

        // 写回元数据
        bsm.setBlockState(box);
        session.item.setItemMeta(bsm);

        player.getInventory().setItemInMainHand(session.item);
    }

    public boolean isShulkerBoxType(Material m) {
        return m.name().endsWith("SHULKER_BOX");
    }

    @EventHandler
    public void onSkulkerBoxClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equals("§r潜影盒")) return;

        Player pl = (Player) e.getWhoClicked();

       new BukkitRunnable(){
           @Override
           public void run() {
               if (pl.getItemInHand().getType() == Material.AIR) {
                   pl.closeInventory();
                   e.setCancelled(true);
               }else {
                   UUID uuid = pl.getUniqueId();
                   ShulkerSession session = shulkerSessionMap.get(uuid);
                   syncShulker(pl, session);
               }
           }
       }.runTaskLater(get(),1L);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (!e.getView().getTitle().equals("§r潜影盒")) return;

        Player player = (Player) e.getPlayer();
        UUID uuid = player.getUniqueId();
        ShulkerSession session = shulkerSessionMap.remove(uuid);
        if (session != null) {
            syncShulker(player, session);
        }
    }

}
