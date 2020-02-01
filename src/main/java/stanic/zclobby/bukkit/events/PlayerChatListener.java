package stanic.zclobby.bukkit.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setFormat("§b§lLOBBY §a| §f" + event.getPlayer().getName() + " §8: §7" + event.getMessage());
    }

}
