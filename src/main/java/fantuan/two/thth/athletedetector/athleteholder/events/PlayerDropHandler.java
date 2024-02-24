package fantuan.two.thth.athletedetector.athleteholder.events;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import fantuan.two.thth.athletedetector.athleteholder.utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;

public class PlayerDropHandler implements Listener {

    @EventHandler
    public void onPlayerDropItem(EntityDropItemEvent event) {

        if (!AthleteHolder.ins.ifOpen) {
            return;
        }
        if (!(event.getEntity() instanceof Player)){
            return;
        }

        if (!AthleteHolder.ins.pThrow) {
            return;
        }

        if (AthleteHolder.ins.whiteList.contains(event.getEntity().getName())) {
            return;
        }

        Player player =  (Player) event.getEntity();

        Item item = event.getItemDrop();

        int am =  item.getItemStack().getAmount();

        MessageUtils.sendMessage(player.getName(),
                player.getLocation(),
                "处 丢出了" +ChatColor.YELLOW+ item.getItemStack().getType().name() + " x " + am);
    }
}
