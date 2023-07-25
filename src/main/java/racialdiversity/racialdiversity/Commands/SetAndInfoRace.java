package racialdiversity.racialdiversity.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import racialdiversity.racialdiversity.Events.AddingEffect;
import racialdiversity.racialdiversity.main;

import java.util.List;


public class SetAndInfoRace implements CommandExecutor {
    private final Plugin plugin = main.getPlugin(main.class);
    private List<String> race = plugin.getConfig().getStringList("info");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check command

        if ((Player) sender != null && args.length == 1 && command.getName().equalsIgnoreCase("race")) {
            Player pl = (Player) sender;
            String verdict = CheckPlayerInConfig(pl);
            // Argument info
            if (args[0].equalsIgnoreCase("info")){
                if (verdict != null){
                    pl.sendMessage("You are in the race of " + verdict + ".");
                }
                else {
                    pl.sendMessage("" +
                            "You are not part of any race.\n" +
                            ChatColor.GREEN + "Use /racial <race> \n" +
                            ChatColor.RED + "To choose a race.");
                }
                return true;
            }
            else if (args[0].equalsIgnoreCase("reload")){
                race = plugin.getConfig().getStringList("info");
                plugin.reloadConfig();
            }
            // Choose race
            else if (race.contains(args[0])) {
                // Remove Effect
                for (PotionEffect v : pl.getActivePotionEffects()){
                    pl.removePotionEffect(v.getType());
                }
                if (verdict != null) {
                    SwapRacialInConfig("players." + verdict, "players." + args[0], pl.getName());
                }
                else {
                    List<String> tmp = plugin.getConfig().getStringList("players." + args[0]);
                    tmp.add(pl.getName());
                    plugin.getConfig().set("players." + args[0], tmp);
                }
                new AddingEffect().AddEffectPlayer(pl);
                return true;
            }
        }
        return false;
    }

    private String CheckPlayerInConfig(Player pl) {
        String p = pl.getName();
        for (String v : race) {
            if (plugin.getConfig().getStringList("players." + v).contains(p)) {
                return v;
            }
        }
        return null;
    }

    private void SwapRacialInConfig(String begin, String end, String playerName){
        List<String> tm1 = plugin.getConfig().getStringList(begin);
        List<String> tm2 = plugin.getConfig().getStringList(end);
        tm1.remove(playerName);
        tm2.add(playerName);
        plugin.getConfig().set(begin, tm1);
        plugin.getConfig().set(end, tm2);
        plugin.getConfig().saveToString();
        plugin.saveConfig();
        plugin.reloadConfig();
    }
}
