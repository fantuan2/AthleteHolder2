package fantuan.two.thth.athletedetector.athleteholder.commands;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


@Deprecated
public class WhiteListRemoveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)&&args.length == 0){
            sender.sendMessage(ChatColor.RED + "只有玩家可以对自己使用这个命令！");
            return true;
        }

        if(!(sender.hasPermission("athleteholder.admin"))){
            sender.sendMessage(ChatColor.RED + "你没有权限使用这个指令！");
            return true;
        }

        Player p = (Player) sender;

        if(args.length == 0) {

            if((!AthleteHolder.ins.whiteList.contains(p.getName()))){
                sender.sendMessage(ChatColor.RED + "您已经不在名单里了！");
                return true;
            }

            AthleteHolder.ins.whiteList.remove(p.getName());
            sender.sendMessage(ChatColor.GREEN + "完成操作");
            return true;
        }

        if(args.length > 1) {
            sender.sendMessage(ChatColor.RED + "您输入的指令有误！");
            return true;
        }

        if (!AthleteHolder.ins.whiteList.contains(args[0])){
            sender.sendMessage(ChatColor.RED + "他已经不在名单里了！");
            return true;
        }

        AthleteHolder.ins.whiteList.remove(args[0]);
        sender.sendMessage(ChatColor.GREEN + "完成操作");



        return true;
    }
}
