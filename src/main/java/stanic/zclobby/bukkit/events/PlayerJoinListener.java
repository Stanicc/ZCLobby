package stanic.zclobby.bukkit.events;

import net.minecraft.server.v1_8_R3.Item;
import net.minecraft.server.v1_8_R3.ItemCarrotStick;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import stanic.zclobby.utils.ItemBuilder;
import stanic.zclobby.utils.Messages;

import java.lang.reflect.Field;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        try {
            Field field = Item.class.getDeclaredField("maxStackSize");
            field.setAccessible(true);
            field.setInt(new ItemCarrotStick(), 1);
        } catch (Exception e) { e.printStackTrace(); }

        player.getInventory().addItem(new ItemBuilder(Material.CARROT).setName("§aBatatas").build());
        player.getInventory().addItem(new ItemBuilder(Material.CARROT).setName("§aClica em mim").build());
        player.getInventory().addItem(new ItemBuilder(Material.CARROT).setName("§aClica no do lado nãokkkkkkkk").build());

        new Messages().sendTitle(player, "§aWelcome kkkkk", "§e§rCrazyServer");
    }

}