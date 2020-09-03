package ru.gorodilov.autorestart.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ru.gorodilov.autorestart.abstracts.AutoCommand;
import ru.gorodilov.autorestart.commands.autore.*;
import ru.gorodilov.autorestart.core.AutoRestart;
import ru.gorodilov.autorestart.utils.Console;

public class CmdAutoRestart implements CommandExecutor {

	public static ArrayList<AutoCommand> subCommands = new ArrayList<AutoCommand>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Default command text header
		sender.sendMessage(ChatColor.RED + "PolyaRestart " + ChatColor.GRAY + "- by Gorodilov");
		
		// Check if argument length requirement meet
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Недостаточно аргументов. Попробуйте: /polyare help");
		}
		else {
			// Sub command arguments list trimmer
			ArrayList<String> argsList = new ArrayList<String>();
			for (String arg : args) {
				argsList.add(arg);
			}
			argsList.remove(0);
			
			// Sub command iteration
			String subCmdLabel = args[0];
			for (AutoCommand autoSubCmd : subCommands) {
				
				// Check if label matches sub command label
				if (autoSubCmd.getLabel().equalsIgnoreCase(subCmdLabel)) {
					
					// Check if sender has permission
					if (autoSubCmd.getPermission() != null) {
						if (!sender.hasPermission(autoSubCmd.getPermission())) {
							
							// Not enough permissions error
							sender.sendMessage(ChatColor.RED + "У вас недостаточно прав.");
							Console.consoleSendMessage("У вас недостаточно прав.");
							return true;
						}
					}

					// Executes sub command
					try {
						autoSubCmd.execute(sender, (String[]) argsList.toArray(new String[argsList.size()]));
					} catch(Exception e) {
						Console.catchError(e, "CmdAutoRestart.onCommand():" + autoSubCmd.getLabel());
					}
					return true;
				}
			}
			
			// Unknown sub command (will be stopped by return statement)
			sender.sendMessage(ChatColor.RED + "Неизвестная подкоманда. Попробуйте: /polyare help");
		}
		
		return true;
	}
	
	public static void setupSubCommands() {
		subCommands.add(new CmdHelp());
		subCommands.add(new CmdIn());
		subCommands.add(new CmdNow());
		subCommands.add(new CmdPause());
		subCommands.add(new CmdReload());
		subCommands.add(new CmdStart());
		subCommands.add(new CmdTime());
	}

}
