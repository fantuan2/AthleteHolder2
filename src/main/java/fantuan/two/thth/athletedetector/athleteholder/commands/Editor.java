package fantuan.two.thth.athletedetector.athleteholder.commands;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Editor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "只有玩家可以使用这个命令！");
            return true;
        }

        if(!sender.hasPermission("athleteholder.admin")){
            sender.sendMessage(ChatColor.RED + "你没有权限使用这个指令！");
            return true;
        }

        Player player = (Player) sender;

        player.spigot().sendMessage(AthleteHolder.ins.text);

        return true;
    }
}
