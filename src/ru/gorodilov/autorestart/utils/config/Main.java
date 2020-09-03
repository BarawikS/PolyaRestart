package ru.gorodilov.autorestart.utils.config;

import ru.gorodilov.autorestart.objects.ConfigFile;
import ru.gorodilov.autorestart.utils.config.main.Modes;

public class Main extends ConfigFile {
	
	public String RESTART_MODE() {
		return Config.MAIN.getString(Config.getNode(), "interval");
	}

	public Modes MODES = new Modes();

	public String PREFIX() {
		return Config.MAIN.getString(Config.getNode(), "&f[&fPolyaRestart&f] &e");
	}

	public String KICK_MESSAGE() {
		return Config.MAIN.getString(Config.getNode(), "&cServer Restarting! We will be back up any minute!");
	}

}
