package fantuan.two.thth.athletedetector.athleteholder.utils;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class MessageUtils {

    public static void sendMessage(String player, Location loc, String otherInfo) {
//        String msg = ChatColor.YELLOW + player.getName() + ChatColor.GRAY +"在  " +
//                ChatColor.YELLOW + player.getLocation().getBlockX() +
//                " " + player.getLocation().getBlockY() + " " +
//                player.getLocation().getBlockZ() + ChatColor.GRAY +
//                "处 丢出了" +ChatColor.YELLOW+ item.getItemStack().getType().name() + " x " + am + " —— " + ChatColor.GRAY +
//                Utils.getCurrentFormattedDateTime();


        TextComponent title = new TextComponent(ChatColor.GOLD + player);
        title.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + player));
        title.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT , new ComponentBuilder("点我传送（需要OP）").create()));
        title.setUnderlined(true);

        TextComponent text1 = new TextComponent(ChatColor.GRAY + "在  ");
        TextComponent text2 = new TextComponent(ChatColor.YELLOW + "" + loc.getBlockX() +
                " " + loc.getBlockY() + " " + loc.getBlockZ());


        TextComponent text3 = new TextComponent(otherInfo);
        TextComponent text4 = new TextComponent( ChatColor.DARK_GREEN + " —— " + ChatColor.GRAY +
                Utils.getCurrentFormattedDateTime());

        title.addExtra(text1);title.addExtra(text2);title.addExtra(text3);title.addExtra(text4);

        if (AthleteHolder.ins.opsOnList.isEmpty()) {
            return;
        }


        for (String pn : AthleteHolder.ins.opsOnList) {

                AthleteHolder.ins.getServer().getPlayer(pn).spigot().sendMessage(title);

        }
    }

}
