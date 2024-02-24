package fantuan.two.thth.athletedetector.athleteholder.events;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import fantuan.two.thth.athletedetector.athleteholder.utils.MessageUtils;
import fantuan.two.thth.athletedetector.athleteholder.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakHandler implements Listener {
    @EventHandler
    public void onDestroy(BlockBreakEvent event) {
        if (!AthleteHolder.ins.ifOpen) {
            return;
        }
        if (AthleteHolder.ins.whiteList.contains(event.getPlayer().getName())) {
            return;
        }

        if (!AthleteHolder.ins.pDestroy){
            return;
        }


        Block block = event.getBlock();


        MessageUtils.sendMessage(event.getPlayer().getName(), block.getLocation(), "处 破坏了"
                + ChatColor.YELLOW+ block.getType().name());


    }
}
