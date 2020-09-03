package ru.gorodilov.autorestart.utils.config;

import ru.gorodilov.autorestart.objects.ConfigFile;

public class MaxPlayers extends ConfigFile {

	public Boolean ENABLED() {
		return Config.MAX_PLAYERS.getBoolean(Config.getNode(), true);
	}

	public Integer AMOUNT() {
		return Config.MAX_PLAYERS.getInteger(Config.getNode(), 10);
	}

	public Integer DELAY() {
		return Config.MAX_PLAYERS.getInteger(Config.getNode(), 10);
	}

}
