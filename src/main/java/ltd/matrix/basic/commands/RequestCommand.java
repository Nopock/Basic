package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import ltd.matrix.basic.Basic;
import ltd.matrix.basic.redis.backend.PacketHandler;
import ltd.matrix.basic.redis.frontend.impl.MessageToStaffPacket;
import ltd.matrix.basic.utils.CC;
import ltd.matrix.basic.utils.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("request|helpop")
public class RequestCommand extends BaseCommand {
    @Default
    public void onMultiChannelRequestCommand(Player player, String message) {
        if (Cooldown.isOnCooldown("request", player)) {
            player.sendMessage(CC.translate("&cYou can only use this command once every &l2 &cminutes."));
            return;
        }//TODO: Make messages and make report.
        Cooldown.addCooldown("request", player, 120);
        player.sendMessage(CC.translate("&aWe have received your request."));
        String first = CC.translate("&9[Request] &b[" + Basic.getInstance().getConfig().getString("servername") + "] &r"+ player.getDisplayName() + " &7has requested assistance: &f" + message);
        //PacketHandler.sendToAll(new MessageToStaffPacket(first));
        Bukkit.getOnlinePlayers().stream().filter(p -> p.hasPermission("basic.staff")).forEach(p -> p.sendMessage(first));

    }
}
