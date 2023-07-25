package racialdiversity.racialdiversity.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import racialdiversity.racialdiversity.main;

import java.util.List;


public class SetRacial implements CommandExecutor {
    private final Plugin plugin = main.getPlugin(main.class);
    private final FileConfiguration config = plugin.getConfig();
    private final List<String> racial = config.getStringList("info");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((Player) sender != null && args.length == 1 && command.getName().equalsIgnoreCase("racial")) {
            Player pl = (Player) sender;
            String verdict = CheckPlayerInConfig(pl);
            plugin.getLogger().info(verdict + "  " + args[0]);
            if (racial.contains(args[0])) {
                if (verdict != null) {
                    SwapRacialInConfig("players." + verdict, "players." + args[0], pl.getName());
                }
            }
        }
        return false;
    }

    private String CheckPlayerInConfig(Player pl) {
        String p = pl.getName();
        for (String v : racial) {
            if (config.getStringList("players." + v).contains(p)) {
                return v;
            }
        }
        return null;
    }

    private void SwapRacialInConfig(String begin, String end, String playerName){
        List<String> tm1 = config.getStringList(begin);
        List<String> tm2 = config.getStringList(end);
        tm1.remove(playerName);
        tm2.add(playerName);
        config.set(begin, tm1);
        config.set(end, tm2);
        plugin.saveConfig();
    }
}
