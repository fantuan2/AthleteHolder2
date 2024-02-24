package fantuan.two.thth.athletedetector.athleteholder.tabcomplete;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ListSetterCompleter implements TabCompleter {

    List<String> lst = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1){
            lst.clear();
            lst.add("add");
            lst.add("remove");
        }

        if (args.length == 2) {
            lst.clear();
            for (Player p : Bukkit.getOnlinePlayers()){
                if(p.hasPermission("athleteholder.admin")){
                    lst.add(p.getName());
                }
            }
        }

        return lst;

    }
}
