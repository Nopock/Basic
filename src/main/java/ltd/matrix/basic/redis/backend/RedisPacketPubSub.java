package ltd.matrix.basic.redis.backend;


import lombok.NoArgsConstructor;
import ltd.matrix.basic.Basic;
import org.bukkit.Bukkit;
import redis.clients.jedis.JedisPubSub;

@NoArgsConstructor
public class RedisPacketPubSub extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        Class<?> packetClass;
        int packetMessageSplit = message.indexOf("||");
        String packetClassStr = message.substring(0, packetMessageSplit);
        String messageJson = message.substring(packetMessageSplit + "||".length());
        try {
            packetClass = Class.forName(packetClassStr);
        }
        catch (ClassNotFoundException ignored) {
            return;
        }
        RedisPacket packet = (RedisPacket) Basic.getGson().fromJson(messageJson, packetClass);
        if (Basic.getInstance().isEnabled()) {
            Bukkit.getScheduler().runTask(Basic.getInstance(), packet::onReceive);
        }
    }
}
