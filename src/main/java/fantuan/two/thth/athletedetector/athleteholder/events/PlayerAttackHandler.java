package fantuan.two.thth.athletedetector.athleteholder.events;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import fantuan.two.thth.athletedetector.athleteholder.utils.MessageUtils;
import fantuan.two.thth.athletedetector.athleteholder.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerAttackHandler implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {

        if (!AthleteHolder.ins.ifOpen) {
            return;
        }

        if (!AthleteHolder.ins.pAttack) {
            return;
        }


        Entity attacker = event.getDamager();
        Entity damagedEntity = event.getEntity();

        // 检查攻击者是否是玩家
        if (attacker instanceof Player) {
            Player playerAttacker = (Player) attacker;
            if (AthleteHolder.ins.whiteList.contains(playerAttacker.getName())) {
                return;
            }

            // 检查被攻击实体的类型
            if (damagedEntity.getType() == EntityType.PLAYER) {

                MessageUtils.sendMessage(playerAttacker.getName(),
                        playerAttacker.getLocation(),
                        "处 " + " 攻击了玩家" +ChatColor.YELLOW+ damagedEntity.getName());



            } else {
                // 被攻击实体是生物

                MessageUtils.sendMessage(playerAttacker.getName(),
                        playerAttacker.getLocation(),
                        "处 " + " 攻击了生物" +ChatColor.YELLOW+ damagedEntity.getName());

            }
        }
    }
}
