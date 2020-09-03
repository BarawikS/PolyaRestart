package ru.gorodilov.autorestart.commands.autore;

import org.bukkit.command.CommandSender;

import ru.gorodilov.autorestart.abstracts.AutoCommand;
import ru.gorodilov.autorestart.utils.Messenger;

public class CmdTime extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		Messenger.messageSenderTime(sender);
	}

	@Override
	public String getLabel() {
		return "TIME";
	}

	@Override
	public String getDescription() {
		return "Показывает время до рестарта.";
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public String getUsage() {
		return "/polyare time";
	}

}
