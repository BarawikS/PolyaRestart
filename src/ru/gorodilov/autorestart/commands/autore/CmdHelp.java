package ru.gorodilov.autorestart.commands.autore;

import static org.bukkit.ChatColor.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.gorodilov.autorestart.abstracts.AutoCommand;
import ru.gorodilov.autorestart.commands.CmdAutoRestart;
import ru.gorodilov.autorestart.core.AutoRestart;
import ru.gorodilov.autorestart.utils.Console;

public class CmdHelp extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		// Check if argument number requirement meet
		if (args.length == 0) {
			
			// List Sub Commands usage and Descriptions
			for (AutoCommand cmd : CmdAutoRestart.subCommands) {
				
				// Check if player has permission
				if (cmd.getPermission() != null) {
					if (!sender.hasPermission(cmd.getPermission())) {
						continue;
					}
				}
				
				// Outputs command usage and description
				sender.sendMessage(GRAY + cmd.getUsage() + RED + " - " + GRAY + cmd.getDescription());
				
			}
			
		}
		else {
			
			// Finding Sub commands dictionary
			for (AutoCommand cmdFind : CmdAutoRestart.subCommands) {
				
				// Checks if label matches argument
				if (!cmdFind.getLabel().equalsIgnoreCase(args[0])) {
					continue;
				}
				
				// Checks if player has permission for this command
				if (cmdFind.getPermission() != null) {
					if (!sender.hasPermission(cmdFind.getPermission())) {
						sender.sendMessage(RED + "� ��� ������������ ���� ��� ��������� ������� ���������.");
						if (sender instanceof Player) {
							Console.consoleSendMessage("� ��� ������������ ����.");
						}
						return;
					}
				}
				
				// Fetch and display dictionary
				try {
					
					// Setup Buffered Reader
					InputStreamReader stream = new InputStreamReader(AutoRestart.PLUGIN.getResource("help_dictionary/" + cmdFind.getLabel().toLowerCase() + ".dict"));
					BufferedReader reader = new BufferedReader(stream);
					
					// Output dictionary
					sender.sendMessage(GRAY + reader.readLine());
					
					// Close stream
					reader.close();
					stream.close();
					
				} catch (Exception e) {
					Console.catchError(e, "CmdHelp.execute():FetchDictionary");
				}
				
				// Console notify
				if (sender instanceof Player) {
					Console.consoleSendMessage(" ����� ������ \"" + cmdFind.getLabel().toLowerCase() + "\" �������!");
				}
				
				return;
			}
			
			// Sub command not found
			sender.sendMessage(RED + "����������� ����������. ���������� \"/polyare help\" ��� ��������� ������ ������!");
			if (sender instanceof Player) {
				Console.consoleSendMessage(" Entered an invalid sub command!");
			}
			
		}
	}

	@Override
	public String getLabel() {
		return "HELP";
	}

	@Override
	public String getDescription() {
		return "���������� ����� ������.";	
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public String getUsage() {
		return "/polyare help <command>";
	}

}
