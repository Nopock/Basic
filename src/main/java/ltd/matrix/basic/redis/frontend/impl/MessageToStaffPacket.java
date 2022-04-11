package ltd.matrix.basic.redis.frontend.impl;

import ltd.matrix.basic.redis.backend.RedisPacket;
import ltd.matrix.basic.utils.CC;
import org.bukkit.Bukkit;

public class MessageToStaffPacket implements RedisPacket {
    public String message;
    public MessageToStaffPacket(String message) {
        this.message = message;
    }

    @Override
    public void onReceive() {
        Bukkit.getOnlinePlayers().stream().filter(p -> p.hasPermission("basic.staff")).forEach(p -> p.sendMessage(CC.translate(message)));
    }
}
