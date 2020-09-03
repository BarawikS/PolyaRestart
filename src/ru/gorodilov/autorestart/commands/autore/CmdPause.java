package ru.gorodilov.autorestart.commands.autore;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import ru.gorodilov.autorestart.abstracts.AutoCommand;
import ru.gorodilov.autorestart.core.AutoRestart;
import ru.gorodilov.autorestart.utils.Console;
import ru.gorodilov.autorestart.utils.Messenger;
import net.md_5.bungee.api.ChatColor;

public class CmdPause extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!AutoRestart.TIMER.PAUSED) {
			AutoRestart.TIMER.PAUSED = true;
			Messenger.broadcastStatusPause(sender);
		}
		else {
			sender.sendMessage(ChatColor.RED + "Таймер уже остановлен.");
			if (sender instanceof ConsoleCommandSender) {
				Console.consoleSendMessage(" Tried to use command, but timer is already paused.");
			}
		}
	}

	@Override
	public String getLabel() {
		return "PAUSE";
	}

	@Override
	public String getDescription() {
		return "Приостанавливает таймер рестарта.";
	}

	@Override
	public String getPermission() {
		return "autorestart.pause";
	}

	@Override
	public String getUsage() {
		return "/polyare pause";
	}

}
