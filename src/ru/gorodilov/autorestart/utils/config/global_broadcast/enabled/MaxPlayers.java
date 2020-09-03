package ru.gorodilov.autorestart.utils.config.global_broadcast.enabled;

import ru.gorodilov.autorestart.utils.config.Config;

public class MaxPlayers {

	public Boolean ALERT() {
		return Config.GLOBAL_BROADCAST.getBoolean(Config.getNode(), true);
	}

	public Boolean PRE_SHUTDOWN() {
		return Config.GLOBAL_BROADCAST.getBoolean(Config.getNode(), true);
	}
	
}
