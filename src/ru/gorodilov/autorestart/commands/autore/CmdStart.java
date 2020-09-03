package ru.gorodilov.autorestart.commands.autore;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import ru.gorodilov.autorestart.abstracts.AutoCommand;
import ru.gorodilov.autorestart.core.AutoRestart;
import ru.gorodilov.autorestart.utils.Console;
import ru.gorodilov.autorestart.utils.Messenger;
import net.md_5.bungee.api.ChatColor;

public class CmdStart extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (AutoRestart.TIMER.PAUSED) {
			AutoRestart.TIMER.PAUSED = false;
			Messenger.broadcastStatusStart(sender);
		}
		else {
			sender.sendMessage(ChatColor.RED + "Таймер уже высчитывает время.");
			if (sender instanceof ConsoleCommandSender) {
				Console.consoleSendMessage(" Tried to use command, but timer is already counting down.");
			}
		}
	}

	@Override
	public String getLabel() {
		return "START";
	}

	@Override
	public String getDescription() {
		return "Включает таймер рестарта.";
	}

	@Override
	public String getPermission() {
		return "autorestart.start";
	}

	@Override
	public String getUsage() {
		return "/polyare start";
	}

}
