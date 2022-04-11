package ltd.matrix.basic;

import co.aikar.commands.BukkitCommandManager;
import co.aikar.commands.MessageType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import lombok.Getter;
import ltd.matrix.basic.commands.*;
import ltd.matrix.basic.redis.backend.PacketHandler;
import ltd.matrix.basic.utils.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Basic extends JavaPlugin {
    @Getter private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().setLongSerializationPolicy(LongSerializationPolicy.STRING).create();


    @Getter private static Basic instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        //PacketHandler.init();

        //ACF Bs
        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new FlyCommand());
        manager.registerCommand(new MsgCommand());
        manager.registerCommand(new RCommand());
        manager.registerCommand(new BroadcastCommand());
        manager.registerCommand(new FeedCommand());
        manager.registerCommand(new HealCommand());
        manager.registerCommand(new GMACommand());
        manager.registerCommand(new GMSCommand());
        manager.registerCommand(new GMCCommand());
        manager.registerCommand(new MoreCommand());
        manager.registerCommand(new RawCommand());
        manager.registerCommand(new ReportCommand());
        manager.registerCommand(new RequestCommand());
        manager.registerCommand(new SlayCommand());
        manager.registerCommand(new TPCommand());
        manager.registerCommand(new InvseeCommand());
        manager.registerCommand(new TPHereCommand());
        manager.registerCommand(new SuicideCommand());
        manager.registerCommand(new SayCommand());
        manager.registerCommand(new RepairCommand());
        manager.registerCommand(new TargetOffSetCommand());
        manager.registerCommand(new RenameCommand());
        Cooldown.createCooldown("request");
        Cooldown.createCooldown("report");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
