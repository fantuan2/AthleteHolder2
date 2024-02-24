package fantuan.two.thth.athletedetector.athleteholder.tabcomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ToolsCompleter implements TabCompleter {

    private List<String> lst = new ArrayList<>();


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            lst.clear();
            lst.add("PlayerPlace");
            lst.add("PlayerDestroy");
            lst.add("PlayerPress");
            lst.add("PlayerDraw");
            lst.add("PlayerStep");
            lst.add("PlayerShoot");
            lst.add("PlayerUseCommand");
            lst.add("PlayerAttack");
            lst.add("PlayerThrow");
            lst.add("PlayerPick");
        }
        return lst;
    }
}
