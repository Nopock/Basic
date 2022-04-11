package ltd.matrix.basic.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Flags;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ltd.matrix.basic.Basic;
import ltd.matrix.basic.redis.backend.PacketHandler;
import ltd.matrix.basic.redis.frontend.impl.MessageToStaffPacket;
import ltd.matrix.basic.utils.CC;
import ltd.matrix.basic.utils.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

@CommandAlias("report")
public class ReportCommand extends BaseCommand {

    @Default
    public void onMultiChannelReportCommand(Player player, @Flags("other")Player target, String reason) {
        if (Cooldown.isOnCooldown("report", player)) {
            player.sendMessage(CC.translate("&cYou can only use this command once every &l2 &cminutes."));
            return;
        }
        player.sendMessage(CC.translate("&aWe have received your report."));
        Cooldown.addCooldown("report", player, 120);
        String first = CC.translate("&9[Report] &b[" + Basic.getInstance().getConfig().getString("servername") + "] &r"+ player.getDisplayName() + " &7has reported " + target.getDisplayName() + " &7for &f" + reason + "&7.");
        //PacketHandler.sendToAll(new MessageToStaffPacket(first));
        Bukkit.getOnlinePlayers().stream().filter(p -> p.hasPermission("basic.staff")).forEach(p -> p.sendMessage(first));
    }
}
