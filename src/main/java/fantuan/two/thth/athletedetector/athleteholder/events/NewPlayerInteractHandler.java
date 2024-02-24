package fantuan.two.thth.athletedetector.athleteholder.events;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import fantuan.two.thth.athletedetector.athleteholder.utils.MessageUtils;
import fantuan.two.thth.athletedetector.athleteholder.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class NewPlayerInteractHandler implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        if (!AthleteHolder.ins.ifOpen) {
            return;
        }

        if (AthleteHolder.ins.whiteList.contains(event.getPlayer().getName())) {
            return;
        }

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            Material m = event.getClickedBlock().getType();

            if (AthleteHolder.ins.pPress&&(m.equals(Material.BAMBOO_BUTTON)||
            m.equals(Material.BIRCH_BUTTON)||
            m.equals(Material.ACACIA_BUTTON)||
            m.equals(Material.CHERRY_BUTTON)||
            m.equals(Material.CRIMSON_BUTTON)||
            m.equals(Material.DARK_OAK_BUTTON)||
            m.equals(Material.JUNGLE_BUTTON)||
            m.equals(Material.MANGROVE_BUTTON)||
            m.equals(Material.OAK_BUTTON)||
            m.equals(Material.POLISHED_BLACKSTONE_BUTTON)||
            m.equals(Material.SPRUCE_BUTTON)||
            m.equals(Material.STONE_BUTTON)||
            m.equals(Material.WARPED_BUTTON))){

                Block clickedBlock = event.getClickedBlock();

//                String msg = ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GRAY +"在  " + ChatColor.YELLOW + clickedBlock.getLocation().getBlockX() +
//                        " " + clickedBlock.getLocation().getBlockY() + " " + clickedBlock.getLocation().getBlockZ() + ChatColor.GRAY + "处 使用了" +ChatColor.YELLOW+ clickedBlock.
//                        getType().name() + " —— " + ChatColor.GRAY + Utils.getCurrentFormattedDateTime();

                MessageUtils.sendMessage(event.getPlayer().getName(), clickedBlock.getLocation(), "处 使用了" +ChatColor.YELLOW+ clickedBlock.
                        getType().name());

            }

            if (AthleteHolder.ins.pDraw&&
            m.equals(Material.LEVER)) {

                Block clickedBlock = event.getClickedBlock();
//                String msg = ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GRAY +"在  " +
//                        ChatColor.YELLOW + clickedBlock.getLocation().getBlockX() +
//                        " " + clickedBlock.getLocation().getBlockY() + " " +
//                        clickedBlock.getLocation().getBlockZ() + ChatColor.GRAY +
//                        "处 使用了" +ChatColor.YELLOW+ "拉杆" + " —— " + ChatColor.GRAY +
//                        Utils.getCurrentFormattedDateTime();


                MessageUtils.sendMessage(event.getPlayer().getName(), clickedBlock.getLocation(), "处 使用了" +ChatColor.YELLOW+ "拉杆");



            }

        }

        if (event.getAction().equals(Action.PHYSICAL)&&AthleteHolder.ins.pStep) {

            Block clickedBlock = event.getClickedBlock();
            Material m = null;

            try {
                m = clickedBlock.getType();
            }catch (NullPointerException n) {
                return;
            }

            if (m.equals(Material.POLISHED_BLACKSTONE_PRESSURE_PLATE)||
            m.equals(Material.ACACIA_PRESSURE_PLATE)||
            m.equals(Material.BAMBOO_PRESSURE_PLATE)||
            m.equals(Material.BIRCH_PRESSURE_PLATE)||
            m.equals(Material.CHERRY_PRESSURE_PLATE)||
            m.equals(Material.CRIMSON_PRESSURE_PLATE)||
            m.equals(Material.DARK_OAK_PRESSURE_PLATE)||
            m.equals(Material.HEAVY_WEIGHTED_PRESSURE_PLATE)||
            m.equals(Material.JUNGLE_PRESSURE_PLATE)||
            m.equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE)||
            m.equals(Material.MANGROVE_PRESSURE_PLATE)||
            m.equals(Material.OAK_PRESSURE_PLATE)||
            m.equals(Material.SPRUCE_PRESSURE_PLATE)||
            m.equals(Material.STONE_PRESSURE_PLATE)||
            m.equals(Material.WARPED_PRESSURE_PLATE)) {

//                String msg = ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.GRAY +"在  " + ChatColor.YELLOW + clickedBlock.getLocation().getBlockX() +
//                        " " + clickedBlock.getLocation().getBlockY() + " " + clickedBlock.getLocation().getBlockZ() + ChatColor.GRAY + "处 踩下了" +ChatColor.YELLOW+ "压力板" + ChatColor.GRAY + clickedBlock.getType().name() + " —— " + ChatColor.GRAY +
//                        Utils.getCurrentFormattedDateTime();


                MessageUtils.sendMessage(event.getPlayer().getName(),
                        clickedBlock.getLocation(),
                        "处 踩下了" +ChatColor.YELLOW+ "压力板" + ChatColor.GRAY + clickedBlock.getType().name());

            }



        }

    }

}
