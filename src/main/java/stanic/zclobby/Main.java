package stanic.zclobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import stanic.zclobby.bukkit.events.*;

import java.util.HashMap;

public class Main extends JavaPlugin {

    public static Main instance;

    public HashMap<String, String> items = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new PlaceChestListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);

        Bukkit.getConsoleSender().sendMessage("§aAtivei");
    }

}