package ru.gorodilov.autorestart.commands.autore;

import static org.bukkit.ChatColor.*;

import org.bukkit.command.CommandSender;

import ru.gorodilov.autorestart.abstracts.AutoCommand;
import ru.gorodilov.autorestart.core.AutoRestart;
import ru.gorodilov.autorestart.utils.Messenger;

public class CmdIn extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		// Checks if enough arguments are present
		if (args.length == 0) {
			sender.sendMessage(RED + "Недостаточно аргументов. Попробуйте: /polyare help in");
			return;
		}
		
		// Variable initialization
		int time = 0;
		
		// Argument adding/parsing loop
		for (String arg : args) {
			try {
				// Split argument
				String[] vars = arg.split(":");
				if (vars.length != 2) {
					sender.sendMessage(RED + "Ошибка в написании. Попробуйте: /polyare help in");
					return;
				}
				int number = Integer.parseInt(vars[0]);
				String type = vars[1].toUpperCase();
				
				// Check type and add with appropriate product
				switch(type) {
				case "H":
					time += number * 3600;
					break;
				case "M":
					time += number * 60;
					break;
				case "S":
					time += number;
					break;
				default:
					sender.sendMessage(RED + "Неизвестный суффикс. \"" + type + "\"! Попробуйте: /polyare help in");
					return;
				}
			} catch (NumberFormatException e) {
				sender.sendMessage(RED + "Введите значение в числовом формате. Попробуйте: /polyare help in");
				return;
			}
		}
		
		// Update timer thread with new time value
		AutoRestart.TIMER.TIME = time;
		
		// Send updated time to appropriate players (Method automatically sorts who gets what message, and pop ups)
		Messenger.broadcastChange(sender);
	}

	@Override
	public String getLabel() {
		return "IN";
	}

	@Override
	public String getDescription() {
		return "Изменяет время рестарта.";
	}

	@Override
	public String getPermission() {
		return "autorestart.in";
	}

	@Override
	public String getUsage() {
		return "/polyare in [hours]:h [minutes]:m [seconds]:s";
	}

}
