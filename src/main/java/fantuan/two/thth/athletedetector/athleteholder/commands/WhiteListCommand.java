package fantuan.two.thth.athletedetector.athleteholder.commands;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WhiteListCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sender.sendMessage(ChatColor.RED + "错误的用法，请使用/ahwhitelist add/remove [player]！");
            return true;
        }

        if(!sender.hasPermission("athleteholder.admin")){
            sender.sendMessage(ChatColor.RED + "你没有权限使用这个指令！");
            return true;
        }

        if(args.length == 1&&!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "只有玩家才能对自己使用！");
            return true;
        }

        if (!args[0].equalsIgnoreCase("add")&&!args[0].equalsIgnoreCase("remove")){
            sender.sendMessage(ChatColor.DARK_RED + "Invalid Usage");
        }
        AthleteHolder ah = AthleteHolder.ins;

        if(args[0].equalsIgnoreCase("add")){
            if(args.length == 1){
                if (ah.whiteList.contains(sender.getName())){
                    sender.sendMessage(ChatColor.GREEN + "您已经豁免监控了！");
                    return true;
                }else {
                    ah.whiteList.add(sender.getName());
                    sender.sendMessage(ChatColor.BLUE + "操作成功");
                    return  true;
                }
            }else if (args.length == 2) {
                if (ah.whiteList.contains(args[1])){
                    sender.sendMessage("他已经豁免监控了！");
                    return true;
                }else {
                    ah.whiteList.add(args[1]);
                    sender.sendMessage(ChatColor.BLUE + "操作成功");
                    return true;
                }
            }else {
                sender.sendMessage(ChatColor.DARK_RED + "Invalid Usage");
                return true;
            }
        }


        if(args[0].equalsIgnoreCase("remove")){
            if(args.length == 1){
                if (!ah.whiteList.contains(sender.getName())){
                    sender.sendMessage(ChatColor.GREEN + "您已经继续受到监控了！");
                    return true;
                }else {
                    ah.whiteList.remove(sender.getName());
                    sender.sendMessage(ChatColor.BLUE + "操作成功");
                    return  true;
                }
            }else if (args.length == 2) {
                if (!ah.whiteList.contains(args[1])){
                    sender.sendMessage("他已经继续受到监控了！");
                    return true;
                }else {
                    ah.whiteList.remove(args[1]);
                    sender.sendMessage(ChatColor.BLUE + "操作成功");
                    return true;
                }

            }else {
                sender.sendMessage(ChatColor.DARK_RED + "Invalid Usage");
                return true;
            }
        }


        return true;
    }
}
