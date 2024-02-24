package fantuan.two.thth.athletedetector.athleteholder.tabcomplete;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


@Deprecated
public class OpsCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

       List<String> list = new ArrayList<>();

       if (args.length == 2) {
           for (Player p : Bukkit.getOnlinePlayers()){
               if(p.hasPermission("athleteholder.admin")){
                   list.add(p.getName());
               }
           }
       }

        return list;
    }
}
