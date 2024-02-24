package fantuan.two.thth.athletedetector.athleteholder.events;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import fantuan.two.thth.athletedetector.athleteholder.utils.MessageUtils;
import fantuan.two.thth.athletedetector.athleteholder.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.projectiles.ProjectileSource;

public class PlayerShootHandler implements Listener {
    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        // 获取投掷物

        if (!AthleteHolder.ins.ifOpen) {
            return;
        }

        if (!AthleteHolder.ins.pShoot){
            return;
        }

        Projectile projectile = event.getEntity();
        ProjectileSource shooter = projectile.getShooter();

        if (!(shooter instanceof Player)) {
            return;
        }

        Player player = (Player) shooter;
        String projectileName = projectile.getType().name();



        MessageUtils.sendMessage(player.getName(),
                player.getLocation(),
                "处 发射了" +ChatColor.YELLOW+ projectileName);



    }
}
