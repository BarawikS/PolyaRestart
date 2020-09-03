package ru.gorodilov.autorestart.commands.autore;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import ru.gorodilov.autorestart.abstracts.AutoCommand;
import ru.gorodilov.autorestart.core.AutoRestart;
import ru.gorodilov.autorestart.objects.ConfigFile;

public class CmdReload extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		ConfigFile.loadConfig();
		AutoRestart.TIMER.calculateTimer();
		sender.sendMessage(ChatColor.GRAY + "Конфиг перезагружен.");
	}

	@Override
	public String getLabel() {
		return "RELOAD";
	}

	@Override
	public String getDescription() {
		return "Перезагружает конфиг.";
	}

	@Override
	public String getPermission() {
		return "autorestart.reload";
	}

	@Override
	public String getUsage() {
		return "/polyare reload";
	}

}
