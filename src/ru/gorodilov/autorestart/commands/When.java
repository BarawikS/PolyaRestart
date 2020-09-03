package ru.gorodilov.autorestart.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ru.gorodilov.autorestart.objects.HMS;
import ru.gorodilov.autorestart.utils.TimerParser;

public class When implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lab, String[] args) {
		String g = "\u00a76[\u00a78[\u00a7b���������\u00a78] \u00a7c���� \u00a7c-> �\u00a76] \u00a7f";
		HMS hms = TimerParser.parseToHMS();
		String h;
		if(hms.H == 1) h = " ��� "; else if(hms.H == 0) h = " ����� "; else h = " ���� ";
		s.sendMessage(g + "������ �������������� ����� " + hms.H.toString() + h + "� " + hms.M.toString() + " �����.");
		return true;
	}

}
