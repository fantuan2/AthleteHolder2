package fantuan.two.thth.athletedetector.athleteholder.commands;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpListCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /ahwhitelist add/remove [player]！");
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
                if (ah.opsOnList.contains(sender.getName())){
                    sender.sendMessage(ChatColor.GREEN + "您已经在接收监控信息了！");
                    return true;
                }else {
                    ah.opsOnList.add(sender.getName());
                    sender.sendMessage(ChatColor.BLUE + "操作成功");
                    return  true;
                }
            }else if (args.length == 2) {
                if (ah.opsOnList.contains(args[1])){
                    sender.sendMessage("他已经在接收监控信息了！");
                    return true;
                }else {
                    ah.opsOnList.add(args[1]);
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
                if (!ah.opsOnList.contains(sender.getName())){
                    sender.sendMessage(ChatColor.GREEN + "您已经没有接收监控信息了！");
                    return true;
                }else {
                    ah.opsOnList.remove(sender.getName());
                    sender.sendMessage(ChatColor.BLUE + "操作成功");
                    return  true;
                }
            }else if (args.length == 2) {
                if (!ah.opsOnList.contains(args[1])){
                    sender.sendMessage("他已经没有接收监控信息了！");
                    return true;
                }else {
                    ah.opsOnList.remove(args[1]);
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

