package ru.gorodilov.autorestart.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import ru.gorodilov.autorestart.commands.CmdAutoRestart;
import ru.gorodilov.autorestart.commands.When;
import ru.gorodilov.autorestart.enums.FileEnum;
import ru.gorodilov.autorestart.objects.ConfigFile;
import ru.gorodilov.autorestart.utils.Console;
import ru.gorodilov.autorestart.utils.Metrics;

public class AutoRestart extends JavaPlugin {

	public static AutoRestart PLUGIN;
	public static String VERSION;
	public static Metrics METRICS;
	public static TimerThread TIMER = new TimerThread();

	@Override
	public void onEnable() {
		try {
			// Plugin variables
			PLUGIN = this;
			VERSION = getDescription().getVersion();
			METRICS = new Metrics(PLUGIN);

			// Setup plugin folder if does not exist
			getDataFolder().mkdirs();

			// Setup files
			for (FileEnum file : FileEnum.values()) {
				file.setup();
			}

			// Configuration file
			ConfigFile.setupConfigFiles();
			ConfigFile.loadConfig();
			ConfigFile.updateConfig();
			
			// Command setup
			new CmdAutoRestart();
			CmdAutoRestart.setupSubCommands();
			Bukkit.getPluginCommand("polyare").setExecutor(new CmdAutoRestart());
			Bukkit.getPluginCommand("server").setExecutor(new When());
			// Timer thread
			TIMER.calculateTimer();
			TIMER.runLoop();
			
			// Done
			//Console.info("Loaded!");
		} catch (Exception e) {
			Console.catchError(e, "UNFILTERED ERROR");
		}
	}
	
}
