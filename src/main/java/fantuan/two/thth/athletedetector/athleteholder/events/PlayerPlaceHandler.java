package fantuan.two.thth.athletedetector.athleteholder.events;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import fantuan.two.thth.athletedetector.athleteholder.utils.MessageUtils;
import fantuan.two.thth.athletedetector.athleteholder.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceHandler implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {


        if (!AthleteHolder.ins.ifOpen) {
            return;
        }
        if (AthleteHolder.ins.whiteList.contains(event.getPlayer().getName())) {
            return;
        }

        if (!AthleteHolder.ins.pPlace){
            return;
        }

        Block block = event.getBlockPlaced();

        MessageUtils.sendMessage(event.getPlayer().getName(),
                block.getLocation(),
                "处 放置了" +ChatColor.YELLOW+ block.getType().name());


    }
}
