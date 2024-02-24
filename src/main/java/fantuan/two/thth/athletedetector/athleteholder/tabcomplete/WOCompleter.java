package fantuan.two.thth.athletedetector.athleteholder.tabcomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class WOCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> lst = new ArrayList<>();

        if (args.length == 1) {

            lst.clear();

            lst.add("detecters");
            lst.add("whitelist");

            return lst;
        }

        return lst;

    }
}
