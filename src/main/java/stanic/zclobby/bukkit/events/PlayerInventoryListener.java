package stanic.zclobby.bukkit.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import stanic.zclobby.Main;
import stanic.zclobby.utils.ItemBuilder;
import stanic.zclobby.utils.Messages;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PlayerInventoryListener implements Listener {

    @EventHandler
    public void onClickInServers(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();
        Integer slot = event.getSlot();

        if (inventory.getTitle().equals("§aServers")) {
            switch (slot) {
                case 12:
                    player.closeInventory();
                case 13:
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

                    try {
                        dataOutputStream.writeUTF("Connect");
                        dataOutputStream.writeUTF("CrazyServer");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.sendPluginMessage(Main.instance, "BungeeCord", byteArrayOutputStream.toByteArray());
                case 14:
                    ItemStack item = new ItemBuilder(Material.STICK).setName("§aNão clique em mim").build();
                    player.getInventory().addItem(item);
                    player.closeInventory();
                    new Messages().sendActionBar(player, "§eClica no stick kkkkkkkkkkkkkk");
            }
        }
    }

}