package fantuan.two.thth.athletedetector.athleteholder.events;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import fantuan.two.thth.athletedetector.athleteholder.utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickHandler implements Listener {

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {

        if (!AthleteHolder.ins.ifOpen) {
            return;
        }


        if (!AthleteHolder.ins.pPick) {
            return;
        }

        if (AthleteHolder.ins.whiteList.contains(event.getPlayer().getName())) {
            return;
        }

        Player player = event.getPlayer();

        Item item = event.getItem();

        int am =  item.getItemStack().getAmount();


        MessageUtils.sendMessage(player.getName(),
                player.getLocation(),
                "处 拾取了" +ChatColor.YELLOW+ item.getItemStack().getType().name() + " x " + am);


    }
}
