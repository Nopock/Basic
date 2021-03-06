package ltd.matrix.basic.redis.backend;

import ltd.matrix.basic.Basic;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class PacketHandler {

    private static String GLOBAL_MESSAGE_CHANNEL;
    static final String PACKET_MESSAGE_DIVIDER = "||";
    public static JedisPool jedispool;

    public static void init() {
        FileConfiguration config = Basic.getInstance().getConfig();
        GLOBAL_MESSAGE_CHANNEL = config.getString("packetChannel", "Packet:ALL");
        JedisPool pool = new JedisPool(new JedisPoolConfig(), Basic.getInstance().getConfig().getString("jedis.host"), Basic.getInstance().getConfig().getInt("jedis.port"), 0, (Basic.getInstance().getConfig().getString("jedis.user").equals("") ? null : Basic.getInstance().getConfig().getString("jedis.user")), Boolean.parseBoolean((Basic.getInstance().getConfig().getString("jedis.pass").equals("") ? null : Basic.getInstance().getConfig().getString("jedis.pass"))));
        connectToServer(pool);
        jedispool = pool;
    }

    public static void connectToServer(JedisPool connectTo) {
        Thread subscribeThread = new Thread(() -> {
            while (Basic.getInstance().isEnabled()) {
                try {
                    Jedis jedis = connectTo.getResource();
                    Throwable throwable = null;
                    try {
                        RedisPacketPubSub pubSub = new RedisPacketPubSub();
                        String channel = GLOBAL_MESSAGE_CHANNEL;
                        jedis.subscribe(pubSub, channel);
                    }
                    catch (Throwable pubSub) {
                        throwable = pubSub;
                        throw pubSub;
                    }
                    finally {
                        if (jedis == null) continue;
                        if (throwable != null) {
                            try {
                                jedis.close();
                            }
                            catch (Throwable pubSub) {
                                throwable.addSuppressed(pubSub);
                            }
                            continue;
                        }
                        jedis.close();
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Compact - jedis thread");
        subscribeThread.setDaemon(true);
        subscribeThread.start();
    }

    public static void sendToAll(RedisPacket packet) {
        PacketHandler.send(packet, jedispool);
    }


    public static void send(RedisPacket packet, JedisPool sendOn) {
        Bukkit.getScheduler().runTaskAsynchronously(Basic.getInstance(), () -> {
            try (Jedis jedis = sendOn.getResource()){
                String encodedPacket = packet.getClass().getName() + PACKET_MESSAGE_DIVIDER + Basic.getGson().toJson(packet);
                jedis.publish(GLOBAL_MESSAGE_CHANNEL, encodedPacket);
            }
        });
    }

    private PacketHandler() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
