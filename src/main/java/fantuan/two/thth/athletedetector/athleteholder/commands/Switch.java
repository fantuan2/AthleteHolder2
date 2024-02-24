package fantuan.two.thth.athletedetector.athleteholder.commands;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Switch implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Invalid Usage");
            return true;
        }


        if (args[0].equalsIgnoreCase("on")) {
            sender.sendMessage(ChatColor.GREEN + "操作成功");
            AthleteHolder.ins.ifOpen = true;
            return true;
        }else if (args[0].equalsIgnoreCase("off")) {
            sender.sendMessage(ChatColor.GREEN + "操作成功");
            AthleteHolder.ins.ifOpen = false;
            return true;
        }

        return true;
    }
}
