package stanic.zclobby.utils;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Messages {

    public void sendTitle(Player player, String title, String subTitle) {
        CraftPlayer craftPlayer = (CraftPlayer) player;
        PlayerConnection connection = craftPlayer.getHandle().playerConnection;

        IChatBaseComponent titleJson = IChatBaseComponent.ChatSerializer.a("{'text': '" + title + "'}");
        IChatBaseComponent subTitleJson = IChatBaseComponent.ChatSerializer.a("{'text': '" + subTitle + "'}");

        Packet titlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleJson, 1, 25, 25);
        Packet subTitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subTitleJson);

        connection.sendPacket(titlePacket);
        connection.sendPacket(subTitlePacket);
    }

    public void sendActionBar(Player player, String message) {
        CraftPlayer craftPlayer = (CraftPlayer) player;
        PlayerConnection connection = craftPlayer.getHandle().playerConnection;

        Packet packet = new PacketPlayOutChat(new ChatComponentText(message), (byte) 2);

        connection.sendPacket(packet);
    }

}