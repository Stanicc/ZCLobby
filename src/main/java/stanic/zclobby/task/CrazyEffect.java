package stanic.zclobby.task;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CrazyEffect extends BukkitRunnable {

    private Player player;
    private Block block;
    private Double start;
    private Double end;

    public CrazyEffect(Player player, Block block, Double start, Double end) {
        this.player = player;
        this.block = block;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        Double angle = 0.0;

        while (angle < 2 * Math.PI) {
            Double x = 2 * Math.cos(angle);
            Double z = 2 * Math.cos(angle);

            Location spawnLocation = block.getLocation().add(x, 0.0, z);
            spawnLocation.getWorld().playEffect(spawnLocation, Effect.FLAME, 1);
            spawnLocation.getWorld().playEffect(spawnLocation, Effect.FLAME, 2);
            spawnLocation.getWorld().playEffect(spawnLocation, Effect.FLAME, 3);
            spawnLocation.getWorld().playEffect(spawnLocation, Effect.EXPLOSION_LARGE, 1);
            spawnLocation.getWorld().playEffect(spawnLocation, Effect.PORTAL, 1);
            block.getLocation().subtract(x, 0.0, z);
            angle += Math.PI / 36;
        }

        start += 2;

        if (start > end) {
            player.sendMessage("§aCompletei o negócio kkkkkkkkkkkkkkk");
            block.setType(Material.TNT);
            this.cancel();
        }
    }

}