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
    private final List<String> racial = config.getStringList("players:");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && args.length == 1 && command.getName().equalsIgnoreCase("racial")) {
            Player pl = (Player) sender;
            String verdict = CheckPlayerInConfig(pl);
            if (racial.contains(args[0])) {
                if (verdict != null) {
                    SwapRacialInConfig("players:" + verdict, "players:" + args[0], pl.getName());
                } else {
                    config.set("players:" + args[0], pl.getName());
                    plugin.saveDefaultConfig();
                }
            }
        }
        return false;
    }

    private String CheckPlayerInConfig(Player pl) {
        String p = pl.getName();
        for (String v : racial) {
            if (config.getStringList("players:" + v).contains(p)) {
                return v;
            }
        }
        return null;
    }

    private void SwapRacialInConfig(String begin, String end, String playerName){
        config.set(begin, config.getStringList(begin).remove(playerName));
        config.set(end, config.getStringList(end).add(playerName));
        plugin.saveDefaultConfig();
    }
}
