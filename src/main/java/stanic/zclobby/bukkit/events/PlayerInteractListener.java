package stanic.zclobby.bukkit.events;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import stanic.zclobby.Main;
import stanic.zclobby.task.CrazyEffect;
import stanic.zclobby.utils.ItemBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getItemInHand() != null) {
            if (player.getItemInHand().getType() == Material.STICK) {
                if (!event.hasBlock()) player.sendMessage("§cClica em um bloco");
                else {
                    player.sendMessage("§aComecei o negócio olha aí");

                    new CrazyEffect(player, event.getClickedBlock(), 2.0, 6.0).runTaskTimer(Main.instance, 0L, 10L);
                }
            }

            return;
        }

        if (player.getItemInHand().getType() == Material.POTATO) {
            switch (player.getItemInHand().getItemMeta().getDisplayName()) {
                case "§aBatatas":
                    ItemStack item = new ItemBuilder(Material.CHEST).setName("§aMe ponha no chão").build();
                    player.getInventory().addItem(item);
                case "§aClica em mim":
                    Inventory inv = Bukkit.createInventory(null, 3 * 9, "§aServers");
                    inv.setItem(12, new ItemBuilder(Material.APPLE).setName("§aVá para o servidor louco").build());
                    inv.setItem(13, new ItemBuilder(Material.ANVIL).setName("§aFecha o inventário").build());
                    inv.setItem(14, new ItemBuilder(Material.BARRIER).setName("§aNão faz nada").build());

                    player.openInventory(inv);
                case "§aClica no do lado nãokkkkkkkk":
                    player.getInventory().clear();
                    player.kickPlayer("§aSe fodeu kkkkkkkkkkkk");
            }

            return;
        }

        if (event.hasBlock() && event.getClickedBlock().hasMetadata("chestdositems")) {
            event.setCancelled(true);

            Inventory inv = Bukkit.createInventory(null, 54, "§aSeus items");
            Type type = new TypeToken<ArrayList<ItemStack>>() {
            }.getType();

            ArrayList<ItemStack> items = new Gson().fromJson(Main.instance.items.get(player.getName()), type);
            for (ItemStack item : items) inv.addItem(item);

            Main.instance.items.remove(player.getName());
            player.openInventory(inv);
        }
    }

}