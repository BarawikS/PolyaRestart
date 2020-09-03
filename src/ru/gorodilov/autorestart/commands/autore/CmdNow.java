package ru.gorodilov.autorestart.commands.autore;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import ru.gorodilov.autorestart.abstracts.AutoCommand;
import ru.gorodilov.autorestart.core.AutoRestart;

public class CmdNow extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.GRAY + "Перезагрузка сервера.");
		AutoRestart.TIMER.TIME = 0;
	}

	@Override
	public String getLabel() {
		return "NOW";
	}

	@Override
	public String getDescription() {
		return "Перезагрузка сервера.";
	}

	@Override
	public String getPermission() {
		return "autorestart.now";
	}

	@Override
	public String getUsage() {
		return "/polyare now";
	}

}
