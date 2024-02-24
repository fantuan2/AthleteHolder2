package fantuan.two.thth.athletedetector.athleteholder.events;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import fantuan.two.thth.athletedetector.athleteholder.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Button;
import org.bukkit.material.Lever;
import org.bukkit.material.PressurePlate;

@Deprecated
public class PlayerInteractHandler implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!AthleteHolder.ins.ifOpen) {
            return;
        }
        if (AthleteHolder.ins.whiteList.contains(event.getPlayer().getName())) {
            return;
        }

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            // 获取被右击的方块
            Block clickedBlock = event.getClickedBlock();

            // 获取方块状态
            BlockState blockState = clickedBlock.getState();

            // 检查方块是否为按钮
            if (blockState instanceof Button&&AthleteHolder.ins.pPress) {


                String msg = ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GRAY +"在  " + ChatColor.YELLOW + clickedBlock.getLocation().getBlockX() +
                        " " + clickedBlock.getLocation().getBlockY() + " " + clickedBlock.getLocation().getBlockZ() + ChatColor.GRAY + "处 使用了" +ChatColor.YELLOW+ clickedBlock.
                        getType().name() + " —— " + ChatColor.GRAY + Utils.getCurrentFormattedDateTime();

                for (String pn : AthleteHolder.ins.opsOnList) {
                    try {
                        AthleteHolder.ins.getServer().getPlayer(pn).sendMessage(msg);
                    }catch (NullPointerException npe){}

                }

            }
            if (blockState instanceof Lever&&AthleteHolder.ins.pDraw) {
                Lever lever = (Lever) blockState;

                if (lever.isPowered()) {

                    String msg = ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GRAY +"在  " +
                            ChatColor.YELLOW + clickedBlock.getLocation().getBlockX() +
                            " " + clickedBlock.getLocation().getBlockY() + " " +
                            clickedBlock.getLocation().getBlockZ() + ChatColor.GRAY +
                            "处 激活了" +ChatColor.YELLOW+ "拉杆" + " —— " + ChatColor.GRAY +
                            Utils.getCurrentFormattedDateTime();

                    for (String pn : AthleteHolder.ins.opsOnList) {
                        try {
                            AthleteHolder.ins.getServer().getPlayer(pn).sendMessage(msg);
                        }catch (NullPointerException npe){}

                    }

                }
            }
            if (blockState instanceof Lever&&AthleteHolder.ins.pDraw) {
                Lever lever = (Lever) blockState;

                if (!lever.isPowered()) {

                    String msg = ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GRAY +"在  " + ChatColor.YELLOW + clickedBlock.getLocation().getBlockX() +
                            " " + clickedBlock.getLocation().getBlockY() + " " + clickedBlock.getLocation().getBlockZ() + ChatColor.GRAY + "处 关闭了" +ChatColor.YELLOW+ "拉杆" + " —— " + ChatColor.GRAY + Utils.getCurrentFormattedDateTime();

                    for (String pn : AthleteHolder.ins.opsOnList) {
                        try {
                            AthleteHolder.ins.getServer().getPlayer(pn).sendMessage(msg);
                        }catch (NullPointerException npe){}

                    }

                }
            }
        }


        if (event.getAction().equals(Action.PHYSICAL)&&AthleteHolder.ins.pStep) {

            Block clickedBlock = event.getClickedBlock();

            BlockState blockState = clickedBlock.getState();

            if (blockState instanceof PressurePlate) {

                String msg = ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GRAY +"在  " + ChatColor.YELLOW + clickedBlock.getLocation().getBlockX() +
                        " " + clickedBlock.getLocation().getBlockY() + " " + clickedBlock.getLocation().getBlockZ() + ChatColor.GRAY + "处 踩下了" +ChatColor.YELLOW+ "压力板" + " —— " + ChatColor.GRAY +
                        Utils.getCurrentFormattedDateTime();

                for (String pn : AthleteHolder.ins.opsOnList) {
                    try {
                        AthleteHolder.ins.getServer().getPlayer(pn).sendMessage(msg);
                    }catch (NullPointerException npe){}

                }

            }
        }
    }

}
