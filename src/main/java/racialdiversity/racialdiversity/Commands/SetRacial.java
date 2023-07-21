package racialdiversity.racialdiversity.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.plugin.Plugin;
import racialdiversity.racialdiversity.main;

public class SetRacial implements CommandExecutor {
    main plugin = new main();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && args.length == 1){
            if (command.getName().equalsIgnoreCase("racial")){
                Object[] Racials = plugin.GroupPlayers.getConfigurationSection("players").getKeys(false).toArray();
                String rac = null;
                for (Object v:Racials){
                    if (args[0].equalsIgnoreCase(v.toString())){
                        rac = v.toString();
                    }
                }
                if (rac != null) {
                    plugin.GroupPlayers.set("players:" + rac, sender.getName());
                    return true;
                }
            }
        }
        return false;
    }
}
