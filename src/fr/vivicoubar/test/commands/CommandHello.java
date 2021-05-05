package fr.vivicoubar.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHello implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            String name = player.getName();
            player.sendMessage("Bonjour "+name+", Hello World!");
            Bukkit.broadcastMessage(name + "a utilisé la commande /hello!");
            return true;
        }
        return false;
    }
}


