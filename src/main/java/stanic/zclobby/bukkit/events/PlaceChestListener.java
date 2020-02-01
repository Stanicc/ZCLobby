package stanic.zclobby.bukkit.events;

import com.google.gson.Gson;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;
import stanic.zclobby.Main;

public class PlaceChestListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.CHEST) {
            block.setMetadata("chestdositems", new FixedMetadataValue(Main.instance, "KKKKKK"));
            Main.instance.items.put(event.getPlayer().getName(), new Gson().toJson(event.getPlayer().getInventory().getContents()));

            event.getPlayer().getInventory().clear();
            event.getPlayer().sendMessage("§aBesta, perdeu os itens kkkkkkkkkkkkkk");
        }
    }

}