package fantuan.two.thth.athletedetector.athleteholder.commands;

import fantuan.two.thth.athletedetector.athleteholder.AthleteHolder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AhOff implements CommandExecutor {
    AthleteHolder ah;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "您输入的指令有误！");
            return true;
        }


        if((sender instanceof Player)&&(!sender.hasPermission("athleteholder.admin"))){
            sender.sendMessage(ChatColor.RED + "你没有权限使用这个指令！");
            return true;
        }
        ah = AthleteHolder.ins;



        if (args[0].equalsIgnoreCase("PlayerPlace")){
            ah.pPlace = false;
            this.configSetter("PlayerPlace");
            messageSend(sender);
        }

        if (args[0].equalsIgnoreCase("PlayerDestroy")){
            ah.pDestroy = false;
            this.configSetter("PlayerDestroy");
            messageSend(sender);
        }

        if (args[0].equalsIgnoreCase("PlayerPress")){
            ah.pPress = false;
            this.configSetter("PlayerPress");
            messageSend(sender);
        }

        //PlayerDraw
        if (args[0].equalsIgnoreCase("PlayerDraw")){
            ah.pDraw = false;
            this.configSetter("PlayerDraw");
            messageSend(sender);
        }

        if (args[0].equalsIgnoreCase("PlayerThrow")){
            ah.pThrow = false;
            this.configSetter("PlayerThrow");
            messageSend(sender);
        }

        if (args[0].equalsIgnoreCase("PlayerPick")){
            ah.pPick = false;
            this.configSetter("PlayerPickup");
            messageSend(sender);
        }

        //PlayerUseCommand
        if (args[0].equalsIgnoreCase("PlayerUseCommand")){
            ah.pUseCommand = false;
            this.configSetter("PlayerUseCommand");
            messageSend(sender);
        }
        //PlayerAttack
        if (args[0].equalsIgnoreCase("PlayerAttack")){
            ah.pAttack = false;
            this.configSetter("PlayerAttack");
            messageSend(sender);
        }
        //PlayerStep
        if (args[0].equalsIgnoreCase("PlayerStep")){
            ah.pStep = false;
            this.configSetter("PlayerStep");
            messageSend(sender);
        }
        //PlayerShoot
        if (args[0].equalsIgnoreCase("PlayerShoot")){
            ah.pShoot = false;
            this.configSetter("PlayerShoot");
            messageSend(sender);
        }



        return true;
    }

    public void configSetter(String name){
        this.ah.config.set(name,false);
    }
    public void messageSend(CommandSender s){
        s.sendMessage(ChatColor.GREEN + "操作成功！");
    }
}
