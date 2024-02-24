package fantuan.two.thth.athletedetector.athleteholder.events;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OpQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (AthleteHolder.ins.opsOnList.contains(event.getPlayer().getName())){
            AthleteHolder.ins.opsOnList.remove(event.getPlayer().getName());
        }
    }
}
