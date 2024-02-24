
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class AthleteHolder extends JavaPlugin {

    public static AthleteHolder ins;
    public List<String> opsOnList = new ArrayList<>();
    public boolean ifOpen = false;
    public List<String> whiteList = new ArrayList<>();

    public boolean pPlace;
    public boolean pDestroy;
    public boolean pPress;
    public boolean pDraw;
    public boolean pStep;
    public boolean pShoot;
    public boolean pUseCommand;
    public boolean pAttack;
    public boolean pThrow;
    public boolean pPick;

    public TextComponent text;

    public FileConfiguration config;

    @Override
    public void onEnable() {
        ins = this;
        saveDefaultConfig();
        this.config = getConfig();

        this.pPlace = this.config.getBoolean("PlayerPlace");
        this.pDestroy = this.config.getBoolean("PlayerDestroy");
        this.pPress = this.config.getBoolean("PlayerPress");
        this.pDraw = this.config.getBoolean("PlayerDraw");
        this.pStep = this.config.getBoolean("PlayerStep");
        this.pShoot = this.config.getBoolean("PlayerShoot");
        this.pUseCommand = this.config.getBoolean("PlayerUseCommand");
        this.pAttack = this.config.getBoolean("PlayerAttack");
        this.pThrow = this.config.getBoolean("PlayerThrow");
        this.pPick = this.config.getBoolean("PlayerPick");


        {
            TextComponent space = new TextComponent("\t");
            TextComponent changeLine = new TextComponent("\n");
            TextComponent title = new TextComponent(ChatColor.GOLD + "=========== 编辑器 ============");

            TextComponent first = new TextComponent(ChatColor.BLUE + "[开启放置监听]");
            TextComponent second = new TextComponent(ChatColor.LIGHT_PURPLE + "[关闭放置监听]");

            TextComponent third = new TextComponent(ChatColor.BLUE + "[开启破坏监听]");
            TextComponent fourth = new TextComponent(ChatColor.LIGHT_PURPLE + "[关闭破坏监听]");

            //按钮监听
            TextComponent fifth = new TextComponent(ChatColor.BLUE + "[开启按钮监听]");
            TextComponent sixth = new TextComponent(ChatColor.LIGHT_PURPLE + "[关闭按钮监听]");
            //拉杆监听
            TextComponent seventh = new TextComponent(ChatColor.BLUE + "[开启拉杆监听]");
            TextComponent eighth = new TextComponent(ChatColor.LIGHT_PURPLE + "[关闭拉杆监听]");
            //压力板监听
            TextComponent ninth = new TextComponent(ChatColor.BLUE + "[开启压力板监听]");
            TextComponent tenth = new TextComponent(ChatColor.LIGHT_PURPLE + "[关闭压力板监听]");
            //投掷物监听
            TextComponent eleventh = new TextComponent(ChatColor.BLUE + "[开启投掷物监听]");
            TextComponent twelfth = new TextComponent(ChatColor.LIGHT_PURPLE + "[关闭投掷物监听]");
            //使用命令监听
            TextComponent thirteenth = new TextComponent(ChatColor.BLUE + "[开启使用命令监听]");
            TextComponent fourteenth = new TextComponent(ChatColor.LIGHT_PURPLE + "[关闭使用命令监听]");
            //攻击监听
            TextComponent fifteenth = new TextComponent(ChatColor.BLUE + "[开启攻击监听]");
            TextComponent sixteenth = new TextComponent(ChatColor.LIGHT_PURPLE + "[关闭攻击监听]");
            //掉落物品监听
            TextComponent seventeenth = new TextComponent(ChatColor.BLUE + "[开启掉落物品监听]");
            TextComponent eighteenth = new TextComponent(ChatColor.LIGHT_PURPLE + "[关闭掉落物品监听]");
            //捡起物品监听
            TextComponent nineteenth = new TextComponent(ChatColor.BLUE + "[开启捡起物品监听]");
            TextComponent twentieth = new TextComponent(ChatColor.LIGHT_PURPLE + "[关闭捡起物品监听]");


            first.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahon playerplace"));
            first.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击打开玩家放置监听").create()));
            second.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahoff playerplace"));
            second.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击关闭玩家放置监听").create()));

            third.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahon playerdestroy"));
            third.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击打开玩家破坏监听").create()));
            fourth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahoff playerdestroy"));
            fourth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击关闭玩家破坏监听").create()));

            fifth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahon playerpress"));
            fifth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击打开玩家按钮监听").create()));
            sixth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahoff playerpress"));
            sixth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击关闭玩家按钮监听").create()));

            seventh.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahon playerdraw"));
            seventh.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击打开玩家拉杆监听").create()));
            eighth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahoff playerdraw"));
            eighth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击关闭玩家拉杆监听").create()));

            ninth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahon playerstep"));
            ninth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击打开玩家压力板监听").create()));
            tenth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahoff playerstep"));
            tenth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击关闭玩家压力板监听").create()));

            eleventh.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahon playershoot"));
            eleventh.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击打开玩家投掷物监听").create()));
            twelfth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahoff playershoot"));
            twelfth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击关闭玩家投掷物监听").create()));

            thirteenth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahon playerusecommand"));
            thirteenth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击打开玩家使用命令监听").create()));
            fourteenth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahoff playerusecommand"));
            fourteenth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击关闭玩家使用命令监听").create()));

            fifteenth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahon playerattack"));
            fifteenth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击打开玩家攻击监听").create()));
            sixteenth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahoff playerattack"));
            sixteenth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击关闭玩家攻击监听").create()));

            seventeenth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahon playerthrow"));
            seventeenth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击打开玩家丢弃物品监听").create()));
            eighteenth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahoff playerthrow"));
            eighteenth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击关闭玩家丢弃物品监听").create()));

            nineteenth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahon playerpick"));
            nineteenth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击打开玩家捡起物品监听").create()));
            twentieth.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ahoff playerpick"));
            twentieth.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("点击关闭玩家捡起物品监听").create()));

            title.addExtra(changeLine);title.addExtra(first);title.addExtra(space);title.addExtra(second);title.addExtra(changeLine);title.addExtra(third);title.addExtra(space);
            title.addExtra(fourth);title.addExtra(changeLine);title.addExtra(fifth);title.addExtra(space);title.addExtra(sixth);title.addExtra(changeLine);
            title.addExtra(seventh);title.addExtra(space);title.addExtra(eighth);title.addExtra(changeLine);title.addExtra(ninth);title.addExtra(space);
            title.addExtra(tenth);title.addExtra(changeLine);title.addExtra(eleventh);title.addExtra(space);title.addExtra(twelfth);title.addExtra(changeLine);
            title.addExtra(thirteenth);title.addExtra(space);title.addExtra(fourteenth);title.addExtra(changeLine);title.addExtra(fifteenth);title.addExtra(space);
            title.addExtra(sixteenth);title.addExtra(changeLine);title.addExtra(seventeenth);title.addExtra(space);title.addExtra(eighteenth);title.addExtra(changeLine);
            title.addExtra(nineteenth);title.addExtra(space);title.addExtra(twentieth);

            text = title;
        }//文本预处理


        getCommand("ahwhitelist").setExecutor(new WhiteListCommand());
        getCommand("ahwhitelist").setTabCompleter(new ListSetterCompleter());

        getCommand("ahdeteclist").setExecutor(new OpListCommand());
        getCommand("ahdeteclist").setTabCompleter(new ListSetterCompleter());

        getCommand("aheditor").setExecutor(new Editor());

        getCommand("ahon").setExecutor(new AhOn());
        getCommand("ahon").setTabCompleter(new ToolsCompleter());

        getCommand("ahoff").setExecutor(new AhOff());
        getCommand("ahoff").setTabCompleter(new ToolsCompleter());

        getCommand("ahswitch").setExecutor(new Switch());
        getCommand("ahswitch").setTabCompleter(new OOCompleter());

        getCommand("ahchecklist").setExecutor(new ListChecker());
        getCommand("ahchecklist").setTabCompleter(new WOCompleter());


        getServer().getPluginManager().registerEvents(new OpQuit(),this);
        getServer().getPluginManager().registerEvents(new PlayerAttackHandler(),this);
        getServer().getPluginManager().registerEvents(new PlayerBreakHandler(),this);
        getServer().getPluginManager().registerEvents(new PlayerCommandHandler(),this);
        getServer().getPluginManager().registerEvents(new PlayerDropHandler(), this);
        //getServer().getPluginManager().registerEvents(new PlayerInteractHandler(), this);

        getServer().getPluginManager().registerEvents(new NewPlayerInteractHandler(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickHandler(), this);
        getServer().getPluginManager().registerEvents(new PlayerPlaceHandler(),this);
        getServer().getPluginManager().registerEvents(new PlayerShootHandler(),this);


    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}

