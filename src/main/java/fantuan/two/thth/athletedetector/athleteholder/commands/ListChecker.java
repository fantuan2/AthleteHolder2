package fantuan.two.thth.athletedetector.athleteholder.commands;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListChecker implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if ((!sender.hasPermission("athleteholder.admin"))&&sender instanceof Player) {
            sender.sendMessage(ChatColor.RED + "您没有权限使用这个命令");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /ahchecklist detecters/whitelist");
            return true;
        }

        if (args[0].equalsIgnoreCase("detecters")) {

            if (AthleteHolder.ins.opsOnList.isEmpty()) {
                sender.sendMessage(ChatColor.GREEN + "没有人在监控哦");
                return true;
            }

            StringBuilder sb = new StringBuilder();
            for (String name : AthleteHolder.ins.opsOnList) {
                sb.append(name);
                sb.append(", ");
            }
            String msgList = sb.toString().substring(0, sb.toString().length() - 1);

            sender.sendMessage(ChatColor.BLUE +  "正在监控的人有：" + ChatColor.WHITE + msgList);
            return true;
        }

        if (args[0].equalsIgnoreCase("whitelist")) {

            if (AthleteHolder.ins.whiteList.isEmpty()) {
                sender.sendMessage(ChatColor.GREEN + "没有人在白名单哦");
                return true;
            }

            StringBuilder sb = new StringBuilder();
            for (String name : AthleteHolder.ins.whiteList) {
                sb.append(name);
                sb.append(", ");
            }
            String msgList = sb.toString().substring(0, sb.toString().length() - 1);

            sender.sendMessage(ChatColor.BLUE +  "正在白名单内的人有：" + ChatColor.WHITE + msgList);
            return true;
        }


        return true;
    }
}
