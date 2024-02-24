package fantuan.two.thth.athletedetector.athleteholder.events;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import fantuan.two.thth.athletedetector.athleteholder.utils.MessageUtils;
import fantuan.two.thth.athletedetector.athleteholder.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandHandler implements Listener {

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        // 获取玩家


        if (!AthleteHolder.ins.ifOpen) {
            return;
        }
        if (AthleteHolder.ins.whiteList.contains(event.getPlayer().getName())) {
            return;
        }

        if (!AthleteHolder.ins.pUseCommand) {
            return;
        }

        Player player = event.getPlayer();
        String command = event.getMessage();

        MessageUtils.sendMessage(player.getName(),
                player.getLocation(),
                "处 使用了命令" +ChatColor.YELLOW+ "\"" + command + "\"");



    }
}
